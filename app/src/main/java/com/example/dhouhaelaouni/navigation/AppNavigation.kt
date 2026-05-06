package com.example.dhouhaelaouni.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dhouhaelaouni.data.Category
import com.example.dhouhaelaouni.data.Difficulty
import com.example.dhouhaelaouni.ui.screens.*

sealed class Screen(val route: String) {
    object Splash        : Screen("splash")
    object MainMenu      : Screen("main_menu")
    object Category      : Screen("category")
    object Settings      : Screen("settings/{timerOn}/{funFacts}/{sound}/{difficulty}") {
        fun createRoute(timerOn: Boolean, funFacts: Boolean, sound: Boolean, difficulty: String) =
            "settings/$timerOn/$funFacts/$sound/$difficulty"
    }
    object Quiz          : Screen("quiz/{category}/{difficulty}/{timer}/{funFacts}") {
        fun createRoute(category: String, difficulty: String, timer: Boolean, funFacts: Boolean) =
            "quiz/$category/$difficulty/$timer/$funFacts"
    }
    object Result        : Screen("result/{score}/{correct}/{total}/{category}/{difficulty}") {
        fun createRoute(score: Int, correct: Int, total: Int, category: String, difficulty: String) =
            "result/$score/$correct/$total/$category/$difficulty"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Settings state lifted here so it persists across navigation
    var timerEnabled by remember { mutableStateOf(true) }
    var showFunFacts by remember { mutableStateOf(true) }
    var soundEnabled by remember { mutableStateOf(false) }
    var difficulty   by remember { mutableStateOf(Difficulty.MEDIUM) }
    var category     by remember { mutableStateOf(Category.ROMAN) }

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(onFinished = {
                navController.navigate(Screen.MainMenu.route) {
                    // We pop Splash to avoid loops, but since user wants to go back,
                    // we'll handle explicit navigation back in MainMenu.
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        composable(Screen.MainMenu.route) {
            MainMenuScreen(
                onStartGame = { 
                    navController.navigate(Screen.Quiz.createRoute(category.name, difficulty.name, timerEnabled, showFunFacts)) 
                },
                onByCategory = { navController.navigate(Screen.Category.route) },
                onSettings = { 
                    navController.navigate(Screen.Settings.createRoute(timerEnabled, showFunFacts, soundEnabled, difficulty.name)) 
                },
                onBack = {
                    navController.navigate(Screen.Splash.route) {
                        popUpTo(Screen.MainMenu.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Category.route) {
            CategoryScreen(
                onBack = { navController.popBackStack() },
                onCategorySelected = { selected ->
                    category = selected
                    navController.navigate(
                        Screen.Quiz.createRoute(
                            selected.name, difficulty.name, timerEnabled, showFunFacts
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.Settings.route,
            arguments = listOf(
                navArgument("timerOn")    { type = NavType.BoolType },
                navArgument("funFacts")   { type = NavType.BoolType },
                navArgument("sound")      { type = NavType.BoolType },
                navArgument("difficulty") { type = NavType.StringType }
            )
        ) {
            SettingScreen(
                onBack = { navController.popBackStack() },
                onSave = { t, d, f, s ->
                    timerEnabled = t; difficulty = d
                    showFunFacts = f; soundEnabled = s
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.Quiz.route,
            arguments = listOf(
                navArgument("category")   { type = NavType.StringType },
                navArgument("difficulty") { type = NavType.StringType },
                navArgument("timer")      { type = NavType.BoolType },
                navArgument("funFacts")   { type = NavType.BoolType }
            )
        ) { back ->
            val cat  = Category.valueOf(back.arguments?.getString("category") ?: Category.ROMAN.name)
            val diff = Difficulty.valueOf(back.arguments?.getString("difficulty") ?: Difficulty.MEDIUM.name)
            QuizScreen(
                category     = cat,
                difficulty   = diff,
                timerEnabled = back.arguments?.getBoolean("timer") ?: true,
                showFunFacts = back.arguments?.getBoolean("funFacts") ?: true,
                onExit = { navController.popBackStack(Screen.MainMenu.route, false) },
                onFinished = { score, correct, total ->
                    navController.navigate(
                        Screen.Result.createRoute(score, correct, total, cat.name, diff.name)
                    ) { popUpTo(Screen.Quiz.route) { inclusive = true } }
                }
            )
        }

        composable(
            route = Screen.Result.route,
            arguments = listOf(
                navArgument("score")      { type = NavType.IntType },
                navArgument("correct")    { type = NavType.IntType },
                navArgument("total")      { type = NavType.IntType },
                navArgument("category")   { type = NavType.StringType },
                navArgument("difficulty") { type = NavType.StringType }
            )
        ) { back ->
            val args = back.arguments!!
            ResultScreen(
                score           = args.getInt("score"),
                correctCount    = args.getInt("correct"),
                totalQuestions  = args.getInt("total"),
                category        = Category.valueOf(args.getString("category") ?: Category.ROMAN.name),
                difficulty      = Difficulty.valueOf(args.getString("difficulty") ?: Difficulty.MEDIUM.name),
                onPlayAgain     = { navController.navigate(
                    Screen.Quiz.createRoute(category.name, difficulty.name, timerEnabled, showFunFacts)
                ) { popUpTo(Screen.Result.route) { inclusive = true } } },
                onChooseCategory = { navController.navigate(Screen.Category.route) {
                    popUpTo(Screen.Result.route) { inclusive = true }
                }}
            )
        }
    }
}
