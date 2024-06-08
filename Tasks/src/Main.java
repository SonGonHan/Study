import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "D:/Projects/Java/Study/Tasks/text.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String Text = "", Line;
        while ((Line = br.readLine()) != null) {
            Text += Line + " ";
        }
        Text = Text.strip();
        String[] Words = Text.split(" ");
        int max_idx = 0;
        for (int idx = 0; idx < Words.length; idx++) {
            Words[idx] = Words[idx].replaceAll("\\pP", "");
            if (Words[max_idx].length() < Words[idx].length()) {
                max_idx = idx;
            }
        }
        System.out.println(Words[max_idx]);
    }
}
