package bts.sio.paris2024.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.SportsMartialArts
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Grade
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.SportsBasketball
import androidx.compose.material.icons.filled.TripOrigin
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun AppBottomBar(navController: NavController) {

    val items = listOf(
        BottomNavItem("Pays", "pays_list", Icons.Filled.Flag),
        BottomNavItem("Athlete", "athlete_list", Icons.Filled.SportsMartialArts),
        BottomNavItem("Site", "site_list", Icons.Filled.PinDrop),
        BottomNavItem("Sport", "sport_list", Icons.Filled.SportsBasketball),
        BottomNavItem("Olymp", "olympiade_list", Icons.Filled.Grade),
        BottomNavItem("Joueur", "joueur_list", Icons.Filled.AttachMoney)

    )

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                }
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String, val icon: ImageVector)
