package com.infinitehorizons

interface DatabaseConfigurator {
    fun configure(moduleName: String?): Triple<String?, String?, Int?>?
}