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
import uz.adkhamjon.fooddelivery.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val display: Display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val bmp = Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(
                resources, R.drawable.splash2

            ), size.x, size.y, true
        )
        binding.splash.setImageBitmap(bmp)
        val background: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                    val intent= Intent(applicationContext,RegistrationActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                }
            }
        }
        background.start()
    }
}