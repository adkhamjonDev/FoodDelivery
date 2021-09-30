package uz.adkhamjon.fooddelivery

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.adkhamjon.fooddelivery.databinding.ActivityFoodBinding

class FoodActivity : AppCompatActivity() {

    private lateinit var mDrawerToggle: ActionBarDrawerToggle
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityFoodBinding
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
        setSupportActionBar(binding.appBarFood.top)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.window.statusBarColor = this.getColor(R.color.orange)
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_food)
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
//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_vector)
//        }
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.myProfileFragment->{
                    navController.navigate(R.id.myProfileFragment)
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
    fun hideToolbar(){
        binding.appBarFood.top.visibility=View.GONE
    }
    fun showToolbar(){
        binding.appBarFood.top.visibility=View.VISIBLE
    }
    fun setUpNavigation() {
        bottomNavigationView=findViewById(R.id.bottomNav)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_content_food) as NavHostFragment?
        NavigationUI.setupWithNavController(bottomNavigationView,
            navHostFragment!!.navController)
    }
}