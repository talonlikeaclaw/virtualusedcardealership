/**
 * Compare interface
 * 
 * @author Juan Badel Sebastian - 2338127
 * @version 11/18/2024
 */
package usedcardealership.comparators;
import usedcardealership.data.vehicle.Vehicle;

/**
 * Compares two Vehicles based on their price.
 * 
 * @param vehicle1 vehicle that gets compared to
 * @param vehicle2 vehicle to compare with
 * @return int: positive if vehicle1's price is greater or equals, negative if it's smaller
 */
public class VehiclePriceCompare extends VehicleCompare{
    @Override
    public int compareTo(Vehicle vehicle1, Vehicle vehicle2){
        if(vehicle1.getPrice() >= vehicle1.getPrice()){
            return 1;
        }
        return -1;
    }
}
