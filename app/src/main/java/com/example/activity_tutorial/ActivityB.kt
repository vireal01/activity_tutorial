package com.example.activity_tutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.activity_tutorial.ui.theme.Activity_tutorialTheme

class ActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val textOfSameTask = "The activity was opened in the same task"
        val textOfDiffetentTask = "The activity was opened in a different task"
        val text = if (intent.getBooleanExtra("isNewTask", false))
            textOfDiffetentTask else textOfSameTask

        super.onCreate(savedInstanceState)
        setContent {
            Activity_tutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = text)
                        Button(
                            onClick = {
                                val intent = ActivityC.newIntent(applicationContext)
                                startActivity(intent)
                            },
                        ) {
                            Text(text = "Open Activity C")
                        }
                    }
                }
            }
        }
    }

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, ActivityB::class.java)
            return intent
        }
    }
}