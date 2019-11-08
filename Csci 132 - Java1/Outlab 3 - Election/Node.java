public class Node
{
    private int data;
    private Node next;
    private Node previous;
    
    public Node(final int x) {
        this.data = x;
        this.next = null;
        this.previous = null;
    }
    
    public int compareData(final Node n) {
        if (n.getData() == this.data) {
            return 1;
        }
        return -1;
    }
    
    public int getData() {
        return this.data;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public Node getPrevious() {
        return this.previous;
    }
    
    public void setPosition(final int x) {
        this.data = x;
    }
    
    public void setNext(final Node n) {
        this.next = n;
    }
    
    public void setPrevious(final Node n) {
        this.previous = n;
    }
}