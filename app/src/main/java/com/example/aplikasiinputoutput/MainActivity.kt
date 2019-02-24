package com.example.aplikasiinputoutput

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        //static class pada Kotlin
        val NAMA: String? = "nama"
        val PASSWORD: String? = "password"
        val EMAIL: String? = "email"
        val JENIS_KELAMIN: String? = "jenis_kelamin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //judul dan sub-judul
        supportActionBar?.title = ("Halaman Registrasi")
        supportActionBar?.subtitle = ("Dapet dari okedroid.com")

        btnRegistrasi.setOnClickListener {

            if ((inputName.text.isEmpty()) || inputPassword.text.isEmpty() || inputEmail.text.isEmpty() || rgJenisKelamin.checkedRadioButtonId == -1) {
                toast("Kolom tidak boleh ada yang kosong!", Toast.LENGTH_LONG)
            } else if (inputName.text.isNotEmpty() || inputPassword.text.isNotEmpty() || inputEmail.text.isNotEmpty()) {
                toast("Registrasi Berhasil", Toast.LENGTH_LONG)

                val intent = Intent(this, OutputActivity::class.java)
                val bundle = Bundle()
                bundle.putString(NAMA, inputName.text.toString())
                bundle.putString(PASSWORD, inputPassword.text.toString())
                bundle.putString(EMAIL, inputEmail.text.toString())

                val id = rgJenisKelamin.checkedRadioButtonId
                val radioButton = findViewById(id) as RadioButton
                bundle.putString(JENIS_KELAMIN, radioButton.text.toString())

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }
}
