package com.mytools.picture.editor.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.LocalSystemUiController
import com.google.accompanist.systemuicontroller.rememberAndroidSystemUiController
import com.mytools.picture.editor.ui.screen.home.Screen
import com.mytools.picture.editor.ui.theme.NavigationBarColor
import com.mytools.picture.editor.ui.theme.PictureEditorTheme
import com.mytools.picture.editor.ui.theme.StatusBarColor

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { PictureEditorApp() }
  }
}

@Composable
@OptIn(ExperimentalAnimatedInsets::class)
fun PictureEditorApp() {
  PictureEditorTheme {
    val controller = rememberAndroidSystemUiController().apply {
      setStatusBarColor(StatusBarColor, darkIcons = true)
      setNavigationBarColor(NavigationBarColor, darkIcons = true)
    }
    CompositionLocalProvider(LocalSystemUiController provides controller) {
      ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
        Screen()
      }
    }
  }
}