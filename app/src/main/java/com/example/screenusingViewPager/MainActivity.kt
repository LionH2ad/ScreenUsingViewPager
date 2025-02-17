package com.example.screenusingViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.screenusingViewPager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pagerAdapter :ViewPagerAdapter by lazy{
        ViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adapter 설정
        binding.viewPager.adapter = pagerAdapter

        // .attach() : TabLayout과 ViewPager를 실제로 연결.
        val tabTitles = listOf("Home","Setting")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, posotion ->
            tab.text = tabTitles[posotion]
        }.attach()
    }
}