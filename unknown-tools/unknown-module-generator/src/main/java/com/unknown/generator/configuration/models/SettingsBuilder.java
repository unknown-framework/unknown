package com.unknown.generator.configuration.models;

import com.google.common.base.Preconditions;
import com.unknown.generator.configuration.models.impl.DefaultSettings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SettingsBuilder {

    private final GeneratorBuilder parent;
    private String projectRoot;
    private String basePackage;
    private String entityName;

    public SettingsBuilder(GeneratorBuilder parent) {
        this.parent = parent;
    }

    public SettingsBuilder projectRoot(String projectRoot) {
        this.projectRoot = projectRoot;
        return this;
    }

    public SettingsBuilder basePackage(String basePackage) {
        this.basePackage = basePackage;
        return this;
    }

    public SettingsBuilder entityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public GeneratorBuilder done() {
        return this.parent;
    }

    private void validate() {
        Path projectRootPath = Paths.get(this.projectRoot);
        Preconditions.checkState(this.projectRoot != null, "The generator needs a project root path to work.");
        Preconditions.checkState(Files.exists(projectRootPath) && Files.isDirectory(projectRootPath),
                "The project root path must be in an existing directory.");
        Preconditions.checkState(this.entityName != null, "The entity name must not be null");
        Preconditions.checkState(this.basePackage != null, "There must be a base package for the generated classes.");
    }

    private void initialize() throws IOException {
        Files.createDirectories(Paths.get(this.projectRoot));
        Files.createDirectories(Paths.get(this.projectRoot).resolve("src").resolve("main").resolve("java"));
        Files.createDirectories(Paths.get(this.projectRoot).resolve("src").resolve("main").resolve("resources"));
    }

    public Settings build() {
        validate();
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new DefaultSettings(Paths.get(this.projectRoot), this.basePackage, this.entityName);
    }
}
