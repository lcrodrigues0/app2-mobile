package com.example.dogcatapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogcatapp.repository.SentenceRepository
import com.example.dogcatapp.repository.client.FactClientRetrofit
import com.example.dogcatapp.repository.model.CatFactEntity
import com.example.dogcatapp.repository.model.DogFactEntity
import com.example.dogcatapp.repository.service.DogFactService
import com.example.dogcatapp.repository.service.CatFactService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private var currentSentence: String = ""
    private var currentAnimal = MutableLiveData<String>()
    private var sentenceRepository = SentenceRepository()

    private val CatFactService = FactClientRetrofit.createCatFactService(CatFactService::class.java)
    private val DogFactService = FactClientRetrofit.createDogFactService(DogFactService::class.java)

    fun getCurrentSentence(): String{
        return currentSentence
    }

    fun getCurrentAnimal(): LiveData<String>{
        return currentAnimal
    }

    fun newSentence(animal: String){
        if (animal == "cat"){
            val listCall: Call<CatFactEntity> = CatFactService.getFact();

            listCall.enqueue(object : Callback<CatFactEntity> {
                override fun onResponse(
                    call: Call<CatFactEntity>,
                    response: Response<CatFactEntity>
                ) {
                    currentSentence = response.body()!!.fact
                }

                override fun onFailure(call: Call<CatFactEntity>, t: Throwable) {
                    currentSentence = "ERRO API CAT!!"
                }
            })

        }
        else if(animal == "dog"){
            val listCall: Call<DogFactEntity> = DogFactService.getFact();

            listCall.enqueue(object : Callback<DogFactEntity> {
                override fun onResponse(
                    call: Call<DogFactEntity>,
                    response: Response<DogFactEntity>
                ) {
                    currentSentence = response.body()!!.fact[0]
                }

                override fun onFailure(call: Call<DogFactEntity>, t: Throwable) {
                    currentSentence = "ERRO API DOG!!"
                }
            })
        }
    }

    fun setCurrentAnimal(animal: String){
        currentAnimal.value = animal
        newSentence(animal)
    }
}