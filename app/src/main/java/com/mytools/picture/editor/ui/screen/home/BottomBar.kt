package com.mytools.picture.editor.ui.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mytools.picture.editor.ui.composable.Icon
import com.mytools.picture.editor.ui.theme.currentColors
import com.mytools.picture.editor.ui.theme.currentTypography
import com.mytools.picture.editor.ui.screen.home.viewmodel.ToolsViewModel

@Composable
fun BottomBar(tools: ToolsViewModel, modifier: Modifier) {
  BottomAppBar(
    elevation = 12.dp,
    contentPadding = PaddingValues(Dp.Hairline),
    modifier = modifier,
  ) {
    ScrollableTabRow(
      selectedTabIndex = tools.currentToolIndex,
      backgroundColor = currentColors.background,
      edgePadding = Dp.Hairline,
      divider = { Divider(Modifier.alpha(0.4f)) },
      indicator = {},
    ) {
      tools.forEach { index, icon, text ->
        Tab(
          selected = index == tools.currentToolIndex,
          icon = { Icon(icon, modifier = Modifier.size(18.dp)) },
          text = { Text(text, style = currentTypography.button.copy(fontSize = 14.sp)) },
          onClick = { tools.selectTool(index) }
        )
      }
    }
  }
}