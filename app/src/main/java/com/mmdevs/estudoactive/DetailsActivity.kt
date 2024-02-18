package com.mmdevs.estudoactive


import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mmdevs.estudoactive.databinding.ActivityDetailsBinding

import com.mmdevs.valorantapiapp.models.DataItem
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
	private lateinit var binding: ActivityDetailsBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDetailsBinding.inflate(layoutInflater)
		setContentView(binding.root)

		var topBar = binding.toolbar2

		setSupportActionBar(topBar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)

		topBar.navigationIcon = resources.getDrawable(R.drawable.baseline_arrow_back_ios_24, theme)

		val agente = intent.extras;

		if(agente != null){
			val detailAgente = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
				agente.getParcelable("agente",DataItem::class.java)
			} else {
				agente.getParcelable("agente")
			}

			topBar.title = "${ detailAgente?.displayName }"

			Picasso.get().load(detailAgente?.displayIcon).into(binding.AgenteImage)

			binding.descriptionAgente.text = detailAgente?.description


			val gradientColors = detailAgente?.backgroundGradientColors?.mapNotNull { parseColor("#$it") }

			val gradientDrawable = GradientDrawable(
				GradientDrawable.Orientation.LEFT_RIGHT,
				gradientColors?.toIntArray()
			)



			topBar.setBackgroundColor(getColor(R.color.topBar))


		}

	}

	override fun onSupportNavigateUp(): Boolean {
		finish()
		return true
	}
	private fun parseColor(colorString: String): Int {
		return Color.parseColor(colorString)
	}

}