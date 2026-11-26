package PraktikumDaspro.Jobsheet11;

import java.util.Scanner;

public class KubusLimas16 {

    static int luasPersegi(int s) {
        return s * s;
    }

    static int volumeKubus(int s) {
        return s * s * s;
    }

    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    static double volumeLimasPersegi(int s, int t) {
        return (double) luasPersegi(s) * t / 3;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU BANGUN RUANG ===");
            System.out.println("1. Luas Persegi");
            System.out.println("2. Volume Kubus");
            System.out.println("3. Luas Permukaan Kubus");
            System.out.println("4. Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan panjang sisi: ");
                    int s1 = input.nextInt();
                    System.out.println("Luas persegi = " + luasPersegi(s1));
                    break;

                case 2:
                    System.out.print("Masukkan panjang sisi: ");
                    int s2 = input.nextInt();
                    System.out.println("Volume kubus = " + volumeKubus(s2));
                    break;

                case 3:
                    System.out.print("Masukkan panjang sisi: ");
                    int s3 = input.nextInt();
                    System.out.println("Luas permukaan kubus = "
                            + luasPermukaanKubus(s3));
                    break;

                case 4:
                    System.out.print("Masukkan panjang sisi alas: ");
                    int s4 = input.nextInt();

                    System.out.print("Masukkan tinggi limas: ");
                    int t = input.nextInt();

                    System.out.println("Volume limas persegi = "
                            + volumeLimasPersegi(s4, t));
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }
}
