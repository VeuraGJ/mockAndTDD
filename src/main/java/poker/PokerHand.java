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
        Map<String,Integer> player1ToMap = new HashMap<>();
        Map<String,Integer> player2ToMap = new HashMap<>();
        for(PokerCard c : player1){
            if(player1ToMap.containsKey(c.getNumber())){
                player1ToMap.put(c.getNumber(),player1ToMap.get(c.getNumber())+1);
            }
            else{
                player1ToMap.put(c.getNumber(),1);
            }
        }
        for(PokerCard c : player2){
            if(player2ToMap.containsKey(c.getNumber())){
                player2ToMap.put(c.getNumber(),player2ToMap.get(c.getNumber())+1);
            }
            else {
                player2ToMap.put(c.getNumber(),1);
            }
        }
        String player1Pair = null;
        String player2Pair = null;
        for(String carNumber:player1ToMap.keySet()){
            if(player1ToMap.get(carNumber) == 2){
                player1Pair = carNumber;
            }
        }
        for(String carNumber:player2ToMap.keySet()){
            if(player2ToMap.get(carNumber) == 2){
                player2Pair = carNumber;
            }
        }
        if(player1Pair != null && player2Pair == null){
            return "player1 win";
        }else if(player1Pair == null && player2Pair != null){
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
