package com.unknown.generator.configuration.models;

import java.nio.file.Path;

/**
 * Settings interface.
 * This is used to get settings from the generated module.
 *
 * @author t.postaire
 */
public interface Settings {

    /**
     * Get the module src path.
     *
     * @return the module src path.
     */
    Path getSrcPath();

    /**
     * Get the module base package.
     *
     * @return the module base package.
     */
    String getBasePackage();

    /**
     * Get the module entity name.
     *
     * @return the module entity name.
     */
    String getEntityName();
}
