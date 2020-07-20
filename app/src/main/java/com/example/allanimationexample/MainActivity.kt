package com.example.allanimationexample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
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
            btnTranslate.setOnClickListener {
                translater()
            }
            btnScale.setOnClickListener {
                scale()
            }
            btnFade.setOnClickListener {
                fade()
            }
            btnBackgroundColor.setOnClickListener {
                colorizer()
            }
        }

    }

    private fun colorizer() {
        val animator=ObjectAnimator.ofArgb(binding.imgStar.parent,
            "backgroundColor",Color.BLACK,Color.RED)
        animator.apply {
            duration=800
            repeatCount=1
            repeatMode=ObjectAnimator.REVERSE
            disableViewDuringAnimation(binding.btnBackgroundColor)
            start()
        }

    }

    private fun fade() {
        val animator=ObjectAnimator.ofFloat(binding.imgStar,View.ALPHA,0f)
        animator.apply {
            duration=500
            repeatCount=1
            repeatMode=ObjectAnimator.REVERSE
            disableViewDuringAnimation(binding.btnFade)
            start()
        }
    }

    private fun scale() {
        val scaleX=PropertyValuesHolder.ofFloat(View.SCALE_X,4f)
        val scaleY=PropertyValuesHolder.ofFloat(View.SCALE_Y,4f)
        val animator=ObjectAnimator.ofPropertyValuesHolder(binding.imgStar,scaleX,scaleY)
        animator.apply {
            duration=1000
            repeatCount=1
            repeatMode=ObjectAnimator.REVERSE
            disableViewDuringAnimation(binding.btnScale)
            start()
        }
    }

    private fun translater() {
        val animator=ObjectAnimator.ofFloat(binding.imgStar,View.TRANSLATION_X,300f)
        animator.apply {
            duration=1000
            repeatCount=1
            repeatMode=ObjectAnimator.REVERSE
            disableViewDuringAnimation(binding.btnTranslate)
            start()
        }
    }

    private fun rotaion() {
        val animator=ObjectAnimator.ofFloat(binding.imgStar,View.ROTATION,
            -360f,0f)
        animator.apply {
            duration=2000
            disableViewDuringAnimation(binding.btnRotate)
            start()
        }

    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View){
        addListener(object :AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled=true
            }

            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled=false
            }

        })
    }
}