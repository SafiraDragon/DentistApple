package com.jetbrains.dentistapple

//MainScreen.kt

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.jetbrains.dentistapple.ui.theme.AppTheme

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
                            inclusive = false
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