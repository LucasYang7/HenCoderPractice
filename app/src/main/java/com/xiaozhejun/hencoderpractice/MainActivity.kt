package com.xiaozhejun.hencoderpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiaozhejun.hencoderpractice.practice1.Practice1Activity
import com.xiaozhejun.hencoderpractice.practice2.Practice2Activity
import com.xiaozhejun.hencoderpractice.practice3.Practice3Activity
import com.xiaozhejun.hencoderpractice.practice4.Practice4Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_goto_practice1.setOnClickListener {
            var intent = Intent(this@MainActivity, Practice1Activity::class.java)
            this@MainActivity.startActivity(intent)
        }
        tv_goto_practice2.setOnClickListener {
            var intent = Intent(this@MainActivity, Practice2Activity::class.java)
            this@MainActivity.startActivity(intent)
        }
        tv_goto_practice3.setOnClickListener {
            var intent = Intent(this@MainActivity, Practice3Activity::class.java)
            this@MainActivity.startActivity(intent)
        }
        // 当接口中只有一个函数时，可以用简化的lambda表达式,下面是OnClickListener接口onClick函数对应的lambda表达式
        tv_goto_practice4.setOnClickListener {
            var intent = Intent(this@MainActivity, Practice4Activity::class.java)
            this@MainActivity.startActivity(intent)
        }
    }
}
