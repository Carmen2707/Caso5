package com.example.caso5

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.caso5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen=installSplashScreen()
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(binding.root)
        Thread.sleep(2000)
        splashScreen.setKeepOnScreenCondition{false}
        prefs=getSharedPreferences("app", MODE_PRIVATE)
        establecerValoresSiExisten()
        binding.btnLogin.setOnClickListener{
            val email=binding.etEmail.text.toString()
            val password=binding.etPassword.text.toString()
            if (login(email,password)) goToMain()
            guardarPreferencias(email,password)
        }
        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                binding.motionLayout.visibility=View.GONE
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }

        })
    }
    //TextUtils y Patterns nos ofrece la posibilidad de validar las reglas básicas de una dirección de email correcta.
    private fun eMailValido(email:String):Boolean{
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun passwordValida(password:String):Boolean{
        return !TextUtils.isEmpty(password) && password.length > 7
    }
    //controlamos que el email y la contraseña sean correctos
    private fun login(email: String,password: String):Boolean{
        var valido=false
        if (!eMailValido(email)){
            Toast.makeText(this, "Email no válido. Introduce un email correcto.", Toast.LENGTH_SHORT).show()
        }else if(!passwordValida(password)){
            Toast.makeText(this, "Password no válida. Debe tener al menos 8 caracteres.",Toast.LENGTH_SHORT).show()
        }else{
            valido=true
        }
        return valido
    }

    private fun goToMain(){
        val intent= Intent(this,MainActivity::class.java)
        //evita que pasemos de nuevo a la activity login
        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    //configuramos las SharedPreferences para guardar los datos de acceso. de forma que cuando entremos a la app no tengamos que especificar el email y la password
    private fun guardarPreferencias(email: String,password: String){
        val editor=prefs!!.edit()
        if (binding.cbRecordar!!.isChecked){
            editor.putString("email",email)
            editor.putString("password",password)
            editor.putBoolean("recordar",true)
            editor.apply()
        }else{
            editor.clear()
            editor.putBoolean("recordar",false)
            editor.apply()
        }
    }

    private fun establecerValoresSiExisten(){
        val email=prefs.getString("email","")
        val password=prefs.getString("password","")
        val recordar=prefs.getBoolean("recordar",false)
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            binding.etEmail.setText(email)
            binding.etPassword.setText(password)
            binding.cbRecordar.isChecked=recordar
        }
    }
}