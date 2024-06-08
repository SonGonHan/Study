import java.util.Scanner;

public class Main {

    public static String check(String word) {
        for (int i = 0; i < word.length() / 2; ++i) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner console_in = new Scanner(System.in);
        String word;
        while (!(word = console_in.nextLine()).isEmpty()) {
            System.out.println(check(word));
        }
        console_in.close();
    }
}
