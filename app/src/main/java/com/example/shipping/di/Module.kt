package com.example.shipping.di

import android.content.Context
import androidx.room.Room
import com.example.shipping.data.repo.RepositoryImpl
import com.example.shipping.data.source.dao.ProductDao
import com.example.shipping.data.source.database.ProductDataBase
import com.example.shipping.domain.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context) = context

    @Volatile
    private var mINSTANCE: ProductDataBase? = null
    private fun getDatabase(context: Context): ProductDataBase {
        val tempInstance = mINSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(context.applicationContext) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                ProductDataBase::class.java,
                "product_database"
            ).build()
            mINSTANCE = instance
            return instance
        }
    }

    @Provides
    @Singleton
    fun providesRepository(context: Context): Repository =
        RepositoryImpl(
            getDatabase(context).productDao()
        )

    @Provides
    @Singleton
    fun providesProductDao(context: Context): ProductDao = getDatabase(context).productDao()
}