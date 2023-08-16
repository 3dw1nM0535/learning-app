package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.learntogether.ui.theme.LearnTogetherTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTogether(getString(R.string.jetpack_compose_tutorial), getString(R.string.paragraph_1), getString(R.string.paragraph_2))
                }
            }
        }
    }
}

@Composable
fun LearnTogether(title: String, paragraph_1: String, paragraph_2: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        GreetingImage()
        CourseDescription(title, paragraph_1, paragraph_2, modifier)
    }
}

@Composable
fun GreetingImage() {
    val image = painterResource(R.drawable.bg_compose_background)
    Box {
        Image(
            painter = image,
            contentDescription = null,
        )
    }
}

@Composable
fun CourseDescription(title: String, paragraph_1: String, paragraph_2: String, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = title,
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Text(
            text = paragraph_1,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = paragraph_2,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        LearnTogether(stringResource(R.string.jetpack_compose_tutorial), stringResource(R.string.paragraph_1), stringResource(R.string.paragraph_2))
    }
}