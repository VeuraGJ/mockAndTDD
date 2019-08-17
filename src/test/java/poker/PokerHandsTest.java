package poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerHandsTest {
    @Test
    public void should_return_player2_win_when_given_2H_5S_4D_8S_6H_and_9D_3S_5H_2D_7H(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("5S"),new PokerCard("4D"),new PokerCard("8S"),new PokerCard("6H"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("3S"),new PokerCard("5H"),new PokerCard("2D"),new PokerCard("7H")));
        //then
        Assert.assertEquals("player2 win",acutalResult);

    }
    @Test
    public void should_return_player1_win_when_given_2H_5S_4D_8S_AH_and_9D_3S_5H_2D_KH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("5S"),new PokerCard("4D"),new PokerCard("8S"),new PokerCard("AH"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("3S"),new PokerCard("5H"),new PokerCard("2D"),new PokerCard("KH")));
        //then
        Assert.assertEquals("player1 win",acutalResult);

    }
    @Test
    public void should_return_player2_win_when_given_2H_5S_4D_8S_AH_and_9D_3S_3H_2D_KH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("5S"),new PokerCard("4D"),new PokerCard("8S"),new PokerCard("AH"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("3S"),new PokerCard("3H"),new PokerCard("2D"),new PokerCard("KH")));
        //then
        Assert.assertEquals("player2 win",acutalResult);

    }
}
