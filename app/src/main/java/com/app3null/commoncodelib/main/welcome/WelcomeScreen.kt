package com.app3null.commoncodelib.main.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app3null.common_code.extensions.notNull

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = hiltViewModel(),
    onClickToDetailScreen: () -> Unit = {}
) {
    with(viewModel) {
        getLiveViewState()
            .observe(
                LocalLifecycleOwner.current
            ) {
                it.goToDetailsScreen?.getValue().notNull {
                    onClickToDetailScreen()
                }
            }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "WELCOME SCREEN",
            fontSize = 50.sp,
            modifier = Modifier.clickable {
                viewModel.goToDetailsScreen()
            }
        )

    }
}

@Composable
@Preview(showBackground = true)
fun ShowWelcomeScreen() {
    WelcomeScreen()
}