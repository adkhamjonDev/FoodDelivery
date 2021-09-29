package uz.adkhamjon.fooddelivery

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.Window
import android.view.WindowManager
import uz.adkhamjon.fooddelivery.databinding.ActivityMainBinding
import uz.adkhamjon.fooddelivery.shared.SharedPreference

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val display: Display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val bmp = Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(
                resources, R.drawable.splash

            ), size.x, size.y, true
        )
        binding.image.setImageBitmap(bmp)
        if(SharedPreference.getInstance(this).haslang){
            startActivity(Intent(this,SplashActivity::class.java))
            finish()
        }
        else{
            binding.start.setOnClickListener {
                startActivity(Intent(this,SplashActivity::class.java))
                SharedPreference.getInstance(this).setHasLang(true)
                finish()
            }
        }
    }
}