package PraktikumDaspro.Jobsheet11;

import java.util.Scanner;

public class BankSampah16 {

    static Scanner input = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];

        for (int i = 0; i < n; i++) {
            setoran[i] = input.nextDouble();
        }

        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah " + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;

        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }

        return total;
    }

    static double hitungSaldo(double berat, double harga) {
        return berat * harga;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int indeks = 0;

        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeks]) {
                indeks = i;
            }
        }

        return indeks;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah: ");
        int n = input.nextInt();

        double[] setoran = inputSetoran(n);

        System.out.println("\nData Setoran:");
        tampilSetoran(setoran);

        System.out.println("\nSaldo Setiap Nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah " + (i + 1) + ": Rp"
                    + hitungSaldo(setoran[i], 3000));
        }

        System.out.println("\nTotal Setoran: " + totalSetoran(setoran) + " kg");

        int indeksTerbesar = nasabahTerbanyak(setoran);
        System.out.println("Nasabah dengan setoran terbesar: Nasabah "
                + (indeksTerbesar + 1));
        System.out.println("Berat setoran terbesar: "
                + setoran[indeksTerbesar] + " kg");

        input.close();
    }
}
