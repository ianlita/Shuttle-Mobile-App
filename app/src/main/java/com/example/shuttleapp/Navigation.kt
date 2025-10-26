package com.example.shuttleapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.shuttle.presentation.LoginScreen
//import com.example.shuttle.presentation.RegisterScreen
//import com.example.shuttle.presentation.viewmodel.LoginViewModel
//import com.example.shuttle.presentation.AVCurrentPassScreenTest
//import com.example.shuttle.presentation.EditShuttlePassInformationScreen
//import com.example.shuttle.presentation.HomeScreen
//import com.example.shuttle.presentation.QRScannerScreen
//import com.example.shuttle.presentation.ShuttlePassItemScreen
//import com.example.shuttle.presentation.ShuttlePassListScreen
//import com.example.shuttle.presentation.viewmodel.FilterViewModel
//import com.example.shuttle.presentation.viewmodel.QrAnalyzerViewModel
//import com.example.shuttle.presentation.viewmodel.ShuttleViewModel
//
////main screen of the app. handles in the main activity
//@Composable
//fun Navigation(navController: NavHostController = rememberNavController()) {
//    val shuttleViewModel: ShuttleViewModel = hiltViewModel<ShuttleViewModel>()
//    //val registerViewModel: RegisterViewModel = viewModel()
//    val loginViewModel: LoginViewModel = hiltViewModel<LoginViewModel>()
//    val qrViewModel = hiltViewModel<QrAnalyzerViewModel>()
//    val filterViewModel = hiltViewModel<FilterViewModel>()
//
//
//    NavHost(navController = navController, startDestination = Route.LoginScreen.route) {
//
//        composable(route = Route.RegisterScreen.route) {
//            RegisterScreen(
//                navController = navController
//            )
//        }
//        composable(route = Route.LoginScreen.route) {
//            LoginScreen(
//                //loginViewModel = loginViewModel,
//                navController = navController
//            )
//        }
//
//        composable(route = Route.HomeScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument("id") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = false
//                }
//            )
//        ) { entry ->
//
//            val id = if(entry.arguments != null) {
//                entry.arguments!!.getString("id")
//            } else {
//                ""
//            }
//
//            if (id != null) {
//                HomeScreen(
//                    userId = id,
//                    navController = navController,
//                    viewModel = shuttleViewModel
//                )
//            }
//
//        }
//
//        composable(route = Route.AVCurrentPassScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument("id") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = false
//                }
//            )
//        ) {entry ->
//            val id = if(entry.arguments != null) {
//                entry.arguments!!.getString("id")
//            } else {
//                ""
//            }
//
//            if (id != null) {
//                AVCurrentPassScreenTest(
//                    viewModel = shuttleViewModel,
//                    navController = navController
//                )
//            }
//        }
//
//        composable(route = Route.ShuttlePassListScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument("id") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = false
//                }
//            )
//        ) { entry ->
//            val id = if(entry.arguments != null) {
//                entry.arguments!!.getString("id")
//            } else {
//                ""
//            }
//
//            if(id != null) {
//                ShuttlePassListScreen(
//                    id = id,
//                    shuttleViewModel = shuttleViewModel,
//                    filterViewModel = filterViewModel,
//                    navController = navController
//                )
//            }
//
//
//        }
//
//        composable(route = Route.ShuttlePassItemScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument("id") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = false
//                })
//        ) { entry ->
//
//            val id = if(entry.arguments != null) {
//                entry.arguments!!.getString("id")
//            } else {
//                ""
//            }
//
//            if (id != null) {
//                ShuttlePassItemScreen(id, viewModel = shuttleViewModel, navController = navController)
//            }
//
//        }
//
//        composable(route = Route.EditShuttlePassInfoScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument("id") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = false
//                }
//            )
//        ) { entry ->
//            val id = if(entry.arguments != null) {
//                entry.arguments!!.getString("id")
//            } else {
//                ""
//            }
//
//            if (id != null) {
//                EditShuttlePassInformationScreen(
//                    id = id,
//                    viewModel = shuttleViewModel,
//                    navController = navController
//                )
//            }
//        }
//
//        composable(route = Route.QrScannerScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument("id") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = false
//                }
//            )
//        ) { entry ->
//
//            val id = if(entry.arguments != null) {
//                entry.arguments!!.getString("id")
//            } else {
//                ""
//            }
//
//            if (id != null) {
//                QRScannerScreen(id,navController)
//            }
//        }
//
//    }
//}


sealed class Route(val route: String) {
    object HomeScreen: Route("homescreen")
    object ShuttlePassListScreen: Route("shuttlepasslistscreen")
    object AVCurrentPassScreen: Route("shuttlepassscreen")
    object ShuttlePassItemScreen: Route("shuttlepassitemscreen")
    object EditShuttlePassInfoScreen: Route("editshuttlepassinfoscreen")
    object QrScannerScreen: Route("qrscannerscreen")
    object LoginScreen: Route("loginscreen")
    object RegisterScreen: Route("registerscreen")
}