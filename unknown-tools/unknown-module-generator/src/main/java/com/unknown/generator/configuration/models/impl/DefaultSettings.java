package com.unknown.generator.configuration.models.impl;

import com.unknown.generator.configuration.models.Settings;

import java.nio.file.Path;

/**
 * Module default settings.
 * This class contains default settings used for the module generation.
 *
 * @author t.postaire
 */
public class DefaultSettings implements Settings {

    private final Path projectRoot;
    private final String basePackage;
    private final String entityName;

    /**
     * Constructor.
     * @param projectRoot project root path, must not be null.
     * @param basePackage project base package, must not be null.
     * @param entityName module entity name, must not be null.
     */
    public DefaultSettings(Path projectRoot, String basePackage, String entityName) {
        this.projectRoot = projectRoot;
        this.basePackage = basePackage;
        this.entityName = entityName;
    }

    /**
     * Get the module src path.
     *
     * @return the module src path.
     */
    @Override
    public Path getSrcPath() {
        return projectRoot.resolve("src").resolve("main").resolve("java");
    }

    /**
     * Get the module base package.
     *
     * @return the module base package.
     */
    @Override
    public String getBasePackage() {
        return basePackage;
    }

    /**
     * Get the module entity name.
     *
     * @return the module entity name.
     */
    @Override
    public String getEntityName() {
        return entityName;
    }
}
