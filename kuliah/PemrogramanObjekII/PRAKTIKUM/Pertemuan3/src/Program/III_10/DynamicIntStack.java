package Program.III_10;

public class DynamicIntStack {
    private IntStackNode top; /* head atau puncak dari stack */

    class IntStackNode { /* class node */
        int data;
        IntStackNode next;

        IntStackNode(int n) {
            data = n;
            next = null;
        }
    }

    void push(int n){
        /* no need to check for overflow */
        IntStackNode node = new IntStackNode(n);
        node.next = top;
        top = node;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
            /* may throw a user-defined exception */
        } else {
            int n = top.data;
            top = top.next;
            return n;
        }
    }

    boolean isEmpty(){
        return top == null;
    }
    public static void main(String args[]) {
        DynamicIntStack myStack = new DynamicIntStack();
        myStack.push(5);
        myStack.push(10);
        /* mencetak elemen dari stack */
        IntStackNode currNode = myStack.top;
        while (currNode!=null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
