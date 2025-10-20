package circularlinkedlist;

public class CircularLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // Add node at end
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Add node at specific position
    public void addByPosition(int pos, int val) {
        Node newNode = new Node(val);

        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (head == null) {
            if (pos == 1) {
                head = newNode;
                head.next = head;
            } else {
                System.out.println("List is empty. Can only insert at position 1.");
            }
            return;
        }

        if (pos == 1) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        } else {
            Node temp = head;
            int i = 1;
            while (i < pos - 1 && temp.next != head) {
                temp = temp.next;
                i++;
            }

            if (i == pos - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Position out of bounds!");
            }
        }
    }

    // Delete node at position
    public void deleteByPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (pos == 1) {
            if (head.next == head) {
                head = null;
                return;
            }

            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        } else {
            Node prev = head;
            Node curr = head.next;
            int i = 2;

            while (curr != head && i < pos) {
                prev = curr;
                curr = curr.next;
                i++;
            }

            if (i == pos && curr != head) {
                prev.next = curr.next;
            } else {
                System.out.println("Position out of bounds!");
            }
        }
    }

    // Modify node by data (change first match)
    public void modifyByValue(int oldValue, int newValue) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == oldValue) {
                temp.data = newValue;
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Value not found!");
    }

    // Display list
    public void displayData() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            Node temp = head;
            System.out.print("Circular Linked List: ");
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }
}
