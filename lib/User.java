package lib;

public class User {
    private final int UserId;
    private double money=0;
    public User(int UserId, double money){
        this.UserId = UserId;
        this.money = money;
    }
    public int getUserId() {
        return UserId;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
}
