package designPatterns.structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightDesipnPattern {
    public static void main(String[] args) {
        List<GamePillar> pillars = new ArrayList<>();

        //Shared image for pillars
        Pillar sharedPillar =  PillarFactory.getPillar("FlappyPillar.png");

        //Creating multiple pillars with unique positions and heights
        pillars.add(new GamePillar(100, 300, sharedPillar));
        pillars.add(new GamePillar(250, 400, sharedPillar));
        pillars.add(new GamePillar(400, 350, sharedPillar));
        pillars.add(new GamePillar(550, 450, sharedPillar));

        for(GamePillar pillar : pillars){
            pillar.render();
        }
    }
}

// FLyweight class : Shared pillar image (Shared State - Pillar image)
class Pillar {
    private final String image;

    public Pillar(String image){
        this.image = image;
    }

    public void draw(int x, int height){
        System.out.println("Drawing pillar ar X: " + x + " with height: " + height + " using pillar " + image);
    }
}

// Factory Class: Reuses pillar images (Manages shared objects)
class PillarFactory {
    private static final Map<String, Pillar> pillarMap = new HashMap<>();

    public static Pillar getPillar(String image){
        if(!pillarMap.containsKey(image)) {
            pillarMap.put(image, new Pillar(image));
            System.out.println("Loading new Pillar Image: " + image);
        }
        return pillarMap.get(image);
    }
}

//Context class - Stores Unique state - position and Height
class GamePillar {
    private final int x;
    private final int height;
    private final Pillar pillar;

    public GamePillar(int x, int height, Pillar pillar){
        this.x = x;
        this.height = height;
        this.pillar = pillar;
    }

    public void render() {
        pillar.draw(x, height);
    }
}
