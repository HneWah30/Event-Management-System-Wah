/** 
 * Data Structure Semester Project
 * @author Ezekiel Hne Wah ewah1@dmacc.com
 * CIS152 Thursday Afternoon
 *  October 24, 2024  
 * @version 1.0
 * @since 1.0
*/
/**  
* OS: IOS
* IDE: [eclipse XX, jGrasp, etc]
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
package dataStructures;

import models.Event;

/**
 * A helper class for creating nodes in a linked list.
 * Each node stores an event and a reference to the next node in the list.
 */
class Node {
    Event event; // The event stored in this node
    Node next;   // A reference to the next node in the linked list

    /**
     * Constructs a Node with the specified event.
     *
     * @param event the event to be stored in the node
     */
    Node(Event event) {
        this.event = event; // Assign the event to this node
        this.next = null;   // Initialize the next reference to null (end of list)
    }
    
    @Override
    public String toString() {
        return event.toString(); 
    }
}
