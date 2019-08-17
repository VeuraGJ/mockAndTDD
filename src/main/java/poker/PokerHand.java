package poker;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand {

    public String play(List<PokerCard> player1, List<PokerCard> player2) {
        List<Integer> sortedPlayer1 = player1.stream()
                .map(pokerCard -> Integer.parseInt(pokerCard.getNumber()))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> sortedPlayer2 = player2.stream()
                .map(pokerCard -> Integer.parseInt(pokerCard.getNumber()))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for(int i =0;i < sortedPlayer1.size();i++){
            if(sortedPlayer1.get(i) > sortedPlayer2.get(i)){
                return "player1 win";
            }
            if(sortedPlayer1.get(i) < sortedPlayer2.get(i)){
                return "player2 win";
            }
        }
        return "peace";
    }
}
