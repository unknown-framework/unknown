package com.unknown.core.common.mapper;

import com.unknown.core.common.dto.AbstractDto;
import com.unknown.core.common.entity.AbstractEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper that convert a given {@link AbstractEntity} and its corresponding {@link AbstractDto} between them.
 *
 * @param <E> the entity class.
 * @param <D> the dto class.
 * @author t.postaire
 */
public interface DtoMapper<E extends AbstractEntity, D extends AbstractDto> extends MapperPlugin {

    /**
     * Map a given {@link AbstractEntity} into its corresponding {@link AbstractDto}.
     *
     * @param entity the given entity to map.
     * @return the mapped dto.
     */
    D mapEntity(E entity);

    /**
     * Map a given {@link AbstractDto} into its corresponding {@link AbstractEntity}.
     *
     * @param dto the given dto to map.
     * @return the mapped entity.
     */
    E mapDto(D dto);

    /**
     * Map a given list of {@link AbstractEntity} into a list of its corresponding {@link AbstractDto}.
     *
     * @param entities the given list of entities to map.
     * @return the list of mapped dtos.
     */
    default List<D> mapEntities(Collection<E> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream().map(this::mapEntity).collect(Collectors.toList());
    }

    /**
     * Map a given list of {@link AbstractDto} into a list of its corresponding {@link AbstractEntity}.
     *
     * @param dtos the given list of dto to map.
     * @return the list of mapped entity.
     */
    default List<E> mapDtos(Collection<D> dtos) {
        if (dtos == null) {
            return Collections.emptyList();
        }
        return dtos.stream().map(this::mapDto).collect(Collectors.toList());
    }
}
