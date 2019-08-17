package poker;

import java.util.*;
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
        List<Integer> player1PairCard = getPairCard(player1ToMap);
        List<Integer> player2PairCard = getPairCard(player2ToMap);
        String result = compareTwoCard(player1PairCard.size(),player2PairCard.size());
        if(!result.equals("peace")){
            return result;
        }
        List<Integer> player1Pair = sortedPairCard(player1PairCard);
        List<Integer> player2Pair = sortedPairCard(player2PairCard);
        for(int i =0;i<player1Pair.size();i++){
            result = compareTwoCard(player1Pair.get(i),player2Pair.get(i));
            if(!result.equals("peace")){
                return result;
            }
        }
        List<Integer> sortedPlayer1 = getSortedCardList(player1);
        List<Integer> sortedPlayer2 = getSortedCardList(player2);
        for(int i =0;i < sortedPlayer1.size();i++){
            result = compareTwoCard(sortedPlayer1.get(i),sortedPlayer2.get(i));
           if(result.equals("peace")){
               continue;
           }else{
               return result;
           }
        }
        return "peace";
    }
    private String compareTwoCard(Integer card1Number,Integer card2Number){
        if(card1Number>card2Number){
            return "player1 win";
        }else if(card1Number<card2Number){
            return "player2 win";
        }else{
            return "peace";
        }
    }
    private List<Integer> getPairCard(Map<Integer,Integer> cardToMap){
        List<Integer> pairCard = new ArrayList<>();
        for(Integer carNumber:cardToMap.keySet()){
            if(cardToMap.get(carNumber) == 2){
                pairCard.add(carNumber);
            }
        }
        return pairCard;
    }
    private List<Integer> sortedPairCard(List<Integer> pairCard){
        return pairCard.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
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
