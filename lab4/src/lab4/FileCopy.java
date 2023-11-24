package lab4;
import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Brak argumentów programu.\nUżycie: java FileCopy source_file target");
            return;
        }

        String sourceFilePath = args[0];
        String targetFilePath = args[1];

        try {
            File sourceFile = new File(sourceFilePath);
            File targetFile = new File(targetFilePath);

            if (!sourceFile.exists()) {
                System.err.println("Plik " + sourceFilePath + " nie istnieje.");
                return;
            }

            if (sourceFile.isDirectory()) {
                System.err.println(sourceFilePath + " jest katalogiem.");
                return;
            }

            if (!sourceFile.canRead()) {
                System.err.println("Brak dostępu do pliku " + sourceFilePath);
                return;
            }

            if (targetFile.isDirectory()) {
                targetFile = new File(targetFile, sourceFile.getName());
            }

            if (targetFile.exists() && !targetFile.canWrite()) {
                System.err.println("Brak wymaganych uprawnień do zapisu pliku " + targetFilePath);
                return;
            }

            if (targetFile.exists() && !targetFile.delete()) {
                System.err.println("Nie można nadpisać pliku " + targetFilePath);
                return;
            }

            try (InputStream in = new FileInputStream(sourceFile);
                 OutputStream out = new FileOutputStream(targetFile)) {

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
            System.err.println("Brak wymaganych uprawnień do katalogu " + targetFilePath);
        }
    }
}