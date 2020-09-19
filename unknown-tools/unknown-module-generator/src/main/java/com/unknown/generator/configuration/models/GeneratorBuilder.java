package com.unknown.generator.configuration.models;

import com.unknown.generator.configuration.models.impl.DefaultGenerator;

public class GeneratorBuilder {

    private final SettingsBuilder settingsBuilder;
    private final ExecutionPlanBuilder executionPlanBuilder;

    public GeneratorBuilder() {
        this.settingsBuilder = new SettingsBuilder(this);
        this.executionPlanBuilder = new ExecutionPlanBuilder(this);
    }

    public static GeneratorBuilder create() {
        return new GeneratorBuilder();
    }

    public SettingsBuilder setting() {
        return settingsBuilder;
    }

    public ExecutionPlanBuilder executionPlan() {
        return executionPlanBuilder;
    }

    public Generator build() {
        Settings builtSettings = settingsBuilder.build();
        ExecutionPlan builtExecutionPlan = executionPlanBuilder.build();
        return new DefaultGenerator(builtSettings, builtExecutionPlan);
    }
}
