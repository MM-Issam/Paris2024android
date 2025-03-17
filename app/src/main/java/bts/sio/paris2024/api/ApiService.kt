package bts.sio.paris2024.api

import bts.sio.paris2024.model.Athlete
import bts.sio.paris2024.model.Pays
import bts.sio.paris2024.model.Site
import bts.sio.paris2024.model.Sport
import retrofit2.http.GET

interface ApiService {
    @GET("/pays")
    suspend fun getPays(): List<Pays>
    @GET("/sports")
    suspend fun getSport(): List<Sport>
    @GET("/sites")
    suspend fun getSite(): List<Site>
    @GET("/athletes")
    suspend fun getAthlete(): List<Athlete>
    }