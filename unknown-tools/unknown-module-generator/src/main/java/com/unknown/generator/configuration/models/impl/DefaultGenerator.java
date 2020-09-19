package com.unknown.generator.configuration.models.impl;

import com.unknown.generator.configuration.models.ExecutionPlan;
import com.unknown.generator.configuration.models.Generator;
import com.unknown.generator.configuration.models.Settings;

import java.io.IOException;

/**
 * Module default generator.
 * This class contains the default generator used for the module generation.
 *
 * @author t.postaire
 */
public class DefaultGenerator implements Generator {

    private final Settings settings;
    private final ExecutionPlan executionPlan;

    /**
     * Constructor.
     *
     * @param settings      module settings.
     * @param executionPlan generator execution plan.
     */
    public DefaultGenerator(Settings settings, ExecutionPlan executionPlan) {
        this.settings = settings;
        this.executionPlan = executionPlan;
    }

    /**
     * Generate the module by executing the execution plan ({@link ExecutionPlan}) thanks to the settings ({@link Settings}).
     *
     * @throws IOException on IO error.
     */
    public void generate() throws IOException {
        this.executionPlan.execute(this.settings);
    }
}
