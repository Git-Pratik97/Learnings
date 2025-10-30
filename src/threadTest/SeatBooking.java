package threadTest;

public class SeatBooking {
    int availableSeats = 1;

    public synchronized void bookSeat(String name){
        if(availableSeats > 0){
            try{
                System.out.println(name + " got a available seat");
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.getMessage();
            }
            availableSeats--;
            System.out.println(name + " successfully booked a seat");
        }else{
            System.out.println(name + " did not find a seat");
        }
    }
}

class Threater{
    public static void main(String[] args) {
        SeatBooking seatBooking = new SeatBooking();
        Runnable book = () -> {
            seatBooking.bookSeat(Thread.currentThread().getName());
        };

        Thread t1 = new Thread(book, "Bob");
        Thread t2 = new Thread(book, "Alice");

        t1.start();
        t2.start();
    }
}
