package com.xiaozhejun.hencoderpractice.practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaozhejun.hencoderpractice.R
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_practice1.*

class Practice1Activity : AppCompatActivity() {
    var pageModels: ArrayList<PageModel> = ArrayList()

    init {
        pageModels.add(
            PageModel(
                R.layout.sample_color,
                R.string.title_draw_color,
                R.layout.practice_color
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice1)
        pager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels[position]
                return PageFragment.newInstance(
                    pageModel.sampleLayoutRes,
                    pageModel.practiceLayoutRes
                )
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return getString(pageModels[position].titleRes)
            }
        }
        tabLayout.setupWithViewPager(pager)
    }

    inner class PageModel internal constructor(
        @param:LayoutRes @field:LayoutRes internal var sampleLayoutRes: Int,
        @param:StringRes @field:StringRes internal var titleRes: Int,
        @param:LayoutRes @field:LayoutRes internal var practiceLayoutRes: Int
    )
}
