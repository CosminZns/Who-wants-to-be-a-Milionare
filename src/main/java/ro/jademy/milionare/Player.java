package ro.jademy.milionare;

public class Player {
    private String name;
    private int money;
    private boolean removeAnswers;

    public Player(String name, int money, boolean removeAnswers) {
        this.name = name;
        this.money = money;
        this.removeAnswers = removeAnswers;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean getRemoveAnswers() {
        return removeAnswers;
    }

    public void setRemoveAnswers(boolean removeAnswers) {
        this.removeAnswers = removeAnswers;
    }

}
