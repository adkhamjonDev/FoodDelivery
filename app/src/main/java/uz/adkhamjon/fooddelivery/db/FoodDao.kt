package uz.adkhamjon.fooddelivery.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.adkhamjon.fooddelivery.models.ExampleModel2
@Dao
interface FoodDao {
    @Insert
    fun addLiked(exampleModel2: ExampleModel2)
    @Query("SELECT * FROM foodLiked")
    fun getAllLiked():List<ExampleModel2>
    @Delete
    fun removeLiked(exampleModel2: ExampleModel2)
}