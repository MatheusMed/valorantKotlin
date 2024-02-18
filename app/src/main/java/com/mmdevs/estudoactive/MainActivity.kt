package com.mmdevs.estudoactive

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.mmdevs.estudoactive.databinding.ActivityMainBinding
import com.mmdevs.valorantapiapp.models.DataItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.abs
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

	private lateinit var binding:ActivityMainBinding


	private var isAppBarExpanded = true

	private val apiService by lazy { HttpNetwork.apiClient }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		

		val progress = binding.circularProgressBar

		val topBar = binding.toolbar2

		topBar.title = "Lista de Agentes"


		progress.progressTintList = ColorStateList.valueOf(getColor(R.color.topBar));

		CoroutineScope(Dispatchers.IO).launch {
			try {

				val response = apiService.getListAgentes()
				progress.visibility = View.VISIBLE;
				withContext(Dispatchers.Main) {
					if (response.data!!.isNotEmpty()) {
						val dados = response.data;
						initRecicleView(dados)
						progress.visibility = View.GONE;
					} else {
						// Handle erro na resposta
						Log.e("SuaClasse", "Erro na requisição:")
					}
				}
			} catch (e: Exception) {

				Log.e("SuaClasse", "Erro na requisição: ${e.message}")
			} finally {
				progress.visibility = View.GONE;
			}
		}


	}


	private fun initRecicleView(
		listaAgentes: List<DataItem>
	){

		val datailsView = Intent(this,DetailsActivity::class.java)

		val layoutManager = LinearLayoutManager(this)
		binding.recyclerView.layoutManager = layoutManager
		binding.recyclerView.setHasFixedSize(true)
		binding.recyclerView.adapter = Adapter(listaAgentes){
			 datailsView.putExtra("agente",it)
			startActivity(datailsView)
		}
	}



}