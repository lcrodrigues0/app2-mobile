package com.example.dogcatapp.view

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.dogcatapp.R
import com.example.dogcatapp.databinding.ActivityHomeBinding
import com.example.dogcatapp.utils.MyPreferences
import kotlin.random.Random

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    object SentencesStore {
         val dogSentences: Array<String> = arrayOf(
            "O cão é o único ser no mundo que te ama mais do que a si mesmo.",
            "Os cães não são nossa vida inteira, mas eles a tornam completa.",
            "Os cães são nossa conexão com o paraíso. Eles nos ensinam como amar incondicionalmente.",
            "A felicidade de um cão é simples: uma bola, um amigo e muito carinho.",
            "Cachorros têm a habilidade de mostrar o que é realmente importante na vida: amor e lealdade.",
            "Onde quer que você vá, o amor de um cão estará lá esperando por você.",
            "Eles não têm palavras, mas seus olhos dizem tudo o que precisamos ouvir.",
            "Um cachorro é a única coisa na terra que te ama mais do que a si mesmo.",
            "Cães não fazem perguntas, eles apenas dão respostas: amor incondicional.",
            "O melhor amigo do homem é um cachorro, porque eles nunca pedem nada além de carinho e atenção."
        )
         val catSentences: Array<String> = arrayOf(
            "Gatos são os mestres da paciência e da suavidade.",
            "Um gato é um enigma disfarçado de animal de estimação.",
            "Catar a felicidade é fácil quando se tem um gato ao seu lado.",
            "Os gatos têm uma maneira de se fazer presentes, mesmo quando não estão ao seu lado.",
            "O melhor remédio para um dia ruim é um abraço de gato.",
            "Gatos são criaturas que nos ensinam a viver o momento e a buscar tranquilidade.",
            "Eles não pedem atenção, eles simplesmente conquistam.",
            "Cuidar de um gato é aprender a arte de amar de maneira silenciosa e graciosa.",
            "Quando um gato se aproxima, o mundo inteiro parece mais calmo e sereno.",
            "Gatos são especialistas em tornar qualquer lugar em casa, só com sua presença."
        )
    }

    private var dogSelected: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.greetingsTv.text = getString(R.string.greetings, MyPreferences(this).getString("username"))

        binding.dogBtn.setOnClickListener(this)
        binding.catBtn.setOnClickListener(this)
        binding.generateBtn.setOnClickListener(this)

        binding.sentenceTv.text = SentencesStore.dogSentences[Random.nextInt(10)]

    }

    override fun onClick(view: View) {
        if(view.id == R.id.cat_btn && dogSelected){
            dogSelected = false
            binding.catBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.yellow))
            binding.dogBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white))

            binding.sentenceTv.text = SentencesStore.catSentences[Random.nextInt(10)]

        } else if(view.id == R.id.dog_btn && !dogSelected){
            dogSelected = true
            binding.dogBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.yellow))
            binding.catBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white))

            binding.sentenceTv.text = SentencesStore.dogSentences[Random.nextInt(10)]

        } else if(view.id == R.id.generate_btn){
            if(dogSelected)
                binding.sentenceTv.text = SentencesStore.dogSentences[Random.nextInt(10)]
            else
                binding.sentenceTv.text = SentencesStore.catSentences[Random.nextInt(10)]
        }
    }
}