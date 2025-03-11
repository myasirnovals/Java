public class DaftarNamaStack {
    private StackNode top;

    class StackNode {
        String data;
        StackNode next;

        StackNode(String data) {
            this.data = data;
            next = null;
        }
    }

    void push(String data) {
        StackNode node = new StackNode(data);
        node.next = top;
        top = node;
    }

    String pop() {
        if (isEmpty()) {
            return "E: Stack is Empty!";
        } else {
            String data = top.data;
            top = top.next;
            return data;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        DaftarNamaStack stack = new DaftarNamaStack();
        stack.push("Muhamad Yasir Noval");
        stack.push("Muhamad Yusron Noval");
        stack.push("Ammar Bagas F W");
        stack.push("Arya Wijaya");
        stack.push("Fauzy Faadillah");
        stack.push("Ricky Gunaldo");
        stack.push("Bagas Aulia");
        stack.push("Aji Kartiko H");

        StackNode currNode = stack.top;
        while (currNode != null) {
            System.out.println("[" + currNode.data + "]");
            currNode = currNode.next;
        }

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
