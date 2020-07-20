package com.example.allanimationexample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.allanimationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            btnRotate.setOnClickListener {
                rotaion()
            }
        }

    }

    private fun rotaion() {
        val animator=ObjectAnimator.ofFloat(binding.imgStar,View.ROTATION,
            -360f,0f)
        animator.apply {
            duration=2000
            addListener(object:AnimatorListenerAdapter(){
                override fun onAnimationEnd(animation: Animator?) {
                    binding.btnRotate.isEnabled=true
                }
                override fun onAnimationStart(animation: Animator?) {
                    binding.btnRotate.isEnabled=false
                }
            })
            start()
        }

    }
}