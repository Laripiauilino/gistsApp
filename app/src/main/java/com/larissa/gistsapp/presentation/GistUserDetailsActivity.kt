package com.larissa.gistsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.larissa.gistsapp.databinding.ActivityGistUserDetailsBinding

class GistUserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGistUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGistUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReturn.setOnClickListener {
            this.finish()
        }

        val login = intent.extras?.get(GistsAdapter.LOGIN_ITEM) as? String
        val userPicture = intent.extras?.get(GistsAdapter.USER_PICTURE_ITEM) as? String

        binding.txtUserName.text = login
        Glide.with(this)
            .load(userPicture)
            .into(binding.imgPictureUser)
    }
}