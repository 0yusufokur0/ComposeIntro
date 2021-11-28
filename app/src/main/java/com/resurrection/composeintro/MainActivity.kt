package com.resurrection.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resurrection.composeintro.ui.theme.ComposeIntroTheme
import com.resurrection.composeintro.ui.theme.cGreen
import com.resurrection.composeintro.ui.theme.cRed

class MainActivity : ComponentActivity() {
    private val context = this

    @ExperimentalUnitApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var myString = remember { mutableStateOf("") }

            ComposeIntroTheme {
                Surface {

                    Scaffold(topBar = { AppBar() }) {

                    }

                    Column {
                        Spacer(modifier = Modifier.padding(top = 80.dp))
                        SpecialTextField(value = myString.value) {
                            myString.value = it
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun AppBar() {
    TopAppBar(
        contentPadding = PaddingValues(10.dp),
        backgroundColor = Color.Red,
        elevation = 25.dp,
        modifier = Modifier.size(width = 150.dp, height = 50.dp)
    ) {
        Text(text = "Main Activity")
    }

}


@Composable
fun SpecialTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = onValueChange)
}


@Composable
fun FullScreen(content: @Composable () -> Unit) {
    Box( // Todo: Suface ile yapmak daha mantıklı
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        content()
    }
}

@Composable
fun Center(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            // Center
            .background(color = Color.Blue)
    ) {
        content()
    }
}


@ExperimentalUnitApi
@ExperimentalFoundationApi
@Composable
fun MainActivityUi() {


    LazyColumn {
        itemsIndexed((1..100).toList()) { index, item ->
            Row(
                modifier = Modifier.padding(3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.toString(),
                    modifier = Modifier
                        .combinedClickable(
                            onClick = {},
                            onLongClick = {
                                /* toast(
                                    context,
                                    item.toString() + "index of item $index"
                                )*/
                            }
                        )
                        .width(50),
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.padding(25.dp))
                Button(
                    onClick = { /*toast(context, item.toString())*/ },
                ) {

                    Text(
                        text = "$item $item",
                        modifier = Modifier
                            .background(cRed)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(3),
                        color = cGreen,
                        textDecoration = TextDecoration.LineThrough.plus(TextDecoration.Underline),
                    )
                }


            }
        }
    }


}

@ExperimentalFoundationApi
@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainActivityUi()

/*
    Box(
        Modifier
            .background(cBlue)
            .fillMaxHeight()
            .fillMaxSize(0.5f)
            .fillMaxWidth()
            .padding(start = 50)
            .size(15.dp)

    ) {
        LazyColumn(
            modifier = Modifier,
            verticalArrangement =Arrangement.Center,
            horizontalAlignment = Alignment.End
            ) {
            items((1..1000).toList()) {
                Column(
                    verticalArrangement =Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {


                    Text(
                        text = "Hi Bro",
                        Modifier
                            .clickable {

                            },
                        fontSize = 30,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,

                        )
                }
            }
        }
    }
*/

}




