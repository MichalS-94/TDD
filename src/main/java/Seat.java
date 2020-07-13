public class Seat {
    private int seatNumber;
    private boolean booked;
    private boolean vip;
    private Customer customer;

    public Seat(int seatNumber, boolean isVip) {
        this.seatNumber = seatNumber;
        this.vip = isVip;
    }

    public boolean cancelReservation() {
        if (!vip) {
            return false;
        }
        this.customer = null;
        this.booked = false;
        return true;

    }

    public boolean reserve(Customer customer) {
        if (booked) {
            return false;
        }
        this.booked = true;
        this.customer = customer;
        return true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean isVip() {
        return vip;
    }

    public Customer getCustomer() {
        return customer;
    }
}
