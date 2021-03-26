@file:OptIn(ExperimentalAnimationApi::class)

package com.mytools.picture.editor.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FadeVisibility(
  visible: Boolean,
  modifier: Modifier = Modifier,
  enter: EnterTransition = fadeIn(),
  exit: ExitTransition = fadeOut(),
  initiallyVisible: Boolean = visible,
  content: @Composable () -> Unit
) {
  AnimatedVisibility(visible, modifier, enter, exit, initiallyVisible, content)
}