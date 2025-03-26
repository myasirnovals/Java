package Program.VII_14;

public class StringBuilderInsertDelete {
    public static void main(String[] args) {
        Object objectRef = "hello";
        String string = "goodbye";
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean booleanValue = true;
        char characterValue = 'K';
        int integerValue = 7;
        long longValue = 10000000;
        float floatValue = 2.5f; //nilai float
        double doubleValue = 33.333;

        StringBuilder buffer = new StringBuilder();

        buffer.insert(0, objectRef).insert(0, "  ").insert(0, string).insert(0, "  ").insert(0, charArray).insert(0, "  ").insert(0, charArray, 3, 3).insert(0, "  ").insert(0, booleanValue).insert(0, "  ").insert(0, characterValue).insert(0, "  ").insert(0, integerValue).insert(0, "  ").insert(0, longValue).insert(0, "  ").insert(0, floatValue).insert(0, "  ").insert(0, doubleValue);

        System.out.printf("buffer after inserts:\n%s\n\n", buffer.toString());

        buffer.deleteCharAt(10);
        buffer.delete(2, 6);

        System.out.printf("buffer after deletes:\n%s\n", buffer.toString());
    }
}
