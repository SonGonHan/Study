import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "D:/Projects/Java/Study/Tasks/text.txt";
        Scanner reader = new Scanner(new File(path));
        String Text = "";

        while (reader.hasNextLine()) {
            Text += reader.nextLine() + " ";
        }
        reader.close();

        Text = Text.replaceAll("\\pP", "").toUpperCase().
                replaceAll(" ", "").replaceAll("Ё", "Е");

        int[] letter_rate = new int[32];
        for (char c : Text.toCharArray()) {
            letter_rate[c - 'А']++;
        }

        for (int i = 0; i < 32; i++) {
            System.out.println((char)(i + 'А') + ": " + letter_rate[i]);
        }
    }
}