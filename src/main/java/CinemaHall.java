import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CinemaHall {
    private String hallName;
    private List<Seat> seats;

    public CinemaHall(String hallName) {
        this.hallName = hallName;
        this.seats = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            if (i > 30 && i <= 40) {
                seats.add(new Seat(i, true));
            } else {
                seats.add(new Seat(i, false));
            }
        }
    }


    public boolean reserveSeat(int seatNumber, Customer customer) {
        return getSeatByNumber(seatNumber)
                .reserve(customer);
    }

    public boolean cancelReservation(int seatNumber) {
        return getSeatByNumber(seatNumber)
                .cancelReservation();
    }

    public Seat getSeatByNumber(int seatNumber){
        return seats.stream()
                .filter(s -> s.getSeatNumber() == seatNumber)
                .findFirst()
                .orElseThrow(()->new RuntimeException("Invalid seat number"));
    }

    public String getHallName() {
        return hallName;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
