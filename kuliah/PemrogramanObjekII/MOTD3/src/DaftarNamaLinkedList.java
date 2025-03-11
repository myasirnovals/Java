public class DaftarNamaLinkedList {
    Node first;

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    public static DaftarNamaLinkedList insertList(DaftarNamaLinkedList list, String data) {
        Node newNode = new Node(data);

        if (list.first == null) {
            list.first = newNode;
        } else {
            Node last = list.first;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

        return list;
    }

    public static void printList(DaftarNamaLinkedList list) {
        Node currNode = list.first;

        System.out.println("Daftar Nama: ");
        while (currNode != null) {
            System.out.print("[" + currNode.data + "] -> ");

            currNode = currNode.next;
        }

        System.out.print("null");
    }

    public static void main(String[] args) {
        DaftarNamaLinkedList list = new DaftarNamaLinkedList();

        System.out.println("=== BEST FRIENDS ===");
        list = insertList(list, "Muhamad Yasir Noval");
        list = insertList(list, "Muhamad Yusron Noval");
        list = insertList(list, "Ammar Bagas F W");
        list = insertList(list, "Arya Wijaya");
        list = insertList(list, "Fauzy Faadillah");
        list = insertList(list, "Ricky Gunaldo");
        list = insertList(list, "Bagas Aulia");
        list = insertList(list, "Aji Kartiko H");

        printList(list);
    }
}
