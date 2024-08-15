/*  
 * TCSS 305 Autumn 2022 
 * Assignment 3
 */
package model;
/** 
 * 
 * Makes child class of a vehicle that is 
 * extends the abstract vehicle class 
 * it shows the rules of and movement of a Bicycle.
 *  
 * @author Christian David 
 * @version 14 Nov 2022 
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Bicycle extends AbstractVehicle {

    /** Creates an instance field for a final death timer.*/
    private static final int DEATH_TIME = 35;

    /** 
     * Creates a constructor for car
     * that takes in a X and Y position
     * the direction of a bicycle and 
     * its death timer. 
     * 
     * 
     * @param theX is the starting X position for bicycle.
     * @param theY is the starting Y position for bicycle.
     * @param theDirection gives the direction for bicycle. 
     */
    public Bicycle(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);
    }

    /**
     * Creates a method to make rules of what terrain and lights
     * a bicycle can travel on.
     * 
     * @param theTerrain shows what terrain bicycle can drive on .
     * @param theLight shows what light bicycle can pass.
     * 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET
                 || theTerrain == Terrain.TRAIL
                 || theTerrain == Terrain.LIGHT && theLight == Light.GREEN
                 || theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN;
 
    }

    /**
     * Creates a method to determine how a bicycle moves on terrains 
     * and how it interprets lights on the street.
     * 
     * @param theNeighbors makes a map assigning the direction and terrain bicycle will take.
     */
  
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction dir = getDirection().reverse();
        final List<Terrain> validter = Arrays.asList
                (Terrain.CROSSWALK, Terrain.TRAIL, Terrain.LIGHT, Terrain.STREET);
        
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            return getDirection();
        }
        if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            return getDirection().right();
        }
        if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            return getDirection().left();
        }
        if (validter.contains(theNeighbors.get(getDirection()))) {
            return getDirection();
        }
        if (validter.contains(theNeighbors.get(getDirection().left()))) {
            return getDirection().left();
        }
        if (validter.contains(theNeighbors.get(getDirection().right()))) {
            return getDirection().right();
        }
        return dir;
    }
}
        

