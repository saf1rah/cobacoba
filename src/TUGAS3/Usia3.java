package TUGAS3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Usia3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan tanggal lahir (1-31): ");
            int hariLahir = scanner.nextInt();

            System.out.print("Masukkan bulan lahir (1-12): ");
            int bulanLahir = scanner.nextInt();

            System.out.print("Masukkan tahun lahir (misal: 1990): ");
            int tahunLahir = scanner.nextInt();

            LocalDate tanggalLahir = validasiTanggal(tahunLahir, bulanLahir, hariLahir);
            Period usia = hitungUsia(tanggalLahir);

            //REFACTORING 3: merubah menjadi printf untuk format string yg lebih jelas
            System.out.printf("Usia Anda saat ini: %d tahun, %d bulan, dan %d hari.%n",
                    usia.getYears(), usia.getMonths(), usia.getDays());

            //REFACTORING 5: menghapus scanner.close();
        }

        //REFACTORING 4: menjadi hitungUsia
        private static Period hitungUsia(LocalDate tanggalLahir) {
            LocalDate sekarang = LocalDate.now();
            Period usia = Period.between(tanggalLahir, sekarang);
            return usia;
        }

        //REFACTORING 2: validasi tanggal
        private static LocalDate validasiTanggal(int tahunLahir, int bulanLahir, int hariLahir) {
            LocalDate tanggalLahir = ambilTanggalLahir(tahunLahir, bulanLahir, hariLahir);
            return tanggalLahir;
        }

        //REFACTORING 1
        private static LocalDate ambilTanggalLahir(int tahunLahir, int bulanLahir, int hariLahir) {
            LocalDate tanggalLahir = LocalDate.of(tahunLahir, bulanLahir, hariLahir);
            return tanggalLahir;
        }
    }


