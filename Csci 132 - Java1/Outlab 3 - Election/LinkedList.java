public class LinkedList
{
    private Node first;
    private Node m;
    private Node k;
    
    public LinkedList() {
        this.first = null;
    }
    
    public int moveK(final int numberSpots) {
        Node moving = this.k;
        for (int x = 0; x < numberSpots - 1; ++x) {
            moving = moving.getNext();
        }
        this.k = moving;
        return this.k.getData();
    }
    
    public int moveM(final int numberSpots) {
        Node moving = this.m;
        for (int x = 0; x < numberSpots - 1; ++x) {
            moving = moving.getPrevious();
        }
        this.m = moving;
        return this.k.getData();
    }
    
    public void add(final Node data) {
        if (this.first == null) {
            (this.first = data).setNext(data);
            data.setPrevious(data);
        }
        else {
            final Node before = this.first.getPrevious();
            before.setNext(data);
            this.first.setPrevious(data);
            data.setNext(this.first);
            data.setPrevious(before);
        }
    }
    
    public void remove(final Node data) {
        Node after = this.first.getNext();
        Node before = this.first.getPrevious();
        Node toRemove;
        for (toRemove = this.first; toRemove.getData() != data.getData(); toRemove = toRemove.getNext()) {}
        if (toRemove == this.m) {
            this.m = this.m.getPrevious();
        }
        if (toRemove == this.k) {
            this.k = this.k.getNext();
        }
        if (toRemove != this.first) {
            before = toRemove.getPrevious();
            after = toRemove.getNext();
            before.setNext(after);
            after.setPrevious(before);
        }
        else {
            before = toRemove.getPrevious();
            after = toRemove.getNext();
            if (after == this.first && before == this.first) {
                this.first = null;
            }
            else {
                before.setNext(after);
                after.setPrevious(before);
                this.first = after;
            }
        }
    }
    
    public void print() {
        Node temp = this.first;
        if (this.first != null) {
            System.out.println(this.first.getData());
            temp = temp.getNext();
        }
        else {
            System.out.println("List is empty");
        }
        while (temp != this.first) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    
    public void setMK() {
        this.m = this.first.getPrevious();
        this.k = this.first;
    }
    
    public int getM() {
        return this.m.getData();
    }
    
    public int getK() {
        return this.k.getData();
    }
    
    public Node getMNode() {
        return this.m;
    }
    
    public Node getKNode() {
        return this.k;
    }
    
    public Node getFirst() {
        return this.first;
    }
}