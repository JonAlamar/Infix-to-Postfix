interface LLStack {
    public boolean empty();
    public int size();
    public void push(char data);
    public char pop();
    public char top();
    public void traverse();
}

public class Stack implements LLStack {

    private int size;
    private Node top;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void push(char data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        size++;
        top = newNode;
    }

    public char pop() {
        char i = top.getData();
        top = top.getNext();
        size--;
        return i;
    }

    public char top() {
        return top.getData();
    }

    public void traverse() {
        Node current = top;
        System.out.println("Stack: ");
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}