import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaTest {

    @Test
    public void shouldCreateCinemaHallWithCorrectName() {
        CinemaHall cinemaHall = new CinemaHall("MojeKino");
        assertEquals("MojeKino", cinemaHall.getHallName());
    }

    @Test
    public void shouldCreateCinemaHallwithEmptySeats() {
        CinemaHall cinemaHall = new CinemaHall("MojeKino");
        assertEquals(50, cinemaHall.getSeats().size());
    }

    @Test
    public void shouldReeserveAvailableSeat() {
        CinemaHall cinemaHall1 = new CinemaHall("MojeKino");
        boolean result = cinemaHall1.reserveSeat(15,
                new Customer("Bronisław", "Komorowski"));
        assertTrue(result);
    }

    @Test
    public void shoouldThrowExceptionWhenWrongSeatNumberProvided() {
        CinemaHall cinemaHall = new CinemaHall(("MojeKino"));
        assertThrows(RuntimeException.class,
                () -> cinemaHall.reserveSeat(100,
                        new Customer("Bronisław", "Komorowski")));
    }

    @Test
    public void shouldNotReserveAlreadeReservedSeat() {
        CinemaHall cinemaHall = new CinemaHall("MojeKino");
        boolean result = cinemaHall.reserveSeat(15, new Customer("Bronisław", "Komorowski"));
        assertTrue(result);

        result = cinemaHall.reserveSeat(15, new Customer("Lech", "Wałęsa"));
        assertFalse(result);
    }

    @Test
    public void shouldCancelUsualReservation() {
        CinemaHall cinemaHall = new CinemaHall("MojeKino");
        cinemaHall.reserveSeat(15, new Customer("Bronisław", "Komorowski"));
        boolean result = cinemaHall.cancelReservation(15);
        assertFalse(result);
    }

    @Test
    public void shouldCancelVipReservation() {
        CinemaHall cinemaHall = new CinemaHall("MojeKino");
        cinemaHall.reserveSeat(35, new Customer("Bronisław", "Komorowski"));
        boolean result = cinemaHall.cancelReservation(35);
        assertTrue(result);
    }
}

