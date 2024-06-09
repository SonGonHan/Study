import java.util.Stack;

public class UndoableStringBuilder {

    private final Stack<Commands> HISTORY;
    private final StringBuilder SB;

    private abstract class Commands {

        abstract void execute();

        abstract void unexecute();

        public void make_com() {
            execute();
            HISTORY.push(this);
        }

        public void undo() {
            unexecute();
            HISTORY.pop();
        }
    }

    public void undo() {
        if (!HISTORY.isEmpty()) {
            HISTORY.peek().undo();
        }
    }

    public UndoableStringBuilder() {
        SB = new StringBuilder();
        HISTORY = new Stack<>();
    }

    public UndoableStringBuilder(String Word) {
        SB = new StringBuilder(Word);
        HISTORY = new Stack<>();
    }

    public void append(String Word) {
        new app_com(Word).make_com();
    }

    protected class app_com extends Commands {

        private final String Word;

        protected app_com(String Word) {
            this.Word = Word;
        }

        @Override
        public void execute() {
            SB.append(Word);
        }

        @Override
        public void unexecute() {
            SB.delete(SB.length() - Word.length(), SB.length());
        }

    }

    public void insert(int idx, String Word) {
        new ins_com(idx, Word).make_com();
    }

    protected class ins_com extends Commands {

        private final String Word;
        private final int idx;

        protected ins_com(int idx, String Word) {
            this.idx = idx;
            this.Word = Word;
        }

        @Override
        public void execute() {
            SB.insert(idx, Word);
        }

        @Override
        public void unexecute() {
            SB.delete(idx, idx + Word.length());
        }
    }

    public void replace(int start, int end, String Word) {
        new rep_com(start, end, Word).make_com();
    }

    protected class rep_com extends Commands {

        private final String inserted_word, replaced_word;
        private final int start;
        private int end;

        protected rep_com(int start, int end, String Word) {
            this.start = start;
            this.end = end;
            this.inserted_word = Word;
            this.replaced_word = SB.substring(start, end);
        }

        @Override
        public void execute() {
            SB.replace(start, end, inserted_word);
            end = start + inserted_word.length();
        }

        @Override
        public void unexecute() {
            SB.replace(start, end, replaced_word);
        }
    }

    public void deleteCharAt(int idx) {
        new delChar_com(idx).make_com();
    }

    protected class delChar_com extends Commands {

        private final int idx;
        private final char c;

        protected delChar_com(int idx) {
            this.idx = idx;
            c = SB.charAt(idx);
        }

        @Override
        public void execute() {
            SB.deleteCharAt(idx);
        }

        @Override
        public void unexecute() {
            SB.insert(idx, c);
        }
    }

    public void delete(int start, int end) {
        new del_com(start, end).make_com();
    }

    protected class del_com extends Commands {

        private final int start, end;
        private final String Word;

        protected del_com(int start, int end) {
            this.start = start;
            this.end = end;
            Word = SB.substring(start, end);
        }

        @Override
        public void execute() {
            SB.delete(start, end);
        }

        @Override
        public void unexecute() {
            SB.insert(start, Word);
        }
    }

    public void reverse() {
        new rev_com().make_com();
    }

    protected class rev_com extends Commands {

        public rev_com() {
        }

        @Override
        public void execute() {
            SB.reverse();
        }

        @Override
        public void unexecute() {
            SB.reverse();
        }
    }

    public void setCharAt(int idx, char c) {
        new set_com(idx, c).make_com();
    }

    protected class set_com extends Commands {

        private final int idx;
        private final char old_c, new_c;

        public set_com(int idx, char c) {
            this.idx = idx;
            this.old_c = SB.charAt(idx);
            this.new_c = c;
        }

        @Override
        public void execute() {
            SB.setCharAt(idx, new_c);
        }

        @Override
        public void unexecute() {
            SB.setCharAt(idx, old_c);
        }
    }


    @Override
    public String toString() {
        return SB.toString();
    }

}
