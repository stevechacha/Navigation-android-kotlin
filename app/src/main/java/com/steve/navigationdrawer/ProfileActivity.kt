package com.steve.navigationdrawer

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.databinding.DataBindingUtil
import com.steve.navigationdrawer.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    lateinit var progressBar: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        progressBar = ProgressDialog(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)


        binding.btnRegister.setOnClickListener {
            val username = binding.userName.text.toString()

        }
        binding.buttonImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }
    }

        var selectPhotoUri: Uri? = null

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (resultCode == Activity.RESULT_OK && requestCode == 0 && data != null) {
//
                selectPhotoUri = data.data
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectPhotoUri)
                binding.imageView.setImageBitmap(bitmap)
                binding.buttonImage.alpha = 0f

            }

        }

    }

