package com.m68476521.comicos.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.m68476521.comicos.model.MyModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: MyModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    myList(viewModel)
                }
            }
        }

    @Composable
    fun myList(viewModel: MyModel) {
        val data by viewModel.comicsResponseData.collectAsState()

        LaunchedEffect(key1 = Unit) {
            viewModel.getData()
        }

        val result = data.data?.results ?: return
        LazyColumn {
            items(result) { currentName ->
                Text(
                    text = currentName.title.toString(),
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                )
                HorizontalDivider(
                    modifier =
                        Modifier
                            .padding(6.dp),
                    thickness = 2.dp,
                )
            }
        }
    }
}
