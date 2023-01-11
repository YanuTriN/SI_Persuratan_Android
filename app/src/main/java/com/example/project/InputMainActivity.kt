package com.example.project

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import com.google.android.material.button.MaterialButton

private const val REQUEST_CODE = 42
class InputMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_main)
        lateinit var send: MaterialButton

        send = findViewById(R.id.fabSend)
        send.setOnClickListener {
            startActivity(Intent(this, NomorMainActivity::class.java))
        }

        lateinit var btn: Button
        lateinit var img: ImageView

        img = findViewById(R.id.imageSuratMasuk)

        btn = findViewById(R.id.btnAmbilFoto)
        btn.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (takePictureIntent.resolveActivity(this.packageManager) !=null){
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            }else{
                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show()
            }
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
                val takenImage = data?.extras?.get("data") as Bitmap
                img.setImageBitmap(takenImage)
            }else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }


        val spinner: Spinner = findViewById(R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
}