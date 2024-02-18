package com.mmdevs.estudoactive
import com.mmdevs.valorantapiapp.models.AgenteModel
import retrofit2.http.GET

interface IAgentesServices {

	@GET("/v1/agents?language=pt-BR&isPlayableCharacter=true")
	suspend fun getListAgentes(): AgenteModel

}