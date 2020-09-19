package com.unknown.generator.configuration.models;

import java.io.IOException;

/**
 * Execution plan Interface.
 * This is used to execute the module generation.
 *
 * @author t.postaire
 */
public interface ExecutionPlan {

    /**
     * Execute the generation of the module.
     * Classes will be generated in the right path.
     *
     * @param settings module settings.
     * @throws IOException an IO error.
     */
    void execute(Settings settings) throws IOException;
}
