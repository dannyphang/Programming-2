package com.example.roomdemo2.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

// Entity ------------------------------------------------------------------------------------------

@Entity
data class Program(
    @PrimaryKey
    var id  : String = "",
    var name: String = "",
) {
    override fun toString() = name
}

@Entity
data class Student(
    @PrimaryKey
    var id       : String = "",
    var name     : String = "",
    var gender   : String = "",
    var programId: String = "",
)

// TODO(1): ProgramCustom - program with students
data class ProgramCustom(
    var id  : String,
    var name: String,
    @Relation(parentColumn = "id", entityColumn = "programId")
    var students: List<Student>
)

// TODO(11): StudentCustom - student with program
data class StudentCustom(
    var id       : String,
    var name     : String,
    var gender   : String,
    var programId: String,
    @Relation(parentColumn = "programId", entityColumn = "id")
    var program: Program,
)

// Dao ---------------------------------------------------------------------------------------------

@Dao
interface ProgramDao {
    // TODO(31): getPrograms
    @Query("SELECT * FROM program ORDER BY id")
    suspend fun getPrograms(): List<Program>

    // TODO(2): getAllCustom
    @Transaction
    @Query("SELECT * FROM program ORDER BY id")
    fun getAllCustom(): LiveData<List<ProgramCustom>>

    // ---------------------------------------------------------------------------------------------

    @Query("SELECT * FROM program ORDER BY id")
    fun getAll(): LiveData<List<Program>>

    @Query("SELECT * FROM program WHERE id = :id")
    fun get(id: String): LiveData<Program>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg programs: Program)

    @Update
    suspend fun update(vararg programs: Program)

    @Delete
    suspend fun delete(vararg programs: Program)
}

@Dao
interface StudentDao {
    // TODO(24): getCount
    @Query("SELECT COUNT(*) FROM student WHERE id = :id")
    // if it is not live data (like like 7, the getAllCustom), then need to add "suspend" before fun
    suspend fun getCount(id: String): Int

    // TODO(12): getAllCustom
    // TODO(17): Add search query
    @Transaction
    @Query("SELECT * FROM student WHERE name LIKE '%' || :query || '%' ORDER BY id")
    fun getAllCustom(query: String = ""): LiveData<List<StudentCustom>>

    // TODO(8): getStudentsByProgramId
    @Query("SELECT * FROM student WHERE programId = :programId ORDER BY id")
    fun getStudentByProgramId(programId: String): LiveData<List<Student>>

    // ---------------------------------------------------------------------------------------------

    @Query("SELECT * FROM student ORDER BY id")
    fun getAll(): LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE id = :id")
    fun get(id: String): LiveData<Student>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg students: Student)

    @Update
    suspend fun update(vararg students: Student)

    @Delete
    suspend fun delete(vararg students: Student)
}

// Database ----------------------------------------------------------------------------------------

@Database(
    entities = [Program::class, Student::class],
    version = 1,
    exportSchema = false
)
abstract class DB : RoomDatabase() {
    abstract val programDao: ProgramDao
    abstract val studentDao: StudentDao

    companion object {
        @Volatile
        private var instance: DB? = null

        @Synchronized
        fun getInstance(context: Context): DB {
            instance = instance ?: Room
                .databaseBuilder(context, DB::class.java, "database.db")
                .createFromAsset("import.db")
                .fallbackToDestructiveMigration()
                .build()
            return instance!!
        }
    }
}