public class Node {
    
    private String name;
    private Node prev, next;
    private double nextConversor;

    public Node() {
        this.name = "";
        this.nextConversor = 1;
        this.prev = null;
        this.next = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public double getNextConversor() {
        return this.nextConversor;
    }

    public void setNextConversor(double nextConversor) {
        this.nextConversor = nextConversor;
    }

}
