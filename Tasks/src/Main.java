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
        Scanner console = new Scanner(System.in);
        System.out.print("Enter word: ");
        String found_word = (console.nextLine()).toLowerCase().strip();
        String[] words = Text.split(" ");
        int count = 0;
        for (String word : words) {
            word = word.replaceAll("\\pP", "").toLowerCase().strip();
            System.out.println(found_word + " " + word);
            if (word.equals(found_word)) {
                ++count;
            }
        }
        System.out.println(count);
        console.close();
    }
}