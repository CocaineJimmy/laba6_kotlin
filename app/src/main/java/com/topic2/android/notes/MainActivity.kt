package com.topic2.android.notes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import com.topic2.android.notes.theme.NotesTheme
import com.topic2.android.notes.ui.components.AppDrawer
import com.topic2.android.notes.ui.components.Note
import com.topic2.android.notes.ui.screens.NotesScreen
import com.topic2.android.notes.viewmodel.MainViewModel
import com.topic2.android.notes.viewmodel.MainViewModelFactory
import kotlinx.coroutines.launch

/**
 * Main activity приложения.
 */
class MainActivity : AppCompatActivity() {
  private val viewModel: MainViewModel by viewModels(factoryProducer = {
    MainViewModelFactory(
      this,
      (application as NotesApplication).dependencyInjector.repository
    )
  })
  @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      NotesTheme {
        NotesScreen(viewModel = viewModel)
      }
    }
  }
}