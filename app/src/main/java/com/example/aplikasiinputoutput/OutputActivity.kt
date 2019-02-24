package com.example.aplikasiinputoutput

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_output.*

class OutputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        supportActionBar?.title = ("Output Data")
        supportActionBar?.subtitle = ("Dapet dari okedroid.com")

        //ambil data dari intent
        val bundle = intent.extras

        //menampilkan data berdasarkan key (companion object)
        outputNama.text = ("Nama anda : " + bundle.getCharSequence(MainActivity.NAMA))
        outputPassword.text = ("Password anda : " + bundle.getCharSequence(MainActivity.PASSWORD))
        outputEmail.text = ("Email anda : " + bundle.getCharSequence(MainActivity.EMAIL))
        outputJenisKelamin.text = ("Jenis Kelamin anda : " + bundle.getCharSequence(MainActivity.JENIS_KELAMIN))
    }
}
