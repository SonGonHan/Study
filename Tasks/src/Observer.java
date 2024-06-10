class Observer implements Observer_interface {

    public void update(ObservableStringBuilder SB) {
        System.out.println("Изменен: " + SB);
    }
}
