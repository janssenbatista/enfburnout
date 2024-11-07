package dev.janssenbatista.enfburnout.di

import dev.janssenbatista.enfburnout.features.talk.TalkViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { TalkViewModel(get()) }
}