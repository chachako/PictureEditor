package com.mytools.picture.editor.ui.screen.home

import androidx.compose.animation.Crossfade
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.meowbase.toolkit.that
import com.mytools.picture.editor.ui.composable.Icon
import com.mytools.picture.editor.ui.composable.coroutineClick

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopBar(scaffoldState: BackdropScaffoldState) {
  TopAppBar(
    title = { Text(text = "图片编辑") },
    elevation = Dp.Hairline,
    actions = {
      IconButton(onClick = coroutineClick {
        scaffoldState.isConcealed that scaffoldState.reveal() ?: scaffoldState.conceal()
      }) {
        Crossfade(targetState = scaffoldState.isConcealed) { isConcealed ->
          Icon(isConcealed that Icons.Rounded.Menu ?: Icons.Rounded.Close)
        }
      }
    }
  )
}