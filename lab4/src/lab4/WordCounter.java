package lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Brak argumentów programu.");
            return;
        }

        String fileName = args[args.length - 1];

        boolean countLines = false;
        boolean countWords = false;
        boolean countChars = false;

        // Sprawdź argumenty i ustaw odpowiednie flagi
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-l":
                    countLines = true;
                    break;
                case "-w":
                    countWords = true;
                    break;
                case "-c":
                    countChars = true;
                    break;
                case "-lc", "-cl":
                    countLines = true;
                    countChars = true;
                    break;
                case "-lw", "-wl":
                    countLines = true;
                    countWords = true;
                    break;
                case "-wc", "-cw":
                    countWords = true;
                    countChars = true;
                    break;
                case "-lcw", "-clw", "-wcl", "-wlc":
                    countLines = true;
                    countWords = true;
                    countChars = true;
                    break;
                default:
                    break;
            }
        }

        int lines = 0;
        int words = 0;
        int chars = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();
                String[] wordList = line.split("\\s+");
                words += wordList.length;
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
        }

        if (countLines) {
            System.out.println("wierszy: " + lines);
        }
        if (countWords) {
            System.out.println("słów: " + words);
        }
        if (countChars) {
            System.out.println("znaków: " + chars);
        }
    }
}
