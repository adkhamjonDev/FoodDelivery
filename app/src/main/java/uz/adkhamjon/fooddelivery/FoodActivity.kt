package uz.adkhamjon.fooddelivery

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.window.statusBarColor = this.getColor(R.color.orange)
        }
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
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_food)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cart->{

            }
        }
        return super.onOptionsItemSelected(item)
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
                if (R.id.myProfileFragment != navController.currentDestination?.id) {
                    while (R.id.nav_home != navController.currentDestination?.id && navController.currentDestination?.id != null) {
                        navController.popBackStack()
                    }
                    navController.navigate(R.id.myProfileFragment)
                    hideToolbar()
                }
            }
        }
        return true
    }
//    fun setUpNavigation() {
//        bottomNavigationView=findViewById(R.id.bottomNav)
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment_content_food) as NavHostFragment?
//        NavigationUI.setupWithNavController(bottomNavigationView,
//            navHostFragment!!.navController)
//    }
}