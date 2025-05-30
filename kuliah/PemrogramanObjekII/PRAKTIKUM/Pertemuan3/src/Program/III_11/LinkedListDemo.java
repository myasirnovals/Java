package Program.III_11;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(1));
        System.out.println(list + ", size = " + list.size());
        list.addFirst(new Integer(0));
        list.addLast(new Integer(4));
        System.out.println(list);
        System.out.println(list.getFirst() + ", " + list.getLast());
        System.out.println(list.get(2) + ", " + list.get(3));
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.remove(new Integer(1));
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.set(1, "one");
        System.out.println(list);
    }
}
