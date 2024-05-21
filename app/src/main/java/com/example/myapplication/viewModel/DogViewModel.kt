package com.example.myapplication.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DogViewModel(private val repository: DogRepository = DogRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateViewModel>()
    val data: LiveData<StateViewModel> = _data

    fun getDogs() {
        CoroutineScope(Dispatchers.IO).launch {
            _data.postValue(StateViewModel.loading)
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
}

