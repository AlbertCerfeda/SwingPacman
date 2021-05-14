package Entities;

import Map.Edge;
import Media.EImage;

/**
 * An entity that has an active presence in the Map and can collide with other Entities
 */
public class Entity extends Sprite {
    
    private Edge currEdge;
    private boolean colliding = true;
    
    /**
     * Initializes an Entity object.
     *
     * @param x  the x coordinate of the Sprite
     * @param y  the y coordinate of the Sprite
     * @param en the EImage ENUM for the image
     * @param currEdge the Edge in which the Entity is located
     */
    public Entity(int x, int y, EImage en, Edge currEdge){
        super(x, y, en);
        this.currEdge=currEdge;
    }
    
    public void onCollision(Entity e) {
    
    }
    
    ///////////////////
    // Setters and getters below
    
    public void setCurrEdge(Edge currEdge){
        this.currEdge=currEdge;
    }
    
    public Edge getCurrEdge(){
        return currEdge;
    }
}
