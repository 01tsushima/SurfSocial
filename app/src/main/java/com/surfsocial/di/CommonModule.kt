package com.surfsocial.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.surfsocial.extension.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.applicationContext.dataStore
    }
}