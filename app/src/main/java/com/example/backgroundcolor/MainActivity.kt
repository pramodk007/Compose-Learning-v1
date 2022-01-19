package com.example.backgroundcolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.backgroundcolor.ui.theme.BackgroundColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        CustomStyledText(
            displayText = "This is the default text style"
        )
        CustomStyledText(
            displayText = "This text is blue in color",
            style = TextStyle(
                color = Color.Blue
            )
        )
        CustomStyledText(
            displayText = "This text has a bigger font size",
            style = TextStyle(fontSize = 20.sp)
        )
        CustomStyledText(
            displayText = "This text is bold",
            style = TextStyle(fontWeight = W700)
        )
        CustomStyledText(
            displayText = "This text is italic",
            style = TextStyle(fontStyle = FontStyle.Italic)
        )
        CustomStyledText(
            displayText = "This text is using a custom font family",
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        CustomStyledText(
            displayText = "This text has an underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        CustomStyledText(
            displayText = "This text has a strikethrough line",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        CustomStyledText(
            displayText = "This text will add an ellipsis to the end of the text if the text is longer that 1 line long.",
            maxLines = 1
        )
        CustomStyledText(
            displayText = "This text has a shadow",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black, blurRadius = 10f,
                    offset = Offset(2f, 2f)
                )
            )
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "This text is center aligned",
                style = TextStyle(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
        Divider(color = Color.DarkGray)

        CustomStyledText(
            displayText = "This text will demonstrate how to justify " +
                    "your paragraph to ensure that the text that ends with a soft " +
                    "line break spreads and takes the entire width of the container",
            style = TextStyle(
                textAlign = TextAlign.Justify
            )
        )

        CustomStyledText(
            displayText = "This text will demonstrate how to add " +
                    "indentation to your text. In this example, indentation was only " +
                    "added to the first line. You also have the option to add " +
                    "indentation to the rest of the lines if you'd like",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                textIndent = TextIndent(firstLine = 30.sp)
            )
        )

        CustomStyledText(
            displayText = "The line height of this text has been " +
                    "increased hence you will be able to see more space between each " +
                    "line in this paragraph.",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        )

        val annotatedString = buildAnnotatedString {
            append("this string has style spans")
            addStyle(style = SpanStyle(color = Color.Red), start = 0, end = 4)
            addStyle(style = SpanStyle(color = Color.Green), start = 5, end = 21)
            addStyle(style = SpanStyle(color = Color.Magenta), start = 22, end = 27)
        }
        Text(text = annotatedString, modifier = Modifier.padding(16.dp))

        Divider(color = Color.DarkGray)

        Surface(color = Color.Yellow){
            Text(
                text = "This text has a background color",
                modifier = Modifier.padding(16.dp)
            )
        }

    }
}

@Composable
fun CustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
    Divider(color = Color.DarkGray)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BackgroundColorTheme {
        MyApp()
    }
}