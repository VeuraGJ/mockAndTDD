package poker;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHand {

    private static Map<String,Integer> cardMap = null;

    public PokerHand() {
        cardMap = new HashMap<String,Integer>(){{
            put("T",10);
            put("J",11);
            put("Q",12);
            put("K",13);
            put("A",14);
        }};
    }

    public String play(List<PokerCard> player1, List<PokerCard> player2) {
        Map<Integer,Integer> player1ToMap = cardToMap(player1);
        Map<Integer,Integer> player2ToMap = cardToMap(player2);
        Integer player1Pair = -1;
        Integer player2Pair = -1;
        for(Integer carNumber:player1ToMap.keySet()){
            if(player1ToMap.get(carNumber) == 2){
                player1Pair = player1Pair > carNumber ? player1Pair:carNumber;
            }
        }
        for(Integer carNumber:player2ToMap.keySet()){
            if(player2ToMap.get(carNumber) == 2){
                player2Pair = player2Pair > carNumber ? player2Pair:carNumber;
            }
        }
        if(player1Pair > player2Pair){
            return "player1 win";
        }else if(player1Pair < player2Pair){
            return "player2 win";
        }
        List<Integer> sortedPlayer1 = getSortedCardList(player1);
        List<Integer> sortedPlayer2 = getSortedCardList(player2);
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
    private Map<Integer,Integer> cardToMap(List<PokerCard> cards){
        Map<Integer,Integer> pairMap = new HashMap<>();
        for(PokerCard c : cards){
            if(pairMap.containsKey(parseCardNumber(c))){
                pairMap.put(parseCardNumber(c),pairMap.get(parseCardNumber(c))+1);
            }
            else{
                pairMap.put(parseCardNumber(c),1);
            }
        }
        return pairMap;
    }
    private List<Integer> getSortedCardList(List<PokerCard> cards){
        return cards.stream()
                .map(pokerCard -> parseCardNumber(pokerCard))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
    private Integer parseCardNumber(PokerCard pokerCard){
        if(pokerCard.getNumber().compareTo("2")>=0 && pokerCard.getNumber().compareTo("9")<=0){
            return Integer.parseInt(pokerCard.getNumber());
        }
        return cardMap.get(pokerCard.getNumber());
    }
}
