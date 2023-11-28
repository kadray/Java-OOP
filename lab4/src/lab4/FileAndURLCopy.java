package lab4;
import java.io.*;
import java.net.*;

public class FileAndURLCopy {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Brak argumentów programu.");
            return;
        }

        String source_path = args[0];
        String end_path = "copy";
        if(isURL(source_path)) end_path+=".html";
        else end_path+=".txt";
        
        if(args.length == 2) {
        	end_path = args[1];
        }
        try {
            if (isURL(source_path)) {
                copyFromURL(source_path, end_path);
            } else {
                copyFromFile(source_path, end_path);
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }

    private static boolean isURL(String path) {
        return path.toLowerCase().startsWith("http://") || path.toLowerCase().startsWith("https://");
    }

    private static void copyFromFile(String sourcePath, String targetPath) throws IOException {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            System.out.println("Plik " + sourcePath + " nie istnieje.");
            return;
        }

        if (sourceFile.isDirectory()) {
            System.out.println(sourcePath + " jest katalogiem.");
            return;
        }

        if (!sourceFile.canRead()) {
            System.out.println("Brak dostępu do pliku " + sourcePath);
            return;
        }

        if (targetFile.isDirectory()) {
            targetFile = new File(targetFile, sourceFile.getName());
        }

        if (targetFile.exists() && !targetFile.canWrite()) {
            System.out.println("Brak wymaganych uprawnień do zapisu pliku " + targetPath);
            return;
        }

        if (targetFile.exists() && !targetFile.delete()) {
            System.out.println("Nie można nadpisać pliku " + targetPath);
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
        }
    }

    private static void copyFromURL(String sourceURL, String targetPath) {
        try {
            URL url = new URL(sourceURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (InputStream in = connection.getInputStream();
                     OutputStream out = new FileOutputStream(targetPath)) {

                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = in.read(buffer)) > 0) {
                        out.write(buffer, 0, length);
                    }

                    System.out.println("Plik z URL został skopiowany pomyślnie.");
                }
            } else {
                System.out.println("Nie udało się pobrać pliku z URL. Kod odpowiedzi: " + responseCode);
            }
        } catch (UnknownHostException e) {
            System.out.println("Brak połączenia siecowego");
        } catch (MalformedURLException e) {
            System.out.println("Podany adres: "+ sourceURL + " jest nieprawidłowy");
        } catch (IOException e) {
            System.out.println("Brak dostępu do " + sourceURL);
        }
    }
}