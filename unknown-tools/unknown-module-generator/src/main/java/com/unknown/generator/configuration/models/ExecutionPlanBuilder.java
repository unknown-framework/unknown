package com.unknown.generator.configuration.models;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.unknown.generator.classes.ClassGenerator;
import com.unknown.generator.classes.ConfigurationGenerator;
import com.unknown.generator.configuration.models.impl.DefaultExecutionPlan;

import java.util.List;
import java.util.Objects;

public class ExecutionPlanBuilder {

    private final GeneratorBuilder parent;

    private ConfigurationGenerator configurationGenerator;

    public ExecutionPlanBuilder(GeneratorBuilder parent) {
        this.parent = parent;
    }

    public ExecutionPlanBuilder configuration() {
        this.configurationGenerator = new ConfigurationGenerator();
        return this;
    }

    public ExecutionPlan build() {
        List<ClassGenerator> classGenerators = Lists.newArrayList(configurationGenerator);
        Iterables.removeIf(classGenerators, Objects::isNull);

        return new DefaultExecutionPlan(classGenerators);
    }
}
