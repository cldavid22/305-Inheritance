/*
 * TCSS 305 - Road Rage
 */
package tests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Direction;
import model.Human;
import model.Light;
import model.Terrain;
import model.Truck;

import org.junit.jupiter.api.Test;
/**
 * Unit tests for class Truck.
 * 
 * @author Christian David
 * @version 14 Nov 2022
 */
public class TruckTest {

    private static final int TRIES_FOR_RANDOMNESS = 50;
    
    @Test
    public void testHumanConstructor() {
        final Truck t  = new Truck(10, 11, Direction.NORTH);
        
        assertEquals(10, t.getX(), "Truck x coordinate not initialized correctly!");
        assertEquals(11, t.getY(), "Truck y coordinate not initialized correctly!");
        assertEquals(Direction.NORTH, t.getDirection(), "Truck direction not initialized correctly!");
        assertEquals(0, t.getDeathTime(), "Truck death time not initialized correctly!");
        assertTrue(t.isAlive(), "Truck isAlive() fails initially!");
    }
    
    /** Test method for Human setters. */
    @Test
    public void testTruckSetters() {
        final Truck t = new Truck(10, 11, Direction.NORTH);
        
        t.setX(12);
        assertEquals(12, t.getX(), "Truck setX failed!");
        t.setY(13);
        assertEquals(13, t.getY(), "Truck setY failed!");
        t.setDirection(Direction.SOUTH);
        assertEquals(Direction.SOUTH, t.getDirection(), "Truck setDirection failed!");
    }


    @Test
    public void testChooseDirectionSurroundedByStreets() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, 
Terrain>();
        neighbors.put(Direction.WEST, Terrain.STREET);
        neighbors.put(Direction.NORTH, Terrain.STREET);
        neighbors.put(Direction.EAST, Terrain.STREET);
        neighbors.put(Direction.SOUTH, Terrain.STREET);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck t = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = t.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue(seenWest && seenNorth && seenEast,
                   "Truck chooseDirection() fails to select randomly "
                           + "among all possible valid choices!");
            
        assertFalse(seenSouth, "Truck chooseDirection() reversed direction when not necessary!");
    }
    @Test
    public void testChooseDirectionSurroundedByLights() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, 
Terrain>();
        neighbors.put(Direction.WEST, Terrain.LIGHT);
        neighbors.put(Direction.NORTH, Terrain.LIGHT);
        neighbors.put(Direction.EAST, Terrain.LIGHT);
        neighbors.put(Direction.SOUTH, Terrain.LIGHT);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck t = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = t.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue(seenWest && seenNorth && seenEast,
                   "Truck chooseDirection() fails to select randomly "
                           + "among all possible valid choices!");
            
        assertFalse(seenSouth, "Truck chooseDirection() reversed direction when not necessary!");
    }
    
    @Test
    public void testChooseDirectionSurroundedByCrosswalks() {
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, 
Terrain>();
        neighbors.put(Direction.WEST, Terrain.CROSSWALK);
        neighbors.put(Direction.NORTH, Terrain.CROSSWALK);
        neighbors.put(Direction.EAST, Terrain.CROSSWALK);
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        final Truck t = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = t.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.NORTH) {
                seenNorth = true;
            } else if (d == Direction.EAST) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue(seenWest && seenNorth && seenEast,
                   "Truck chooseDirection() fails to select randomly "
                           + "among all possible valid choices!");
            
        assertFalse(seenSouth, "Truck chooseDirection() reversed direction when not necessary!");
    }

    @Test
    public void testChooseDirectionOnGrassMustReverse() {
        
        for (final Terrain t : Terrain.values()) {
            if (t != Terrain.STREET && t != Terrain.LIGHT && t != Terrain.CROSSWALK) {
                
                final Map<Direction, Terrain> neighbors = new HashMap<Direction, 
Terrain>();
                neighbors.put(Direction.WEST, t);
                neighbors.put(Direction.NORTH, t);
                neighbors.put(Direction.EAST, t);
                neighbors.put(Direction.SOUTH, Terrain.GRASS);
                
                final Truck tr = new Truck(0, 0, Direction.NORTH);
                
                // the Human must reverse and go SOUTH
                assertEquals(Direction.SOUTH, tr.chooseDirection(neighbors),
                             "Truck chooseDirection() failed "
                                     + "when reverse was the only valid choice!");
            }
            
        }

            }
        
    @Test
    public void testCanPass() {  
            final List<Terrain> validTerrain = new ArrayList<>();
            validTerrain.add(Terrain.STREET);
            validTerrain.add(Terrain.CROSSWALK);
            validTerrain.add(Terrain.LIGHT);
                    
            final Truck tr = new Truck(0, 0, Direction.NORTH);

    }
}



    


