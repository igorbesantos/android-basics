package br.dev.ibs.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.dev.ibs.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var step by remember { mutableIntStateOf(1) }
    var imagePainter: Painter;
    var contentDescription: String;
    var text: String;

    when(step) {
        1 -> {
            imagePainter = painterResource(id = R.drawable.lemon_tree)
            contentDescription = stringResource(R.string.lemon_tree_description)
            text = stringResource(R.string.instruction_step_1)
        }
        2 -> {
            imagePainter = painterResource(id = R.drawable.lemon_squeeze)
            contentDescription = stringResource(R.string.lemon_squeeze_description)
            text = stringResource(R.string.instruction_step_2)
        }
        3 -> {
            imagePainter = painterResource(id = R.drawable.lemon_drink)
            contentDescription = stringResource(R.string.lemon_drink_description)
            text = stringResource(R.string.instruction_step_3)
        }
        else -> {
            imagePainter = painterResource(id = R.drawable.lemon_restart)
            contentDescription = stringResource(R.string.lemon_restart_description)
            text = stringResource(R.string.instruction_step_4)
        }
    }

    LemonadeStep(
        painter = imagePainter,
        contentDescription = contentDescription,
        text = text,
        onNext = {
            if (step > 3) {
                step = 1
            } else if (step != 2 || (1..5).random() == 1) {
                 step += 1;
            }
        },
        modifier = modifier
    )
}

@Composable
fun LemonadeStep(
    painter: Painter,
    contentDescription: String,
    text: String,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier.width(IntrinsicSize.Max),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface (
                color = colorResource(id = R.color.lime),
                shape = RoundedCornerShape(32.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(250.dp)
                    .clickable {
                        onNext()
                    }
            ) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .padding(32.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(32.dp)
                    .width(IntrinsicSize.Min)
            )
            Text(
                text = text,
                fontSize = 18.sp,
                modifier = Modifier.width(IntrinsicSize.Max)
            )
        }
    }
}