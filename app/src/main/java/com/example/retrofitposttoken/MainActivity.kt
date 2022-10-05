package com.example.retrofitposttoken

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.lifecycle.lifecycleScope
import com.example.retrofitposttoken.databinding.ActivityMainBinding

import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val api = ApiHelper.getInstanceOfRetrofit() // ссылка на наш АПИ
    val signup = SignUpForm("admin",
        "admin",
        "admin@admin.ru",
        arrayOf(),
        "admin"

    )
    val signin=SignInForm("admin","admin")
    lateinit var  pref: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        pref =  getSharedPreferences("aaa", Context.MODE_PRIVATE)
        /*
      SetContentView is used to fill the window with the UI
       provided from layout file incase of setContentView(R. layout. somae_file).
        Here layoutfile is inflated to view and added to the Activity context(Window).  */

        binding.login.setOnClickListener { login() }
        binding.registr.setOnClickListener{
            registration()
        }
        binding.getInfo.setOnClickListener{getInfo()}


    }

    private fun getInfo() {
        var token= fromPreferences()
        println(token)
     //   Toast.makeText(this@MainActivity,token,Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            var response = fromPreferences()?.let { api.helloadmin2("Bearer $it") }
//            var response =api.helloadmin()
            if (response!!.isSuccessful){
                var body = response.body()
                Toast.makeText(this@MainActivity,body,Toast.LENGTH_SHORT).show()

            } else{
                Toast.makeText(this@MainActivity,"response.message()",Toast.LENGTH_SHORT).show()

            }
        }

    }


    fun login(){
    lifecycleScope.launch {
        var response = api.signIn(SignInForm("admin","admin"))
        if (response.isSuccessful){
            val a = response.body()
           Toast.makeText(this@MainActivity,a?.accessToken,Toast.LENGTH_SHORT).show()
            println(a)
            toPreferences(a?.accessToken)

        } else {
            println(response.message())
            Toast.makeText(this@MainActivity,response.message(),Toast.LENGTH_SHORT).show()

        }
    }
}

    fun registration()  {
        lifecycleScope.launch {
            var response = api.login(signup)
            if (response.isSuccessful) {
//                val token = response.headers().get("Access-Token")
                //toPreferences(token)
                 var b:String? =  response.body()

                 Toast.makeText(this@MainActivity,b,Toast.LENGTH_SHORT).show()
            }


        }
    }

    fun toPreferences(token:String?){
        val editor=pref.edit()
        editor.putString(EDIT_TEXT_KEY,token).apply()
    }
    fun fromPreferences():String?{
        return pref.getString(EDIT_TEXT_KEY,"")
    }

    companion object {
        private const val EDIT_TEXT_KEY = "EDIT_TEXT_KEY"
        const val app_preferences = "app_preferences"

//        var  pref: SharedPreferences =(this as Context).getSharedPreferences("aaa", Context.MODE_PRIVATE)
//
//
//        fun toPreferences(token:String?){
//            val editor=pref.edit()
//            editor.putString(EDIT_TEXT_KEY,token).apply()
//        }
//        fun fromPreferences():String?{
//            return pref.getString(EDIT_TEXT_KEY,"")
//        }
    }
}