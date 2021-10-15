package com.larissa.gistsapp.data.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.larissa.gistsapp.data.db.base.Converter
import com.larissa.gistsapp.data.db.service.FavoriteDao
import com.larissa.gistsapp.data.model.Gist

@Database(entities = [Gist::class], version = 1)
@TypeConverters(Converter::class)

abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

}
