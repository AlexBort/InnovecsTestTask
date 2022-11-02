package com.example.innovecstesttask.di_hilt

import com.example.innovecstesttask.data.repository.ActionConfig
import com.example.innovecstesttask.data.result_handling.ConfigurationDataManager
import com.example.innovecstesttask.data.result_handling.DataManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

@Module
@InstallIn()
abstract class DataManagerModule {

    @Binds
    abstract fun bindDataManager(configManager: ConfigurationDataManager): DataManager<List<ActionConfig>, ActionConfig>
    /**
     * @Binds - зв'язує конкретну реалізацію ConfigurationDataManager з DataManager
     */
}