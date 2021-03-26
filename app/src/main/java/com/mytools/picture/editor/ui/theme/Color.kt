package com.mytools.picture.editor.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Blur700 = Color(0xFF2962ff)
val Purple200 = Color(0xFF5D6266)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val StatusBarColor
  @Composable
  get() = if (currentColors.isLight) currentColors.primary else Color.Black

val NavigationBarColor
  @Composable
  get() = if (currentColors.isLight) Color.White else Color(0xFF222222)