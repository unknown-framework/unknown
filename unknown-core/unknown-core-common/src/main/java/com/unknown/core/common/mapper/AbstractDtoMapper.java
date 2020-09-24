package com.unknown.core.common.mapper;

import com.google.common.reflect.TypeToken;
import com.unknown.core.common.dto.AbstractDto;
import com.unknown.core.common.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base {@link DtoMapper}.
 *
 * @param <E> the entity class.
 * @param <D> the dto class.
 * @author t.postaire
 */
@SuppressWarnings("UnstableApiUsage")
public abstract class AbstractDtoMapper<E extends AbstractEntity, D extends AbstractDto> implements DtoMapper<E, D> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDtoMapper.class);
    private final TypeToken<E> typeToken = new TypeToken<E>(getClass()) {
    };

    /**
     * <p>Constructor.</p>
     * <p>Log for which entity class the DtoMapper is created.</p>
     */
    public AbstractDtoMapper() {
        LOGGER.info("Creating DtoMapper for entity class {}", typeToken.getRawType());
    }

    /**
     * Returns if the {@code mapperPlugin} should be invoked according to the given delimiter.
     *
     * @param delimiter must not be {@literal null}.
     * @return if the {@code mapperPlugin} should be invoked.
     */
    @Override
    public boolean supports(final Class<? extends AbstractEntity> delimiter) {
        return delimiter.isAssignableFrom(typeToken.getRawType());
    }
}
