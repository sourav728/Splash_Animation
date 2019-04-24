package com.tvd.splash_screen.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tvd.splash_screen.R
import com.tvd.splash_screen.utils.NetWorkConection
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

/**
 *Created By Sourav
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_call_api.setOnClickListener {
            if (NetWorkConection.isNEtworkConnected(applicationContext)) {
               val intent = Intent(this@MainActivity, MovieActivity::class.java)
                startActivity(intent)
            } else {
                toast("Please turn on internet!!")
            }
        }
    }
}
