interface LLQueue {
    public boolean empty();
    public int size();
    public void enqueue(char data);
    public char dequeue();
    public void traverse();
}

public class Queue implements LLQueue {

    int size;
    Node front;
    Node rear;

    public Queue() {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void enqueue(char data) {
        Node newNode = new Node(data);
        if (this.empty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    public char dequeue() {
        char i = front.getData();
        front = front.getNext();
        size--;
        if (this.empty()) {
            rear = null;
        }
        return i;
    }

    public void traverse() {
        Node current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("****** End of Queue ******\n");
    }
}