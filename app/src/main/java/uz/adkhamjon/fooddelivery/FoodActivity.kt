package uz.adkhamjon.fooddelivery

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.adkhamjon.fooddelivery.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener  {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityFoodBinding

    lateinit var bottomNavigationView: BottomNavigationView
    private var backPressedToExitOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.appBarFood.content.bottomNav.setOnItemSelectedListener(this)
        setSupportActionBar(binding.appBarFood.top)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_content_food)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        binding.drawerLayout.setViewScale(Gravity.START, 0.7f)
        binding.drawerLayout.setRadius(Gravity.START, 30f)
        binding.drawerLayout.setViewElevation(Gravity.START, 18f)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.myProfileFragment->{
                    navController.navigate(R.id.myProfileFragment)
                    hideToolbar()
                    hideBottomNav()
                }
                R.id.ordersFragment->{
                    navController.navigate(R.id.ordersFragment)
                    hideToolbar()
                    hideBottomNav()
                }
            }
            drawerLayout.closeDrawers()
            true
        }
        binding.appBarFood.bell.setOnClickListener {
            navController.navigate(R.id.notificationFragment)
            hideToolbar()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_food)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            val count = supportFragmentManager.backStackEntryCount
            if (count == 0) {
                if (backPressedToExitOnce) {
                    super.onBackPressed()
                } else {
                    this.backPressedToExitOnce = true
                    Toast.makeText(this, "Чтобы выйти из программы, нажмите еще раз", Toast.LENGTH_SHORT)
                        .show()
                    Handler().postDelayed({
                        backPressedToExitOnce = false
                    }, 2000)
                }
            } else {
                if (navController.currentDestination?.id == R.id.nav_home) {
                    binding.appBarFood.content.bottomNav.selectedItemId = 0
                    navController.popBackStack()
                }
                supportFragmentManager.popBackStack()
            }
        }
    }
    fun setTittle(str:String){
        binding.appBarFood.tittle.text=str
    }
    fun hideBell(){
        binding.appBarFood.bell.visibility=View.GONE
        binding.appBarFood.number.visibility=View.GONE
    }
    fun showBell(){
        binding.appBarFood.bell.visibility=View.VISIBLE
        binding.appBarFood.number.visibility=View.VISIBLE
    }
    fun hideToolbar(){
        binding.appBarFood.top.visibility=View.GONE
    }
    fun showToolbar(){
        binding.appBarFood.top.visibility=View.VISIBLE
    }
    fun hideBottomNav(){
        binding.appBarFood.content.bottomNav.visibility=View.GONE
    }
    fun showBottomNav(){
        binding.appBarFood.content.bottomNav.visibility=View.VISIBLE
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home->{
                while (R.id.nav_home != navController.currentDestination?.id && navController.currentDestination?.id != null)
                {
                    navController.popBackStack()
                }
            }
            R.id.myProfileFragment->{

            }
            R.id.historyFragment->{
                if (R.id.historyFragment != navController.currentDestination?.id) {
                    while (R.id.nav_home != navController.currentDestination?.id && navController.currentDestination?.id != null) {
                        navController.popBackStack()
                    }
                    navController.navigate(R.id.historyFragment)
                    hideToolbar()
                }
            }
            R.id.likedFragment->{
                if (R.id.likedFragment != navController.currentDestination?.id) {
                    while (R.id.nav_home != navController.currentDestination?.id && navController.currentDestination?.id != null) {
                        navController.popBackStack()
                    }
                    navController.navigate(R.id.likedFragment)
                    hideToolbar()
                }
            }
            R.id.ordersFragment->{
                if (R.id.ordersFragment != navController.currentDestination?.id) {
                    while (R.id.nav_home != navController.currentDestination?.id && navController.currentDestination?.id != null) {
                        navController.popBackStack()
                    }
                    navController.navigate(R.id.ordersFragment, bundleOf("check" to "bottom"))
                    hideToolbar()
                }
            }
        }
        return true
    }
}