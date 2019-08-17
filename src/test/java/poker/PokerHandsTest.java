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
    @Test
    public void should_return_player1_win_when_given_2H_5S_4D_KC_KD_and_9D_3S_3H_2D_KH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("5S"),new PokerCard("4D"),new PokerCard("KS"),new PokerCard("KH"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("3S"),new PokerCard("3H"),new PokerCard("2D"),new PokerCard("KH")));
        //then
        Assert.assertEquals("player1 win",acutalResult);

    }
    @Test
    public void should_return_player2_win_when_given_2H_5S_4D_KC_KD_and_9D_KS_3H_2D_KH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("5S"),new PokerCard("4D"),new PokerCard("KS"),new PokerCard("KH"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("KS"),new PokerCard("3H"),new PokerCard("2D"),new PokerCard("KH")));
        //then
        Assert.assertEquals("player2 win",acutalResult);

    }
    @Test
    public void should_return_player1_win_when_given_2H_2S_4D_KC_KD_and_9D_AS_3H_2D_AH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("2S"),new PokerCard("4D"),new PokerCard("KS"),new PokerCard("KH"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("AS"),new PokerCard("3H"),new PokerCard("2D"),new PokerCard("AH")));
        //then
        Assert.assertEquals("player1 win",acutalResult);

    }
    @Test
    public void should_return_player2_win_when_given_2H_2S_4D_AC_AD_and_9D_AS_3H_3D_AH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("2S"),new PokerCard("4D"),new PokerCard("AC"),new PokerCard("AD"))
                ,Arrays.asList(new PokerCard("9D"),new PokerCard("AS"),new PokerCard("3H"),new PokerCard("3D"),new PokerCard("AH")));
        //then
        Assert.assertEquals("player2 win",acutalResult);

    }
    @Test
    public void should_return_player1_win_when_given_2H_2S_9D_AC_AD_and_4D_AS_2H_2D_AH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("2S"),new PokerCard("9D"),new PokerCard("AC"),new PokerCard("AD"))
                ,Arrays.asList(new PokerCard("4D"),new PokerCard("AS"),new PokerCard("2H"),new PokerCard("2D"),new PokerCard("AH")));
        //then
        Assert.assertEquals("player1 win",acutalResult);

    }
    @Test
    public void should_return_player1_win_when_given_2H_2S_9D_2C_6D_and_4D_AS_4H_7D_AH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("2S"),new PokerCard("9D"),new PokerCard("2C"),new PokerCard("6D"))
                ,Arrays.asList(new PokerCard("4D"),new PokerCard("AS"),new PokerCard("4H"),new PokerCard("7D"),new PokerCard("AH")));
        //then
        Assert.assertEquals("player1 win",acutalResult);

    }
    @Test
    public void should_return_player2_win_when_given_2H_2S_9D_2C_6D_and_4D_4S_4H_7D_AH(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("2S"),new PokerCard("9D"),new PokerCard("2C"),new PokerCard("6D"))
                ,Arrays.asList(new PokerCard("4D"),new PokerCard("4S"),new PokerCard("4H"),new PokerCard("7D"),new PokerCard("AH")));
        //then
        Assert.assertEquals("player2 win",acutalResult);

    }
    @Test
    public void should_return_player2_win_when_given_2H_2S_9D_2C_6D_and_2C_3S_4H_5D_6H(){
        //given
        PokerHand pokerHand = new PokerHand();
        //when
        String acutalResult = pokerHand.play(Arrays.asList(new PokerCard("2H"),new PokerCard("2S"),new PokerCard("9D"),new PokerCard("2C"),new PokerCard("6D"))
                ,Arrays.asList(new PokerCard("2C"),new PokerCard("3S"),new PokerCard("4H"),new PokerCard("5D"),new PokerCard("6H")));
        //then
        Assert.assertEquals("player2 win",acutalResult);

    }

}
