package riza.example.katalogfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_rv.toolbar
import riza.example.katalogfilm.adapter.MyPagerAdapter
import riza.example.katalogfilm.data.MyPrefs
import riza.example.katalogfilm.fragments.FavoriteFragment
import riza.example.katalogfilm.fragments.NowPlayingFragment
import riza.example.katalogfilm.fragments.UpcomingFragment

class HomeActivity : AppCompatActivity() {

    private val pagerAdapter by lazy { MyPagerAdapter(
        supportFragmentManager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) }


    private val myPref by lazy { MyPrefs(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //simpen username
        myPref.saveUsername("Riza")

//
//          ini buat load fragment di frame layout/ 1 halaman tok
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.mycontainer, MovieFragment())
//            .commit()

        //get username
        val username = myPref.getUserName()

        setUpToolbar("Hai, $username")

        pagerAdapter.addFragment(NowPlayingFragment(), "Now Playing")
        pagerAdapter.addFragment(UpcomingFragment(), "Upcoming")
        pagerAdapter.addFragment(FavoriteFragment(), "Favorite")

        view_pager?.apply {
            adapter = pagerAdapter
        }

        tab?.setupWithViewPager(view_pager)

    }

    private fun setUpToolbar(title: String){

        setSupportActionBar(toolbar) // set toolbar
        supportActionBar?.title = title //set title

    }

}
