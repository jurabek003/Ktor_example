package uz.turgunboyevjurabek.ktorexample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.ktorexample.data.data_source.remote.KtorApiClient
import uz.turgunboyevjurabek.ktorexample.domain.repository.MyRepository
import uz.turgunboyevjurabek.ktorexample.presentation.components.MyTextLists
import uz.turgunboyevjurabek.ktorexample.presentation.viewmodel.MyViewModel
import uz.turgunboyevjurabek.ktorexample.presentation.viewmodel.MyViewModelFactory
import uz.turgunboyevjurabek.ktorexample.ui.theme.KtorExampleTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MyViewModel

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiClient = KtorApiClient()
        val repository = MyRepository(apiClient = apiClient)
        val factory = MyViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MyViewModel::class.java]

        setContent {
            KtorExampleTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                       val posts by viewModel.posts.collectAsState()
                        MyTextLists(posts = posts)

                    }
                }
            }
        }
    }
}
//suspend fun main(){
//    val client= HttpClient(CIO)
//    val response:HttpResponse=client.get("https://jsonplaceholder.typicode.com/todos/1")
//    println(response.status)
//    println(response.bodyAsText())
//    client.close()
//}
