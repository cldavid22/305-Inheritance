/*  
 * TCSS 305 Autumn 2022 
 * Assignment 3
 */
package model;
/** 
 * 
 * Makes child class of a vehicle that is 
 * extends the abstract vehicle class 
 * it shows the rules of and movement of a Taxi.
 *  
 * @author Christian David 
 * @version 14 Nov 2022 
 */

public class Taxi extends Car {

    /** Creates an instance field for a final wait time.*/
    private int myWaitTime;
    
    /** 
     * Creates a constructor for taxi
     * that takes in a X and Y position
     * the direction of a taxi and 
     * its death timer. 
     * 
     * 
     * @param theX is the starting X position for taxi.
     * @param theY is the starting Y position for taxi.
     * @param theDirection gives the direction for taxi. 
     */
    public Taxi(final int theX, final int theY, final Direction theDirection) {
        super(theX, theY, theDirection);
        myWaitTime = 0;
    }

    
    /**
     * Creates a method to make rules of what terrain and lights
     * a taxi can travel on.
     * 
     * @param theTerrain shows what terrain taxi can drive on .
     * @param theLight shows what light taxi can pass.
     * 
     */
   
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        final int i = 3;
        if (theTerrain == Terrain.LIGHT && theLight == Light.RED) {
            return false; 
        }
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            myWaitTime++;
            return myWaitTime == i;
        }
        myWaitTime = 0;
        return true;
    }



}
