package com.m68476521.comicos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.m68476521.comicos.data.BottomNavigation

val items =
    listOf(
        BottomNavigation(
            title = "Home",
            icon = Icons.Rounded.Home,
        ),
        BottomNavigation(
            title = "Second",
            icon = Icons.Rounded.AccountBox,
        ),
        BottomNavigation(
            title = "Menu",
            icon = Icons.Rounded.Menu,
        ),
    )

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface),
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    },
                )
            }
        }
    }
}
