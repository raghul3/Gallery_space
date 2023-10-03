package com.raghul.artspace

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raghul.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()

                }
            }
        }
    }
}


@Composable
fun ArtSpace(){
    var taker by remember{ mutableStateOf(1) }
    val imageRes = when (taker) {
        1 -> R.drawable.image1
        2 -> R.drawable.image2
        3 -> R.drawable.image3
        4 -> R.drawable.image4
        else -> R.drawable.image5
    }

    val quotes = when (taker){
        1 -> R.string.quote1
        2 -> R.string.quote2
        3 -> R.string.quote3
        4 -> R.string.quote4
        else -> R.string.quote5

    }

    val name = when(taker){
        1-> R.string.imagename1
        2-> R.string.imagename1
        3-> R.string.imagename1
        4-> R.string.imagename1
        else-> R.string.imagename1
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .size(height = 500.dp, width = 350.dp)
                .border(BorderStroke(3.dp, SolidColor(Color.Black)), RectangleShape)
                .shadow(12.dp, RectangleShape)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .border(BorderStroke(30.dp, SolidColor(Color.White)), RectangleShape)
                    .shadow(12.dp, RectangleShape)
                //.padding(borderWidth)
                //.clip(RectangleShape)

            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .wrapContentSize(Alignment.Center),


            ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                , shape = RectangleShape

            ) {
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(text = stringResource(quotes),Modifier.align(Alignment.Start))

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = stringResource(name),Modifier.align(Alignment.Start),
                        color= colorResource(id = R.color.Argentine),

                        fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        //BUTTONS
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            OutlinedButton(     //PREVIOUS BUTTON
                modifier= Modifier.size(width = 150.dp, height =50.dp),
                onClick = {taker = when (taker) {1 -> 1 else -> --taker }
                }) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(50.dp))

            OutlinedButton(     //NEXT BUTTON
                modifier= Modifier.size(width = 150.dp, height =50.dp),
                onClick = {taker = when (taker) { in 1..4 -> ++taker else -> 1}
                }) {
                Text(text = "Next")
            }
        }

    }
}


//static model
@Composable
fun image (){


    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
        ) {
        Image(painter = painterResource(id = R.drawable.image1 ), contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .border(border = BorderStroke(2.dp, Color.Transparent), shape = RectangleShape)
                .height(350.dp)
                .width(300.dp)
                .shadow(elevation = 5.dp, shape = RectangleShape)
                .padding(20.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        text()

        Spacer(modifier = Modifier.height(40.dp))

        button()
    }


}

@Composable
fun text(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            , shape = RectangleShape

    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(text = stringResource(id = R.string.quote1),Modifier.align(Alignment.Start))
            
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(id = R.string.imagename1),Modifier.align(Alignment.Start),
                color= colorResource(id = R.color.Argentine),

                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun button(){

    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ) {
        
        OutlinedButton(onClick = { /*TODO*/ } ,contentPadding = PaddingValues(horizontal = 40.dp)
            ) {
            Text(text = stringResource(id = R.string.button1))
        }

        OutlinedButton(onClick = { /*TODO*/ },contentPadding = PaddingValues(horizontal = 50.dp)) {
            Text(text = stringResource(id = R.string.button2))

        }

    }

}