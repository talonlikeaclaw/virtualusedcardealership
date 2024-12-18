/**
 * Vehicle Abstract type.
 * 
 * @author Talon Dunbar - 2131651
 * @version 11/10/2024
 */

package usedcardealership.data.vehicle;

import java.time.*;
import java.util.*;

import usedcardealership.interaction.PrettyUtils;

public abstract class Vehicle {
    private Random rng;
    private String type;
    private int id;
    private String make;
    private String model;
    private int year;
    private double price;
    private String color;
    private String transmission;
    private String driveType;
    private int horsepower;
    private double weight;
    private double kilometerage;
    private double damage;
    private boolean isElectric;

    /**
     * Vehicle Constructor
     * Initializes the Vehicle fields
     * 
     * @param type         the Vehicle's type
     * @param id           the Vehicle's unique identifier
     * @param make         the company that makes the Vehicle
     * @param model        the name of the Vehicle's model
     * @param year         the year the Vehicle was released
     * @param price        the initial price of the Vehicle
     * @param color        the color of the Vehicle's paint
     * @param transmission the type of transmission (Auto, Manual, CVT)
     * @param driveType    the drive type of the Vehicle (front wheel, all wheel)
     * @param horsepower   the Vehicle's engine's horsepower
     * @param weight       the weight of the Vehicle
     * @param kilometerage the number of kilometers the Vehicle has on the gauge
     * @param damage       the damage of the Vehicle (0.00 - 100.00)
     * @param isElectric   if the Vehicle is electric or not
     */
    public Vehicle(
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
            boolean isElectric) {
        if (type == null || type.length() == 0) {
            throw new IllegalArgumentException("Type cannot be null or empty.");
        }
        if (id < 1) {
            throw new IllegalArgumentException("ID must be positive integer.");
        }
        if (make == null || make.length() == 0) {
            throw new IllegalArgumentException("Make cannot be null or empty.");
        }
        if (model == null || model.length() == 0) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (year < 1886) {
            throw new IllegalArgumentException("Year must be 1886 or later.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (color == null || color.length() == 0) {
            throw new IllegalArgumentException("Color cannot be null or empty.");
        }
        if (transmission == null || transmission.length() == 0) {
            throw new IllegalArgumentException("Transmission cannot be null or empty.");
        }
        if (driveType == null || driveType.length() == 0) {
            throw new IllegalArgumentException("Drive type cannot be null or empty.");
        }
        if (horsepower <= 0) {
            throw new IllegalArgumentException("Horsepower cannot be negative.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        if (kilometerage < 0) {
            throw new IllegalArgumentException("Kilometrage cannot be negative.");
        }
        if (damage < 0 || damage > 100) {
            throw new IllegalArgumentException("Damage percentage must be between 0.00 and 100.00");
        }
        this.rng = new Random();
        this.type = type;
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.transmission = transmission;
        this.driveType = driveType;
        this.horsepower = horsepower;
        this.weight = weight;
        this.kilometerage = kilometerage;
        this.damage = damage;
        this.isElectric = isElectric;
    }

    /**
     * Copy constructor for Vehicle.
     * Creates a new Vehicle instance with the same values as the given Vehicle.
     * 
     * @param v the Vehicle to copy
     */
    public Vehicle(Vehicle v) {
        this(
                v.type,
                v.id,
                v.make,
                v.model,
                v.year,
                v.price,
                v.color,
                v.transmission,
                v.driveType,
                v.horsepower,
                v.weight,
                v.kilometerage,
                v.damage,
                v.isElectric);
        this.rng = new Random();
    }

    @Override
    public String toString() {
        return PrettyUtils.returnYellow("[" + this.id + "] ") + this.year + " " + this.color + " " + this.make + " " + this.model + "\n"
                + "Price: $" + String.format("%.2f", this.calculateTotalPrice()) + " | Transmission: " + this.transmission + ", "
                + this.driveType + " | Kilometrage: " + String.format("%.2f", this.kilometerage) + " km\n";
    }

    /**
     * Provides a formatted string containing the common details of the vehicle.
     * 
     * @return String - a formatted string with the vehicle's common details:
     * 
     *         ID: <vehicle id>
     *         Make: <vehicle make>
     *         Model: <vehicle model>
     *         Year: <vehicle year>
     *         Price: $<calculated total price>
     *         Color: <vehicle color>
     *         Transmission: <transmission type>
     *         Drive Type: <drive type>
     *         Horsepower: <horsepower>
     *         Weight: <weight> lbs
     *         Kilometerage: <kilometerage> km
     *         Damage: <damage>%
     *         Electric: <True/False>
     */
    public String getCommonDetails() {
        return getImportantDetails() +
                PrettyUtils.returnCyan("Color: ") + this.color + "\n" +
                PrettyUtils.returnCyan("Transmission: ") + this.transmission + "\n" +
                PrettyUtils.returnCyan("Drive Type: ") + this.driveType + "\n" +
                PrettyUtils.returnCyan("Horsepower: ") + String.valueOf(this.horsepower) + "\n" +
                PrettyUtils.returnCyan("Weight: ") + String.format("%.2f", this.weight) + " lbs\n" +
                PrettyUtils.returnCyan("Kilometerage: ") + String.format("%.2f", this.kilometerage) + " km\n" +
                PrettyUtils.returnCyan("Damage: ") + String.format("%.2f", this.damage) + "%\n" +
                PrettyUtils.returnCyan("Electric: ") + 
                (this.isElectric ? PrettyUtils.returnGreen("Yes") : PrettyUtils.returnRed("No"));
    }
    

    /**
     * Provides a formatted string containing the important details of the vehicle.
     * 
     * @return String - a formatted string with the vehicle's important details:
     * 
     *         ID: <vehicle id>
     *         Make: <vehicle make>
     *         Model: <vehicle model>
     *         Year: <vehicle year>
     *         Price: $<calculated total price>
     */
    public String getImportantDetails() {
        return PrettyUtils.returnCyan("\nType: ") + this.type + "\n" +
                PrettyUtils.returnCyan("ID: ") + String.valueOf(this.id) + "\n" +
                PrettyUtils.returnCyan("Make: ") + this.make + "\n" +
                PrettyUtils.returnCyan("Model: ") + this.model + "\n" +
                PrettyUtils.returnCyan("Year: ") + String.valueOf(this.year) + "\n" +
                PrettyUtils.returnCyan("Price: ") + "$" + String.format("%.2f", calculateTotalPrice()) + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vehicle) {
            Vehicle v = (Vehicle) o;
            return v.id == this.id;
        }
        return false;
    }

    public abstract String getFullDetails();

    public String getType() {
        return this.type;
    }

    public int getID() {
        return this.id;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getPrice() {
        return this.price;
    }

    public String getColor() {
        return this.color;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public String getDriveType() {
        return this.driveType;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getKilometerage() {
        return this.kilometerage;
    }

    public double getDamage() {
        return this.damage;
    }

    public boolean isElectric() {
        return this.isElectric;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        } else {
            this.price = price;
        }
    }

    /**
     * Adds kilometers to the Vehicle's kilometerage gauge.
     * 
     * @param kilometers - the amount of kilometers to add to the Vehicle's
     *                   kilometerage (must be positive)
     */
    public void addKilometerage(double kilometers) {
        if (kilometers >= 0) {
            this.kilometerage += kilometers;
        } else {
            throw new IllegalArgumentException("Kilometers must be greater than or equal to zero.");
        }
    }

    /**
     * Changes amount of damage to the Vehicle's damage modifier field.
     * 
     * @param damage - the amount of damage to add (postive or negative)
     */
    public void addDamage(double damage) {
        double newDamage = this.damage + damage;
        if (newDamage >= 0 && newDamage <= 100) {
            this.damage = newDamage;
        } else if (newDamage > 100) {
            this.damage = 100;
        } else {
            throw new IllegalArgumentException("Vehicle damage may not be below zero.");
        }
    }

    /**
     * Performs a virtual test drive for Vehicle with random chance of crashing.
     * Applies random damage and kilometerage to the Vehicle.
     */
    public void testDrive() {
        final double MAX_DAMAGE = 0.1;
        final double MAX_KILOMETER = 50.0;
        final double CRASH_PROBABILITY = 0.01;
        final double MAX_CRASH_DAMAGE = 90.0;
        final double MIN_CRASH_DAMAGE = 10.0;

        // Generate random damage and kilometers
        double randomDamage = rng.nextDouble() * MAX_DAMAGE;
        double randomKilometers = rng.nextDouble() * MAX_KILOMETER;
        randomDamage = Math.round(randomDamage * 100.0) / 100.0;
        randomKilometers = Math.round(randomKilometers * 100.0) / 100.0;

        // Check for crash
        boolean hasCrashed = rng.nextDouble() < CRASH_PROBABILITY;
        if (hasCrashed) {
            // Generate crash damage multiplier
            double multiplierRange = MAX_CRASH_DAMAGE - MIN_CRASH_DAMAGE;
            double crashAddition = MIN_CRASH_DAMAGE + (rng.nextDouble() * multiplierRange);
            randomDamage += crashAddition;
            randomDamage = Math.round(randomDamage * 100.0) / 100.0;
            PrettyUtils.printRed("\nYou crashed the vehicle during the test drive!");
            System.out.println("This caused " + String.format("%.2f", crashAddition) + "% additional damage.");
        }

        // Apply damage
        addDamage(randomDamage);
        addKilometerage(randomKilometers);

        PrettyUtils.printGreen("\nTest drive completed:");
        System.out.println("Damage applied: " + randomDamage + "%");
        System.out.println("Kilometers driven: " + randomKilometers + " km");
    }

    /**
     * Calculates the total price based on depreciation from age, mileage, and
     * damage.
     * 
     * @return the price of the vehicle after depreciation.
     */
    public double calculateTotalPrice() {
        return this.price - calculateDepreciation();
    }

    /**
     * Calculates depreciation based on damage, year, and mileage.
     * 
     * @return the amount of money to deduct from the Vehicle's price.
     *         If depreciation exceeds the Vehicle's price, returns the full price.
     */
    private double calculateDepreciation() {
        double totalDepreciation = 0.0;
        totalDepreciation += calculateAgeDepreciation();
        totalDepreciation += calculateKilometerageDepreciation();
        totalDepreciation += calculateDamageDepreciation();
        // Cap depreciation at the vehicle's full price
        return totalDepreciation >= this.price ? this.price : totalDepreciation;
    }

    /**
     * Calculates the depreciation based on the age of the vehicle.
     * 
     * @return the amount to deduct from the vehicle's price due to age.
     */
    private double calculateAgeDepreciation() {
        int currentYear = Year.now().getValue();
        final double AGE_DEPRECIATION_RATE = 0.02;
        return (currentYear - this.year) * AGE_DEPRECIATION_RATE * this.price; // 5% per year
    }

    /**
     * Calculates the depreciation based on the vehicle's kilometerage .
     * 
     * @return the amount to deduct from the vehicle's price due to kilometerage.
     */
    private double calculateKilometerageDepreciation() {
        final double KILOMETER_DEPRECIATION_RATE = 0.02;
        return this.kilometerage * KILOMETER_DEPRECIATION_RATE; // $0.02 per kilometer
    }

    /**
     * Calculates the depreciation based on the vehicle's damage percentage.
     * 
     * @return the amount to deduct from the vehicle's price due to damage.
     */
    private double calculateDamageDepreciation() {
        final double DAMAGE_DEPRECIATION_RATE = 0.50;
        return (this.damage / 100) * this.price * DAMAGE_DEPRECIATION_RATE; // 50% impact of damage on price
    }

    /**
     * Returns an array of strings representing the fields of the vehicle
     * for CSV conversion
     *
     * @return String[] representing the fields of the vehicle
     */
    public abstract String[] toCSVFields();
}