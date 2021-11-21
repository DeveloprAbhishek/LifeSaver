package com.masai.lifesaver.ui.activity.userhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.lifesaver.R
import com.masai.lifesaver.models.BookingRecordModel
import com.masai.lifesaver.ui.loginpackage.InstantActionActivity
import kotlinx.android.synthetic.main.activity_user_home.*

class UserHomeActivity: AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        auth = FirebaseAuth.getInstance()
        setBottomNavigation()

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout,  R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)


        toggle.syncState()

        addDataToHeaderOfDrawer(navView)


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

                R.id.nav_logout -> {
                    auth.signOut()
                    val intent = Intent(this, InstantActionActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }

            }
            true

        }


    }

    private fun addDataToHeaderOfDrawer(navView: NavigationView) {
        val headerView = navView.getHeaderView(0)
        val imageView: ImageView = headerView.findViewById(R.id.headerImage)
        val emailText: TextView = headerView.findViewById(R.id.tvHeaderEmail)
        val userName: TextView = headerView.findViewById(R.id.tvUsername)
        val uid = auth.uid
        if (uid != null) {
            db.collection("user").document(uid).get().addOnSuccessListener { document ->
                if (document != null) {
                    val email = document.data?.get("email")
                    val image = document.data?.get("image")
                    val name = document.data?.get("name")
                    userName.setText(name.toString())
                    emailText.setText(email.toString())
                    Glide.with(imageView).load(image).into(imageView)

                    Log.d("Abhishek", "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d("Abhishek", "No such document")
                }

            }.addOnFailureListener { exception ->
                Log.w("Abhishek", "Error getting documents: ", exception)
            }
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