package com.example.dogcatapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogcatapp.repository.SentenceRepository

class HomeViewModel: ViewModel() {
    private var currentSentence: String = ""
    private var currentAnimal = MutableLiveData<String>()
    private var sentenceRepository = SentenceRepository()

    fun getCurrentSentence(): String{
        return currentSentence
    }

    fun getCurrentAnimal(): LiveData<String>{
        return currentAnimal
    }

    fun newSentence(animal: String){
        if (animal == "cat")
            currentSentence = sentenceRepository.getCatSentence()
        else if(animal == "dog")
            currentSentence = sentenceRepository.getDogSentence()
    }

    fun setCurrentAnimal(animal: String){
        currentAnimal.value = animal
        newSentence(animal)
    }
}