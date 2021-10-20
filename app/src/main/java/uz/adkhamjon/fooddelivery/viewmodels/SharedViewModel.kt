package uz.adkhamjon.fooddelivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.adkhamjon.fooddelivery.models.ExampleModel
class SharedViewModel: ViewModel() {
    private val data = MutableLiveData<ExampleModel>()
     fun setData(exampleModel: ExampleModel){
        data.value=exampleModel
    }
    fun getData():LiveData<ExampleModel>{
        return data
    }

}