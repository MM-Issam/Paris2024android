package bts.sio.paris2024.model.viewsmodel

import androidx.lifecycle.ViewModel
import bts.sio.paris2024.model.Joueur
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024.api.RetrofitInstance

class JoueurViewModel : ViewModel() {
    private val _joueur = MutableStateFlow<List<Joueur>>(emptyList())
    val joueur: StateFlow<List<Joueur>> = _joueur

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getJoueur()
    }

    private fun getJoueur() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getJoueur()
                _joueur.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
