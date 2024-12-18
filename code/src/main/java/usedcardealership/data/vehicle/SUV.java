/**
 * Represents Sport Utility Vehicle objects.
 * 
 * @author Talon Dunbar - 2131651
 * @version 11/10/2024
 */

package usedcardealership.data.vehicle;

import usedcardealership.interaction.PrettyUtils;

public class SUV extends EnclosedVehicle {
    private boolean hasThirdRowSeating;

    /**
     * SUV Constructor
     * Initializes the SUV fields
     * 
     * @param type               the SUV's type
     * @param id                 the SUV's unique identifier
     * @param make               the company that makes the SUV
     * @param model              the name of the SUV's model
     * @param year               the year the SUV was released
     * @param price              the initial price of the SUV
     * @param color              the color of the SUV's paint
     * @param transmission       the type of transmission (Auto, Manual, CVT)
     * @param driveType          the drive type of the SUV
     * @param horsepower         the SUV's engine's horsepower
     * @param weight             the weight of the SUV
     * @param kilometerage       the number of kilometers the SUV has
     * @param damage             the damage of the SUV (00.00 - 100.00)
     * @param isElectric         if the SUV is electric of not
     * @param numSeats           the number of seats of the SUV
     * @param numDoor            the number of doors of the SUV
     * @param hasSunRoof         if the SUV has a sunroof or not
     * @param hasThirdRowSeating if the SUV has a third row of seats
     */
    public SUV(
            String type,
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
            boolean hasThirdRowSeating) {
        super(type, id, make, model, year, price, color, transmission, driveType, horsepower,
                weight, kilometerage, damage, isElectric, numSeats, numDoors, hasSunRoof);
        this.hasThirdRowSeating = hasThirdRowSeating;
    }

    /**
     * Copy constructor for SUV.
     * Creates a new SUV instance with the same values as the given SUV.
     * 
     * @param s the SUV to copy
     */
    public SUV(SUV s) {
        super(s);
        if (s == null) {
            throw new IllegalArgumentException("Cannot copy from a null SUV.");
        }
        this.hasThirdRowSeating = s.hasThirdRowSeating;
    }

    @Override
    public String getFullDetails() {
        return getCommonDetails() + "\n" +
                PrettyUtils.returnCyan("Third Row Seating: ") +
                (this.hasThirdRowSeating ? PrettyUtils.returnGreen("Yes") : PrettyUtils.returnRed("No"));
    }

    public boolean hasThirdRowSeating() {
        return this.hasThirdRowSeating;
    }

    /**
     * Returns an array of strings representing the fields of the SUV
     * for CSV conversion
     *
     * @return String[] representing the fields of the SUV
     */
    @Override
    public String[] toCSVFields() {
        return new String[] {
                getType(),
                String.valueOf(getID()),
                getMake(),
                getModel(),
                String.valueOf(getYear()),
                String.valueOf(getPrice()),
                getColor(),
                getTransmission(),
                getDriveType(),
                String.valueOf(getHorsepower()),
                String.valueOf(getWeight()),
                String.valueOf(getKilometerage()),
                String.valueOf(getDamage()),
                String.valueOf(isElectric()),
                String.valueOf(getNumSeats()),
                String.valueOf(getNumDoors()),
                String.valueOf(hasSunRoof()),
                String.valueOf(hasThirdRowSeating())
        };
    }
}