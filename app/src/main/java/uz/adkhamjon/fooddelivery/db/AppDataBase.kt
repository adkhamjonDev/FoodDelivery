package uz.adkhamjon.fooddelivery.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.adkhamjon.fooddelivery.models.ExampleModel2


@Database(entities = [ExampleModel2::class],version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun scannerDao():FoodDao
    companion object{
        private var appDatabase: AppDataBase? = null
        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDataBase::class.java, "my_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return appDatabase!!
        }
    }
}