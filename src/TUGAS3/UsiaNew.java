package TUGAS3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class UsiaNew {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate tanggalLahir = null;
        boolean tanggalValid = false;

        // Loop untuk memastikan input tanggal yang valid
        while (!tanggalValid) {
            try {
                System.out.print("Masukkan tanggal lahir (1-31): ");
                int hariLahir = scanner.nextInt();

                System.out.print("Masukkan bulan lahir (1-12): ");
                int bulanLahir = scanner.nextInt();

                System.out.print("Masukkan tahun lahir (misal: 1990): ");
                int tahunLahir = scanner.nextInt();

                tanggalLahir = validasiTanggal(tahunLahir, bulanLahir, hariLahir);

                // Memastikan tanggal lahir tidak di masa depan
                if (tanggalLahir.isAfter(LocalDate.now())) {
                    System.out.println("Tanggal lahir tidak boleh di masa depan. Coba lagi.");
                } else {
                    tanggalValid = true;
                }

            } catch (DateTimeException e) {
                System.out.println("Tanggal tidak valid. Pastikan hari, bulan, dan tahun benar.");
                scanner.nextLine(); // Membersihkan input jika terjadi kesalahan
            }
        }

        Period usia = hitungUsia(tanggalLahir);

        System.out.printf("Usia Anda saat ini: %d tahun, %d bulan, dan %d hari.%n",
                usia.getYears(), usia.getMonths(), usia.getDays());
    }

    private static Period hitungUsia(LocalDate tanggalLahir) {
        LocalDate sekarang = LocalDate.now();
        return Period.between(tanggalLahir, sekarang);
    }

    private static LocalDate validasiTanggal(int tahunLahir, int bulanLahir, int hariLahir) {
        return LocalDate.of(tahunLahir, bulanLahir, hariLahir);
    }
}
