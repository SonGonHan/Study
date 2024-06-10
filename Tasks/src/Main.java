public class Main {

    public static void main(String[] args) {
        ObservableStringBuilder Test = new ObservableStringBuilder("ВХАВХЫАХЫВХАЫХВ");
        Test.insert(5, "_LMAO_");
        Test.replace(5, 11, "...");
    }
}