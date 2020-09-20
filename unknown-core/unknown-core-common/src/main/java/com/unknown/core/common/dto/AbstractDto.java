package com.unknown.core.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;
import java.util.Objects;

/**
 * <p>Abstract DTO class for representing a domain entity.</p>
 * <p>This class contains only basic technical information and should be extending for your domain entity.</p>
 *
 * @author t.postaire
 */
public abstract class AbstractDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Date creationDate;
    private String creationUser;
    private Date modificationDate;
    private String modificationUser;

    /**
     * Constructor.
     */
    public AbstractDto() {
    }

    /**
     * <p>Copy constructor.</p>
     * <p>This method is used to copy a dto in a new one.</p>
     *
     * @param toCopy dto to copy.
     */
    public AbstractDto(AbstractDto toCopy) {
        this.id = toCopy.id;
        if (toCopy.creationDate != null) {
            this.creationDate = new Date(toCopy.creationDate.getTime());
        }
        this.creationUser = toCopy.creationUser;
        if (toCopy.modificationDate != null) {
            this.modificationDate = new Date(toCopy.modificationDate.getTime());
        }
        this.modificationUser = toCopy.modificationUser;
    }

    /**
     * Gets entity id.
     *
     * @return value of the entity id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets entity id.
     *
     * @param id id to set.
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets entity creation date.
     *
     * @return value of the entity creation date.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets entity creation date.
     *
     * @param creationDate creation date to set.
     */
    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets entity creation user.
     *
     * @return value of the entity creation user.
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * Sets entity creation user.
     *
     * @param creationUser creation user to set.
     */
    public void setCreationUser(final String creationUser) {
        this.creationUser = creationUser;
    }

    /**
     * Gets entity modification date.
     *
     * @return value of the entity modification date.
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets entity modification date.
     *
     * @param modificationDate modification date to set.
     */
    public void setModificationDate(final Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * Gets entity modification user.
     *
     * @return value of the entity modification user.
     */
    public String getModificationUser() {
        return modificationUser;
    }

    /**
     * Sets entity modification user.
     *
     * @param modificationUser modification user to set.
     */
    public void setModificationUser(final String modificationUser) {
        this.modificationUser = modificationUser;
    }

    /**
     * <p>Indicates whether some object is equal to this one.</p>
     * <p>Note that two entities are equals if at least their ids are the same.</p>
     *
     * @param o the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the o argument, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractDto that = (AbstractDto) o;
        return Objects.equals(id, that.id);
    }

    /**
     * <p>Returns a hash code value for the object. This method is supported for the benefit of hash tables such as
     * those provided by {@link java.util.HashMap}</p>
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
