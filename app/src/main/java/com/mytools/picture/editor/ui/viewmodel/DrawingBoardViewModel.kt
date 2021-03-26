package com.mytools.picture.editor.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrawingBoardViewModel @Inject constructor() : ViewModel() {
  var picture by mutableStateOf<Any?>(null)

  val isEmpty get() = picture == null
  val isNotEmpty get() = !isEmpty
}