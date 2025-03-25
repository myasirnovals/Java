package Tugas.III_8;

public class TestNode {
    public static void main(String[] args) {
        Node emptyList = null; /* membuat list kosong */

        /* head points untuk node pertama dalam list */
        Node head = new Node();

        /* inisialisasi node pertama dalam list */
        head.name = "Yasir Noval";
        head.age = 19;
        head.next = new Node();

        head.next.name = "Yusron Noval";
        head.next.age = 19;

        /* null menandai akhir dari list */
        head.next.next = null;

        /* mencetak elemen list */
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.name);
            System.out.println(currNode.age);
            currNode = currNode.next;
        }
    }
}
