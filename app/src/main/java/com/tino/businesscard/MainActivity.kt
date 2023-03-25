package com.tino.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tino.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .background(Color(0xfff9f0d8))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Bio("Faustino Andrade", "Founder")
        ContactInfo()
    }
}

@Composable
fun Bio(name: String, title: String) {
    val image = painterResource(id = R.drawable.cream_logo)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(bottom = 128.dp).fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = "The logo of the business is a digital photo of a musical record.",
            modifier = Modifier
                .height(200.dp)
                .padding(bottom = 24.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ContactInfo() {
    ContactRow(Icons.Filled.Home, stringResource(R.string.stellar_tempo_website))
    ContactRow(Icons.Filled.Call, stringResource(R.string.phone_number))
    ContactRow(Icons.Filled.Share, stringResource(R.string.instagram_handle))
    ContactRow(Icons.Filled.Email, stringResource(R.string.email_address))
}

@Composable
fun ContactRow(icon: ImageVector, contactInfo: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 64.dp, end = 64.dp, bottom = 20.dp)
                .height(28.dp)
                .width(28.dp)
        )
        Text(
            text = contactInfo,
            fontSize = 18.sp,
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}