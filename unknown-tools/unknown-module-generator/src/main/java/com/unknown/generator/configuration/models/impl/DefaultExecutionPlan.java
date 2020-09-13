package com.unknown.generator.configuration.models.impl;

import com.helger.jcodemodel.JCodeModel;
import com.unknown.generator.classes.ClassGenerator;
import com.unknown.generator.configuration.models.ExecutionPlan;
import com.unknown.generator.configuration.models.Settings;

import java.io.IOException;
import java.util.List;

/**
 * Generator default execution plan. This will generate the module with default execution.
 *
 * @author t.postaire
 */
public class DefaultExecutionPlan implements ExecutionPlan {

    private final List<ClassGenerator> classGenerators;

    /**
     * Constructor.
     *
     * @param classGenerators class generator list. Contain the list of every class to be generated.
     */
    public DefaultExecutionPlan(List<ClassGenerator> classGenerators) {
        this.classGenerators = classGenerators;
    }

    /**
     * Default execution the module generation.
     * Classes will be generated in the right path.
     *
     * @param settings module settings.
     * @throws IOException an IO error.
     */
    @Override
    public void execute(Settings settings) throws IOException {
        JCodeModel jCodeModel = new JCodeModel();

        classGenerators.forEach(g -> {
            g.prepare(settings, jCodeModel);
            g.generate(settings, jCodeModel);
        });

        jCodeModel.build(settings.getSrcPath().toFile());
    }
}
