package com.example.navegation2.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navegation2.components.MainButton
import com.example.navegation2.components.MainIconButton
import com.example.navegation2.components.Space
import com.example.navegation2.components.TitleBar
import com.example.navegation2.components.TitleView
import androidx.compose.ui.graphics.Color



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController,id: Int, opcional: String?){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail view")},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Blue),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()

                        }
                }
            )
        }
    ){
        ContentDetailView(navController,id,opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController,id: Int, opcional: String?){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TitleView(name = "Detail View")
        Space()
        TitleView(name = id.toString())
        Space()

        if(opcional==""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = opcional.orEmpty() )
        }
        MainButton(name = "Return", backColor = Color.Blue , color = Color.White) {
            navController.popBackStack()
        }
    }

}


