package Program.III_9;

import Program.III_8.Node;

public class TestNode {
    public static void main(String[] args) {
        Node emptyList = null; /* membuat list kosong */

        /* head points untuk node pertama dalam list */
        Node head = new Node();

        /* inisialisasi node pertama dalam list */
        head.data = 5;
        head.nextNode = new Node();
        head.nextNode.data = 10;

        /* null menandai akhir dari list */
        head.nextNode.nextNode = null;

        /* mencetak elemen list */
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.nextNode;
        }
    }
}
