package com.m68476521.comicos.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m68476521.comicos.model.MyModel

@Composable
fun HomeScreen(viewModel: MyModel, itemSelected: (result: String?, albumId: String?) -> Unit) {

    val data by viewModel.comicsResponseData.collectAsState()

    var text by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getData()
    }

    val result = data.data?.results ?: return
    LazyColumn(
        modifier = Modifier
            .height(100.dp)
    ) {

        item {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                textStyle = TextStyle(
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Blue
                ),
                label = {
                    Text(text = "your name")
                },
                placeholder = {
                    Text(text = "Please enter yor name")
                }
            )
        }

        items(result) { currentName ->
            Text(
                text = currentName.title.toString(),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .clickable {
                        itemSelected.invoke(currentName.title, currentName.id.toString())
                    }
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(6.dp),
                thickness = 2.dp
            )
        }
    }
}