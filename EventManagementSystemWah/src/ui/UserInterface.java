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
package ui;

import javax.swing.*;

import models.Attendee;
import models.Event;
import services.AttendeeService;
import services.EventService;

import java.awt.*;

/**
 * User interface for the Event Management System using JFrame.
 */
public class UserInterface {
	private AttendeeService attendeeService;
	private EventService eventService;
	private JFrame frame;
	public UserInterface() {
		attendeeService = new AttendeeService();
		eventService = new EventService();
		initialize();
	}

	/**
	 * Method to view sorted attendees.
	 *
	 * @param textArea The text area to display messages.
	 */
	private void sortAttendees(JTextArea textArea) {
		attendeeService.sortAttendees();
		textArea.setText("Attendees sorted by registration time:\n" + attendeeService.displayAttendees());
	}

	/**
	 * Initializes the GUI components.
	 */
	private void initialize() {
		frame = new JFrame("Event Management System");
		new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setLayout(new BorderLayout());

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.add(scrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 10, 10));
		frame.add(buttonPanel, BorderLayout.SOUTH);

		JButton addEventButton = new JButton("Add Event");
		JButton addAttendeeButton = new JButton("Add Attendee");
		JButton viewEventsButton = new JButton("View Events");
		JButton viewAttendeesButton = new JButton("View Attendees");
		JButton editEventButton = new JButton("Edit Event");
		JButton editAttendeeButton = new JButton("Edit Attendee");
		JButton deleteEventButton = new JButton("Delete Event");
		JButton deleteAttendeeButton = new JButton("Delete Attendee");
		JButton sortAttendeesButton = new JButton("Sort Attendees by Registration Time");

		buttonPanel.add(addEventButton);
		buttonPanel.add(addAttendeeButton);
		buttonPanel.add(viewEventsButton);
		buttonPanel.add(viewAttendeesButton);
		buttonPanel.add(editEventButton);
		buttonPanel.add(deleteEventButton);
		buttonPanel.add(editAttendeeButton);
		buttonPanel.add(deleteAttendeeButton);
		buttonPanel.add(sortAttendeesButton);

		// Action listeners for buttons
		addEventButton.addActionListener(e -> addEvent(textArea)); // Pass the textArea correctly
		addAttendeeButton.addActionListener(e -> addAttendee(textArea));
		viewEventsButton.addActionListener(e -> textArea.setText(eventService.displayEvents()));
		viewAttendeesButton.addActionListener(e -> textArea.setText(attendeeService.displayAttendees()));
		editEventButton.addActionListener(e -> editEvent(textArea));
		deleteEventButton.addActionListener(e -> deleteEvent(textArea));
		editAttendeeButton.addActionListener(e -> editAttendee(textArea));
		deleteAttendeeButton.addActionListener(e -> deleteAttendee(textArea));
		sortAttendeesButton.addActionListener(e -> sortAttendees(textArea));

		// Make the frame visible
		frame.setVisible(true);
	}

	/**
	 * Method to add an event via input dialog.
	 *
	 * @param textArea The text area to display messages.
	 */
	private void addEvent(JTextArea textArea) {
		String name = JOptionPane.showInputDialog(frame, "Enter event name:");
		String date = JOptionPane.showInputDialog(frame, "Enter event date:");
		String location = JOptionPane.showInputDialog(frame, "Enter event location:");

		// Input validation
		if (name == null || name.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Error: Name cannot be null or empty.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (date == null || date.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Error: Date cannot be null or empty.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (location == null || location.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Error: Location cannot be null or empty.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			Event event = new Event(name, date, location); // Make sure the Event constructor works
			eventService.addEvent(event);
			textArea.setText("Event added successfully.");
		} catch (IllegalArgumentException e) {
			// Handle the case where the Event constructor throws an exception
			textArea.setText("Error: " + e.getMessage());
		}
	}

	private void editEvent(JTextArea textArea) {
		String eventIdText = JOptionPane.showInputDialog(frame, "Enter the event ID to edit:");

		// Check if the input is empty or null before parsing
		if (eventIdText == null || eventIdText.trim().isEmpty()) {
			textArea.setText("Error: Event ID cannot be empty.");
			return;
		}

		try {
			int eventId = Integer.parseInt(eventIdText.trim()); // Parse the event ID

			// Retrieve the existing event by ID
			Event event = eventService.getEvent(eventId); // a method to get an event by ID

			// If event doesn't exist
			if (event == null) {
				textArea.setText("Error: Event not found.");
				return;
			}

			// Display the current details in input dialogs
			String name = JOptionPane.showInputDialog(frame, "Enter new event name:", event.getName());
			String date = JOptionPane.showInputDialog(frame, "Enter new event date:", event.getDate());
			String location = JOptionPane.showInputDialog(frame, "Enter new event location:", event.getLocation());

			// Input validation
			if (name == null || name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Error: Name cannot be null or empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (date == null || date.trim().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Error: Date cannot be null or empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (location == null || location.trim().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Error: Location cannot be null or empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Update the event with new details
			event.setName(name);
			event.setDate(date);
			event.setLocation(location);

			// Update the event in the service
			eventService.updateEvent(event);

			// Display updated event details
			textArea.setText("Event updated successfully:\n" + event.toString()); // Use toString to show updated info

		} catch (NumberFormatException e) {
			textArea.setText("Error: Invalid Event ID. Please enter a valid integer.");
		} catch (Exception e) {
			textArea.setText("Error: " + e.getMessage());
		}
	}

	/**
	 * Method to add an attendee via input dialog.
	 *
	 * @param textArea The text area to display messages.
	 */
	private void addAttendee(JTextArea textArea) {
		String name = JOptionPane.showInputDialog(frame, "Enter attendee full name:");
		String email = JOptionPane.showInputDialog(frame, "Enter attendee email:");
		String phone = JOptionPane.showInputDialog(frame, "Enter attendee phone:");

		// Input validation
		if (name == null || name.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Error: Name cannot be null or empty.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (email == null || email.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Error: Email cannot be null or empty.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (phone == null || phone.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "Error: Phone cannot be null or empty.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			Attendee attendee = new Attendee(name, email, phone);
			attendeeService.addAttendee(attendee);
			textArea.setText("Attendee added successfully.");
		} catch (IllegalArgumentException e) {
			// Handle the case where the Event constructor throws an exception
			textArea.setText("Error: " + e.getMessage());
		}
	}

	private void editAttendee(JTextArea textArea) {
		String attendeeIdText = JOptionPane.showInputDialog(frame, "Enter the attendee ID to edit:");

		// Check if the input is empty or null before parsing
		if (attendeeIdText == null || attendeeIdText.trim().isEmpty()) {
			textArea.setText("Error: Attendee ID cannot be empty.");
			return;
		}

		try {
			int attendeeId = Integer.parseInt(attendeeIdText.trim()); // Parse the attendee ID

			// Retrieve the existing attendee by ID using the AttendeeService
			Attendee attendee = attendeeService.getAttendee(attendeeId); // Use the service to get the attendee

			// If attendee doesn't exist
			if (attendee == null) {
				textArea.setText("Error: Attendee not found.");
				return;
			}

			// Prompt for new details for the attendee
			String name = JOptionPane.showInputDialog(frame, "Enter new name:");
			String email = JOptionPane.showInputDialog(frame, "Enter new email:");
			String phone = JOptionPane.showInputDialog(frame, "Enter new phone:");

			// Input validation for the new details
			if (name == null || name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Error: Name cannot be null or empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (email == null || email.trim().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Error: Email cannot be null or empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (phone == null || phone.trim().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Error: Phone cannot be null or empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Create a new Attendee object with the updated details
			Attendee updatedAttendee = new Attendee(name, email, phone);

			// Update the attendee in the service
			attendeeService.editAttendee(attendeeId, updatedAttendee);
			textArea.setText("Attendee updated successfully.");
		} catch (NumberFormatException e) {
			textArea.setText("Error: Invalid Attendee ID. Please enter a valid integer.");
		} catch (Exception e) {
			textArea.setText("Error: " + e.getMessage());
		}
	}

	/**
	 * Method to delete an event.
	 *
	 * @param textArea The text area to display messages.
	 */
	private void deleteEvent(JTextArea textArea) {
		String eventIdText = JOptionPane.showInputDialog(frame, "Enter the event ID to delete:");

		// Check if the input is empty or null before parsing
		if (eventIdText == null || eventIdText.trim().isEmpty()) {
			textArea.setText("Error: Event ID cannot be empty.");
			return;
		}

		try {
			int eventId = Integer.parseInt(eventIdText.trim()); // Parse the event ID
			eventService.deleteEvent(eventId); // Call the method to delete the event
			textArea.setText("Event deleted successfully.");
		} catch (NumberFormatException e) {
			textArea.setText("Error: Invalid Event ID. Please enter a valid integer.");
		} catch (Exception e) {
			textArea.setText("Error: " + e.getMessage());
		}
	}

	/**
	 * Method to delete an attendee.
	 *
	 * @param textArea The text area to display messages.
	 */
	private void deleteAttendee(JTextArea textArea) {
		String attendeeIdText = JOptionPane.showInputDialog(frame, "Enter the attendee ID to delete:");

		// Check if the input is empty or null before parsing
		if (attendeeIdText == null || attendeeIdText.trim().isEmpty()) {
			textArea.setText("Error: Attendee ID cannot be empty.");
			return;
		}

		try {
			int attendeeId = Integer.parseInt(attendeeIdText.trim()); // Parse the attendee ID
			attendeeService.deleteAttendee(attendeeId); // Call the method to delete the attendee
			textArea.setText("Attendee deleted successfully.");
		} catch (NumberFormatException e) {
			textArea.setText("Error: Invalid Attendee ID. Please enter a valid integer.");
		} catch (Exception e) {
			textArea.setText("Error: " + e.getMessage());
		}
	}
}