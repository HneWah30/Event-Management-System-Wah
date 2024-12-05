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
package services;

import dataStructures.AttendeeList;
import models.Attendee;

public class AttendeeService {

	// Internal list to store attendees
	private AttendeeList attendeeList;

	/**
	 * Constructs an AttendeeService object and initializes the attendee list.
	 */
	public AttendeeService() {
		// Initializes the attendeeList object
		attendeeList = new AttendeeList();
	}

	/**
	 * Adds a new attendee to the attendee list.
	 * 
	 * @param attendee The Attendee object to be added.
	 * @throws IllegalArgumentException If the attendee is null.
	 */
	public void addAttendee(Attendee attendee) {
		if (attendee == null) {
			throw new IllegalArgumentException("Attendee cannot be null.");
		}
		// Adds the provided attendee to the list
		attendeeList.addAttendee(attendee);
	}
	
	/**
     * Get an attendee by their ID.
     * 
     * @param attendeeId The ID of the attendee.
     * @return The attendee object if found, otherwise null.
     */
    public Attendee getAttendee(int attendeeId) {
        // Assuming AttendeeList has a method to get an attendee by ID
        return attendeeList.getAttendee(attendeeId); // You'll need to implement this in AttendeeList
    }

	/**
	 * Returns a string representation of all attendees in the list.
	 * 
	 * @return A string containing details of all attendees.
	 */
	public String displayAttendees() {
		return attendeeList.displayAttendees();
	}

	/**
	 * Edits an existing attendee's details at the specified index.
	 * 
	 * @param index           The index of the attendee to be updated.
	 * @param updatedAttendee The updated Attendee object containing the new
	 *                        details.
	 * @throws IndexOutOfBoundsException If the index is out of range of the
	 *                                   attendee list.
	 * @throws IllegalArgumentException  If the updatedAttendee is null.
	 */
	public void editAttendee(int index, Attendee updatedAttendee) {
	    if (updatedAttendee == null) {
	        throw new IllegalArgumentException("Updated Attendee cannot be null.");
	    }

	    validateIndex(index, attendeeList.size(), "Attendee");

	    Attendee attendee = attendeeList.getAttendee(index);
	    attendee.setName(updatedAttendee.getName());
	    attendee.setEmail(updatedAttendee.getEmail());
	    attendee.setPhoneNumber(updatedAttendee.getPhoneNumber());
	}
	
	private void validateIndex(int index, int size, String entity) {
	    if (index < 0 || index >= size) {
	        throw new IllegalArgumentException(entity + " index out of bounds.");
	    }
	}

	/**
	 * Deletes an attendee from the list at the specified index.
	 * 
	 * @param index The index of the attendee to be deleted.
	 * @throws IndexOutOfBoundsException If the index is out of range of the
	 *                                   attendee list.
	 */
	public void deleteAttendee(int index) {
	    // Check if the provided index is valid
	    if (index < 0 || index >= attendeeList.size()) {
	        throw new IndexOutOfBoundsException("Attendee index out of bounds.");
	    }
	    // Deletes the attendee at the specified index
	    attendeeList.deleteAttendee(index);
	}
	
	public void updateAttendee(int attendeeId, Attendee updatedAttendee) {
	    Attendee existingAttendee = getAttendee(attendeeId); // Retrieve the attendee by ID
	    if (existingAttendee != null) {
	        existingAttendee.setName(updatedAttendee.getName());
	        existingAttendee.setEmail(updatedAttendee.getEmail());
	        existingAttendee.setPhoneNumber(updatedAttendee.getPhoneNumber());
	    } else {
	        throw new IllegalArgumentException("Attendee not found.");
	    }
	}

	/**
	 * Sorts the list of attendees, usually based on their time of registration.
	 */
	public void sortAttendees() {
		attendeeList.sortAttendees();
	}
}
