package OODesign;

import java.time.LocalDateTime;
import java.util.*;

class Seat {
    private int seatNumber;
}

class User {
    private String Name;
    private UserType userType;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}

enum UserType {
    CHILD, ADULT, STUDENT;
}

class Movie {
    private String movieName;
    private LocalDateTime movieTime;
    private int movieScreenNumber;
    private List<Seat> seatList = new ArrayList<>();
    private int totalSeatCapacity;
    private String movieIdentifier;
    private int movieTicketPrice;

    Movie(int capacity, String movieName, int movieScreenNumber) {
        this.totalSeatCapacity = capacity;
        this.movieName = movieName;
        this.movieScreenNumber = movieScreenNumber;
    }

    public boolean isSeatsAvailable() {
        return totalSeatCapacity > seatList.size();
    }

    public boolean bookSeat(User user) {
        return false;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(LocalDateTime movieTime) {
        this.movieTime = movieTime;
    }

    public int getMovieScreenNumber() {
        return movieScreenNumber;
    }

    public void setMovieScreenNumber(int movieScreenNumber) {
        this.movieScreenNumber = movieScreenNumber;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public int getTotalSeatCapacity() {
        return totalSeatCapacity;
    }

    public void setTotalSeatCapacity(int totalSeatCapacity) {
        this.totalSeatCapacity = totalSeatCapacity;
    }

    public String getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(String movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }

    public int getMovieTicketPrice() {
        return movieTicketPrice;
    }

    public void setMovieTicketPrice(int movieTicketPrice) {
        this.movieTicketPrice = movieTicketPrice;
    }
}

class CinemaHall {
    private String hallName;
    private Map<String, Movie> moviesList = new HashMap<>();

    public boolean bookTicket(String movieName, User user) {
        return false;
    }

    public boolean cancelTicket(String movieName, User user) {
        return false;

    }
}

interface PaymentService {
    public int transactionID = new Random().nextInt(10);
    public int getPrice(int moviePrice,User user);
    public void payAmount(int price);

}

class Student implements PaymentService {

    public int getPrice(int moviePrice, User user) {
        return moviePrice-10;
    }
    public void payAmount(int price){
        System.out.println("Student-Success");
    }
}

class Adult implements PaymentService {

    public int getPrice(int moviePrice, User user) {
        return moviePrice;
    }
    public void payAmount(int price){
        System.out.println("Adult-Success");
    }
}

class Child implements PaymentService {

    public int getPrice(int moviePrice, User user) {
        return moviePrice - 30;
    }

    @Override
    public void payAmount(int price) {
        System.out.println("Child-Success");
    }
}

public class MovieTicketBookingSystem {
    private Map<String, CinemaHall> cinemaHallMap = new HashMap<>();

    public boolean bookTicket(String cinemaHallName, String movieName, User user) {

        return false;
    }

    public boolean cancelTicket(String cinemaHallName, String movieName, User user) {
        return false;
    }

    public boolean checkout(Movie movie,User user) {
        int price = 0;
        PaymentService ps;
        switch (user.getUserType()){
            case ADULT:
                ps = new Adult();
                price = ps.getPrice(movie.getMovieTicketPrice(),user);
                ps.payAmount(price);
            case CHILD:
                ps = new Child();
                price = ps.getPrice(movie.getMovieTicketPrice(),user);
                ps.payAmount(price);
            case STUDENT:
                ps = new Student();
                price = ps.getPrice(movie.getMovieTicketPrice(),user);
                ps.payAmount(price);
        }
        return true;
    }
}
