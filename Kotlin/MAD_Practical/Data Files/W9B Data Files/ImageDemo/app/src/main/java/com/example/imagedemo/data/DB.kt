package com.example.imagedemo.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class Image(
    @PrimaryKey(autoGenerate = true)
    var id  : Int = 0,
    var name: String = "",
    // TODO(1): Add date field (store date and time)

)

// TODO(2): TypeConverter class (handle date)


@Dao
interface ImageDao {
    @Query("SELECT * FROM image WHERE id = :id")
    suspend fun get(id: Int): Image

    @Query("SELECT * FROM image ORDER BY id")
    fun getAll(): LiveData<List<Image>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg images: Image)

    @Update
    suspend fun update(vararg images: Image)

    @Delete
    suspend fun delete(vararg images: Image)

    @Query("DELETE FROM image")
    suspend fun deleteAll()
}

@Database(
    entities = [Image::class],
    version = 1,
    exportSchema = false
)
// TODO(3): Attach TypeConverters to database

abstract class DB : RoomDatabase() {
    abstract val imageDao: ImageDao

    companion object {
        @Volatile
        private var instance: DB? = null

        @Synchronized
        fun getInstance(context: Context): DB {
            instance = instance ?: Room
                .databaseBuilder(context, DB::class.java, "database.db")
                .fallbackToDestructiveMigration()
                .build()
            return instance!!
        }
    }
}