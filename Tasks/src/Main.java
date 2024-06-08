import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "D:/Projects/Java/Study/Tasks/text.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String Text = "", Line;
        while ((Line = reader.readLine()) != null) {
            Text += Line + " ";
        }
        Scanner console = new Scanner(System.in);
        System.out.print("Enter word: ");
        String Word = console.nextLine();
        Text = Text.replaceAll(Word, "***");
        System.out.println(Text);
    }
}
