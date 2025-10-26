package com.example.shuttleapp.di


import android.app.Application
import androidx.room.Room
import com.example.shuttleapp.data.network.AuthApi
import com.example.shuttleapp.domain.repository.UserDataRepository
import com.example.shuttleapp.domain.usecase.login.ValidateLoginInput
import com.example.shuttleapp.domain.usecase.login.ValidatePasswordInput
import com.example.shuttleapp.domain.usecase.login.ValidateUsernameInput
import com.example.shuttleapp.domain.usecase.logout.LogoutUseCase
import com.example.shuttleapp.domain.usecase.register.ValidateEmpNoInput
import com.example.shuttleapp.domain.usecase.register.ValidateFirstNameInput
import com.example.shuttleapp.domain.usecase.register.ValidateLastNameInput
import com.example.shuttleapp.domain.usecase.register.ValidateMiddleNameInput
import com.example.shuttleapp.domain.usecase.register.ValidateProviderInput
import com.example.shuttleapp.domain.usecase.register.ValidateRePasswordInput
import com.example.shuttleapp.config.API
import com.example.shuttleapp.config.ShuttleDatabase
import com.example.shuttleapp.data.network.ShuttleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //interceptor for retrofit used for logging
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    //provide the api
    @Singleton
    @Provides
    fun providesShuttleApi() : ShuttleApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API.BASE_URL)
            .client(client)
            .build()
            .create(ShuttleApi::class.java)
    }

    @Singleton
    @Provides
    fun providesAuthApi() : AuthApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API.BASE_URL)
            .client(client)
            .build()
            .create(AuthApi::class.java)
    }

    //provide the database
    @Singleton
    @Provides
    fun providesShuttleDatabase(app: Application) : ShuttleDatabase {
        return Room.databaseBuilder(
            app,
            ShuttleDatabase::class.java,
            "shuttle.db"
        )
            .fallbackToDestructiveMigration(dropAllTables = false)
            .build()
    }






}
