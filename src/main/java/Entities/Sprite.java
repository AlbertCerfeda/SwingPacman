package Entities;

import Media.*;
import Game.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A Entities.Sprite to be displayed on the game screen.
 */
public class Sprite extends JPanel {
    private int x;
    private int y;
    
    private EImage image;
    
    /**
     * The x and y axis offsets in order for the anchor point
     *  to be the center of the sprite at coordinates (0,0)
     */
    private int x_render_offset;
    private int y_render_offset;
    
    
    /**
     * Initializes a Entities.Sprite object.
     * @param x the x coordinate of the Entities.Sprite
     * @param y the y coordinate of the Entities.Sprite
     * @param en the EImage ENUM for the image
     */
    public Sprite(int x, int y, EImage en) {
        setImage(en);
        setPos(x,y);
        setOpaque(false);
    }
    
    /**
     * Paints the sprite in its swing Container.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Media.get(image), 0, 0, this); // see javadoc for more info on the parameters
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
    }
    
    /**
     * Handles the complete deletion and removal of this Entities.Sprite in the game.
     */
    public void removeSprite() {
        Game.painter().unregisterSprite(this);
    }
    
    /////////////////////////////
    // Getters and setters below
    
    public void setImage(EImage image){
        BufferedImage img = Media.get(image);
        setSize(img.getWidth(), img.getHeight());
        this.image = image;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int newX){
        x = newX - getWidth()/2;
    }
    
    public void setY(int newY){
        y = newY - getWidth()/2;
    }
    
    public void setPos(int newX, int newY) {
        setY(newY);
        setX(newX);
    }
    
}
