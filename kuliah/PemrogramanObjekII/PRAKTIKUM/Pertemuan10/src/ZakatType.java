public enum ZakatType {
    ZAKAT_EMAS("Zakat Emas"),
    ZAKAT_FITRAH("Zakat Fitrah"),
    ZAKAT_PENGHASILAN("Zakat Penghasilan");

    private final String displayName;

    ZakatType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}