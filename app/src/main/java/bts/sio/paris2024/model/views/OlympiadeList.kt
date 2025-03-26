package bts.sio.paris2024.model.views

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024.model.viewsmodel.OlympiadeViewModel // Assurez-vous que l'import est correct

@Composable
fun OlympiadeList(viewModel: OlympiadeViewModel = viewModel()) {
    val olympiade by viewModel.olympiade.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!, color = Color.Red)
        else -> LazyColumn {
            items(olympiade) { olympiade ->
                OlympiadeCard(olympiade = olympiade)
            }
        }
    }
}
