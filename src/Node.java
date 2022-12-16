interface LList {
    public void setData(char data);
    public void setNext(Node next);
    public void setNumber(double number);
    public char getData();
    public Node getNext();
    public double getNumber();
    public void displayNode();
}

public class Node implements LList {

    private char data;
    private Node next;
    private double number;

    public Node() {
        this('\0', null);     //is there a null for char if I don't have a value
    }

    public Node(char data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(char data) {
        this.data = data;
        next = null;           //is this null needed everytime we make a new node that we don't specify next
    }

    public Node(double number) {
        this.number = number;
        next = null;
    }

    public void setData(char data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public char getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public double getNumber() {
        return number;
    }

    public void displayNode() {
        System.out.println(data);
    }
}