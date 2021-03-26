package com.mytools.picture.editor.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BackdropItem(
  val icon: ImageVector,
  val title: String,
  val action: Action,
  val enabled: Boolean = true,
) {
  enum class Action {
    NewFile,
    OpenPicture,
    OpenCamera,
    Save,
    Share,
    Close
  }
}

object BackdropDivider