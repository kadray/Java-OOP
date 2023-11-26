package lab4;
import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Brak argumentów programu");
            return;
        }

        String source_path = args[0];
        String end_path = args[1];

        try {
            File source_file = new File(source_path);
            File end_file = new File(end_path);

            if (!source_file.exists()) {
                System.err.println("Plik " + source_path + " nie istnieje.");
                return;
            }

            if (source_file.isDirectory()) {
                System.err.println(source_path + " jest katalogiem.");
                return;
            }

            if (!source_file.canRead()) {
                System.err.println("Brak dostępu do pliku " + source_path);
                return;
            }

            if (end_file.isDirectory()) {
                end_file = new File(end_file, source_file.getName());
            }

            if (end_file.exists() && !end_file.canWrite()) {
                System.err.println("Brak wymaganych uprawnień do zapisu pliku " + end_path);
                return;
            }

            if (end_file.exists() && !end_file.delete()) {
                System.err.println("Nie można nadpisać pliku " + end_path);
                return;
            }

            try (InputStream in = new FileInputStream(source_file);
                 OutputStream out = new FileOutputStream(end_file)) {

                byte[] buffer = new byte[1024];
                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }

                System.out.println("Plik został skopiowany pomyślnie.");
            } catch (IOException e) {
                System.err.println("Wystąpił błąd podczas kopiowania pliku: " + e.getMessage());
            }

        } catch (SecurityException e) {
            System.err.println("Brak wymaganych uprawnień do katalogu " + end_path);
        }
    }
}