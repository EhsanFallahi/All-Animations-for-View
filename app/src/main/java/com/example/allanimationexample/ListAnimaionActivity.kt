package com.example.allanimationexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.allanimationexample.activitisOfAnimations.Step_1_Activity
import com.example.allanimationexample.databinding.ActivityListAnimaionBinding

class ListAnimaionActivity : AppCompatActivity() {
    private lateinit var binding:ActivityListAnimaionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_list_animaion)

        binding.apply {
            btnStep1.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity,Step_1_Activity::class.java)
                startActivity(intent)
            }
        }




    }
}