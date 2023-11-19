package com.example.plannerproject
import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [User::class], version = 1, exportSchema = false)
abstract class FriendDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile private var Instance: FriendDatabase? = null

                fun getDatabase(context: Context): FriendDatabase {
                    return Instance  ?: synchronized(this){
                        Room.databaseBuilder(context, FriendDatabase::class.java, "user_database")
                            .fallbackToDestructiveMigration()
                            .build()
                            .also { Instance = it }
                    }
                }
    }
}