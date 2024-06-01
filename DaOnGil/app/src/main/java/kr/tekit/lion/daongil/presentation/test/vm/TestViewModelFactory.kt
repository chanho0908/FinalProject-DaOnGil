package kr.tekit.lion.daongil.presentation.test.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
class TestViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)){
            return TestViewModel() as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }
}