package com.example.barcode
import android.os.Bundle
import android.view.SurfaceView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
/**
 * created by Arshad...........
 */
class MainActivity : AppCompatActivity() {

    private lateinit var cameraview: SurfaceView
    internal lateinit var barcode: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        cameraview = findViewById(R.id.camera_view)
        barcode = findViewById(R.id.code_info)
        Helper.init(this, cameraview,
            object : Listner {
                override fun onDetected(data: String) {
                    barcode.post { barcode.text = data }
                }
            })
    }
}