package com.example.i_choose_you

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.i_choose_you.ui.theme.EscolhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EscolhaTheme(dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.movietheaterwallpaper),
                            contentDescription = "background",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Home(name = "CineDraw")
                    }
                }
            }
        }
    }
}

@Composable
fun Espacamento() {
    Spacer(modifier = Modifier.padding(16.dp))
}

@Composable
fun Home(name: String, modifier: Modifier = Modifier) {
    var sorteio by remember { mutableIntStateOf(0) }

    val imgsorteada = when (sorteio) {
        0 -> R.drawable.scorsese
        1 -> R.drawable.bansheesposter
        2 -> R.drawable.challengersposter
        3 -> R.drawable.eraserheadposter
        4 -> R.drawable.furyroadposter
        5 -> R.drawable.judaseomessiasposter
        6 -> R.drawable.johnwick4poster
        7 -> R.drawable.kaguyaposter
        8 -> R.drawable.legobatmanposter
        9 -> R.drawable.niceguysposter
        10 -> R.drawable.suicidesquadposter
        11 -> R.drawable.rogerrabbitposter
        12 -> R.drawable.marcelposter
        13 -> R.drawable.amoscaposter
        14 -> R.drawable.jessejamesposter
        15 -> R.drawable.firewalksposter
        16 -> R.drawable.diabodecadadiaposter
        17 -> R.drawable.amoscaposter
        18 -> R.drawable.liquidificadorposter
        19 -> R.drawable.indianaposter
        20 -> R.drawable.scottpilgrimposter
        21 -> R.drawable.caribeposter
        22 -> R.drawable.eofimposter
        23 -> R.drawable.punchdrunkposter
        24 -> R.drawable.saneamentoposter
        25 -> R.drawable.zathuraposter
        26 -> R.drawable.therightthingposter
        27 -> R.drawable.ondevivemposter
        28 -> R.drawable.dozemacacosposter
        else -> R.drawable.sixtysecondsposter
    }

    val textoSorteado = when (sorteio) {
        0 -> "Qual será o filme sorteado para hoje?"
        1 -> "Os Banshees de Inisherin"
        2 -> "Challengers"
        3 -> "Eraserhead"
        4 -> "Mad Max: Estrada da Fúria"
        5 -> "Judas e o Messias Negro"
        6 -> "John Wick 4: Baba Yaga"
        7 -> "O Conto da Princesa Kaguya"
        8 -> "Lego Batman"
        9 -> "The Nice Guys"
        10 -> "O Esquadrão Suicida"
        11 -> "Uma Cilada para Roger Rabbit"
        12 -> "Marcel, the Shell with Shoes On"
        13 -> "A Mosca"
        14 -> "O Assassinato de Jesse James pelo Covarde Robert Ford"
        15 -> "Twin Peaks: Fire Walk with Me"
        16 -> "O Diabo de Cada Dia"
        17 -> "A Mosca"
        18 -> "Reflexões de um Liquidificador"
        19 -> "Indiana Jones"
        20 -> "Scott Pilgrim Contra o Mundo"
        21 -> "Piratas do Caribe"
        22 -> "É o Fim"
        23 -> "Embriagado de Amor"
        24 -> "Saneamento Básico, o Filme"
        25 -> "Zathura: Uma Aventura Espacial"
        26 -> "Faça a Coisa Certa"
        27 -> "Onde Vivem os Monstros"
        28 -> "Os 12 Macacos"
        else -> "Gone in 60 Seconds"
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = name,
            fontSize = 57.5.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(imgsorteada),
            contentDescription = "Poster",
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 50.dp)
        )

        Text(
            text = textoSorteado,
            fontSize = 26.77.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Espacamento()

        Button(
            onClick = { sorteio = (1..28).random() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.size(width = 324.dp, height = 58.06.dp)
        ) {
            Text(
                text = "Sortear",
                fontSize = 26.77.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EscolhaTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Home(name = "CineDraw")
        }
    }
}