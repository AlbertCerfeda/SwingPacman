package Entities;

import Map.Edge;
import Media.EAudio;
import Media.EImage;
import Settings.*;

public class LargeFood extends Food {
    public LargeFood(int x, int y, Edge currEdge){
        super(x, y, EImage.large_food, currEdge, (int)Settings.get(EParam.large_food_score));
    }
    
    @Override
    public void onCollision(Entity e){
        super.onCollision(e);
        Game.Game.audioengine().playIfNotAlready(EAudio.large_food, null);
        //TODO: Makes Ghosts vulnerable
    }
}
