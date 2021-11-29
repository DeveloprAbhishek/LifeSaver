package com.masai.lifesaver.ui.loginpackage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.masai.lifesaver.R
import com.masai.lifesaver.ui.activity.EmergencyActivity
import com.masai.lifesaver.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_instant_action.*


class SignupOrLoginFragment : Fragment(R.layout.activity_instant_action) {
    private val SIGN_IN_KEY = 1
    private lateinit var mAuth: FirebaseAuth

    lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        mAuth = FirebaseAuth.getInstance()

        btnSignUpFrag.setOnClickListener {
            navController.navigate(R.id.action_signupOrLoginFragment2_to_signUpFragment)
        }

        btnSignInFrag.setOnClickListener {
            navController.navigate(R.id.action_signupOrLoginFragment2_to_loginFragment)
        }

        btnInstantEmergency.setOnClickListener {
            startActivity(Intent(requireActivity(), EmergencyActivity::class.java))
        }


    }

//    private fun signInWithGoogle() {
//
//        // Configure Google Sign In
//        val gso = GoogleSignInOptions
//            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken("R.string.default_web_client_id")
//            .requestEmail()
//            .build()
//
//        val googleSignInClient = GoogleSignIn.getClient(context, gso)
//        //val signInClient: GoogleSignInClient = GoogleSignIn.getClient(context, gso)
//        val signInIntent: Intent = googleSignInClient.getSignInIntent()
//        startActivityForResult(signInIntent, SIGN_IN_KEY)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Fetching request code for sign in
//
//        // Fetching request code for sign in
//        if (requestCode === SIGN_IN_KEY) {
//            val task: Task<GoogleSignInAccount> =
//                GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                val account: GoogleSignInAccount = task.getResult(ApiException::class.java)!!
//                firebaseAuthWithGoogle(account!!.idToken)
//            } catch (e: ApiException) {
//                //Toast.makeText(context, e.message + "", Toast.LENGTH_SHORT).show()
//                Log.d("SighUpActivity", "onActivityResult: ")
//                val intent = Intent(activity?.applicationContext, HomeActivity::class.java)
//                startActivity(intent)
//            }
//        }
//    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        // Generating credential and token
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("SighUpActivity", "success: ")
                val intent = Intent(activity?.applicationContext, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                //saveLoginState()
            } else {
                Toast.makeText(
                    context,it.exception.toString() + "",Toast.LENGTH_SHORT).show()
                Log.d("SighUpActivity", "error: ")
            }
        }
    }


//    private fun saveLoginState() {
//        val preferences: SharedPreferences.Editor =
//            getSharedPreferences("PREFS", MODE_PRIVATE).edit()
//        preferences.putBoolean("loggedIn", true)
//        preferences.apply()
//        finish()
//    }

}