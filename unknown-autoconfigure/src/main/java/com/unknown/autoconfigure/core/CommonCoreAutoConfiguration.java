package com.unknown.autoconfigure.core;

import com.unknown.core.common.mapper.MapperPlugin;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

/**
 * AutoConfiguration class for the core/common module.
 *
 * @author t.postaire
 */
@Configuration
@EnablePluginRegistries({MapperPlugin.class})
public class CommonCoreAutoConfiguration {
}
