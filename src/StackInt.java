interface LLStackInt {
    public boolean empty();
    public int size();
    public void push(double number);
    public double pop();
    public double top();
    public void traverse();
}

public class StackInt implements LLStackInt {

    private int size;
    private Node top;

    public StackInt() {
        top = null;
        size = 0;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void push(double number) {
        Node newNode = new Node(number);
        newNode.setNext(top);
        size++;
        top = newNode;
    }

    public double pop() {
        double i = top.getNumber();
        top = top.getNext();
        size--;
        return i;
    }

    public double top() {
        return top.getNumber();
    }

    public void traverse() {
        Node current = top;
        System.out.println("Stack: ");
        while (current != null) {
            System.out.println(current.getNumber());
            current = current.getNext();
        }
    }
}