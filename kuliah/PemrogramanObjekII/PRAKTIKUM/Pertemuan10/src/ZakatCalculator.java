public class ZakatCalculator {
    private static final double NISAB_EMAS_GRAM = 85.0;
    private static final double PERSENTASE_ZAKAT = 0.025;
    private static final double TAKARAN_BERAS_PER_JIWA = 2.5;

    public static double hitungZakatEmas(double hargaEmasPerGram, double jumlahEmasDimiliki) {
        double nilaiTotalEmas = hargaEmasPerGram * jumlahEmasDimiliki;

        if (jumlahEmasDimiliki >= NISAB_EMAS_GRAM) {
            return nilaiTotalEmas * PERSENTASE_ZAKAT;
        } else {
            return 0.0;
        }
    }

    public static double hitungZakatFitrah(int jumlahAnggotaKeluarga, double hargaBerasPerKg) {
        return TAKARAN_BERAS_PER_JIWA * jumlahAnggotaKeluarga * hargaBerasPerKg;
    }

    public static double hitungZakatPenghasilan(double penghasilanBersihBulanan, double hargaEmasPerGram) {
        double nisabPenghasilan = NISAB_EMAS_GRAM * hargaEmasPerGram / 12.0;

        if (penghasilanBersihBulanan >= nisabPenghasilan) {
            return penghasilanBersihBulanan * PERSENTASE_ZAKAT;
        } else {
            return 0.0;
        }
    }
}