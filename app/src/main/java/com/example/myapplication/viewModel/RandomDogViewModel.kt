package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RandomDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomDogViewModel(private val repository: RandomDogRepository = RandomDogRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateRandomDogViewModel>()
    private val data: LiveData<StateRandomDogViewModel> = _data

    private val _selectedImageUrl = MutableLiveData<String?>()
    val selectedImageUrl: LiveData<String?> = _selectedImageUrl

    fun getRandomDog(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getRandomDogs()
            if (response.isSuccessful) {
                response.body()?.let {
                    _data.postValue(StateRandomDogViewModel.Success(it))
                } ?: _data.postValue(StateRandomDogViewModel.Error("No data"))
            } else {
                _data.postValue(StateRandomDogViewModel.Error("Service error"))
            }
        }
    }

    fun getData(): LiveData<StateRandomDogViewModel>{
        return this.data
    }

}