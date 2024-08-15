/*  
 * TCSS 305 Autumn 2022 
 * Assignment 3
 */
package model;
/** 
 * 
 * Makes abstract vehicle class to be the parent classes 
 * to represent many different ways of transportation on streets.
 *  
 * @author Christian David 
 * @version 14 Nov 2022 
 */
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public abstract class AbstractVehicle implements Vehicle {
    
    
    /** Creates an object to assort random.*/
    protected static final Random RAND = new Random();
    
    /** Orders the collection of objects.*/
    protected static final Comparator<Direction> SHUFFLE = 
            (theFirst, theSencond) -> RAND.nextInt();
   
            
    /** Creates an instance field for a X.*/
    private int myX;
    /** Creates an instance field for a Y.*/
    private int myY;
    /** Creates an instance field for Direction.*/
    private Direction myDirection;
    /** Creates an instance field for starting X.*/
    private final int myInitialX;
    /** Creates an instance field for starting Y.*/
    private final int myInitialY;    
    /** Creates an instance field for initial direction.*/
    private final Direction myInitialDirection;
    /** Creates an instance field for death timer.*/
    private final int myDeathTime;
    /** Creates an instance field for poke count.*/
    private int myPokeCount;
    /** Creates an instance field for if alive.*/
    private boolean myAlive;
    
    /** 
     * Creates a constructor for abstract 
     * vehicle for X, Y, direction and death
     * timer.
     * 
     * @param theX is the starting X position.
     * @param theY is the starting Y position.
     * @param theDirection gives the starting direction. 
     * @param theDeathTime gives amount of time a vehicle is dead for.
     */
    public AbstractVehicle(final int theX, final int theY, final Direction theDirection,
                           final int theDeathTime) {
        myInitialX = theX;
        myInitialY = theY;
        myInitialDirection = theDirection;
        myDeathTime = theDeathTime;
        reset();
    }
    /** 
     * Makes rules for vehicle if it can pass on that 
     * terrain or light.
     *  
     * @param theTerrain sets what terrain vehicle can pass on.
     * @param theLguht sets what light vehicle can pass on.
     */ 
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * Shows how a vehicle can move on the streets and on
     * what move it will perform on that terrain.
     * 
     * @param theNeighbors makes a map to set the direction and terrain.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * Finds if a vehicle has collided and check if its alive
     * and if dead sets a death timer for that vehicle. 
     * 
     * @param theOther check if vehicle has collided and determines its death.
     */
    @Override
    public void collide(final Vehicle theOther) {
        if (isAlive() && theOther.isAlive() && getDeathTime() >  theOther.getDeathTime()) {
            myAlive = false;
        }

    }
    
    /** Gets the image of vehicle and shows if dead when collided. */
    public String getImageFileName() { 
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName().toLowerCase(Locale.US));
        if (!isAlive()) {
            sb.append("_dead");
        }
        sb.append(".gif");
        return sb.toString();
    }

    /** 
     * Creates a method to return the death timer.
     * @return the death timer.
     */
    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    /** 
     * Creates a method to find a direction.
     * @return the direction of vehicle.
     */
    @Override
    public Direction getDirection() {
        return myDirection;
    }

    /** 
     * Creates a method to return position X.
     * @return the X position of vehicle. 
     */
    @Override
    public int getX() {
        return myX;
    }

    /** 
     * Creates a method to return position Y.
     * @return the Y position of vehicle. 
     */
    @Override
    public int getY() {
        return myY;
    }

    /** 
     * Creates a method to return if vehicle is alive .
     * @return the alive state of vehicle. 
     */
    @Override
    public boolean isAlive() {
        return myAlive;
    }

    /** 
     * Creates a method to return the increment of death timer
     * to return vehicle to alive state after timer. 
     */
    @Override
    public void poke() {
        myPokeCount++;
        if (myPokeCount == getDeathTime()) {
            myDirection = Direction.random();
            myPokeCount = 0;
            myAlive = true;
        }
    }

    /** 
     * Creates a method to reset everything and bring 
     * everything back to its initial state. 
     * 
     */
    @Override
    public void reset() {
        myX = myInitialX;
        myY = myInitialY;
        myDirection = myInitialDirection;
        myPokeCount = 0;
        myAlive = true;

    }
    
    /** sets the direction of vehicle. */ 
    @Override
    public void setDirection(final Direction theDirection) {
        myDirection = theDirection;

    }
    
    /** sets the X position of vehicle. */ 
    @Override
    public void setX(final int theX) {
        myX = theX;

    }
    
    /** sets the Y position of vehicle. */ 
    @Override
    public void setY(final int theY) {
        myY = theY;
    }


}
