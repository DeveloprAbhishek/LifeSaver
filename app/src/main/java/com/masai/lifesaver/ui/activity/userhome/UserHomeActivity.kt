package com.masai.lifesaver.ui.activity.userhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.masai.lifesaver.R
import kotlinx.android.synthetic.main.activity_user_home.*

class UserHomeActivity: AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        setBottomNavigation()

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout,  R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {
                R.id.nav_settings ->
                    replaceFragment(UserHomeFragment(), it.title.toString())

                R.id.nav_about ->
                    replaceFragment(PreviBookingsFragment(), it.title.toString())

                R.id.nav_help ->
                    replaceFragment(NewBookingFragment(), it.title.toString())

            }
            true

        }


    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navView, fragment)
        fragmentTransaction.commit()

        // to close the drawer
        drawerLayout.closeDrawers()
        // to set the title on top
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true

        return super.onOptionsItemSelected(item)
    }


    private fun setBottomNavigation() {

        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, UserHomeFragment()).commit()

        menu_bottom.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            var temp: Fragment? = null
            when (item.itemId) {
                R.id.menu_home -> temp = UserHomeFragment()
                R.id.menu_training -> temp = NewBookingFragment()
                R.id.menu_ongoing -> temp = PreviBookingsFragment()
            }
            if (temp != null) {
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, temp).commit()
            }
            true
        })

    }

}