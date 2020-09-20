package com.unknown.core.common.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * <p>Abstract base class for all entities.</p>
 * <p>Provides technical columns such as identifier and auditing listener, and deals with setting/updating them.</p>
 *
 * @author t.postaire
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationDate;

    @Column(name = "creation_user", updatable = false)
    @CreatedBy
    private String creationUser;

    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modificationDate;

    @Column(name = "modification_user")
    @LastModifiedBy
    private String modificationUser;

    /**
     * <p>Sets the id of the entity just before it is persisted for the first time.</p>
     * <p>Ids are generated with the {@link UUID} class and its method {@link UUID#getLeastSignificantBits()
     * getLeastSignificantBits}.</p>
     */
    @PrePersist
    public void ensureId() {
        if (this.id == null) {
            this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        }
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
     * <p>Note that two entities are equals if their ids are equals, not regarding other fields</p>
     *
     * @param o the reference object with which to compare.
     * @return <code>true</code> if this object is the same as the o argument, <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractEntity that = (AbstractEntity) o;
        return this.id != null && that.id != null && this.id.equals(that.id);
    }

    /**
     * <p>Returns a hash code value for the object. This method is supported for the benefit of hash tables such as
     * those provided by {@link java.util.HashMap}</p>
     * <p>A base hash code is set when the entity is not persisted yet to solve Jpa issues with hash codes.</p>
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    }
}
