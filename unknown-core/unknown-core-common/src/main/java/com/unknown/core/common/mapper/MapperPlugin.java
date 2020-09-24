package com.unknown.core.common.mapper;

import com.unknown.core.common.PluginConstants;
import com.unknown.core.common.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.plugin.core.Plugin;

/**
 * Plugin for {@link DtoMapper}.
 *
 * @author t.postaire
 */
@Qualifier(value = PluginConstants.PLUGIN_MAPPER)
public interface MapperPlugin extends Plugin<Class<? extends AbstractEntity>> {
}
