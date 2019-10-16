package riza.example.katalogfilm.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by riza@deliv.co.id on 10/14/19.
 */
class MyPagerAdapter(fm: FragmentManager, behavior: Int)
    : FragmentPagerAdapter(fm, behavior) {

    //buat nyimpen fragment
    private val fragmentList = arrayListOf<Fragment>()
    private val titleList = arrayListOf<String>()

    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getItem(position: Int): Fragment {
       return fragmentList[position]
    }

    override fun getCount(): Int {
        return  fragmentList.size
    }

    //ngembalin title fragment buat dipasang di tab
    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}