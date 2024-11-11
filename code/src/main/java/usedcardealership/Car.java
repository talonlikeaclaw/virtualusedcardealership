/**
 * Represents Car objects.
 * 
 * @author Talon Dunbar - 2131651
 * @version 11/10/2024
 */

package usedcardealership;

public class Car extends EnclosedVehicle {
    private boolean isConvertible;

    /**
     * Car Constructor
     * Initializes the Car fields
     * 
     * @param id            the Car's unique identifier
     * @param make          the company that makes the Car
     * @param model         the name of the Car's model
     * @param year          the year the Car was released
     * @param price         the initial price of the Car
     * @param color         the color of the Car's paint
     * @param transmission  the type of transmission (Auto, Manual, CVT)
     * @param driveType     the drive type of the Car
     * @param horsepower    the Car's engine's horsepower
     * @param weight        the weight of the Car
     * @param kilometerage  the number of kilometers the Car has
     * @param damage        the damage of the Car (00.00 - 100.00)
     * @param isElectric    if the Car is electric of not
     * @param numSeats      the number of seats of the Car
     * @param numDoor       the number of doors of the Car
     * @param hasSunRoof    if the Car has a sunroof or not
     * @param isConvertible if the Car is able to remove roof
     */
    public Car(
            int id,
            String make,
            String model,
            int year,
            double price,
            String color,
            String transmission,
            String driveType,
            int horsepower,
            double weight,
            double kilometerage,
            double damage,
            boolean isElectric,
            int numSeats,
            int numDoors,
            boolean hasSunRoof,
            boolean isConvertible) {
        super(id, make, model, year, price, color, transmission, driveType, horsepower,
                weight, kilometerage, damage, isElectric, numSeats, numDoors, hasSunRoof);
        this.isConvertible = isConvertible;
    }

    /**
     * Copy constructor for Car.
     * Creates a new Car instance with the same values as the given Car.
     * 
     * @param c the Car to copy
     */
    public Car(Car c) {
        super(c);
        this.isConvertible = c.isConvertible;
    }

    @Override
    public String toString() {
        return "Type: Car\n" +
                getCommonDetails() + "\n" +
                "Convertible: " + (this.isConvertible ? "Yes" : "No");
    }

    public boolean isConvertible() {
        return this.isConvertible;
    }
}