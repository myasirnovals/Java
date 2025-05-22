public class SubStringExample {
    public static void main(String[] args) {
        String str;
        StringBuffer strBuf;

        str = "Decaffeinated";
        strBuf = new StringBuffer(str.substring(2, 7));
        strBuf.setCharAt(1, 'o');
        strBuf.append("e");
        str = strBuf.toString();
        System.out.println("The new string is: " + str);
    }
}
