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
project-root/
 ├── src/
 │   ├── dataStructures/                # LinkedList, Node, AttendeeList classes
 │   │   ├── LinkedList.java            # LinkedList class (generic)
 │   │   ├── Node.java                  # Node class for LinkedList
 │   │   └── AttendeeList.java          # AttendeeList class for managing attendees
 │   │
 │   ├── models/                        # Event and Attendee model classes
 │   │   ├── Event.java                 # Event class
 │   │   └── Attendee.java              # Attendee class
 │   │
 │   ├── services/                      # Business logic related to events and attendees
 │   │   ├── EventService.java          # Event management logic
 │   │   └── AttendeeService.java       # Attendee management logic
 │   ├── ui/                            # User interface components
 │   │   ├── UserInterface.java         # Main UI for user interaction
 │   │   └── EventManagementSystem.java # Main application entry point
 ├── build/                             # Build-related files (for Maven or Gradle)
 ├── lib/                               # External libraries (JARs)
 └── README.md                          # Project documentation

## Before running the Event Management System, ensure the following:
Java Development Kit (JDK) version 8 or higher.
JUnit (optional) for testing functionality.
IDE such as IntelliJ IDEA, Eclipse, or any other Java-compatible IDE.

## Contributing
Feel free to contribute to this project by forking the repository and submitting pull requests.
Ensure that your code follows the existing project structure and passes all validation tests.

## Acknowledgments
Special thanks to the contributors and my instructor for their guidance in building this project.
