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

    @Test
    public void shouldCopyAndBeImmutable() {
        TestDto toCopy = new TestDto();
        toCopy.setId(1L);
        toCopy.setCreationDate(from(Instant.now()));
        toCopy.setCreationUser("Creation User");
        toCopy.setModificationDate(from(Instant.now()));
        toCopy.setModificationUser("Modification User");

        TestDto testDto = new TestDto(toCopy);

        assertEquals("Id must be the same for the copy", toCopy.getId(), testDto.getId());
        assertEquals("Creation date must be the same for the copy", toCopy.getCreationDate(), testDto.getCreationDate());
        assertEquals("Creation user must be the same for the copy", toCopy.getCreationUser(), testDto.getCreationUser());
        assertEquals("Modification date must be the same for the copy", toCopy.getModificationDate(), testDto.getModificationDate());
        assertEquals("Modification user must be the same for the copy", toCopy.getModificationUser(), testDto.getModificationUser());

        assertNotSame("Creation date object should be distinct", toCopy.getCreationDate(), testDto.getCreationDate());
        assertNotSame("Modification date object should be distinct", toCopy.getModificationDate(), testDto.getModificationDate());

        toCopy.setId(2L);
        toCopy.setCreationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        toCopy.setCreationUser("Another Creation User");
        toCopy.setModificationDate(from(Instant.now().plus(10, ChronoUnit.SECONDS)));
        toCopy.setModificationUser("Another Modification User");

        assertNotEquals("Id must be independent for the copy", toCopy.getId(), testDto.getId());
        assertNotEquals("Creation date must be independent for the copy", toCopy.getCreationDate(), testDto.getCreationDate());
        assertNotEquals("Creation user must be independent for the copy", toCopy.getCreationUser(), testDto.getCreationUser());
        assertNotEquals("Modification date must be independent for the copy", toCopy.getModificationDate(), testDto.getModificationDate());
        assertNotEquals("Modification user must be independent for the copy", toCopy.getModificationUser(), testDto.getModificationUser());
    }

    @Test
    public void shouldBeAbleToCopyEmptyDto() {
        TestDto toCopy = new TestDto();
        TestDto testDto = new TestDto(toCopy);

        assertEquals("Id must be the same for the copy", toCopy.getId(), testDto.getId());
        assertEquals("Creation date must be the same for the copy", toCopy.getCreationDate(), testDto.getCreationDate());
        assertEquals("Creation user must be the same for the copy", toCopy.getCreationUser(), testDto.getCreationUser());
        assertEquals("Modification date must be the same for the copy", toCopy.getModificationDate(), testDto.getModificationDate());
        assertEquals("Modification user must be the same for the copy", toCopy.getModificationUser(), testDto.getModificationUser());
    }

    public static class TestDto extends AbstractDto {
        public TestDto() {
        }

        public TestDto(final AbstractDto toCopy) {
            super(toCopy);
        }
    }
}
