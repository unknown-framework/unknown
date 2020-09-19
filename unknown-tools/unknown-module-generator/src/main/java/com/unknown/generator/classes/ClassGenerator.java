package com.unknown.generator.classes;

import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.unknown.generator.configuration.models.Settings;

/**
 * Class generator interface.
 *
 * @author t.postaire
 */
public interface ClassGenerator {

    /**
     * Prepare the class to be generated.
     *
     * @param settings  module settings.
     * @param codeModel an instance of {@link JCodeModel} holding the context of the generated class.
     */
    void prepare(Settings settings, JCodeModel codeModel);

    /**
     * Generate the class.
     *
     * @param settings  module settings.
     * @param codeModel an instance of {@link JCodeModel} holding the context of the generated class.
     * @return a {@link JDefinedClass} representing the generated class.
     */
    JDefinedClass generate(Settings settings, JCodeModel codeModel);
}
