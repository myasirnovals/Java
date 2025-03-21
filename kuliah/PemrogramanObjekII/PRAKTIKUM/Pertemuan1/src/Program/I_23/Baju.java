package Program.I_23;

public class Baju extends Pakaian {
    // kode warna R=Merah, B=Biru, H=Hitam, W=Putih, U=Belum Ditentukan
    public char kodeWarna = 'U';

    public void tampilkanInformasiBaju() {
        System.out.println("ID Baju: " + getID());
        System.out.println("Keterangan Baju: " + getKeterangan());
        System.out.println("Kode Warna Baju: " + kodeWarna);
        System.out.println("Harga Baju: " + getHarga());
        System.out.println("Jumlah Stok Baju: " + getJmlStok());
    }
}
