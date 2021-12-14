package com.example.fragmenthw

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(var mList:List<Fragment>,fm:FragmentManager?): FragmentStatePagerAdapter(fm!!) {
    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Fragment {
        return mList[position]
    }


}