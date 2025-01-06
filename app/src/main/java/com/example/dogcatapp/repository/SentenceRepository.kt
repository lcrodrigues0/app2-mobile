package com.example.dogcatapp.repository

import kotlin.collections.get
import kotlin.random.Random

class SentenceRepository {
    // Classe para emular o acesso a uma API ou a um banco de dados

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

    fun getCatSentence(): String {
        return SentencesStore.catSentences[Random.nextInt(10)]
    }

    fun getDogSentence(): String {
        return SentencesStore.dogSentences[Random.nextInt(10)]
    }
}