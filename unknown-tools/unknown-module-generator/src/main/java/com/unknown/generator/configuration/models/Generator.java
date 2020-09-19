package com.unknown.generator.configuration.models;

import java.io.IOException;

/**
 * Generator interface.
 * This is used to generate the module.
 *
 * @author t.postaire
 */
public interface Generator {

    /**
     * Generate the module by executing the execution plan ({@link ExecutionPlan}) thanks to the settings ({@link Settings}).
     *
     * @throws IOException on IO error.
     */
    void generate() throws IOException;
}
