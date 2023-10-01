package com.example.practical_7_mad_041_5a3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var media: VideoView? = null
    var media_control: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        media=findViewById(R.id.videoview)
        if(media_control==null){
            media_control= MediaController(this)
            media_control!!.setAnchorView(this.media)
        }
        media!!.setMediaController(media_control)
        media!!.setVideoURI(Uri.parse("android.resource://"+ packageName + "/" + R.raw.thestoryoflight))
        media!!.requestFocus()
        media!!.start()
        var m_btn: FloatingActionButton =findViewById(R.id.m_btn)
        m_btn.setOnClickListener(){
            var intent= Intent(this@MainActivity,Youtube::class.java)
            startActivity(intent)
        }
    }
}