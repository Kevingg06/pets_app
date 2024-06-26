package com.example.myapplication.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogViewModel(private val repository: DogRepository = DogRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateViewModel>()
    val data: LiveData<StateViewModel> = _data

    private val _selectedImageUrl = MutableLiveData<String?>()
    private val selectedImageUrl: LiveData<String?> = _selectedImageUrl

    fun getDogs() {
        CoroutineScope(Dispatchers.IO).launch {
            _data.postValue(StateViewModel.Loading)
            val response = repository.getDogs()
            if (response.isSuccessful) {
                response.body()?.let {
                    _data.postValue(StateViewModel.Success(it))
                } ?: _data.postValue(StateViewModel.Error("No data"))
            } else {
                _data.postValue(StateViewModel.Error("Service error"))
            }
        }
    }

    fun getImage(): LiveData<String?>{
        return this.selectedImageUrl
    }

    fun onImageClicked(imageUrl: String): Unit {
        _selectedImageUrl.value = imageUrl
        ImageClass.imageGrid = imageUrl
    }
}
