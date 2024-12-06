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

import dataStructures.LinkedList;
import models.Event;

public class EventService {

	// LinkedList to store events
	private LinkedList events;

	/**
	 * Constructs an EventService object and initializes the events list.
	 */
	public EventService() {
		// Initializes the linked list for storing events
		events = new LinkedList();
	}

	/**
	 * Adds a new event to the list.
	 * 
	 * @param event The Event object to be added to the list.
	 */
	public void addEvent(Event event) {
	    // Check if the provided event is null
	    if (event == null) {
	        // If null, throw an exception to ensure no invalid event is added
	        throw new IllegalArgumentException("Event cannot be null.");
	    }
	    // Add the event to the list
	    events.add(event);
	}

	/**
	 * Displays all events in the list as a formatted string.
	 * 
	 * @return A string containing the details of all events in the list.
	 */
	public String displayEvents() {
		StringBuilder sb = new StringBuilder();

		// Loop through all events in the list and append them to the string builder
		for (int i = 0; i < events.size(); i++) {
			sb.append(i + 1).append(". ").append(events.get(i)).append("\n");
		}

		// Returns the string representation of all events
		return sb.toString();
	}

	/**
	 * Retrieves the event at the specified index.
	 * 
	 * @param index The index of the event to retrieve.
	 * @return The Event object at the specified index.
	 */
	public Event getEvent(int index) {
		// Check if index is valid
		if (index < 0 || index >= events.size()) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		// Returns the event at the specified index from the list
		return events.get(index);
	}

	/**
	 * Edits an existing event by replacing it with a new event at the specified
	 * index.
	 * 
	 * @param index        The index of the event to be edited.
	 * @param updatedEvent The new Event object containing updated information.
	 * @throws IndexOutOfBoundsException If the index is out of bounds.
	 */
	public void editEvent(int index, Event updatedEvent) {
	    // Validate the updatedEvent object
	    if (updatedEvent == null) {
	        throw new IllegalArgumentException("Updated event cannot be null.");
	    }

	    // Validate the index
	    validateIndex(index, events.size(), "Event");

	    // Update the event details
	    Event event = events.get(index);
	    event.setName(updatedEvent.getName());
	    event.setDate(updatedEvent.getDate());
	    event.setLocation(updatedEvent.getLocation());
	}
	
	private void validateIndex(int index, int size, String entity) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException(entity + " index out of bounds.");
	    }
	}
	/**
	 * Deletes the event at the specified index.
	 * 
	 * @param index The index of the event to be deleted.
	 * @throws IndexOutOfBoundsException If the index is out of bounds.
	 */
	public void deleteEvent(int index) {
	    // Check if the provided index is valid
	    if (index < 0 || index >= events.size()) {
	        throw new IndexOutOfBoundsException("Event index out of bounds.");
	    }
	    // Removes the event at the specified index
	    events.remove(index);
	}

	/**
	 * Updates an existing event based on the ID. Assumes each event has a unique
	 * ID.
	 * 
	 * @param updatedEvent The event object with the updated details.
	 */
	public void updateEvent(Event updatedEvent) {
		if (updatedEvent == null) {
			throw new IllegalArgumentException("Updated event cannot be null.");
		}

		boolean updated = false;
		for (int i = 0; i < events.size(); i++) {
			Event event = events.get(i);
			if (event.getId() == updatedEvent.getId()) { // Assuming the Event has a unique ID
				events.set(i, updatedEvent); // Replace the old event with the updated one
				updated = true;
				break; // Exit once the event is found and updated
			}
		}

		if (!updated) {
			throw new IllegalArgumentException("Event not found for ID: " + updatedEvent.getId());
		}
	}
}
