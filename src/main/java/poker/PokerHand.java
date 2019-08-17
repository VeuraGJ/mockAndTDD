package poker;

import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {
    public String play(List<String> player1, List<String> player2) {
        List<String> sortedPlayer1 = player1.stream().sorted().collect(Collectors.toList());
        List<String> sortedPlayer2 = player2.stream().sorted().collect(Collectors.toList());
        return null;
    }
}
