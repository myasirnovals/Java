public class DaftarNama {
    public static void main(String[] args) {
        String[] names = {
                "Derek Westbrook",
                "Gary Sanderson",
                "Mac Tavish",
                "John Price",
                "Sorasaki Hina",
                "Takanashi Hoshino",
                "James Ramirez",
                "Simon Rally",
                "Mac Millan",
                "Satou Hina"
        };

        boolean terdaftar = true;
        int i = 0;

        try {
            while (terdaftar) {
                System.out.println(names[i]);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Daftar hanya berisi 10 nama saja");
        }
    }
}
