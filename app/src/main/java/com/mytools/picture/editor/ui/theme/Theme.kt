package com.mytools.picture.editor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
  primary = Purple200,
  primaryVariant = Purple700,
  secondary = Teal200
)

private val LightColorPalette = lightColors(
  primary = Color(0xFFEFEFEF),
  primaryVariant = Color(0xFFFAFAFA),
  secondary = Color(0xFF2962ff),
  secondaryVariant = Color(0xFF0039cb),
  background = Color.White,
  surface = Color.White,
  onPrimary = Color.Black,
  onSecondary = Color.White,
  onBackground = Color.Black,
  onSurface = Color.Black,
)

@Composable
fun PictureEditorTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}


val currentTypography
  @Composable
  get() = MaterialTheme.typography

val currentShapes
  @Composable
  get() = MaterialTheme.shapes

val currentColors
  @Composable
  get() = MaterialTheme.colors
