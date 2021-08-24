package com.example.roomdemo1.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class Fruit (
    @PrimaryKey(autoGenerate = true)
    var id   : Int = 0,
    var name : String,
    var price: Double,
)

@Dao // data access object
interface FruitDao {
    @Query("SELECT * FROM fruit")
    fun getAll(): LiveData<List<Fruit>>

    @Query("SELECT * FROM fruit WHERE id = :id")
    fun get(id: Int): LiveData<Fruit>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(f: Fruit)
    // suspend fun insert(f: Fruit): Long // its to return a Long value

    @Update
    suspend fun update(f: Fruit) // Int -> count

    @Delete
    suspend fun delete(f: Fruit) // Int -> count

    @Query("DELETE FROM fruit")
    suspend fun deleteAll()
}

@Database(
    entities = [Fruit::class],
    version = 1,
    exportSchema = false
)
abstract class DB : RoomDatabase(){
    abstract val fruitDao: FruitDao

    // singleton
    companion object{
        @Volatile
        private var instance: DB? = null

        @Synchronized
        fun getInstance(context: Context): DB{
            instance = instance ?: Room
                .databaseBuilder(context, DB:: class.java, "database.db")
                .createFromAsset("database_db.db")
                .fallbackToDestructiveMigration()
                .build()
            return instance!!
        }
    }
}