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

package dataStructures;

import models.Attendee;
import java.util.ArrayList;

/**
 * A class that manages a list of attendees. 
 * Provides methods to add, remove, display, and sort attendees.
 */
public class AttendeeList {
    private ArrayList<Attendee> attendees; // List to store attendees

    /**
     * Constructor to initialize an empty list of attendees.
     */
    public AttendeeList() {
        attendees = new ArrayList<>(); // Initialize the list of attendees
    }

    /**
     * Adds an attendee to the list.
     * 
     * @param attendee the Attendee object to add
     */
    public void addAttendee(Attendee attendee) {
        attendees.add(attendee); // Add the attendee to the list
    }

    /**
     * Displays all attendees in the list as a string.
     * 
     * @return a String representing all attendees
     */
    public String displayAttendees() {
        StringBuilder sb = new StringBuilder();
        for (Attendee attendee : attendees) {
            sb.append(attendee.toString()).append("\n"); // Append each attendee's string representation
        }
        return sb.toString(); // Return the string representation of all attendees
    }

    /**
     * Retrieves an attendee by their index in the list.
     * 
     * @param index the index of the attendee in the list
     * @return the Attendee object at the specified index
     */
    public Attendee getAttendee(int index) {
        if (index < 0 || index >= attendees.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return attendees.get(index); // Return the attendee at the specified index
    }

    /**
     * Removes an attendee from the list by their index.
     * 
     * @param index the index of the attendee to remove
     */
    public void deleteAttendee(int index) {
        if (index < 0 || index >= attendees.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        attendees.remove(index); // Remove the attendee at the specified index
    }

    /**
     * Returns the number of attendees in the list.
     * 
     * @return the number of attendees
     */
    public int size() {
        return attendees.size(); // Return the size of the list (number of attendees)
    }

    /**
     * Sorts the attendees list using the Merge Sort algorithm.
     */
    public void sortAttendees() {
        attendees = mergeSort(attendees);  // Sort the list of attendees using Merge Sort
    }

    /**
     * Performs the Merge Sort algorithm on a list of attendees.
     * This is a recursive function that splits the list into smaller sublists and merges them in sorted order.
     * 
     * @param list the list of Attendees to sort
     * @return a sorted list of Attendees
     */
    private ArrayList<Attendee> mergeSort(ArrayList<Attendee> list) {
        // Base case: if the list has 1 or fewer elements, it's already sorted
        if (list.size() <= 1) {
            return list;
        }

        // Split the list into two halves
        int mid = list.size() / 2;
        ArrayList<Attendee> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Attendee> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the two sorted halves and return the result
        return merge(left, right);
    }

    /**
     * Merges two sorted lists into a single sorted list.
     * 
     * @param left the first sorted list
     * @param right the second sorted list
     * @return a merged and sorted list of Attendees
     */
    private ArrayList<Attendee> merge(ArrayList<Attendee> left, ArrayList<Attendee> right) {
        ArrayList<Attendee> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        // Merge the two lists by comparing their elements
        while (leftIndex < left.size() && rightIndex < right.size()) {
            // Compare the time of the attendees and add the smaller one to the result list
            if (left.get(leftIndex).getRegistrationTime().compareTo(right.get(rightIndex).getRegistrationTime()) <= 0) {
                result.add(left.get(leftIndex));  // Add the left element if it's smaller or equal
                leftIndex++;
            } else {
                result.add(right.get(rightIndex)); // Otherwise, add the right element
                rightIndex++;
            }
        }

        // Add any remaining elements from the left list
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }

        // Add any remaining elements from the right list
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }

        return result; // Return the merged sorted list
    }
}
