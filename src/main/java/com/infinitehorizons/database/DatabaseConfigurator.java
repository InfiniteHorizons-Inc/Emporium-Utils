package com.infinitehorizons.database;

import kotlin.Triple;

/**
 * Interface DatabaseConfigurator.
 * <p>
 * This interface defines the contract for configuring database connections dynamically 
 * based on the provided module name. It is designed to be flexible and reusable across 
 * different projects, particularly when working with microservices or modular architectures.
 * <p>
 * Example usage:
 * <pre>
 * DatabaseConfigurator configurator = new MyDatabaseConfigurator();
 * Triple<String, String, Integer> config = configurator.configure("user-service");
 * String databaseUrl = config.getFirst();
 * String schemaName = config.getSecond();
 * Integer port = config.getThird();
 * </pre>
 *
 * <b>Note:</b> Ensure that the implementation of this interface handles exceptions gracefully
 * in case of invalid or unexpected input, such as module names that are not configured.
 *
 */
public interface DatabaseConfigurator {

    /**
     * Configures the database connection for the given module name.
     *
     * @param moduleName The name of the module (e.g., "user-service"). This is used to
     *                   determine the database URL, schema name, and port dynamically.
     * @return A {@link kotlin.Triple} containing the database URL as the first element,
     *         the schema name as the second element, and the port as the third element.
     *         If any of these values cannot be determined, the implementation should
     *         handle the scenario appropriately (e.g., return default values or throw
     *         an exception).
     */
    Triple<String, String, Integer> configure(String moduleName);
}
