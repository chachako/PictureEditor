@file:OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)

package com.mytools.picture.editor.ui.screen.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import com.meowbase.toolkit.that
import com.mytools.picture.editor.ui.composable.animateAsState
import com.mytools.picture.editor.ui.viewmodel.DrawingBoardViewModel
import com.mytools.picture.editor.ui.viewmodel.ToolsViewModel

@Composable
fun Screen() {
  val tools = hiltNavGraphViewModel<ToolsViewModel>()
  val drawingBoard = hiltNavGraphViewModel<DrawingBoardViewModel>()
  val scaffoldState = rememberBackdropScaffoldState(
    drawingBoard.isEmpty that BackdropValue.Revealed ?: BackdropValue.Concealed
  )

  Box(modifier = Modifier.fillMaxSize()) {
    BackdropScaffold(
      appBar = {
        TopBar(scaffoldState)
        Divider(Modifier.alpha(animateAsState(scaffoldState.isRevealed that 1f ?: 0f).value))
      },
      backLayerContent = { BackLayer(drawingBoard) },
      frontLayerContent = { DrawingBoard(drawingBoard) },
      frontLayerElevation = 4.dp,
      scaffoldState = scaffoldState,
      modifier = Modifier.padding(bottom = BottomBarHeight),
    )
    BottomBar(
      tools,
      modifier = Modifier
        .align(Alignment.BottomCenter)
        .height(BottomBarHeight)
    )
  }
}

private val BottomBarHeight = 60.dp