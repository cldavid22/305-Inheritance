/*  
 * TCSS 305 Autumn 2022 
 * Assignment 3
 */
package model;
/** 
 * 
 * Makes child class of a vehicle that is 
 * extends the abstract vehicle class 
 * it shows the rules of and movement of a Truck.
 *  
 * @author Christian David 
 * @version 14 Nov 2022 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Truck extends AbstractVehicle {
    
    /** Creates an instance field for a final death timer.*/
    private static final int DEATH_TIME = 0;
    
    
    /** 
     * Creates a constructor for truck
     * that takes in a X and Y position
     * the direction of a truck and 
     * its death timer. 
     * 
     * 
     * @param theX is the starting X position for truck.
     * @param theY is the starting Y position for truck.
     * @param theDirection gives the direction for truck. 
     */
    public Truck(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);     
    }
    
    /**
     * Creates a method to make rules of what terrain and lights
     * a truck can travel on.
     * 
     * @param theTerrain shows what terrain truck can drive on .
     * @param theLight shows what light truck can pass.
     * 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET
            || theTerrain == Terrain.LIGHT
            || theTerrain == Terrain.CROSSWALK && theLight != Light.RED;
    }
        
    /**
     * Creates a method to determine how a truck moves on terrains 
     * and how it interprets lights on the street.
     * 
     * @param theNeighbors makes a map assigning the direction and terrain truck will take.
     */
    
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction dir = getDirection().reverse();
        final ArrayList<Direction> dirlist = new ArrayList<>();
        final List<Terrain> validter = Arrays.asList
                (Terrain.STREET, Terrain.LIGHT, Terrain.CROSSWALK);
        if (validter.contains(theNeighbors.get(getDirection()))) {
            dirlist.add(getDirection());
        }
        if (validter.contains(theNeighbors.get(getDirection().left()))) {
            dirlist.add(getDirection().left());
        }
        if (validter.contains(theNeighbors.get(getDirection().right()))) {
            dirlist.add(getDirection().right());
        }
        Collections.shuffle(dirlist);
        for (Direction x : dirlist) {
            dir = x;
        }
        return dir;
    }
} 
