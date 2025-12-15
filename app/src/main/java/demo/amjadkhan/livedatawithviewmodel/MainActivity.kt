package demo.amjadkhan.livedatawithviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import demo.amjadkhan.livedatawithviewmodel.ui.theme.LivedatawithviewmodelTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: NameViewModel
    var currentNameOfUser = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // here we have replace the method with the indexing operator
        // viewModel = ViewModelProvider(this).get(NameViewModel::class.java)
        viewModel = ViewModelProvider(this)[NameViewModel::class.java]

        setContent {
            LivedatawithviewmodelTheme {
                var currentNameOfUser by remember {
                    mutableStateOf(viewModel.getCurrentName().value ?: "NA" )
                }

                LaunchedEffect(Unit) {
                    viewModel.getCurrentName().observe(this@MainActivity) { name ->
                        currentNameOfUser = name ?: "NA";
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "$currentNameOfUser",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Column {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
            Button(onClick = {
                viewModel.getCurrentName().value = "Amjad"
            }) {
                Text(text = "Click Me")
            }
        }
    }

}
