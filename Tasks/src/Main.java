public class Main {

    public static void main(String[] args) {
        UndoableStringBuilder Test = new UndoableStringBuilder("ВХАВХЫАХЫВХАЫХВ");
        Test.insert(5, "_LMAO_");
        System.out.println(Test);
        Test.replace(5, 11, "...");
        System.out.println(Test);
        Test.undo();
        System.out.println(Test);
    }
}