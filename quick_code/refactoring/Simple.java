import java.util.Enumeration;
import java.util.Vector;

class Movie {
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS   = 2;

    private String _title;
    private int    _priceCode;

    public Movie (String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);}

    public int getPriceCode () { // const
        return _priceCode;}

    public String getTitle () { // const
        return _title;}

    public void setPriceCode (int priceCode) {
        _priceCode = priceCode;}}

class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental (Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;}

    public int getDaysRented () { // const
        return _daysRented;}

    public Movie getMovie () { // const
        return _movie;}

    public double getCharge () {
        double total = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                total += 2;
                if (getDaysRented() > 2)
                    total += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                total += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                total += 1.5;
                if (getDaysRented() > 3)
                    total += (getDaysRented() - 3) * 1.5;
                break;}  
        return total;      
    }    

    public int getFrequentRenterPoints () {
        int frequentRenterPoints = 0;
        ++frequentRenterPoints;
            if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                (getDaysRented()           >  1))
                ++frequentRenterPoints;
        return frequentRenterPoints;
    }
}

class Customer {
    private String         _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer (String name) {
        _name = name;}

    public void addRental (Rental rental) {
        _rentals.addElement(rental);}

    public String getName () { // const
        return _name;}

    /**
     * Movie
     *     REGULAR
     *     NEW_RELEASE
     *     CHILDRENS
     * _rentals.elements().nextElement()
     *     getDaysRented()
     *     getMovie()
     *         getPriceCode()
     *         getTitle()
     */
    public String statement () { // O(n)
        String              result               = "Rental Record for " + getName() + "\n";
        Enumeration<Rental> rentals              = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each       = rentals.nextElement();

            result +=
                "\t" + each.getMovie().getTitle() +
                "\t" + String.valueOf(each.getCharge()) + "\n";}
        result +=
            "Amount owed is "                  +
            String.valueOf(getTotalAmount()) + "\n";
        result +=
            "You earned "                        +
            String.valueOf(getTotalFrequentRenterPoints()) +
            " frequent renter points";
        return result;
    }

    public int getTotalFrequentRenterPoints () {
        int frequentRenterPoints = 0;
                Enumeration<Rental> rentals              = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each       = rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount () {
        double totalAmount = 0;
        Enumeration<Rental> rentals              = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each       = rentals.nextElement();
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }
}

final class Simple {
    public static void main (String[] args) {


}}
