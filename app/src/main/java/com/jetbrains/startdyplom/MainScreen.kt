package com.jetbrains.startdyplom

//MainScreen.kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.jetbrains.startdyplom.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = "brushing") {
                composable("brushing") { BrushingScreen() }
                composable("calendar") { CalendarScreen() }
                composable("chat") { ChatScreen() }
                composable("profile") { ProfileScreen() }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("brushing", "B"),
        BottomNavItem("calendar", "M"),
        BottomNavItem("chat", "C"),
        BottomNavItem("profile", "P")
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Text(item.label) },
                label = null,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = false // Виправлено, щоб не видаляти стартовий екран
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val route: String, val label: String)

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}