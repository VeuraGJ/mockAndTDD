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
        Map<Integer,Integer> player1ToMap = cardToMap(player1);
        Map<Integer,Integer> player2ToMap = cardToMap(player2);
        Integer fourPair1 = getFourPairNumber(player1ToMap);
        Integer fourPair2 = getFourPairNumber(player2ToMap);
        Integer threePair1 = getThreePairNumber(player1ToMap);
        Integer threePair2 = getThreePairNumber(player2ToMap);
        List<Integer> player1PairCard = getPairCard(player1ToMap);
        List<Integer> player2PairCard = getPairCard(player2ToMap);
        String result = compareTwoCard(fourPair1,fourPair2);
        if(!result.equals("peace")){
            return result;
        }
       result = compareFlush(player1,player2);
        if(!result.equals("peace")){
            return result;
        }
        result = compareStraight(player1,player2);
        if(!result.equals("peace")){
            return result;
        }
        result = compareTwoCard(threePair1,threePair2);
        if(result.equals("player1 win")){
            if(player2PairCard.size()>0 && player1PairCard.size()==0 && threePair2 >0 ){
                return "player2 win";
            }
            return result;
        }
        if(result.equals("player2 win")){
            if(player1PairCard.size()>0 && player2PairCard.size()==0 && threePair1 >0){
                return "player1 win";
            }
            return result;
        }
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

    private boolean isFlush(List<PokerCard> pokerCards) {
        String type = pokerCards.get(0).getType();
        int sameTypeCount = pokerCards.stream()
                .filter(pokerCard -> pokerCard.getType().equals(type))
                .collect(Collectors.toList()).size();
        if(sameTypeCount == pokerCards.size()){
            return true;
        }
        return false;
    }
    private String compareFlush(List<PokerCard> pokerCards1,List<PokerCard> pokerCards2){
        Integer threePair1 = getThreePairNumber(cardToMap(pokerCards1));
        Integer threePair2 = getThreePairNumber(cardToMap(pokerCards2));
        List<Integer> player1PairCard = getPairCard(cardToMap(pokerCards1));
        List<Integer> player2PairCard = getPairCard(cardToMap(pokerCards2));
        if(isFlush(pokerCards1) && !isFlush(pokerCards2)){
            if(threePair2 != 0 && player2PairCard.size()>0){
                return "player2 win";
            }
            return "player1 win";
        }else if(!isFlush(pokerCards1) && isFlush(pokerCards2)){
            if(threePair1 != 0 && player1PairCard.size()>0){
                return "player1 win";
            }
            return "player2 win";
        }
        return "peace";
    }
    private String compareStraight(List<PokerCard> pokerCards1,List<PokerCard> pokerCards2){
        List<Integer> sortedPlayer1 = getSortedCardList(pokerCards1);
        List<Integer> sortedPlayer2 = getSortedCardList(pokerCards2);
        Map<Integer,Integer> player1ToMap = cardToMap(pokerCards1);
        Map<Integer,Integer> player2ToMap = cardToMap(pokerCards2);
        Integer threePair1 = getThreePairNumber(player1ToMap);
        Integer threePair2 = getThreePairNumber(player2ToMap);
        List<Integer> player1PairCard = getPairCard(player1ToMap);
        List<Integer> player2PairCard = getPairCard(player2ToMap);
        if(isStraight(sortedPlayer1) && !isStraight(sortedPlayer2)){
            if(threePair2 != 0 && player2PairCard.size()>0){
                return "player2 win";
            }
            return "player1 win";
        }else if(!isStraight(sortedPlayer1) && isStraight(sortedPlayer2)){
            if(threePair1 != 0 && player1PairCard.size()>0){
                return "player1 win";
            }
            return "player2 win";
        }
        return "peace";
    }
    private boolean isStraight(List<Integer> sortedCards) {
        if(sortedCards.get(0)-sortedCards.get(sortedCards.size()-1) == 4){
            return true;
        }
        return  false;
    }
    private Integer getFourPairNumber(Map<Integer,Integer> cardToMap){
        for(Integer carNumber:cardToMap.keySet()){
            if(cardToMap.get(carNumber) == 4){
                return carNumber;
            }
        }
        return 0;
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
