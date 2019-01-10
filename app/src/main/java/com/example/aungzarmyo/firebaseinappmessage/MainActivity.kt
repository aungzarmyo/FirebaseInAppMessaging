package com.example.aungzarmyo.firebaseinappmessage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener(
                this
            ) { pendingDynamicLinkData ->
                // Get deep link from result (may be null if no link is found)
                var deepLink: Uri? = null
                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData!!.link
                }


                // Handle the deep link. For example, open the linked
                // content, or apply promotional credit to the user's
                // account.
                // ...
                if (deepLink != null) {
                    var intnet = Intent(this, HomeActivity::class.java)
                    startActivity(intnet)
                }

            }
            .addOnFailureListener(this, object : OnFailureListener {
                override fun onFailure(@NonNull e: Exception) {
                    Log.w("TAG", "getDynamicLink:onFailure", e)
                }
            })
    }
}
