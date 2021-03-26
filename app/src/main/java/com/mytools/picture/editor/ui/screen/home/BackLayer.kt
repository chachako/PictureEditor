package com.mytools.picture.editor.ui.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddAPhoto
import androidx.compose.material.icons.outlined.AddPhotoAlternate
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.IosShare
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.meowbase.toolkit.that
import com.mytools.picture.editor.model.BackdropDivider
import com.mytools.picture.editor.model.BackdropItem
import com.mytools.picture.editor.ui.composable.Icon
import com.mytools.picture.editor.ui.composable.clickable
import com.mytools.picture.editor.ui.screen.home.viewmodel.DrawingBoardViewModel

@Composable
fun BackLayer(drawingBoard: DrawingBoardViewModel) {
  List(
    backdropItems = arrayOf(
      BackdropItem(
        icon = Icons.Outlined.OpenInNew,
        title = "新建图片",
        action = BackdropItem.Action.NewFile
      ),
      BackdropItem(
        icon = Icons.Outlined.AddPhotoAlternate,
        title = "从图库打开",
        action = BackdropItem.Action.OpenPicture
      ),
      BackdropItem(
        icon = Icons.Outlined.AddAPhoto,
        title = "从相机打开",
        action = BackdropItem.Action.OpenCamera
      ),
      BackdropDivider,
      BackdropItem(
        icon = Icons.Outlined.Save,
        title = "保存图片",
        action = BackdropItem.Action.Save,
        enabled = drawingBoard.isNotEmpty
      ),
      BackdropItem(
        icon = Icons.Outlined.IosShare,
        title = "分享图片",
        action = BackdropItem.Action.Share,
        enabled = drawingBoard.isNotEmpty
      ),
      BackdropItem(
        icon = Icons.Outlined.Cancel,
        title = "关闭图片",
        action = BackdropItem.Action.Close,
        enabled = drawingBoard.isNotEmpty
      ),
    )
  )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun List(backdropItems: Array<Any>) {
  LazyColumn {
    items(backdropItems) {
      when (it) {
        is BackdropItem -> ListItem(
          icon = { Icon(it.icon) },
          text = { Text(it.title) },
          modifier = Modifier
            .alpha(it.enabled that 1f ?: 0.54f)
            .clickable(enabled = it.enabled) {
              when(it.action) {
                BackdropItem.Action.NewFile -> TODO()
                BackdropItem.Action.OpenPicture -> TODO()
                BackdropItem.Action.OpenCamera -> TODO()
                BackdropItem.Action.Save -> TODO()
                BackdropItem.Action.Share -> TODO()
                BackdropItem.Action.Close -> TODO()
              }
            }
        )
        else -> Divider(modifier = Modifier.alpha(0.8f))
      }
    }
  }
}