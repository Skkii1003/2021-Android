package com.example.fragmenthw

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.fragmenttest.Fragment0
import com.example.fragmenttest.Fragment2

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tab1: TextView = findViewById(R.id.t1)
        val tab2: TextView = findViewById(R.id.t2)
        val tab3: TextView = findViewById(R.id.t3)
        val list : List<Fragment> = listOf(Fragment0(),Fragment1(),Fragment2())
        val viewPager : ViewPager = findViewById(R.id.ViewPager)

        viewPager.adapter = PagerAdapter(list,supportFragmentManager)
        viewPager.setCurrentItem(0)
        tab1.setBackgroundColor(Color.RED)
        tab2.setBackgroundColor(Color.WHITE)
        tab3.setBackgroundColor(Color.WHITE)
        viewPager.addOnPageChangeListener(PagerChangeListener())

        tab1.setOnClickListener{
            viewPager.setCurrentItem(0)
            tab1.setBackgroundColor(Color.RED)
            tab2.setBackgroundColor(Color.WHITE)
            tab3.setBackgroundColor(Color.WHITE)
        }

        tab2.setOnClickListener{
            viewPager.setCurrentItem(1)
            tab1.setBackgroundColor(Color.WHITE)
            tab2.setBackgroundColor(Color.RED)
            tab3.setBackgroundColor(Color.WHITE)
        }

        tab3.setOnClickListener{
            viewPager.setCurrentItem(2)
            tab1.setBackgroundColor(Color.WHITE)
            tab2.setBackgroundColor(Color.WHITE)
            tab3.setBackgroundColor(Color.RED)
        }
    }
    inner class PagerChangeListener : ViewPager.OnPageChangeListener{
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {}

        override fun onPageSelected(position: Int) {
            //Log.d("page","change")

            val tab1 = findViewById<TextView>(R.id.t1)
            val tab2 = findViewById<TextView>(R.id.t2)
            val tab3 = findViewById<TextView>(R.id.t3)
            when (position) {
                0 -> {
                    tab1.setBackgroundColor(Color.RED)
                    tab2.setBackgroundColor(Color.WHITE)
                    tab3.setBackgroundColor(Color.WHITE)
                }
                1 -> {
                    tab1.setBackgroundColor(Color.WHITE)
                    tab2.setBackgroundColor(Color.RED)
                    tab3.setBackgroundColor(Color.WHITE)
                }
                2 -> {
                    tab1.setBackgroundColor(Color.WHITE)
                    tab2.setBackgroundColor(Color.WHITE)
                    tab3.setBackgroundColor(Color.RED)
                }
            }
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }

}