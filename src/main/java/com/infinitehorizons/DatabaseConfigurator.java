package com.infinitehorizons;

import kotlin.Triple;

public interface DatabaseConfigurator {
    Triple<String, String, Integer> configure(String moduleName);
}
