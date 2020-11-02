package com.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    var liveData = MutableLiveData<UserProfile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        liveData.observe(this, { userProfile ->
            //변경된 값이 파라메터로 넘어온다
            binding.userProfile = userProfile
        })

        if (liveData.value == null) fetchUserData()

    }

    private fun fetchUserData() {
        var userProfile = UserProfile()
        userProfile.name = "김미미"
        userProfile.phone = "010-3333-8888"
        userProfile.address = "인천광역시 계양구"
        userProfile.profileImage = "https://ibb.co/6Wprh9w"

        //이제 데이터는 liveData가 관리한다.
        liveData.value = userProfile

//        userProfile.getGenderAsText()
//        binding.userProfile = userProfile
//        updateUser(userProfile)

    }

    fun goEditActivity(view: View) {
        // liveData에서 관리하고 있는 value를 userProfile에 담아서 전송
        val userProfile = liveData.value
        var intent = Intent(this, EditActivity::class.java)

        intent.putExtra("phone", userProfile!!.phone)
        intent.putExtra("address", userProfile.address)
        startActivityForResult(intent, 100)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            var userProfile = liveData.value
            userProfile!!.phone = data!!.getStringExtra("phone").toString()
            userProfile.address = data.getStringExtra("address").toString()

            liveData.value = userProfile
        }
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