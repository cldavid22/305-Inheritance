/*  
 * TCSS 305 Autumn 2022 
 * Assignment 3
 */
package model;
/** 
 * 
 * Makes child class of a vehicle that is 
 * extends the abstract vehicle class 
 * it shows the rules of and movement of a Human.
 *  
 * @author Christian David 
 * @version 14 Nov 2022 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Human extends AbstractVehicle {
    
    /** Creates an instance field for a final death timer.*/
    private static final int DEATH_TIME = 45;
    
    
    /** 
     * Creates a constructor for Human
     * that takes in a X and Y position
     * the direction of a Human and 
     * its death timer. 
     * 
     * 
     * @param theX is the starting X position for Human.
     * @param theY is the starting Y position for Human.
     * @param theDirection gives the direction for Human. 
     */
    public Human(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection, DEATH_TIME);     
    }
    
    
    /**
     * Creates a method to make rules of what terrain and lights
     * a Human can travel on.
     * 
     * @param theTerrain shows what terrain Human can move on .
     * @param theLight shows what light Human can pass.
     * 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.GRASS
            || theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN;
    }
        
    /**
     * Creates a method to determine how a Human moves on terrains 
     * and how it interprets lights on the street.
     * 
     * @param theNeighbors makes a map assigning the direction and terrain Human will take.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction dir = getDirection().reverse();
        final ArrayList<Direction> dirlist = new ArrayList<>();
        final List<Terrain> validter = Arrays.asList
                (Terrain.CROSSWALK, Terrain.GRASS);
        for (Direction z: theNeighbors.keySet()) {
            if (theNeighbors.get(z) == Terrain.CROSSWALK && z != getDirection().reverse()) {
                return z;
            }
            if (validter.contains(theNeighbors.get(z)) && z != getDirection().reverse()) {
                dirlist.add(z);
            }  
        }
        Collections.shuffle(dirlist);
        for (Direction x : dirlist) {
            dir = x; 
        }
        
        return dir;
    }
}