public class Book {
    private String judulBuku;
    private String penulis;
    private String tanggalTerbit;
    private String issnIsbn;
    private String nomorRegistrasi;

    public Book(String judulBuku, String penulis, String tanggalTerbit, String issnIsbn, String nomorRegistrasi) {
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.tanggalTerbit = tanggalTerbit;
        this.issnIsbn = issnIsbn;
        this.nomorRegistrasi = nomorRegistrasi;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public String getIssnIsbn() {
        return issnIsbn;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    // Setter methods
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public void setIssnIsbn(String issnIsbn) {
        this.issnIsbn = issnIsbn;
    }

    public void setNomorRegistrasi(String nomorRegistrasi) {
        this.nomorRegistrasi = nomorRegistrasi;
    }

    @Override
    public String toString() {
        return "Book{" + "judulBuku='" + judulBuku + '\'' + ", penulis='" + penulis + '\'' + ", tanggalTerbit='" + tanggalTerbit + '\'' + ", issnIsbn='" + issnIsbn + '\'' + ", nomorRegistrasi='" + nomorRegistrasi + '\'' + '}';
    }
}
