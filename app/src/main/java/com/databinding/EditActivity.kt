package com.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.databinding.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit)


    }

    fun save(view: View) {
        var intent = Intent()
        intent.putExtra("phone", binding.editPhone.text.toString())
        intent.putExtra("address", binding.editAddress.text.toString())
        setResult(RESULT_OK, intent)
        finish()

    }

    fun cancel(view: View) {
        finish()
    }
}