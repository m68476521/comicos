import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.m68476521.comicos.R
import com.m68476521.comicos.model.MyModel
import com.m68476521.comicos.navigation.ScreenHome
import com.m68476521.comicos.navigation.navigateToDetailViewerScreen
import com.m68476521.comicos.navigation.detailViewerScreen
import com.m68476521.comicos.navigation.homeViewerScreen
import com.m68476521.comicos.ui.BottomNavigationBar
import java.lang.String.valueOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComicosBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(title = { Text(currentScreen) }, colors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ), modifier = modifier, navigationIcon = {
        if (canNavigateBack) {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    })
}

@Composable
fun ComicosApp(
    viewModel: MyModel = viewModel(), navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = valueOf(
        backStackEntry?.destination?.route ?: ScreenHome
    )

    Scaffold(
        topBar = {
            ComicosBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        },
        bottomBar = {
            BottomNavigationBar()
        }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenHome,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {

            fun goToDetailViewerScreen(navController: NavController): (albumName: String, albumId: String) -> Unit {
                return { albumId, albumName ->
                    navController.navigateToDetailViewerScreen(
                        albumId = albumId, albumName = albumName
                    )
                }
            }

            homeViewerScreen(viewModel) { name, albumId ->
                if (name != null && albumId != null) {
                    goToDetailViewerScreen(navController)(name, albumId)
                }
            }

            detailViewerScreen("", "", viewModel)

        }
    }
}