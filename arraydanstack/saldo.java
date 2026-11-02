package arraydanstack;

import java.util.ArrayList;
import java.util.Scanner;

public class saldo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int balance = 2000000;
        ArrayList<Integer> transactions = new ArrayList<>();

        int nav;

        do {
            System.out.println("\nPilih Menu");
            System.out.println("1. Penarikan");
            System.out.println("2. Menyimpan");
            System.out.println("3. Lihat Saldo");
            System.out.println("4. Total Uang Masuk");
            System.out.println("5. Total Uang Keluar");
            System.out.println("0. Exit");

            System.out.print("Pilih Menu: ");
            nav = input.nextInt();

            if ((nav == 1 || nav == 2) &&
                transactions.size() == 5) {
                System.out.println("Data Transaksi sudah penuh");
                continue;
            }

            if (nav == 0) break;

            if (nav == 1) {

                System.out.print("Jumlah yang ditarik: ");
                int amount = input.nextInt();

                if (amount > balance || amount <= 0) {
                    System.out.println("Saldo tidak mencukupi atau jumlah tidak valid");
                    continue;
                }

                transactions.add(-amount);
                balance -= amount;

            } else if (nav == 2) {

                System.out.print("Jumlah yang disimpan: ");
                int amount = input.nextInt();

                if (amount <= 0) {
                    System.out.println("Jumlah tidak valid");
                    continue;
                }

                transactions.add(amount);
                balance += amount;

            } else if (nav == 3) {

                System.out.println("Saldo Anda: " + balance);

            } else if (nav == 4) {

                int total = 0;

                for (int x : transactions) {
                    if (x > 0) {
                        total += x;
                    }
                }

                System.out.println("Total Uang Masuk: " + total);

            } else if (nav == 5) {

                int total = 0;

                for (int x : transactions) {
                    if (x < 0) {
                        total += x;
                    }
                }

                System.out.println("Total Uang Keluar: " + (total * -1));
            }

        } while (true);

        input.close();
    }
}
