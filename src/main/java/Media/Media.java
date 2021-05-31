package Media;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import javax.imageio.ImageIO;

/**
 *  Contains all the media files needed to display the game.
 */
public class Media {
    static private EnumMap<EImage, BufferedImage> img;
    static private EnumMap<EAudio, File> sfx;
    
    /**
     * Imports the media files.
     *  Throws an Exception if a media file can't be found
     */
    static {
        try{
            importMedia();
        } catch (IOException e){
            System.out.println("[-] Could not import media resources.");
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the image object associated with its key.
     * @param eimage the EImage ENUM key
     * @return the image
     */
    public static BufferedImage getImg(EImage eimage) {
        return img.get(eimage);
    }
    
    /**
     * Returns the File object associated with its key.
     * @param eaudio the EAudio ENUM key
     * @return the sfx File
     */
    public static File getSfx(EAudio eaudio) {
        return sfx.get(eaudio);
    }
    
    /**
     * Imports the media files in the class.
     */
    static private void importMedia() throws IOException  {
    
        EnumMap<EImage, BufferedImage> newImage = new EnumMap<>(EImage.class);
        EnumMap<EAudio, File> newSfx = new EnumMap<>(EAudio.class);
    
        newImage.put(EImage.pacman, ImageIO.read(new File("./src/main/resources/img/pacman.png")));
    
        newImage.put(EImage.ghost1, ImageIO.read(new File("./src/main/resources/img/ghost1.png")));
        newImage.put(EImage.ghost2, ImageIO.read(new File("./src/main/resources/img/ghost2.png")));
        newImage.put(EImage.ghost3, ImageIO.read(new File("./src/main/resources/img/ghost3.png")));
        newImage.put(EImage.ghost4, ImageIO.read(new File("./src/main/resources/img/ghost4.png")));
        newImage.put(EImage.ghost_vuln, ImageIO.read(new File("./src/main/resources/img/ghost_vuln.png")));

        newImage.put(EImage.large_food, ImageIO.read(new File("./src/main/resources/img/large_food.png")));
        newImage.put(EImage.small_food, ImageIO.read(new File("./src/main/resources/img/small_food.png")));

        newImage.put(EImage.live, ImageIO.read(new File("./src/main/resources/img/live.png")));
        
        ////////////////////
        // Audio
        newSfx.put(EAudio.placeholder, new File("./src/main/resources/sfx/ding.wav").getAbsoluteFile());
        
        newSfx.put(EAudio.ghost_moving, new File("./src/main/resources/sfx/ghost_moving.wav").getAbsoluteFile());
        newSfx.put(EAudio.ghost_vulnerable, new File("./src/main/resources/sfx/placeholder.wav").getAbsoluteFile());
        newSfx.put(EAudio.small_food, new File("./src/main/resources/sfx/small_food.wav").getAbsoluteFile());
        newSfx.put(EAudio.large_food, new File("./src/main/resources/sfx/large_food.wav").getAbsoluteFile());
        newSfx.put(EAudio.ghost_vulnerable_end, new File("./src/main/resources/sfx/placeholder.wav").getAbsoluteFile());
        newSfx.put(EAudio.round_start, new File("./src/main/resources/sfx/round_start.wav").getAbsoluteFile());
        newSfx.put(EAudio.death_sound, new File("./src/main/resources/sfx/death_sound.wav").getAbsoluteFile());
    
        img= newImage;
        sfx = newSfx;
    }
    
    /**
     * Scales all the images by a factor.
     * @param scale the scale factor of the new images
     */
    static public void rescaleMedia(double scale) {
        try{
            importMedia();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        for (EImage img: img.keySet()) {
            BufferedImage originalImage = getImg(img);
            Media.img.replace(img, scaleImg(originalImage,scale));
        }
    }
    
    private static BufferedImage scaleImg(BufferedImage img, double scale) {
        int targetWidth = (int)(img.getWidth()*scale);
        int targetHeight = (int) (img.getHeight()*scale);
    
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(img, 0, 0, targetWidth, targetHeight, null);
        
        return resizedImage;
    }
    
    /**
     * Getter method for the EnumMap.
     * @return the img EnumMap
     */
    public static EnumMap<EImage, BufferedImage> getImgMap() {
        return img;
    }
    /**
     * Getter method for the EnumMap.
     * @return the sfx EnumMap
     */
    public static EnumMap<EAudio, File> getSfxMap() {
        return sfx;
    }
    
}
