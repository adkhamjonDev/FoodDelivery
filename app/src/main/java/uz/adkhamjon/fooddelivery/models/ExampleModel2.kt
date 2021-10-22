package uz.adkhamjon.fooddelivery.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "foodLiked")
data class ExampleModel2(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String?=null,
    var image:String?=null
):Serializable
