package dev.janssenbatista.enfburnout.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import dev.janssenbatista.enfburnout.R
import dev.janssenbatista.enfburnout.features.about_app.AboutAppScreen
import dev.janssenbatista.enfburnout.features.home.HomeScreen
import dev.janssenbatista.enfburnout.features.other_diseases.OtherDiseasesScreen
import dev.janssenbatista.enfburnout.features.support_services.SupportServicesScreen
import dev.janssenbatista.enfburnout.features.take_care.TakeCareScreen
import dev.janssenbatista.enfburnout.features.treatment.TreatmentScreen

@Composable
fun DrawerContent(
    navigator: Navigator,
    onMenuClick: (Screen) -> Unit
) {
    Column(
        Modifier
            .padding(NavigationDrawerItemDefaults.ItemPadding)
            .padding(top = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(
                    id = R.string.app_logo
                )
            )
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Enf",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(text = "Burn", fontWeight = FontWeight.Medium, fontSize = 32.sp)
        }
        HorizontalDivider(Modifier.padding(top = 16.dp, bottom = 8.dp))
        NavigationDrawerItem(
            label = { Text(text = HomeScreen.TITLE) },
            selected = navigator.lastItem::class.simpleName == HomeScreen::class.simpleName,
            onClick = { onMenuClick(HomeScreen) },
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Article,
                    contentDescription = HomeScreen.TITLE
                )
            })
        NavigationDrawerItem(
            label = { Text(text = TreatmentScreen.TITLE) },
            selected = navigator.lastItem::class.simpleName == TreatmentScreen::class.simpleName,
            onClick = { onMenuClick(TreatmentScreen) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_medical_services_filled),
                    contentDescription = HomeScreen.TITLE
                )
            })
        NavigationDrawerItem(
            label = { Text(text = OtherDiseasesScreen.TITLE) },
            selected = navigator.lastItem::class.simpleName == OtherDiseasesScreen::class.simpleName,
            onClick = { onMenuClick(OtherDiseasesScreen) },
            icon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Article,
                    contentDescription = OtherDiseasesScreen.TITLE
                )
            })
        NavigationDrawerItem(
            label = { Text(text = SupportServicesScreen.TITLE) },
            selected = navigator.lastItem::class.simpleName == SupportServicesScreen::class.simpleName,
            onClick = { onMenuClick(SupportServicesScreen) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.ContactPhone,
                    contentDescription = SupportServicesScreen.TITLE
                )
            })
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f))
        HorizontalDivider()
        NavigationDrawerItem(
            label = { Text(text = "Sobre o Aplicativo") },
            selected = false,
            onClick = { onMenuClick(AboutAppScreen) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = AboutAppScreen.TITLE
                )
            })
    }
}