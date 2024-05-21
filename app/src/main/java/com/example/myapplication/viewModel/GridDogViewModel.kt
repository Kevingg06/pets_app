package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.GridDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GridDogViewModel(private val repository: GridDogRepository = GridDogRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateGridViewModel>()
    private val data: LiveData<StateGridViewModel> = _data

    private val _selectedImageUrl = MutableLiveData<String?>()
    val selectedImageUrl: LiveData<String?> = _selectedImageUrl

    fun getGridDogs() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getGridDogs()
            if (response.isSuccessful) {
                response.body()?.let {
                    _data.postValue(StateGridViewModel.Success(it))
                } ?: _data.postValue(StateGridViewModel.Error("No data"))
            } else {
                _data.postValue(StateGridViewModel.Error("Service error"))
            }
        }
    }

    fun getData(): LiveData<StateGridViewModel>{
        return this.data
    }

    fun onImageClicked(imageUrl: String) {
        _selectedImageUrl.value = imageUrl
        ImageGridClick.imageGrid = imageUrl
    }
}

