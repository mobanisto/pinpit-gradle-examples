import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Pinpit Compose Hello World",
            icon = painterResource("icon.svg")
        ) {
            var text by remember { mutableStateOf("Hello, World!") }

            MaterialTheme {
                Button(modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp), onClick = {
                    text = "Hello, Desktop!"
                }) {
                    Text(text)
                }
            }
        }
    }
}
