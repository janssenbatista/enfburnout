package dev.janssenbatista.enfburnout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import cafe.adriel.voyager.navigator.Navigator
import dev.janssenbatista.enfburnout.components.DrawerContent
import dev.janssenbatista.enfburnout.features.home.HomeScreen
import dev.janssenbatista.enfburnout.features.splashscreen.SplashScreen
import dev.janssenbatista.enfburnout.ui.theme.EnfBurnoutTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnfBurnoutTheme {

                val coroutineScope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                var appBarTitle by remember {
                    mutableStateOf(HomeScreen.TITLE)
                }

                Navigator(screen = SplashScreen) { navigator: Navigator ->
                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet {
                                DrawerContent(navigator = navigator) { screen, title ->
                                    navigator.replace(screen)
                                    appBarTitle = title
                                    coroutineScope.launch {
                                        drawerState.close()
                                    }
                                }
                            }
                        },
                        drawerState = drawerState
                    ) {
                        Scaffold(
                            topBar = {
                                if (navigator.lastItem::class.simpleName != SplashScreen::class.simpleName) {
                                    TopAppBar(
                                        title = { Text(text = appBarTitle) },
                                        navigationIcon = {
                                            IconButton(onClick = {
                                                coroutineScope.launch {
                                                    drawerState.open()
                                                }
                                            }) {
                                                Icon(
                                                    imageVector = Icons.Default.Menu,
                                                    contentDescription = "Menu"
                                                )
                                            }
                                        },
                                        scrollBehavior = scrollBehavior
                                    )
                                }
                            }) { paddingValues ->
                            Column(
                                Modifier
                                    .padding(paddingValues)
                                    .fillMaxSize()
                                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                            ) {
                                navigator.lastItem.Content()
                            }
                        }
                    }
                }
            }
        }
    }
}
