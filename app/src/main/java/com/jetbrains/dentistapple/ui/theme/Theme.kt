package com.jetbrains.dentistapple.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Фонове зображення для всього екрану
@Composable
fun BackgroundScreen(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        content()
    }
}

// Головна тема застосунку
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF6200EE),
            onPrimary = Color.White,
            background = Color(0xFFF2F2F2),
            onBackground = Color.Black
        ),
        typography = AppTypography
    ) {
        BackgroundScreen {
            content()
        }
    }
}

// Стилі тексту
val AppTypography = Typography(
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        color = Color.White
    )
)

// Стилі кнопок
val ButtonStyle
    @Composable get() = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF6200EE),
        contentColor = Color.White
    )
