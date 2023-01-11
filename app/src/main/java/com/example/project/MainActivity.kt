package com.example.project

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var mydownlodid : Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var img: ImageView

        img = findViewById(R.id.img_keluar)
        img.setOnClickListener {
            startActivity(Intent(this, KeluarMainActivity::class.java))
        }
        lateinit var img2: ImageView

        img2 = findViewById(R.id.img_masuk)
        img2.setOnClickListener {
            startActivity(Intent(this, InputMainActivity::class.java))
        }
        lateinit var img3: ImageView

        img3 = findViewById(R.id.img_arsip)
        img3.setOnClickListener {
            startActivity(Intent(this, ArsipMainActivity::class.java))
        }

        lateinit var text1: TextView

        text1 = findViewById(R.id.srt_permohonan)
        text1.setOnClickListener {
            var request = DownloadManager.Request(Uri.parse("https://drive.google.com/file/d/1JywOMypd-qC5V6QIvdnuY11VNHTAkPCN/view"))
                .setTitle("Surat Permohonan")
                .setDescription("Surat Permohonan Downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)

            var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownlodid = dm.enqueue(request)
        }

        var br = object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long? = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==mydownlodid){
                    Toast.makeText(applicationContext,"Download Surat Permohonan Selesai",Toast.LENGTH_LONG).show()
                }
            }
        }
        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))


        lateinit var text2: TextView

        text2 = findViewById(R.id.srt_undangan)
        text2.setOnClickListener {
            var request = DownloadManager.Request(Uri.parse("https://drive.google.com/file/d/1JywOMypd-qC5V6QIvdnuY11VNHTAkPCN/view"))
                .setTitle("Surat Undangan")
                .setDescription("Surat Undangan Downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)

            var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownlodid = dm.enqueue(request)
        }

        var br2 = object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long? = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==mydownlodid){
                    Toast.makeText(applicationContext,"Download Surat Udangan Selesai",Toast.LENGTH_LONG).show()
                }
            }
        }
        registerReceiver(br2, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))


        lateinit var text3: TextView

        text3 = findViewById(R.id.srt_tugas)
        text3.setOnClickListener {
            var request = DownloadManager.Request(Uri.parse("https://drive.google.com/file/d/1JywOMypd-qC5V6QIvdnuY11VNHTAkPCN/view"))
                .setTitle("Surat Tugas")
                .setDescription("Surat Tugas Downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)

            var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownlodid = dm.enqueue(request)
        }

        var br3 = object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long? = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==mydownlodid){
                    Toast.makeText(applicationContext,"Download Surat Tugas Selesai",Toast.LENGTH_LONG).show()
                }
            }
        }
        registerReceiver(br3, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))


        lateinit var text4: TextView

        text4 = findViewById(R.id.srt_edaran)
        text4.setOnClickListener {
            var request = DownloadManager.Request(Uri.parse("https://drive.google.com/file/d/1JywOMypd-qC5V6QIvdnuY11VNHTAkPCN/view"))
                .setTitle("Surat Edaran")
                .setDescription("Surat Edaran Downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setAllowedOverMetered(true)

            var dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            mydownlodid = dm.enqueue(request)
        }

        var br4 = object:BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id:Long? = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(id==mydownlodid){
                    Toast.makeText(applicationContext,"Download Surat Edaran Selesai",Toast.LENGTH_LONG).show()
                }
            }
        }
        registerReceiver(br4, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }
}