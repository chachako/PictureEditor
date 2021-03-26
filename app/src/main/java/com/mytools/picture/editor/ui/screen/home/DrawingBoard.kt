package com.mytools.picture.editor.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AddPhotoAlternate
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.mytools.picture.editor.ui.composable.CoilImage
import com.mytools.picture.editor.ui.composable.Icon
import com.mytools.picture.editor.ui.viewmodel.DrawingBoardViewModel

@Composable
fun DrawingBoard(drawingBoard: DrawingBoardViewModel) {
  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    when(drawingBoard.isEmpty) {
      false -> CoilImage(data = drawingBoard.picture!!)
      else -> Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.alpha(0.24f)
      ) {
        Icon(
          imageVector = Icons.TwoTone.AddPhotoAlternate,
          tint = LocalContentColor.current.copy(alpha = 0.24f),
          modifier = Modifier
            .size(130.dp)
            .padding(bottom = 8.dp)
        )
        Text(text = "请新建或打开一张图片")
      }
    }
  }
}