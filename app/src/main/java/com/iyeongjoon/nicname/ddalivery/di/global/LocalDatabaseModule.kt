package com.iyeongjoon.nicname.ddalivery.di.global

import android.content.Context
import androidx.room.Room
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDatabaseModule{
    @Provides
    @Singleton
    fun provideLocalDatabase(context: Context) = Room.databaseBuilder(context,LocalDatabase::class.java,"ddalivery.db").build()
}