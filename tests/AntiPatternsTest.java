import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AntiPatternsTest {
    @AfterAll
    static void tearDown() {
        End e = new End();
    }
    
    @Test
    void testTornamentName() throws ParseException, InvalidDateException {
        Tournament tournament = new Tournament("ESTGV tournament");
        assertEquals("ESTGV tournament",tournament.getName());
    }

    @Test
    void testPlayer() throws ParseException, InvalidDateException {
        Player player = new Player();
        player.setBornDate(29,4,2020);
        player.setNickname("just");
        assertEquals("just",player.getNickname());
    }

    @Test
    void testPlayerBornDate() throws ParseException, InvalidDateException {
        Player player = new Player();
        player.setBornDate(30,3,2020);

        assertEquals(30, player.getBornDay());
        assertEquals(3, player.getBornMonth());
        assertEquals(2020,player.getBornYear());
    }
}
