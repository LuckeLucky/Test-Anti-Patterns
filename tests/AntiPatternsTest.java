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
    void testPlayerAndTornamentName() throws ParseException, InvalidDateException {
        Player player = new Player();
        player.setBornDate(29,4,2020);
        player.setNickname("just");
        assertEquals("just",player.getNickname());

        Tournament tournament = new Tournament("test tournament");
        tournament.setName("ESTGV tournament");
        assertEquals("ESTGV tournament",tournament.getName());
    }

    @Test
    void testPlayerBornDate() throws ParseException, InvalidDateException, NoSuchFieldException, IllegalAccessException {
        Player player = new Player();
        player.setBornDate(30,3,2020);

        Field fieldBornDay = player.getClass().getDeclaredField("bornDay");
        fieldBornDay.setAccessible(true);

        assertEquals(30,(int)fieldBornDay.get(player));

        assertEquals(3, player.getBornMonth());
        assertEquals(2020,player.getBornYear());
    }



}
