package com.xiaozhejun.hencoderpractice.practice3

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.xiaozhejun.hencoderpractice.PageFragment
import kotlinx.android.synthetic.main.activity_practice.*
import com.xiaozhejun.hencoderpractice.R

class Practice3Activity : AppCompatActivity() {
    var pageModels: ArrayList<PageModel> = ArrayList()

    init {
        pageModels.add(
            PageModel(
                R.layout.sample_draw_text,
                R.string.title_draw_text,
                R.layout.practice_draw_text
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_static_layout,
                R.string.title_static_layout,
                R.layout.practice_static_layout
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_text_size,
                R.string.title_set_text_size,
                R.layout.practice_set_text_size
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_typeface,
                R.string.title_set_typeface,
                R.layout.practice_set_typeface
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_fake_bold_text,
                R.string.title_set_fake_bold_text,
                R.layout.practice_set_fake_bold_text
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_strike_thru_text,
                R.string.title_set_strike_thru_text,
                R.layout.practice_set_strike_thru_text
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_underline_text,
                R.string.title_set_underline_text,
                R.layout.practice_set_underline_text
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_text_skew_x,
                R.string.title_set_text_skew_x,
                R.layout.practice_set_text_skew_x
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_text_scale_x,
                R.string.title_set_text_scale_x,
                R.layout.practice_set_text_scale_x
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_set_text_align,
                R.string.title_set_text_align,
                R.layout.practice_set_text_align
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_get_font_spacing,
                R.string.title_get_font_spacing,
                R.layout.practice_get_font_spacing
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_measure_text,
                R.string.title_measure_text,
                R.layout.practice_measure_text
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_get_text_bounds,
                R.string.title_get_text_bounds,
                R.layout.practice_get_text_bounds
            )
        )
        pageModels.add(
            PageModel(
                R.layout.sample_get_font_metrics,
                R.string.title_get_font_metrics,
                R.layout.practice_get_font_metrics
            )
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)
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