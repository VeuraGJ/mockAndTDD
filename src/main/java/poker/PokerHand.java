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
        List<Integer> sortedPlayer1 = getSortedCardList(player1);
        List<Integer> sortedPlayer2 = getSortedCardList(player2);
        if(isStraight(sortedPlayer1) && !isStraight(sortedPlayer2)){
            return "player1 win";
        }else if(!isStraight(sortedPlayer1) && isStraight(sortedPlayer2)){
            return "player2 win";
        }
        Map<Integer,Integer> player1ToMap = cardToMap(player1);
        Map<Integer,Integer> player2ToMap = cardToMap(player2);
        Integer threePair1 = getThreePairNumber(player1ToMap);
        Integer threePair2 = getThreePairNumber(player2ToMap);
        String result = compareTwoCard(threePair1,threePair2);
        if(!result.equals("peace")){
            return result;
        }
        List<Integer> player1PairCard = getPairCard(player1ToMap);
        List<Integer> player2PairCard = getPairCard(player2ToMap);
        result = compareTwoCard(player1PairCard.size(),player2PairCard.size());
        if(!result.equals("peace")){
            return result;
        }
        result = compareTwoList(player1PairCard,player2PairCard);
        if(!result.equals("peace")){
            return result;
        }
        result = compareTwoList(sortedPlayer1,sortedPlayer2);
        return result;
    }

    private boolean isStraight(List<Integer> sortedCards) {
        if(sortedCards.get(0)-sortedCards.get(sortedCards.size()-1) == 4){
            return true;
        }
        return  false;
    }

    private Integer getThreePairNumber(Map<Integer,Integer> cardToMap){
        for(Integer carNumber:cardToMap.keySet()){
            if(cardToMap.get(carNumber) == 3){
                return carNumber;
            }
        }
        return 0;
    }
    private String compareTwoList(List<Integer> list1,List<Integer> list2){
        String result = "peace";
        for(int i =0;i < list1.size();i++){
            result = compareTwoCard(list1.get(i),list2.get(i));
            if(!result.equals("peace")){
                return result;
            }
        }
        return result;
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
