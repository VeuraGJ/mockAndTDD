package poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PokerHandsTest {
    @Test
    public void should_return_player2_win_when_given_2H_3D_5S_7C_8D_and_2S_3C_5D_7S_9D(){
        //given
        List<String> player1 = Arrays.asList("2H","3D","5S","7C","8D");
        List<String> player2 = Arrays.asList("2S","3C","5D","7S","9D");
        PokerHand pokerHand = new PokerHand();
        //when
        String result1 = pokerHand.play(player1,player2);
        String result2 = pokerHand.play(player2,player1);
        //then
        Assert.assertEquals("player2 win",result1);
        Assert.assertEquals("player1 win",result2);

    }
}
