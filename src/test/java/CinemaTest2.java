import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CinemaHall - Given there is a Cinema Hall")
public class CinemaTest2 {

    @Nested
    @DisplayName("When we have a usual seat")
    class UsualSeatTest {

        @Test
        @DisplayName("Then you can not cancel reservaton")
        public void shouldCancelUsualReservation() {
            CinemaHall cinemaHall = new CinemaHall("MojeKino");
            cinemaHall.reserveSeat(15, new Customer("Bronisław", "Komorowski"));
            boolean result = cinemaHall.cancelReservation(15);
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("When we have a vip seat")
    class VipSeatTest {

        @Test
        @DisplayName("Then you can cancel your reservation")
        public void shouldCancelVipReservation() {
            CinemaHall cinemaHall = new CinemaHall("MojeKino");
            cinemaHall.reserveSeat(35, new Customer("Bronisław", "Komorowski"));
            boolean result = cinemaHall.cancelReservation(35);
            assertTrue(result);
        }

    }
    @Nested
    @DisplayName("When we have a CinemaHall operations available")
    class CinemaHallOperationsTestz {

        @Test
        @DisplayName("Then you can create cinema hall with the right name")
        public void shouldCreateCinemaHallWithCorrectName() {
            CinemaHall cinemaHall = new CinemaHall("MojeKino");
            assertEquals("MojeKino", cinemaHall.getHallName());
        }

        @Test
        @DisplayName("Then you should create cinema hall with empty seats")
        public void shouldCreateCinemaHallwithEmptySeats() {
            CinemaHall cinemaHall = new CinemaHall("MojeKino");
            assertEquals(50, cinemaHall.getSeats().size());
        }

        @Test
        @DisplayName("Then you should reserve available seat")
        public void shouldReeserveAvailableSeat() {
            CinemaHall cinemaHall1 = new CinemaHall("MojeKino");
            boolean result = cinemaHall1.reserveSeat(15,
                    new Customer("Bronisław", "Komorowski"));
            assertTrue(result);
        }

        @Test
        @DisplayName("Then should throw runtime exception when wrong seat number provided")
        public void shouldThrowExceptionWhenWrongSeatNumberProvided() {
            CinemaHall cinemaHall = new CinemaHall(("MojeKino"));
            assertThrows(RuntimeException.class,
                    () -> cinemaHall.reserveSeat(100,
                            new Customer("Bronisław", "Komorowski")));
        }

        @Test
        @DisplayName("Then you should not reserve already reserved seat")
        public void shouldNotReserveAlreadeReservedSeat() {
            CinemaHall cinemaHall = new CinemaHall("MojeKino");
            boolean result = cinemaHall.reserveSeat(15, new Customer("Bronisław", "Komorowski"));
            assertTrue(result);

            result = cinemaHall.reserveSeat(15, new Customer("Lech", "Wałęsa"));
            assertFalse(result);
        }
    }
}

