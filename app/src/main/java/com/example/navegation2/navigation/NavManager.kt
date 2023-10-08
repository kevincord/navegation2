package com.example.navegation2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.navegation2.views.DetailView
import com.example.navegation2.views.HomeView


@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController=navController, starDestination = "home"){
        composable(
            "home", {
                HomeView(navController)
            }, listOf(
                navArgument("id"){type= NavType.IntType},
                navArgument("opcional"){type = NavType.StringType},
            )
        )
        composable("Detail/{id}/?{opcional}", arguments= listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("opcional"){type = NavType.StringType},
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional")?: ""
            DetailView(navController, id , opcional)

    }
}


