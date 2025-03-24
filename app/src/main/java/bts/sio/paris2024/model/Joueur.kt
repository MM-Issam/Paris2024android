package bts.sio.paris2024.model

import java.time.LocalDate

data class Joueur(
    val id: Int,
    val nom: String,
    val prenom: String,
    val dateNaiss: String,
    val niveau: Niveau,
    val sport: Sport
)
