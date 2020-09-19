package com.unknown.generator.utils;

import com.unknown.generator.configuration.models.Settings;

/**
 * Generator Utility class.
 *
 * @author t.postaire
 */
public class GeneratorUtils {

    private GeneratorUtils() {
        throw new IllegalStateException();
    }

    /**
     * Get the entity class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the entity class name.
     */
    public static String getEntityClassName(Settings settings) {
        return settings.getEntityName();
    }

    /**
     * Get the repository class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the repository class name.
     */
    public static String getRepositoryClassName(Settings settings) {
        return settings.getEntityName() + "Repository";
    }

    /**
     * Get the dao class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the dao class name.
     */
    public static String getDaoClassName(Settings settings) {
        return settings.getEntityName() + "Dao";
    }

    /**
     * Get the dao implementation class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the dao implementation class name.
     */
    public static String getDaoImplClassName(Settings settings) {
        return settings.getEntityName() + "DaoImpl";
    }

    /**
     * Get the service class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the service class name.
     */
    public static String getServiceClassName(Settings settings) {
        return settings.getEntityName() + "Service";
    }

    /**
     * Get the service implementation class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the service implementation class name.
     */
    public static String getServiceImplClassName(Settings settings) {
        return settings.getEntityName() + "ServiceImpl";
    }

    /**
     * Get the dto class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the dto class name.
     */
    public static String getDtoClassName(Settings settings) {
        return settings.getEntityName() + "Dto";
    }

    /**
     * Get the mapper class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the mapper class name.
     */
    public static String getMapperClassName(Settings settings) {
        return settings.getEntityName() + "DtoMapper";
    }

    /**
     * Get the configuration class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the configuration class name.
     */
    public static String getConfigurationClassName(Settings settings) {
        return settings.getEntityName() + "Configuration";
    }

    /**
     * Get the configuration fully qualified class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the configuration fully qualified class name.
     */
    public static String getConfigurationFullyQualifiedClassName(Settings settings) {
        return getPackage(settings) + '.' + getConfigurationClassName(settings);
    }

    /**
     * Get entity class name for the module to be generated.
     *
     * @param settings module settings.
     * @return the entity class name.
     */
    private static String getPackage(Settings settings, String... subpackages) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(settings.getBasePackage());

        for (String subpackage : subpackages) {
            stringBuilder.append(".").append(subpackage);
        }
        return stringBuilder.toString();
    }
}
