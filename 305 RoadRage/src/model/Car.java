/*  
 * TCSS 305 Autumn 2022 
 * Assignment 3
 */
package model;
/** 
 * 
 * Makes child class of a vehicle that is 
 * extends the abstract vehicle class 
 * it shows the rules of and movement of a Car.
 *  
 * @author Christian David 
 * @version 14 Nov 2022 
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Car extends AbstractVehicle {

    /** Creates an instance field for a final death timer.*/
    private static final int DEATH_TIME = 15;

    /** 
     * Creates a constructor for car
     * that takes in a X and Y position
     * the direction of a car and 
     * its death timer. 
     * 
     * 
     * @param theX is the starting X position for car.
     * @param theY is the starting Y position for car.
     * @param theDirection gives the direction for car. 
     */
    public Car(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);
    }

    /**
     * Creates a method to make rules of what terrain and lights
     * a car can travel on.
     * 
     * @param theTerrain shows what terrain car can drive on .
     * @param theLight shows what light car can pass.
     * 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET
                 || theTerrain == Terrain.LIGHT && theLight != Light.RED
                 || theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN;
    }

    /**
     * Creates a method to determine how a car moves on terrains 
     * and how it interprets lights on the street.
     * 
     * @param theNeighbors makes a map assigning the direction and terrain car will take.
     */
  
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction dir = getDirection().reverse();
        final List<Terrain> validter = Arrays.asList
                (Terrain.STREET, Terrain.LIGHT, Terrain.CROSSWALK);
        if (validter.contains(theNeighbors.get(getDirection()))) {
            dir = getDirection();
        } else if (validter.contains(theNeighbors.get(getDirection().left()))) {
            dir = getDirection().left();
        } else if (validter.contains(theNeighbors.get(getDirection().right()))) {
            dir = getDirection().right();
        }
        return dir;
    }
}