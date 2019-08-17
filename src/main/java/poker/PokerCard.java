package poker;

public class PokerCard {
    private String number;
    private String type;
    public PokerCard(String s) {
        this.number = s.substring(0,1);
        this.type = s.substring(1,2);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
