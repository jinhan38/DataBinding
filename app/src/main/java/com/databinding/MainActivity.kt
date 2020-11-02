package com.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fetchUserData()
    }

    private fun fetchUserData() {
        var userProfile = UserProfile()
        userProfile.name = "김미미"
        userProfile.phone = "010-3333-8888"
        userProfile.address = "인천광역시 계양구"
        userProfile.profileImage = "https://ibb.co/6Wprh9w"

//        userProfile.getGenderAsText()
        

        binding.userProfile = userProfile

//        updateUser(userProfile)
    }

    private fun updateUser(userProfile: UserProfile) {
        userProfile.apply {
            binding.name.text = this.name
            binding.phone.text = this.phone
            binding.address.text = this.address
        }

    }

    companion object {
        private const val TAG = "MainActivity"
    }


}