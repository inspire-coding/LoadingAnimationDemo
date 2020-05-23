package com.inspirecoding.loadinganimationdemo

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.inspirecoding.loadinganimationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    private lateinit var loadingAnimation: AnimationDrawable
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        )

        initCartLoadingAnimation()

        binding.btnStartStopAnimation.setOnClickListener {
            if (isLoading)
            {
                stopLoadingAnimation()
            }
            else
            {
                startLoadingAnimation()
            }
        }
    }
    private fun startLoadingAnimation()
    {
        isLoading = true
        binding.btnStartStopAnimation.text = getString(R.string.stop)
        binding.ivLoading.visibility = View.VISIBLE
        loadingAnimation.start()
    }
    private fun stopLoadingAnimation()
    {
        isLoading = false
        binding.btnStartStopAnimation.text = getString(R.string.start)
        binding.ivLoading.visibility = View.INVISIBLE
        loadingAnimation.stop()
    }
    private fun initCartLoadingAnimation()
    {
        binding.ivLoading.setBackgroundResource(R.drawable.anim_loading)
        loadingAnimation = binding.ivLoading.background as AnimationDrawable
    }
}
