public class ObservableStringBuilder {

    private StringBuilder SB;
    private Observer Obs;

    public ObservableStringBuilder() {
        SB = new StringBuilder();
        Obs = new Observer();
    }

    private void notifyOSB  () {
        if (Obs != null) {
            Obs.update(this);
        }
    }

    public ObservableStringBuilder(String Word) {
        SB = new StringBuilder(Word);
        Obs = new Observer();
    }

    public void append(String Word) {
        SB.append(Word);
        notifyOSB();
    }

    public void insert(int idx, String Word) {
        SB.insert(idx, Word);
        notifyOSB();
    }

    public void replace(int start, int end, String Word) {
        SB.replace(start, end, Word);
        notifyOSB();
    }

    public void deleteCharAt(int idx) {
        SB.deleteCharAt(idx);
        notifyOSB();
    }

    public void delete(int start, int end) {
        SB.delete(start, end);
        notifyOSB();
    }

    public void reverse() {
        SB.reverse();
        notifyOSB();
    }

    public void setCharAt(int idx, char c) {
        SB.setCharAt(idx, c);
        notifyOSB();
    }

    @Override
    public String toString() {
        return SB.toString();
    }

}
