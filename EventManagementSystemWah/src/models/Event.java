/** 
 * Data Structure Semester Project
 * @author Ezekiel Hne Wah ewah1@dmacc.com
 * CIS152 Thursday Afternoon
 *  October 24, 2024  
 * @version 1.0
 * @since 1.0
*/
/**  
* OS: [Window 11]
* IDE: [eclipse XX, jGrasp, etc]
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
* This class represents an Event, which includes details such as the name, date, 
* location, and a unique identifier (ID). The event's date is validated to ensure 
* it follows the correct format (yyyy-MM-dd) and is a valid calendar date. 
* The event name and location are validated to ensure they are not empty or null.
* 
*/
public class Event {
	private String name; // Name of the event
	private String date; // Date of the event (in yyyy-MM-dd format)
	private String location; // Location of the event
	private String id; // Unique ID for the event

	/**
	 * Constructor to create a new Event object with a specified name, date, and
	 * location. A unique ID is generated automatically.
	 *
	 * @param name     the name of the event (cannot be null or empty)
	 * @param date     the date of the event (must be in yyyy-MM-dd format and
	 *                 valid)
	 * @param location the location of the event (cannot be null or empty)
	 * @throws IllegalArgumentException if the name, date, or location are invalid
	 */
	public Event(String name, String date, String location) {
		this.name = name;
		this.date = date;
		this.location = location;
		this.id = UUID.randomUUID().toString(); // Generate a unique ID for the event
		// Validate the event name
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Event name cannot be empty.");
		}
		// Validate the event date
		if (date == null || date.trim().isEmpty()) {
			throw new IllegalArgumentException("Event date cannot be null or empty.");
		}
		if (!isValidDate(date)) {
			throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
		}
		// Validate the event location
		if (location == null || location.trim().isEmpty()) {
			throw new IllegalArgumentException("Event location cannot be empty.");
		}
		
	}

	/**
	 * Returns the name of the event.
	 *
	 * @return the name of the event
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the date of the event.
	 *
	 * @return the date of the event
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Returns the location of the event.
	 *
	 * @return the location of the event
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Returns the unique ID of the event.
	 *
	 * @return the unique ID of the event
	 */
	public String getId() {
		return id; // Return the unique ID for the event
	}

	/**
	 * Sets the name of the event. The name cannot be null or empty.
	 *
	 * @param name the new name of the event
	 * @throws IllegalArgumentException if the name is null or empty
	 */
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Event name cannot be empty.");
		}
		this.name = name;
	}

	/**
	 * Sets the date of the event. The date must be in yyyy-MM-dd format and must be
	 * valid.
	 *
	 * @param date the new date of the event
	 * @throws IllegalArgumentException if the date is null, empty, or invalid
	 */
	public void setDate(String date) {
		if (date == null || date.trim().isEmpty()) {
			throw new IllegalArgumentException("Event date cannot be null or empty.");
		}
		if (!isValidDate(date)) {
			throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
		}
		this.date = date;
	}

	/**
	 * Sets the location of the event. The location cannot be null or empty.
	 *
	 * @param location the new location of the event
	 * @throws IllegalArgumentException if the location is null or empty
	 */
	public void setLocation(String location) {
		if (location == null || location.trim().isEmpty()) {
			throw new IllegalArgumentException("Event location cannot be empty.");
		}
		this.location = location;
	}

	/**
	 * Returns a string representation of the event, including its ID, name, date,
	 * and location.
	 *
	 * @return a string representation of the event
	 */
	@Override
	public String toString() {
		return "Event ID: " + getId() + "\nEvent Name: " + getName() + "\nDate: " + getDate() + "\nLocation: "
				+ getLocation();
	}

	/**
	 * Validates whether the given date string is in the correct format (yyyy-MM-dd)
	 * and represents a valid calendar date.
	 *
	 * @param date the date string to validate
	 * @return true if the date is valid; false otherwise
	 */
	private boolean isValidDate(String date) {
		// First, check the format using a regular expression to ensure it's yyyy-MM-dd
		if (!date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			return false; // Date format is not yyyy-MM-dd
		}

		// Then, check if the date is actually valid using SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false); // Strict date parsing (e.g., no February 30th)
		try {
			sdf.parse(date); // Try to parse the date
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}