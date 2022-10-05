package com.example.simpleadaptivelayoutapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.WindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScreenLayout():WindowInf{
    val configuration= LocalConfiguration.current
    return WindowInf(
        screenWidthInfo = when{
            configuration.screenWidthDp<=600 ->WindowInf.WindowType.Compact
            configuration.screenWidthDp<=840 ->WindowInf.WindowType.Medium
            else -> WindowInf.WindowType.Expanded
        },

        screenheigthInfo = when{
            configuration.screenHeightDp<=480 ->WindowInf.WindowType.Compact
            configuration.screenHeightDp<=840 ->WindowInf.WindowType.Medium
            else -> WindowInf.WindowType.Expanded
        },

        screenWidth = configuration.screenWidthDp.dp,

        screenheigth = configuration.screenHeightDp.dp
    )
}

data class WindowInf(
    val screenWidthInfo:WindowType,
    val  screenheigthInfo: WindowType,
    val screenWidth: Dp,
    val screenheigth: Dp
        ){
    sealed class WindowType(){
        object Compact:WindowType()
        object Medium:WindowType()
        object Expanded:WindowType()
    }
}