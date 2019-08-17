package poker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHand {

    private static Map<String,Integer> cardMap = new HashMap<String,Integer>(){{
        put("T",10);
        put("J",11);
        put("Q",12);
        put("K",13);
        put("A",14);
    }};
    public String play(List<PokerCard> player1, List<PokerCard> player2) {
        List<Integer> sortedPlayer1 = player1.stream()
                .map(pokerCard -> parseCardNumber(pokerCard))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> sortedPlayer2 = player2.stream()
                .map(pokerCard -> parseCardNumber(pokerCard))
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
    private Integer parseCardNumber(PokerCard pokerCard){
        if(pokerCard.getNumber().compareTo("2")>=0 && pokerCard.getNumber().compareTo("9")<=0){
            return Integer.parseInt(pokerCard.getNumber());
        }
        return cardMap.get(pokerCard.getNumber());
    }
}
