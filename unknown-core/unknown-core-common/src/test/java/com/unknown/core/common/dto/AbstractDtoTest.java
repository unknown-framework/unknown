package com.unknown.core.common.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static java.util.Date.from;
import static org.junit.Assert.*;

/**
 * {@link AbstractDto} test class.
 *
 * @author t.postaire
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractDtoTest {

    private String creationUser = "Creation User";
    private String modificationUser = "Modification User";

    private String anotherCreationUser = "Creation User";
    private String anotherModificationUser = "Modification User";

    @Test
    public void shouldCopyAndBeImmutable() {
        AbstractDto toCopy = new TestDto();
        toCopy.setId(1L);
        toCopy.setCreationDate(from(Instant.now()));
        toCopy.setCreationUser(this.creationUser);
        toCopy.setModificationDate(from(Instant.now()));
        toCopy.setModificationUser(this.modificationUser);

        AbstractDto testDto = new TestDto(toCopy);

        assertEquals("Id must be the same for the copy", toCopy.getId(), testDto.getId());
        assertEquals("Creation date must be the same for the copy", toCopy.getCreationDate(), testDto.getCreationDate());
        assertEquals("Creation user must be the same for the copy", toCopy.getCreationUser(), testDto.getCreationUser());
        assertEquals("Modification date must be the same for the copy", toCopy.getModificationDate(), testDto.getModificationDate());
        assertEquals("Modification user must be the same for the copy", toCopy.getModificationUser(), testDto.getModificationUser());

        assertNotSame("Creation date object should be distinct", toCopy.getCreationDate(), testDto.getCreationDate());
        assertNotSame("Modification date object should be distinct", toCopy.getModificationDate(), testDto.getModificationDate());

        toCopy.setId(2L);
        toCopy.setCreationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        toCopy.setCreationUser(this.anotherCreationUser);
        toCopy.setModificationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        toCopy.setModificationUser(this.anotherModificationUser);

        assertNotEquals("Id must be independent for the copy", toCopy.getId(), testDto.getId());
        assertNotEquals("Creation date must be independent for the copy", toCopy.getCreationDate(), testDto.getCreationDate());
        assertNotEquals("Creation user must be independent for the copy", toCopy.getCreationUser(), testDto.getCreationUser());
        assertNotEquals("Modification date must be independent for the copy", toCopy.getModificationDate(), testDto.getModificationDate());
        assertNotEquals("Modification user must be independent for the copy", toCopy.getModificationUser(), testDto.getModificationUser());
    }

    @Test
    public void shouldBeAbleToCopyEmptyDto() {
        AbstractDto toCopy = new TestDto();
        AbstractDto testDto = new TestDto(toCopy);

        assertEquals("Id must be the same for the copy", toCopy.getId(), testDto.getId());
        assertEquals("Creation date must be the same for the copy", toCopy.getCreationDate(), testDto.getCreationDate());
        assertEquals("Creation user must be the same for the copy", toCopy.getCreationUser(), testDto.getCreationUser());
        assertEquals("Modification date must be the same for the copy", toCopy.getModificationDate(), testDto.getModificationDate());
        assertEquals("Modification user must be the same for the copy", toCopy.getModificationUser(), testDto.getModificationUser());
    }

    @Test
    public void shouldBeEqualsIfIdAreEquals() {
        Long id = 1L;
        AbstractDto a1 = new TestDto();
        a1.setId(id);
        AbstractDto a2 = new TestDto();
        a2.setId(id);

        assertEquals(a1.getId(), a2.getId());
        assertEquals(a1, a2);
        assertEquals(a2, a1);
    }

    @Test
    public void shouldBeEqualsIfIdAreEqualsNotRegardingOtherFields() {
        Long id = 1L;
        AbstractDto a1 = new TestDto();
        a1.setId(id);
        a1.setCreationDate(from(Instant.now()));
        a1.setCreationUser(this.creationUser);
        a1.setModificationDate(from(Instant.now()));
        a1.setModificationUser(this.modificationUser);
        AbstractDto a2 = new TestDto();
        a2.setId(id);
        a2.setCreationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setCreationUser(this.anotherCreationUser);
        a2.setModificationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setModificationUser(this.anotherModificationUser);

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
        AbstractDto a1 = new TestDto();
        a1.setId(1L);
        AbstractDto a2 = new TestDto();
        a2.setId(2L);

        assertNotEquals(a1.hashCode(), a2.hashCode());
        assertNotEquals(a1, a2);
        assertNotEquals(a2, a1);
    }

    @Test
    public void shouldNotBeEqualsIfIdAreNull() {
        AbstractDto a1 = new TestDto();
        a1.setCreationDate(from(Instant.now()));
        a1.setCreationUser(this.creationUser);
        a1.setModificationDate(from(Instant.now()));
        a1.setModificationUser(this.modificationUser);
        AbstractDto a2 = new TestDto();
        a2.setCreationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setCreationUser(this.anotherCreationUser);
        a2.setModificationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        a2.setModificationUser(this.anotherModificationUser);

        assertEquals(a1.hashCode(), a2.hashCode());
        assertNotEquals(a1, a2);
        assertNotEquals(a2, a1);
    }

    @Test
    public void shouldNotBeEqualsIfClassesAreDifferent() {
        AbstractDto a1 = new TestDto();
        a1.setId(1L);
        AbstractDto a2 = new AnotherTestDto();
        a2.setId(2L);

        assertNotEquals(a1.hashCode(), a2.hashCode());
        assertNotEquals(a1, a2);
        assertNotEquals(a2, a1);
    }

    @Test
    public void shouldNotBeEqualsIfOtherIsNull() {
        AbstractDto a1 = new TestDto();
        a1.setId(1L);

        assertNotEquals(a1, null);
    }

    public static class TestDto extends AbstractDto {
        public TestDto() {
        }

        public TestDto(final AbstractDto toCopy) {
            super(toCopy);
        }
    }

    public static class AnotherTestDto extends AbstractDto {
        public AnotherTestDto() {
        }

        public AnotherTestDto(final AbstractDto toCopy) {
            super(toCopy);
        }
    }
}
