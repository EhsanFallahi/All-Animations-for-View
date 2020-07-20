package com.example.allanimationexample

import android.animation.*
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewDebug
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
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
            btnShower.setOnClickListener {
                shower()
            }
        }

    }

    private fun shower() {
        val container=binding.imgStar.parent as ViewGroup
        val containerW=container.width
        val containerH=container.height
        var starW:Float=binding.imgStar.width.toFloat()
        var starH:Float=binding.imgStar.height.toFloat()
        val newStar=AppCompatImageView(this)
        newStar.setImageResource(R.drawable.ic_star)
        newStar.layoutParams=FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        container.addView(newStar)
        newStar.scaleX=Math.random().toFloat()*1.5f+.1f
        newStar.scaleY=newStar.scaleX
        starW *=newStar.scaleX
        starH *=newStar.scaleY
        newStar.translationX=Math.random().toFloat() *containerW-starW/2
        val mover=ObjectAnimator.ofFloat(newStar,View.TRANSLATION_Y,-starH,containerH +starH)
        mover.interpolator=AccelerateInterpolator(1f)
        val rotator=ObjectAnimator.ofFloat(newStar,View.ROTATION,(Math.random()*1080).toFloat())
        rotator.interpolator=LinearInterpolator()
        val set=AnimatorSet()
        set.playTogether(mover,rotator)
        set.duration=(Math.random()*1500+500).toLong()
        set.addListener(object :AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                container.removeView(newStar)
            }
        })
        set.start()
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