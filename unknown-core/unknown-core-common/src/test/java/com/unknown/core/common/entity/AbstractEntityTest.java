package com.unknown.core.common.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static java.util.Date.from;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

/**
 * {@link AbstractEntity} test class.
 *
 * @author t.postaire
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractEntityTest {

    @Test
    public void shouldEnsureIdBeSetIfNotAlreadySet() {
        AbstractEntity abstractEntity = spy(new TestEntity());
        abstractEntity.ensureId();

        assertNotNull(abstractEntity.getId());
    }

    @Test
    public void shouldEnsureIdNotChangeIfAlreadySet() {
        Long id = 1L;
        AbstractEntity abstractEntity = spy(new TestEntity());
        abstractEntity.setId(id);
        abstractEntity.ensureId();

        assertNotNull(abstractEntity.getId());
        assertEquals(abstractEntity.getId(), id);
    }

    @Test
    public void shouldBeEqualsIfIdAreEquals() {
        Long id = 1L;
        AbstractEntity a1 = new TestEntity();
        a1.setId(id);
        AbstractEntity a2 = new TestEntity();
        a2.setId(id);

        assertEquals(a1.getId(), a2.getId());
        assertEquals(a1, a2);
        assertEquals(a2, a1);
    }

    @Test
    public void shouldBeEqualsIfIdAreEqualsNotRegardingOtherFields() {
        Long id = 1L;
        AbstractEntity a1 = new TestEntity();
        a1.setId(id);
        a1.setCreationDate(from(Instant.now()));
        a1.setCreationUser("Creation User");
        a1.setModificationDate(from(Instant.now()));
        a1.setModificationUser("Modification User");
        AbstractEntity a2 = new TestEntity();
        a2.setId(id);
        a2.setCreationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setCreationUser("Another Creation User");
        a2.setModificationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setModificationUser("Another Modification User");

        assertEquals(a1.hashCode(), a2.hashCode());
        assertEquals(a1, a2);
        assertEquals(a2, a1);
        assertTrue(a1.getCreationDate().before(a2.getCreationDate()));
        assertTrue(a1.getModificationDate().before(a2.getModificationDate()));
        assertNotEquals(a1.getCreationUser(), a2.getCreationUser());
        assertNotEquals(a1.getModificationUser(), a2.getModificationUser());
    }

    @Test
    public void shouldNotBeEqualsIfIdAreNotEquals() {
        AbstractEntity a1 = new TestEntity();
        a1.setId(1L);
        AbstractEntity a2 = new TestEntity();
        a2.setId(2L);

        assertNotEquals(a1.hashCode(), a2.hashCode());
        assertNotEquals(a1, a2);
        assertNotEquals(a2, a1);
    }

    @Test
    public void shouldNotBeEqualsIfIdAreNull() {
        AbstractEntity a1 = new TestEntity();
        a1.setCreationDate(from(Instant.now()));
        a1.setCreationUser("Creation User");
        a1.setModificationDate(from(Instant.now()));
        a1.setModificationUser("Modification User");
        AbstractEntity a2 = new TestEntity();
        a2.setCreationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setCreationUser("Another Creation User");
        a2.setModificationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setModificationUser("Another Modification User");

        assertEquals(a1.hashCode(), a2.hashCode());
        assertNotEquals(a1, a2);
        assertNotEquals(a2, a1);
    }

    @Test
    public void shouldNotBeEqualsIfClassesAreDifferent() {
        AbstractEntity a1 = new TestEntity();
        a1.setId(1L);
        AbstractEntity a2 = new AnotherTestEntity();
        a2.setId(2L);

        assertNotEquals(a1.hashCode(), a2.hashCode());
        assertNotEquals(a1, a2);
        assertNotEquals(a2, a1);
    }

    @Test
    public void shouldNotBeEqualsIfOtherIsNull() {
        AbstractEntity a1 = new TestEntity();
        a1.setId(1L);

        assertNotEquals(a1, null);
    }

    public static class TestEntity extends AbstractEntity {
        public TestEntity() {
            // Constructor
        }
    }

    public static class AnotherTestEntity extends AbstractEntity {
        public AnotherTestEntity() {
            // Constructor
        }
    }
}
