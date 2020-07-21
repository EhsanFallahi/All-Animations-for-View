package com.example.allanimationexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.allanimationexample.activitisOfAnimations.*
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
            btnStep2.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity, Step_2_Activity::class.java)
                startActivity(intent)
            }
            btnStep3.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity, Step_3_Activity::class.java)
                startActivity(intent)
            }
            btnStep4.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity, Step_4_Activity::class.java)
                startActivity(intent)
            }
            btnStep5.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity, Step_5_Activity::class.java)
                startActivity(intent)
            }
            btnStep6.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity, Step_6_Activity::class.java)
                startActivity(intent)
            }
            btnStep7.setOnClickListener {
                val intent= Intent(this@ListAnimaionActivity, Step_7_Activity::class.java)
                startActivity(intent)
            }
        }




    }
}