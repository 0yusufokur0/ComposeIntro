package com.resurrection.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resurrection.composeintro.ui.theme.cBlue
import com.resurrection.composeintro.ui.theme.cGreen
import com.resurrection.composeintro.ui.theme.cGrey
import com.resurrection.composeintro.ui.theme.cRed

class MainActivity : ComponentActivity() {
    private val context = this

    @ExperimentalUnitApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* ComposeIntroTheme { Surface { DefaultPreview() } } */
            MainActivityUi()
        }
    }

    @ExperimentalUnitApi
    @ExperimentalFoundationApi
    @Preview(showBackground = true)
    @Composable
    fun MainActivityUi() {
        Box(
            Modifier
                .background(cGrey)
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(start = 10)

        ) {
            LazyColumn {
                itemsIndexed((1..100).toList()) {index, item->
                    Row(
                        modifier = Modifier.padding(3.dp)
                    ) {
                        Text(
                            text = item.toString(),
                            modifier = Modifier
                                .width(50)
                                .combinedClickable(
                                    onClick = {},
                                    onLongClick = { toast(context,item.toString() +"index of item $index") }
                                )
                        ,
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                        Button(
                            onClick = { toast(context,item.toString()) },
                            modifier = Modifier.animateContentSize()
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

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(
        Modifier
            .background(cBlue)
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(start = 50)
            .size(15.dp)

    ) {
        LazyColumn {
            items((1..1000).toList()) {
                Text(
                    text = "Hi Bro",
                    Modifier.clickable {

                    },
                    fontSize = 30,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,

                    )
            }
        }
    }

}



