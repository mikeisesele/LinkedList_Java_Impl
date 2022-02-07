package com.company.mine;

public class LinkedList {

    Node head; // head of list
    int size = 0;

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
    // Method to insert a new node
    public void append(int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
            size++;
        }
        else {
            // if the linked list is not empty
            // go through the list, checking each node via its next property if its the last

            // set a new head to trverse through the list (for loop in linkedlist)
            Node loopHelper = head;

            while (loopHelper.next != null) {
                loopHelper = loopHelper.next;
            }

            // Insert the new_node at last node  givne that we have traversed through
            loopHelper.next = new_node;
            size++;
        }

        printList();
    }

    public void insert(int data, int position) {

        Node node = new Node(data);
        node.next = null;

        if (head == null && position == 0){
            head = node;
            size++;
        }
        else if(head != null && position == 0){
            node.next = head;
            head = node;
            size++;
        }

        Node tempCurrentNode = head ;
        int index = 0;
        while (index < position) {
            tempCurrentNode = tempCurrentNode.next;
            index = index + 1;
        }
        node.next = tempCurrentNode;
        size++;
        printList();
    }

    // Method to print the LinkedList.
    public void printList() {
        Node currNode = head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
    }

    // Method to delete a node in the LinkedList by data
    public Node SearchByKey(int key) {
        // Store head node
        Node currNode = head;
        Node answer = null;
        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            // Display the message
            System.out.println(key + " node found");
            // Return the data
            answer = currNode;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            answer = currNode;
            // Display the message
            System.out.println(key + " found node");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        return answer;
    }

    // Method to delete a node in the LinkedList by position
    public Node searchByPosition(int pos) {

        Node currentNode = head;
        int counter = 0;
        Node answer = null;

        if (currentNode != null) {
            if (pos == 0) {
                answer = currentNode;
                System.out.println("element at " + pos + " is " + answer.data);
            } else {
                // Count for the pos to be deleted, keep track of the previous node as it is needed to change currentNode.next
                while (currentNode != null) {
                    if (counter == pos) {
                        answer = currentNode;
                        System.out.println("element at " + pos + " is " + answer.data);
                        break;
                    } else {
                        currentNode = currentNode.next;
                        counter++;
                    }
                }
            }
        }

        System.out.println(pos);
        System.out.println(counter);

        if (pos > counter) {
            System.out.println("no node found at position:" + pos + " ,as it greater than the size of the list");
        }

        if (pos == counter) {
            System.out.println("no node found at position:" + pos + " , as it is greater than the index notation of the list starting from zero.  \n  " + " pos:  " + pos +  " \n Highest Index: " + size);
        }


        return answer;
    }

    // Method to delete a node in the LinkedList by data
    public void deleteNodeByKey(int key) {
        Node currNode = head, prev = null;

        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            head = currNode.next; // Changed head
            size --;

            // Display the message
            System.out.println(key + " found and deleted");
            printList();
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;
            size --;
            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        printList();
    }

    // Method to delete a node in the LinkedList by position
    public void deleteAtPosition(int pos) {

        Node currentNode = head;
        Node prev = null;
        int counter = 0;

        if (currentNode != null) {
            if (pos == 0) {
                head = currentNode.next;
                size--;
                System.out.println("element at position" + pos + " has been deleted");
            } else {
                // Count for the pos to be deleted, keep track of the previous node as it is needed to change currentNode.next
                while (currentNode != null) {
                    if (counter == pos) {
                        prev.next = currentNode.next;
                        size--;
                        System.out.println("element at " + pos + " has been deleted");
                        break;
                    } else {
                        prev = currentNode;
                        currentNode = currentNode.next;
                        counter++;
                    }
                }
            }
        }
        if (pos > counter) {
            System.out.println("no node found at position:" + pos + " ,as it greater than the size of the list");
        }

        printList();
    }

}
