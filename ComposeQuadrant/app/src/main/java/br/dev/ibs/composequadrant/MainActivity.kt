package br.dev.ibs.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.dev.ibs.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = stringResource(id = R.string.text_composable_title),
                text = stringResource(id = R.string.text_composable_desc),
                color = colorResource(id = R.color.quadrant_1_color),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.image_composable_title),
                text = stringResource(id = R.string.image_composable_desc),
                color = colorResource(id = R.color.quadrant_2_color),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ){
            Quadrant(
                title = stringResource(id = R.string.row_composable_title),
                text = stringResource(id = R.string.row_composable_desc),
                color = colorResource(id = R.color.quadrant_3_color),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(id = R.string.column_composable_title),
                text = stringResource(id = R.string.column_composable_desc),
                color = colorResource(id = R.color.quadrant_4_color),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(title: String, text: String, color: Color, modifier: Modifier = Modifier) {
    Box(modifier) {
        Surface(modifier.background(color = color)){}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .background(color)
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = text,
                textAlign = TextAlign.Justify
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        Quadrants()
    }
}