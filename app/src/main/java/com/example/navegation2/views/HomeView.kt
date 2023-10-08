package com.example.navegation2.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegation2.components.ActionButton
import com.example.navegation2.components.MainButton
import com.example.navegation2.components.Space
import com.example.navegation2.components.TitleBar
import com.example.navegation2.components.TitleView
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView (navController: NavController){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "HomeView")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
        ) {
        ContentHomeView(navController)
    }
}

@OptIn (ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView (navController: NavController) {

    val id = 123
    var optional by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        TitleView(name= "Home View")
        Space()
        TextField(
            value = optional,
            onValueChange = {optional = it},
            label = { Text(text = "Opcional")}
        )
        MainButton(name = "Detail view", backColor = Color.Red , color = Color.White ) {
            navController.navigate("Detail/${id}/?{opcional}")
        }
    }
    }