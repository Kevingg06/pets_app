package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RandomDogRepository
import com.example.myapplication.repository.SearchDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchDogViewModel(private val repository: SearchDogRepository = SearchDogRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateSearchDogViewModel>()
    private val data: LiveData<StateSearchDogViewModel> = _data

    private val _selectedImageUrl = MutableLiveData<String?>()
    val selectedImageUrl: LiveData<String?> = _selectedImageUrl

    fun getSearchDogs(breed : String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getSearchDogs(breed)
            if (response.isSuccessful) {
                response.body()?.let {
                    _data.postValue(StateSearchDogViewModel.Success(it))
                } ?: _data.postValue(StateSearchDogViewModel.Error("No data"))
            } else {
                _data.postValue(StateSearchDogViewModel.Error("Service error"))
            }
        }
    }

    fun getData(): LiveData<StateSearchDogViewModel>{
        return this.data
    }

}