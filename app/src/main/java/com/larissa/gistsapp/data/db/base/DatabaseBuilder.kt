package com.larissa.gistsapp.data.db.base

import android.content.Context
import androidx.room.Room


object DatabaseBuilder {
    // Singleton prevents multiple instances of database opening at the same time.
    @Volatile
    private var database: FavoriteDatabase? = null

    fun getFavoriteDatabase(context: Context? = null): FavoriteDatabase {
        val localDatabase = database
        // If database exists...
        return if (localDatabase != null) {
            localDatabase
        } else synchronized(this) {
            // If database does not exist...
            buildDatabase(context!!).also { database = it }
        }
    }

    private fun buildDatabase(context: Context): FavoriteDatabase {
        return Room.databaseBuilder(context, FavoriteDatabase::class.java, "favoriteDb")
            .build()
    }
}

//object DatabaseBuilder {
//    private var database: FavoriteDatabase? = null
//
//    fun getFavoriteDatabase(context: Context): FavoriteDatabase? {
//        if (database == null) {
//            synchronized(FavoriteDatabase::class) {
//                database = Room.databaseBuilder(
//                    context.applicationContext,
//                    FavoriteDatabase::class.java,
//                    "favoriteDb"
//                ).build()
//            }
//        }
//        return database
//    }
//}

//object DatabaseBuilder {
//    private var database: FavoriteDatabase? = null
//
//    fun buildDatabase(context: Context){
//        database = Room.databaseBuilder(
//            context, FavoriteDatabase::class.java, "db"
//        ).build()
//    }
//
//    fun getFavoriteDao(): FavoriteDao? {
//        database?.let{
//            return it.favoriteDao()
//        }
//        return null
//    }
//}