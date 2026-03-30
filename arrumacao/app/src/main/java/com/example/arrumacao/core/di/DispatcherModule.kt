package com.example.arrumacao.core.di

import com.example.arrumacao.core.dispatchers.AppDispatchers
import com.example.arrumacao.core.dispatchers.AppDispatchersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    @Singleton
    abstract fun bindAppDispatchers(
        impl: AppDispatchersImpl
    ): AppDispatchers
}