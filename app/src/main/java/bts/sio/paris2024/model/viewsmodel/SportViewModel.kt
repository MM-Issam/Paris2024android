package bts.sio.paris2024.model.viewsmodel

import androidx.lifecycle.ViewModel
import bts.sio.paris2024.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024.api.RetrofitInstance

class SportViewModel : ViewModel() {
    private val _sport = MutableStateFlow<List<Sport>>(emptyList())
    val sport: StateFlow<List<Sport>> = _sport

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getSport()
    }

    private fun getSport() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getSport()
                _sport.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
