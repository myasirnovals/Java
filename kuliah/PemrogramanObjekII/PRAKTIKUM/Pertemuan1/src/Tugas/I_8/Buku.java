package Tugas.I_8;

class Buku {
    private String penulis;
    private String judul;
    private String nomorISBN;
    public static int jumBuku = 0;

    public Buku(String penulis, String judul, String nomorISBN) {
        this.penulis = penulis;
        this.judul = judul;
        this.nomorISBN = nomorISBN;
        jumBuku++;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getNomorISBN() {
        return nomorISBN;
    }

    public void cetakInformasiBuku() {
        System.out.println("Informasi Buku:");
        System.out.println("Penulis: " + penulis);
        System.out.println("Judul: " + judul);
        System.out.println("Nomor ISBN: " + nomorISBN);
    }

    public static void main(String[] args) {
        Buku buku = new Buku("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "978-0747532699");
        buku.cetakInformasiBuku();
    }
}

