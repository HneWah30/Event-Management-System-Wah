## Event Management System

## Description
Welcome to the Event Management System repository! This system is designed to manage events and attendee registrations 
with features that include event creation, attendee management, and data validation. It uses LinkedList and ArrayList data structures 
to efficiently manage event data and attendee details. Merge Sort algorithm to sort attendee base on registration time.

## Key Features
Event Creation: Allows users to create events with attributes like name, date, and location.
Attendee Registration: Enables attendee registration with name, email, and phone number validation.
Date and Input Validation: Ensures all event dates are valid (yyyy-MM-dd format) and validates all attendee inputs for acuracy.
Error Handling: Invalid inputs are caught and handled via exceptions with descriptive error messages.
Sorting: Events and attendees can be sorted by their registration time.

## File Structure
dataStructures/: Implements the EventList and AttendeeList classes, which manage the storage events and attendees and sorts attendees.
models/: Contains the Event and Attendee classes, including validation logic for event and attendee data.
services/: Handles the business logic for adding, editing, deleting, and retrieving events and attendees.
test/: Contains the EventTest and AttendeeTest for testing this project method.
ui/: Contains the GUI features and the main class for running this project

## Before running the Event Management System, ensure the following:
Java Development Kit (JDK) version 8 or higher.
JUnit (optional) for testing functionality.
IDE such as IntelliJ IDEA, Eclipse, or any other Java-compatible IDE.

## Contributing
Feel free to contribute to this project by forking the repository and submitting pull requests.
Ensure that your code follows the existing project structure and passes all validation tests.

## Acknowledgments
Special thanks to the contributors and my instructor for their guidance in building this project.
