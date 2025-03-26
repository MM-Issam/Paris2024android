package bts.sio.paris2024.model.viewsmodel

import androidx.lifecycle.ViewModel
import bts.sio.paris2024.model.Athlete
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024.api.RetrofitInstance

class AthleteViewModel : ViewModel() {
    private val _athlete = MutableStateFlow<List<Athlete>>(emptyList())
    val athlete: StateFlow<List<Athlete>> = _athlete

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getAthlete()
    }

    private fun getAthlete() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getAthlete()
                _athlete.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false


            }

        }
    }
}
