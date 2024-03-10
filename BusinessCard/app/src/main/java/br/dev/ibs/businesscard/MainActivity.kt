package br.dev.ibs.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.dev.ibs.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Surface (
        modifier = modifier.fillMaxSize(),
        color = colorResource(R.color.green_bg)
    ) {
        Box (
            modifier = modifier
                .fillMaxSize(1f)
                .padding(16.dp)
        ) {
            PersonalInfo(
                name = "Jennifer Doe",
                title = "Android Developer",
                modifier = modifier.align(Alignment.Center)
            )
            ContactContainer(
                number = "+12 (123) 444 555 666",
                social = "@AndroidDev",
                email = "user@android.com",
                modifier = modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun PersonalInfo(modifier: Modifier, name: String, title: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(painter = painterResource(
            id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            tint = colorResource(id = R.color.green_ic),
            modifier = Modifier
                .background(color = colorResource(id = R.color.blue_bg))
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = title,
            color = colorResource(id = R.color.green_fg),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ContactContainer(modifier: Modifier, number: String, social: String, email: String) {
    Column (
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            horizontalAlignment = Alignment.Start,
            modifier = modifier
        ) {
            ContactLine(
                icon = Icons.Rounded.Call,
                text = number,
                modifier = modifier
            )
            Spacer(Modifier.height(16.dp))
            ContactLine(
                icon = Icons.Rounded.Share,
                text = social,
                modifier = modifier
            )
            Spacer(Modifier.height(16.dp))
            ContactLine(
                icon = Icons.Rounded.Email,
                text = email,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ContactLine(icon: ImageVector, text: String, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier
                .size(32.dp),
            tint = colorResource(id = R.color.green_fg)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}