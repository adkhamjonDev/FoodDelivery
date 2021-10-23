package uz.adkhamjon.fooddelivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.adkhamjon.fooddelivery.models.ExampleModel
import uz.adkhamjon.fooddelivery.models.ProfileModelExample



class ProfileViewModel: ViewModel() {
    private val userProfile = MutableLiveData<ProfileModelExample>()
    fun setUserData(profileModelExample: ProfileModelExample){
        userProfile.value=profileModelExample
    }
    fun getUserData():LiveData<ProfileModelExample>{
        return userProfile
    }

}