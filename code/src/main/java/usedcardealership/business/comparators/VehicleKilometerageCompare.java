/**
 * Compare interface
 * 
 * @author Juan Badel Sebastian - 2338127
 * @version 11/18/2024
 */
package usedcardealership.business.comparators;

import usedcardealership.data.vehicle.Vehicle;

/**
 * Compares two Vehicles based on their kilometerage.
 * 
 * @param vehicle1 vehicle that gets compared to
 * @param vehicle2 vehicle to compare with
 * @return int: positive if vehicle1's kilometerage is greater or equals,
 *         negative if it's smaller
 */
public class VehicleKilometerageCompare extends VehicleCompare {
    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2)  {
        if (vehicle1 == null || vehicle2 == null) {
            throw new IllegalArgumentException("Vehicles cannot be null.");
        }
        if  (vehicle1.getKilometerage() > vehicle2.getKilometerage())  {
            return 1;
        } else if (vehicle1.getKilometerage() < vehicle2.getKilometerage()) {
            return -1;
        } else {
            return 0;
        }
    }
}
