package com.example.i_choose_you
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
                            painter = painterResource(id = R.drawable.cinedrawn),
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
fun Home(name: String, modifier: Modifier = Modifier) {
    var sorteio by remember { mutableIntStateOf(1) }
    val imgsorteada = when (sorteio) {
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
        else -> R.drawable.sixtysecondsposter
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 20.dp)
    ) {
        Text(
            text = name,
            fontSize = 57.5.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.interroga),
            contentDescription = "Interrogação",
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 50.dp)
        )
        Button(
            onClick = { sorteio = (1..12).random() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
            ),
            modifier = Modifier.size(width = 324.dp, height = 58.06.dp)
        ) {
            Text(
                text = "Sorteie o Filme",
                fontSize = 26.77.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.White
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