package bts.sio.paris2024.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import bts.sio.paris2024.model.views.AthleteList
import bts.sio.paris2024.model.views.OlympiadeList
import bts.sio.paris2024.model.views.SiteList
import bts.sio.paris2024.model.views.SportList
import bts.sio.paris2024.model.views.PaysList

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "pays_list",
        modifier = modifier
    ) {
        composable("pays_list") {
            PaysList()
        }
        composable("athlete_list") {
            AthleteList()
        }
        composable("site_list") {
            SiteList()
        }
        composable("sport_list") {
            SportList()
        }
        composable("olympiade_list") {
            OlympiadeList()
        }
        }
    }
