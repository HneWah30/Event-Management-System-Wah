/** 
 * Data Structure Semester Project
 * @author Ezekiel Hne Wah ewah1@dmacc.com
 * CIS152 Thursday Afternoon
 *  October 24, 2024  
 * @version 1.0
 * @since 1.0
*/
/**  
* OS: [OS]
* IDE: [eclipse XX, jGrasp, etc]
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
package tests;

/**
 * 
 */
import org.junit.jupiter.api.Test;

import models.Event;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {
	// Test for successful event creation with valid inputs
	@Test
	public void testEventCreation() {
		Event event = new Event("Conference", "2023-10-24", "Main Hall");
		assertNotNull(event.getId()); // Ensure that the event has a unique ID
		assertEquals("Conference", event.getName());
		assertEquals("2023-10-24", event.getDate());
		assertEquals("Main Hall", event.getLocation());
	}

	@Test
	public void testEmptyName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("", "2023-10-24", "Main Hall");
		});
		assertEquals("Event name cannot be empty.", exception.getMessage());
	}

	// Test for null event name
	@Test
	public void testNullName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event(null, "2023-10-24", "Main Hall");
		});
		assertEquals("Event name cannot be empty.", exception.getMessage());
	}

	// Test for invalid date format
	@Test
	public void testInvalidDateFormat() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "invalid-date", "Main Hall");
		});
		assertEquals("Invalid date format. Please use yyyy-MM-dd.", exception.getMessage());
	}

	// Test for null event date
	@Test
	public void testNullDate() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", null, "Main Hall");
		});
		assertEquals("Event date cannot be null or empty.", exception.getMessage());
	}

	// Test for empty event location
	@Test
	public void testEmptyLocation() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "2023-10-24", "");
		});
		assertEquals("Event location cannot be empty.", exception.getMessage());
	}

	// Test for null event location
	@Test
	public void testNullLocation() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "2023-10-24", null);
		});
		assertEquals("Event location cannot be empty.", exception.getMessage());
	}

	// Test for valid date format
	@Test
	public void testValidDateFormat() {
		Event event = new Event("Conference", "2023-10-24", "Main Hall");
		assertNotNull(event.getDate()); // Ensure that the date is properly set
	}

	// Test for invalid date (invalid month - "13")
	@Test
	public void testInvalidMonthInDate() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "2023-13-24", "Main Hall");
		});
		assertEquals("Invalid date format. Please use yyyy-MM-dd.", exception.getMessage());
	}

	// Test for invalid date (invalid day - "32")
	@Test
	public void testInvalidDayInDate() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "2023-10-32", "Main Hall");
		});
		assertEquals("Invalid date format. Please use yyyy-MM-dd.", exception.getMessage());
	}

	// Test for date format with slashes instead of dashes
	@Test
	public void testInvalidDateWithSlashes() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "10/24/2023", "Main Hall");
		});
		assertEquals("Invalid date format. Please use yyyy-MM-dd.", exception.getMessage());
	}

	@Test
	public void testInvalidYearInDate() {
		// Passing an incorrect year format (two digits for the year)
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new Event("Conference", "23-10-24", "Main Hall"); // This is invalid because it's "yy-MM-dd"
		});
		assertEquals("Invalid date format. Please use yyyy-MM-dd.", exception.getMessage());
	}
}