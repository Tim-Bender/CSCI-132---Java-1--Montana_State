public class Driver1
{
    public static void main (String [] args)
    {
        LinkedList<Song> list;
        
        list = new LinkedList<Song>();
        Song song;
        Node<Song> node;
        
        list.print();
        song = new Song("I Cant Get No Satisfaction", "Rolling Stones", 1965);
        node = new Node<Song>(song);
        
        list.addInOrder(node);
        //list.add(node);
        
        
        song = new Song("A Hard Day's Night", "Beatles", 1964);
        node = new Node<Song>(song);
        list.addInOrder(node);
        //list.add(node);

        song = new Song("Jumpin' Jack Flash", "Rolling Stones", 1968);
        node = new Node<Song>(song);
        list.addInOrder(node);
        //list.add(node);
        
        song = new Song("Not Fade Away", "Rolling Stones", 1964);
        node = new Node<Song>(song);
        list.addInOrder(node);
        //list.add(node);
        
        song = new Song("Michelle", "Beatles", 1965);
        node = new Node<Song>(song);
        list.addInOrder(node);
        //list.add(node);
        System.out.println("Forwards Print\n");
        list.print();
        //System.out.println("Backwards Print\n");
         //list.printBackwards();

        System.out.println("\nRemove item\n");
        song = new Song("I Cant Get No Satisfaction", "Rolling Stones", 1965);
        node = new Node<Song>(song);
        list.remove(node);

        System.out.println("Forwards Print - 2\n");
        list.print();
        
        System.out.println("\nBackwards Print\n");
        list.printBackwards();

        // Remove remaining
        song = new Song("Michelle", "Beatles", 1965);
        list.remove(node);
        song = new Song("A Hard Day's Night", "Beatles", 1964);
        list.remove(node);
        song = new Song("Not Fade Away", "Rolling Stones", 1964);
        list.remove(node);
        song = new Song("Jumpin' Jack Flash", "Rolling Stones", 1968);
        list.remove(node);
        System.out.println("Forwards Print -3\n");
        list.print();

    }
}
