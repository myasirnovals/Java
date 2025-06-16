import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class ZakatUI extends JFrame implements ActionListener {

    private final JComboBox<ZakatType> zakatTypeComboBox;
    private final JPanel inputPanel;
    private final JLabel resultLabel;
    private final JButton calculateButton;

    private JTextField inputHargaEmas;
    private JTextField inputJumlahEmas;

    private JTextField inputJumlahAnggotaKeluarga;
    private JTextField inputHargaBerasKg;

    private JTextField inputPenghasilanBersihBulanan;
    private JTextField inputHargaEmasPenghasilan;


    public ZakatUI() {
        setTitle("Aplikasi Penghitung Zakat");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel titleLabel = new JLabel("Pilih Jenis Zakat:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(titleLabel);

        zakatTypeComboBox = new JComboBox<>(ZakatType.values());
        zakatTypeComboBox.addActionListener(this);
        headerPanel.add(zakatTypeComboBox);
        add(headerPanel, BorderLayout.NORTH);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Data"));
        add(inputPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout(10, 10));

        resultLabel = new JLabel("Total Zakat: -", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        southPanel.add(resultLabel, BorderLayout.CENTER);

        calculateButton = new JButton("Hitung Zakat");
        calculateButton.addActionListener(this);
        southPanel.add(calculateButton, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);

        updateInputPanel((ZakatType) Objects.requireNonNull(zakatTypeComboBox.getSelectedItem()));

        setVisible(true);
    }

    private void updateInputPanel(ZakatType selectedType) {
        inputPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        switch (selectedType) {
            case ZAKAT_EMAS:
                gbc.gridx = 0; gbc.gridy = 0;
                JLabel labelHargaEmas = new JLabel("Harga Emas per Gram (Rp):");
                inputPanel.add(labelHargaEmas, gbc);

                gbc.gridx = 1; gbc.gridy = 0;
                inputHargaEmas = new JTextField(15);
                inputPanel.add(inputHargaEmas, gbc);

                gbc.gridx = 0; gbc.gridy = 1;
                JLabel labelJumlahEmas = new JLabel("Jumlah Emas Dimiliki (gram):");
                inputPanel.add(labelJumlahEmas, gbc);

                gbc.gridx = 1; gbc.gridy = 1;
                inputJumlahEmas = new JTextField(15);
                inputPanel.add(inputJumlahEmas, gbc);
                break;

            case ZAKAT_FITRAH:
                gbc.gridx = 0; gbc.gridy = 0;
                JLabel labelJumlahAnggotaKeluarga = new JLabel("Jumlah Anggota Keluarga:");
                inputPanel.add(labelJumlahAnggotaKeluarga, gbc);

                gbc.gridx = 1; gbc.gridy = 0;
                inputJumlahAnggotaKeluarga = new JTextField(15);
                inputPanel.add(inputJumlahAnggotaKeluarga, gbc);

                gbc.gridx = 0; gbc.gridy = 1;
                JLabel labelHargaBerasKg = new JLabel("Harga Beras per Kg (Rp):");
                inputPanel.add(labelHargaBerasKg, gbc);

                gbc.gridx = 1; gbc.gridy = 1;
                inputHargaBerasKg = new JTextField(15);
                inputPanel.add(inputHargaBerasKg, gbc);
                break;

            case ZAKAT_PENGHASILAN:
                gbc.gridx = 0; gbc.gridy = 0;
                JLabel labelPenghasilanBersihBulanan = new JLabel("Penghasilan Bersih Bulanan (Rp):");
                inputPanel.add(labelPenghasilanBersihBulanan, gbc);

                gbc.gridx = 1; gbc.gridy = 0;
                inputPenghasilanBersihBulanan = new JTextField(15);
                inputPanel.add(inputPenghasilanBersihBulanan, gbc);

                gbc.gridx = 0; gbc.gridy = 1;
                JLabel labelHargaEmasPenghasilan = new JLabel("Harga Emas per Gram (Rp):");
                inputPanel.add(labelHargaEmasPenghasilan, gbc);

                gbc.gridx = 1; gbc.gridy = 1;
                inputHargaEmasPenghasilan = new JTextField(15);
                inputPanel.add(inputHargaEmasPenghasilan, gbc);
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
        resultLabel.setText("Total Zakat: -");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == zakatTypeComboBox) {
            ZakatType selectedType = (ZakatType) zakatTypeComboBox.getSelectedItem();
            assert selectedType != null;
            updateInputPanel(selectedType);
        } else if (e.getSource() == calculateButton) {
            calculateZakat();
        }
    }

    private void calculateZakat() {
        ZakatType selectedType = (ZakatType) zakatTypeComboBox.getSelectedItem();
        double totalZakat = 0.0;
        String errorMessage = "";
        DecimalFormat currencyFormat = new DecimalFormat("Rp #,##0.00");

        try {
            switch (Objects.requireNonNull(selectedType)) {
                case ZAKAT_EMAS:
                    String hargaEmasStr = inputHargaEmas.getText();
                    String jumlahEmasStr = inputJumlahEmas.getText();

                    if (ZakatValidation.isValidPositiveNumber(hargaEmasStr) || ZakatValidation.isValidPositiveNumber(jumlahEmasStr)) {
                        errorMessage = "Input harga emas dan jumlah emas harus angka positif.";
                    } else {
                        double hargaEmas = Double.parseDouble(hargaEmasStr);
                        double jumlahEmas = Double.parseDouble(jumlahEmasStr);
                        totalZakat = ZakatCalculator.hitungZakatEmas(hargaEmas, jumlahEmas);
                    }
                    break;

                case ZAKAT_FITRAH:
                    String jumlahAnggotaStr = inputJumlahAnggotaKeluarga.getText();
                    String hargaBerasStr = inputHargaBerasKg.getText();

                    if (!ZakatValidation.isValidPositiveInteger(jumlahAnggotaStr) || ZakatValidation.isValidPositiveNumber(hargaBerasStr)) {
                        errorMessage = "Jumlah anggota keluarga harus bilangan bulat positif dan harga beras harus angka positif.";
                    } else {
                        int jumlahAnggota = Integer.parseInt(jumlahAnggotaStr);
                        double hargaBeras = Double.parseDouble(hargaBerasStr);
                        totalZakat = ZakatCalculator.hitungZakatFitrah(jumlahAnggota, hargaBeras);
                    }
                    break;

                case ZAKAT_PENGHASILAN:
                    String penghasilanStr = inputPenghasilanBersihBulanan.getText();
                    String hargaEmasPenghasilanStr = inputHargaEmasPenghasilan.getText();

                    if (ZakatValidation.isValidPositiveNumber(penghasilanStr) || ZakatValidation.isValidPositiveNumber(hargaEmasPenghasilanStr)) {
                        errorMessage = "Input penghasilan dan harga emas harus angka positif.";
                    } else {
                        double penghasilan = Double.parseDouble(penghasilanStr);
                        double hargaEmasUntukNisab = Double.parseDouble(hargaEmasPenghasilanStr);
                        totalZakat = ZakatCalculator.hitungZakatPenghasilan(penghasilan, hargaEmasUntukNisab);
                    }
                    break;
            }

            if (!errorMessage.isEmpty()) {
                JOptionPane.showMessageDialog(this, errorMessage, "Error Input", JOptionPane.ERROR_MESSAGE);
            } else {
                if (totalZakat > 0) {
                    resultLabel.setText("Total Zakat: " + currencyFormat.format(totalZakat));
                } else {
                    resultLabel.setText("Total Zakat: Belum Wajib Zakat atau 0");
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input tidak valid. Pastikan semua kolom terisi dengan angka yang benar.", "Error Input", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}