package tamingbadcode.testfirst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ben
 * Date: 13-12-26
 * Time: 下午6:30
 * To change this template use File | Settings | File Templates.
 */
@RunWith(JUnit4.class)
public class HotelWorldClockTest {
    @Test
    public void WHEN_BeijingIsSetToNineOclock() {
        // Given
        DeskClerk deskClerk = new DeskClerk();
        deskClerk.addCityClock("Beijing", new BeijingClock(8));
        deskClerk.addCityClock("London", new LondonClock(0));
        deskClerk.addCityClock("Moscow", new MoscowClock(4));
        deskClerk.addCityClock("Sydney", new SydneyClock(10));
        deskClerk.addCityClock("NewYork", new NewYorkClock(-5));

        // When
        deskClerk.setLocalTimeToCityClock(9, "Beijing");

        // Then
        assertEquals("Failure - the local time of Beijing should be 9"
                , 9, deskClerk.getCityClock("Beijing").getLocalTime());
        assertEquals("Failure - the local time of London should be 1"
                , 1, deskClerk.getCityClock("London").getLocalTime());
        assertEquals("Failure - the local time of Moscow should be 5"
                , 5, deskClerk.getCityClock("Moscow").getLocalTime());
        assertEquals("Failure - the local time of Sydney should be 11"
                , 11, deskClerk.getCityClock("Sydney").getLocalTime());
        assertEquals("Failure - the local time of New York should be 20"
                , 20, deskClerk.getCityClock("NewYork").getLocalTime());
    }
}