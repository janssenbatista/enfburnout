package dev.janssenbatista.enfburnout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
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
import dev.janssenbatista.enfburnout.components.QuestionHintDialog
import dev.janssenbatista.enfburnout.features.home.HomeScreen
import dev.janssenbatista.enfburnout.features.splashscreen.SplashScreen
import dev.janssenbatista.enfburnout.features.talk.TalkScreen
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
                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                var isQuestionHintDialogVisible by remember {
                    mutableStateOf(false)
                }

                Navigator(screen = SplashScreen) { navigator: Navigator ->
                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet {
                                DrawerContent(
                                    navigator = navigator,
                                ) { screen ->
                                    navigator.replace(screen)
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
                                        title = { Text(text = getTopBarTitle(navigator)) },
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
                                        scrollBehavior = scrollBehavior,
                                        actions = {
                                            if (navigator.lastItem::class.simpleName == TalkScreen::class.simpleName) {
                                                IconButton(onClick = {
                                                    isQuestionHintDialogVisible = true
                                                }) {
                                                    Icon(
                                                        imageVector = Icons.AutoMirrored.Outlined.Help,
                                                        contentDescription = "show help dialog"
                                                    )
                                                }
                                            }
                                        }
                                    )
                                }
                            }) { paddingValues ->
                            Column(
                                Modifier
                                    .padding(paddingValues)
                                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                                    .fillMaxSize()
                            ) {
                                navigator.lastItem.Content()
                                if (isQuestionHintDialogVisible) {
                                    QuestionHintDialog(
                                        onDismissRequestClick = {
                                            isQuestionHintDialogVisible = false
                                        },
                                        onConfirmButtonClick = {
                                            isQuestionHintDialogVisible = false
                                        })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun getTopBarTitle(navigator: Navigator): String =
    when (navigator.lastItem::class.simpleName) {
        HomeScreen::class.simpleName -> HomeScreen.TITLE
        TalkScreen::class.simpleName -> TalkScreen.TITLE
        else -> ""
    }
