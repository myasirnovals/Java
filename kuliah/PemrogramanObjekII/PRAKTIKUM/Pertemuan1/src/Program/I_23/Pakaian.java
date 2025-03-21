package Program.I_23;

public class Pakaian {
    private int ID = 0; // Default value for all clothes
    private String keterangan = "-keterangan diperlukan-";  // Default value
    private double harga = 0.0; // Default value
    private int jmlStok = 0;    // Default value
    private static int UNIQUE_ID = 0;   // Unique ID for each clothes

    public Pakaian() {
        this.ID = ++UNIQUE_ID;
    }

    public int getID() {
        return ID;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public void setJmlStok(int jmlStok) {
        this.jmlStok = jmlStok;
    }

    public int getJmlStok() {
        return jmlStok;
    }
}
