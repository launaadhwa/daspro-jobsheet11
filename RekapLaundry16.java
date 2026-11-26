package PraktikumDaspro.Jobsheet11;

import java.util.Scanner;

public class RekapLaundry16 {

    static void inputData(int[][] data, String[] namaLayanan,
            String[] namaHari, Scanner input) {

        for (int i = 0; i < data.length; i++) {
            System.out.println("\nMasukkan berat " + namaLayanan[i]);

            for (int j = 0; j < data[i].length; j++) {
                System.out.print(namaHari[j] + ": ");
                data[i][j] = input.nextInt();
            }
        }
    }

    static void tampilData(int[][] data, String[] namaLayanan,
            int[] hargaPerKg, String[] namaHari) {

        System.out.println("\nRekap Data Laundry:");
        System.out.print("Layanan | Harga/kg | ");

        for (int j = 0; j < namaHari.length; j++) {
            System.out.print(namaHari[j] + " | ");
        }

        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(namaLayanan[i] + " | Rp"
                    + hargaPerKg[i] + " | ");

            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " | ");
            }

            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;

        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }

        return total;
    }

    static int layananTerbanyak(int[][] data) {
        int indeks = 0;

        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) >
                    totalPerLayanan(data, indeks)) {
                indeks = i;
            }
        }

        return indeks;
    }

    static int hariTersibuk(int[][] data) {
        int indeks = 0;
        int totalTerbesar = 0;

        for (int j = 0; j < data[0].length; j++) {
            int total = 0;

            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }

            if (total > totalTerbesar) {
                totalTerbesar = total;
                indeks = j;
            }
        }

        return indeks;
    }

    static void tampilPendapatan(int[][] data, String[] namaLayanan,
            int[] hargaPerKg) {

        int totalPendapatan = 0;

        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * hargaPerKg[i];

            System.out.println("Pendapatan " + namaLayanan[i]
                    + ": Rp" + pendapatan);

            totalPendapatan += pendapatan;
        }

        System.out.println("Total pendapatan: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = input.nextInt();

        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = input.nextInt();

        String[] namaLayanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        String[] namaHari = new String[jumlahHari];

        int[][] data = new int[jumlahLayanan][jumlahHari];

        input.nextLine();

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("\nMasukkan nama layanan ke-" + (i + 1) + ": ");
            namaLayanan[i] = input.nextLine();

            System.out.print("Masukkan harga per kg: ");
            hargaPerKg[i] = input.nextInt();
            input.nextLine();
        }

        for (int j = 0; j < jumlahHari; j++) {
            namaHari[j] = "Hari ke-" + (j + 1);
        }

        inputData(data, namaLayanan, namaHari, input);

        tampilData(data, namaLayanan, hargaPerKg, namaHari);

        System.out.println("\nTotal Berat Setiap Layanan:");

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println(namaLayanan[i] + ": "
                    + totalPerLayanan(data, i) + " kg");
        }

        int indeksLayanan = layananTerbanyak(data);

        System.out.println("\nLayanan dengan total berat tertinggi: "
                + namaLayanan[indeksLayanan] + " ("
                + totalPerLayanan(data, indeksLayanan) + " kg)");

        int indeksHari = hariTersibuk(data);

        System.out.println("Hari tersibuk: " + namaHari[indeksHari]);

        System.out.println("\nPendapatan:");
        tampilPendapatan(data, namaLayanan, hargaPerKg);

        input.close();
    }
}
