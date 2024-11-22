// Izel Escoto
// 11/22/2024
// LinkedList.java
public class LinkedList {

    private Link first; // Reference to the first link in the list


    public LinkedList() {
        first = null; // No items initially
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // Add a card to the start of the list
    public void add(Card card) {
        Link newLink = new Link(card); // Create a new link
        newLink.next = first; // Link it to the current first item
        first = newLink; // Update first to the new link
    }

    // Remove the first card from the list
    public Card removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot remove.");
        }
        Card temp = first.cardLink; // Save the card from the first link
        first = first.next; // Update first to the next link
        return temp;
    }

    // Get (don't remove) the first card in the list
    public Card getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot retrieve.");
        }
        return first.cardLink;
    }

    // Shuffle the list
    public void shuffle() {
        if (isEmpty()) return;

        // Convert to array for shuffling
        java.util.ArrayList<Card> cardList = new java.util.ArrayList<>();
        Link current = first;
        while (current != null) {
            cardList.add(current.cardLink);
            current = current.next;
        }

        // Shuffle the array
        java.util.Collections.shuffle(cardList);

        // Rebuild the linked list
        first = null;
        for (Card card : cardList) {
            add(card); // Reuse the add method
        }
    }

    // Display all cards in the list
    public void displayList() {
        Link current = first; // Start at the first link
        while (current != null) {
            current.displayLink(); // Print the card in the current link
            current = current.next; // Move to the next link
        }
    }

    // Find and remove a card by value
    public Card remove(Card card) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot remove.");
        }

        Link current = first;
        Link previous = null;

        while (current != null) {
            if (current.cardLink.equals(card)) {
                if (previous == null) { // Removing the first link
                    first = current.next;
                } else {
                    previous.next = current.next;
                }
                return current.cardLink;
            }
            previous = current;
            current = current.next;
        }

        throw new IllegalArgumentException("Card not found in the list.");
    }

    // Count the total cards in the list
    public int size() {
        int count = 0;
        Link current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
// And that's all!
