package com.mytools.picture.editor.ui.screen.home.viewmodel

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.material.icons.rounded.Carpenter
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.FormatColorFill
import androidx.compose.material.icons.rounded.FormatSize
import androidx.compose.material.icons.rounded.HighlightAlt
import androidx.compose.material.icons.rounded.Transform
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToolsViewModel @Inject constructor() : ViewModel() {
  private val tools = listOf(
    Icons.Rounded.Brush to "画笔",
    Icons.Rounded.Category to "形状",
    Icons.Rounded.FormatSize to "文本",
    Icons.Rounded.Carpenter to "擦除",
    Icons.Rounded.HighlightAlt to "选择",
    Icons.Rounded.Transform to "变换",
    Icons.Rounded.FormatColorFill to "填充",
  )
  var currentToolIndex by mutableStateOf(0)

  val currentTool get() = tools[currentToolIndex]

  fun selectTool(index: Int) {
    currentToolIndex = index
  }

  @Composable @SuppressLint("ComposableNaming")
  fun forEach(action: @Composable (index: Int, icon: ImageVector, title: String) -> Unit) {
    tools.forEachIndexed { index, (icon, title) ->
      action(index, icon, title)
    }
  }
}