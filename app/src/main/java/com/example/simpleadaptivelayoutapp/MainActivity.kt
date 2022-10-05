package com.example.simpleadaptivelayoutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleadaptivelayoutapp.ui.theme.ScreenLayout
import com.example.simpleadaptivelayoutapp.ui.theme.SimpleAdaptiveLayoutAppTheme
import com.example.simpleadaptivelayoutapp.ui.theme.WindowInf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleAdaptiveLayoutAppTheme {
                // A surface container using the 'background' color from the theme
                val configuration = ScreenLayout()

                if(configuration.screenWidthInfo is WindowInf.WindowType.Compact){
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(10) {
                            Text(
                                text = "item $it",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                                    .background(Color.Blue),
                                fontSize = 25.sp
                            )
                        }
                        items(10) {
                            Text(
                                text = "item $it",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                                    .background(Color.Green),
                                fontSize = 25.sp
                            )
                        }
                    }
                }

                else{
                    Row(modifier = Modifier.fillMaxSize()){
                        LazyColumn(modifier = Modifier.weight(1f)){
                            items(10) {
                                Text(
                                    text = "item $it",
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .background(Color.Blue),
                                    fontSize = 25.sp
                                )
                            }
                        }
                        LazyColumn(Modifier.weight(1f)){
                            items(10) {
                                Text(
                                    text = "item $it",
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                        .background(Color.Green),
                                    fontSize = 25.sp
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) {
            Text(
                text = "item $it",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color.Blue),
                fontSize = 25.sp
            )
        }
        items(10) {
            Text(
                text = "item $it",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color.Green),
                fontSize = 25.sp
            )
        }
    }
}

