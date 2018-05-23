package com.example.pvankayala.activitylifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var btn_camera : Button
    var REQUEST_IMAGE_CAPTURE :  Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("activity","create")

        btn_camera = findViewById(R.id.btn_to_open_camera) as Button

    }

    override fun onRestoreInstanceState(savedInstanceState : Bundle?){
            //This method is called between onStart() and onPostCreate(Bundle).
    }

    override fun onStart() {
        super.onStart()
        Log.e("activity","start")
    }

    override fun onResume() {
        super.onResume()
        Log.e("activity","resume")

        //openCamera()
    }

    override fun onPause() {
        super.onPause()
        Log.e("activity","pause")
    }

     override fun onSaveInstanceState(outState : Bundle){
         super.onSaveInstanceState(outState)
           // this method will occur before onStop()
    }

    override fun onStop() {
        super.onStop()
        Log.e("activity","stop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("activity","destroy")
    }

    fun openCamera(view : View){
        btn_camera.setOnClickListener{
            Log.e("Camera clicked", "button")
            Toast.makeText(this , "Opening camera..", Toast.LENGTH_SHORT).show()
            val cameraIntent =  Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            if(cameraIntent.resolveActivity(packageManager) != null) {
                        startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE)
            }
        }


    }

}
