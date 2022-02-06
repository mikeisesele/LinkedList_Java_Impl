package com.company.mine;

public class LinkedList {

    Node head; // head of list
    Node last = null;
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
    public LinkedList append(LinkedList list, int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
            size++;
        }
        else {
            // if the linked list is not empty
            // go through the list, checking each node via its next property if its the last

            // set a new head to trverse through the list (for loop in linkedlist)
            Node loopHelper = list.head;

            while (loopHelper.next != null) {
                loopHelper = loopHelper.next;
            }

            // Insert the new_node at last node  givne that we have traversed through
            loopHelper.next = new_node;
            size++;
        }

        // Return the list by head
        return list;
    }


    public LinkedList insert( LinkedList list, int data, int position) {

        Node node = new Node(data);
        node.next = null;

        if (list.head == null && position == 0){
            list.head = node;
        }
        else if(list.head != null && position == 0){
            node.next = list.head;
            head = node;
        }

        Node tempCurrentNode = list.head ;
        Node tempPreviousNode = null;
        int index = 0;
        while (index < position) {
            tempPreviousNode =  tempCurrentNode;
            tempCurrentNode = tempCurrentNode.next;
            index = index + 1;
        }
        node.next = tempCurrentNode;
        tempPreviousNode.next = node;

        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;


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
    public static Node SearchByKey(LinkedList list, int key) {
        // Store head node
        LinkedList finalList = list;
        Node currNode = finalList.head, prev = null;
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
            prev = currNode;
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
    public Node searchByPosition(LinkedList list, int pos) {

        LinkedList finalList = list;

        Node currentNode = finalList.head;
        Node prev = null;
        int counter = 0;
        Node answer = null;

        if (currentNode != null) {
            if (pos == 0) {
                answer = currentNode;
                System.out.println("Node found");
            } else {
                // Count for the pos to be deleted, keep track of the previous node as it is needed to change currentNode.next
                while (currentNode != null) {
                    if (counter == pos) {
                        answer = currentNode;
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

        return answer;
    }


    // Method to delete a node in the LinkedList by data
    public static LinkedList deleteNodeByKey(LinkedList list, int key) {
        // Store head node
        LinkedList finalList = list;
        Node currNode = finalList.head, prev = null;


        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            finalList.head = currNode.next; // Changed head
            finalList.size --;

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List

            return finalList;
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
            finalList.size --;
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

        // return the List
        return finalList;
    }

    // Method to delete a node in the LinkedList by position
    public LinkedList deleteAtPosition(LinkedList list, int pos) {

        LinkedList finalList = list;

        Node currentNode = finalList.head;
        Node prev = null;
        int counter = 0;

        if (currentNode != null) {
            if (pos == 0) {
                finalList.head = currentNode.next;
                finalList.size--;
                System.out.println("element at position" + pos + " has been deleted");
            } else {
                // Count for the pos to be deleted, keep track of the previous node as it is needed to change currentNode.next
                while (currentNode != null) {
                    if (counter == pos) {
                        prev.next = currentNode.next;
                        finalList.size--;
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

        return finalList;
    }

}
