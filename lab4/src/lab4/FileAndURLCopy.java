package lab4;
import java.io.*;
import java.net.*;

public class FileAndURLCopy {
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("Sposób użycia: java FileAndURLCopy <adres_URL> [<nazwa_pliku_docelowego>]");
            return;
        }

        String sourceURL = args[0];
        String destinationFile = "";

        if (args.length == 2) {
            destinationFile = args[1];
        } else {
            try {
                URL url = new URL(sourceURL);
                String[] pathSegments = url.getPath().split("/");
                destinationFile = pathSegments[pathSegments.length - 1];
            } catch (MalformedURLException e) {
                System.out.println("Podany adres: '" + sourceURL + "' jest nieprawidłowy.");
                return;
            }
        }

        try {
            URL url = new URL(sourceURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(destinationFile);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();
                System.out.println("Plik skopiowany pomyślnie jako: " + destinationFile);
            } else {
                System.out.println("Brak dostępu do '" + sourceURL + "'. Kod odpowiedzi: " + responseCode);
            }
        } catch (MalformedURLException e) {
            System.out.println("Podany adres: '" + sourceURL + "' jest nieprawidłowy.");
        } catch (IOException e) {
            System.out.println("Brak połączenia sieciowego.");
        }
    }
}