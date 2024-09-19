package Levels;

import CollisionListeners.*;
import Entities.MovingGhostEnemy;
import Entities.VerticalMovingPlatforms;
import city.cs.engine.Shape;
import game.Game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * The first level of my game.
 * It defines all the layout, obstacles, and entities.
 */
public class Level1 extends GameLevel {
    float hue = 32.0f / 360.0f;
    float saturation = 52.0f / 100.0f;
    float brightness = 30.0f / 100.0f;


    /**
     * Constructs a Level1 object.
     * @param game The game instance.
     */
    public Level1(Game game) {
        super(game);

        int rgbColor = Color.HSBtoRGB(hue, saturation, brightness);

        //Creating ground platforms
        Shape groundShape1 = new BoxShape(9f, 10f);
        StaticBody ground1 = new StaticBody(this, groundShape1);
        ground1.setPosition(new Vec2(-20f, -25f));
        ground1.addImage(new BodyImage(("data/Level1/Ground.jpg"), 20));

        Shape groundShape2 = new BoxShape(9f, 10f);
        StaticBody ground2 = new StaticBody(this, groundShape2);
        ground2.setPosition(new Vec2(17f, -25f));
        ground2.addImage(new BodyImage(("data/Level1/Ground.jpg"), 20));

        Shape groundShape3 = new BoxShape(9f, 10f);
        StaticBody ground3 = new StaticBody(this, groundShape3);
        ground3.setPosition(new Vec2(-1.5f, -30));
        ground3.addImage(new BodyImage(("data/Level1/Ground.jpg"), 20));

        Shape groundShape4 = new BoxShape(9f, 10f);
        StaticBody ground4 = new StaticBody(this, groundShape4);
        ground4.setPosition(new Vec2(-38.5f, -30));
        ground4.addImage(new BodyImage(("data/Level1/Ground.jpg"), 20));

        Shape FinalPlatform = new BoxShape(60, 0.5f);
        StaticBody finalPlatform = new StaticBody(this, FinalPlatform);
        finalPlatform.setPosition(new Vec2(-10, -50));
        finalPlatform.setFillColor(new Color(rgbColor));

        // Adding platform type 1 (short)
        Vec2[] platformPositions1 = {
                new Vec2(-1, -10),
                new Vec2(8, -12),
        };

        for (Vec2 position : platformPositions1) {
            Shape platformShape1 = new BoxShape(1.5f, 0.75f);
            StaticBody platform1 = new StaticBody(this, platformShape1);
            platform1.setPosition(position);
            platform1.addImage(new BodyImage("data/Level1/Stone_plat.png", 1.5f));
        }

        Shape platformShape2_Deg = new BoxShape(3.5f, 0.8f);
        StaticBody platform2_Deg = new StaticBody(this, platformShape2_Deg);
        platform2_Deg.setPosition(new Vec2(-28.5f, 9));
        platform2_Deg.rotateDegrees(90);
        platform2_Deg.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        // Adding platform type 1 (long)
        Vec2[] platformPositions2 = {
                new Vec2(8, 5),
                new Vec2(15, 5),
                new Vec2(-17, 6),
                new Vec2(-24, 6),
        };


        for (Vec2 position : platformPositions2) {
            Shape platformShape2 = new BoxShape(3.5f, 0.8f);
            StaticBody platform2 = new StaticBody(this, platformShape2);
            platform2.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform2.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));
        }


        //Adding platform type 2 (long)
        Vec2[] platformPositions3 = {
                new Vec2(-10.5f, -12),
                new Vec2(-10.5f, -4),
                new Vec2(-1, 1),
        };


        for (Vec2 position : platformPositions3) {
            Shape platformShape3 = new BoxShape(2f, 0.75f);
            StaticBody platform3 = new StaticBody(this, platformShape3);
            platform3.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform3.addImage(new BodyImage("data/Level1/Platform_2.png", 1.5f));
        }

        //Adding platform type 2 (short)
        Vec2[] platformPositions4 = {
                new Vec2(-10, 6),
        };


        for (Vec2 position : platformPositions4) {
            Shape platformShape4 = new BoxShape(1.5f, 0.75f);
            StaticBody platform4 = new StaticBody(this, platformShape4);
            platform4.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform4.addImage(new BodyImage("data/Level1/Platform_1.png", 1.5f));
        }

        //Add moving platforms
        VerticalMovingPlatforms movingPlatforms1 = new VerticalMovingPlatforms(this, (new Vec2(-20, -12)), 0.03f, 3.5f, 0.8f);
        movingPlatforms1.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        MovingGhostEnemy movingGhost = new MovingGhostEnemy(this);
        movingGhost.setPosition(new Vec2(10, 7));

        // Movable crate
        Shape WoodenCrate = new BoxShape(1f, 1f);
        DynamicBody woodenCrate = new DynamicBody(this, WoodenCrate);
        woodenCrate.setPosition(new Vec2(-17, 7));
        woodenCrate.addImage(new BodyImage("data/Level1/WoodenBox.png", 2));

        // Obstacles
        Shape WaterObstacle = new BoxShape(9.5f, 10f);
        StaticBody waterObstacle = new StaticBody(this, WaterObstacle);
        waterObstacle.setPosition(new Vec2(-1.5f, -25));
        waterObstacle.addImage(new BodyImage("data/Level1/Water.jpg", 20));

        Shape WaterObstacle2 = new BoxShape(9.5f, 10f);
        StaticBody waterObstacle2 = new StaticBody(this, WaterObstacle2);
        waterObstacle2.setPosition(new Vec2(-38.5f, -25));
        waterObstacle2.addImage(new BodyImage("data/Level1/Water.jpg", 20));

        // Coins
        Vec2[] coinPositions = {
                new Vec2(-10.5f, -10),
                new Vec2(-10.5f, -2),
                new Vec2(-1, 3),
                new Vec2(-18, -14),
                new Vec2(-22, -14),
                new Vec2(14, -14),
                new Vec2(16, -14),
                new Vec2(18, -14),
                new Vec2(16, 10),
        };

        for (Vec2 position : coinPositions) {
            Shape CollectEnergy = new BoxShape(0.5f, 0.5f);
            StaticBody collectEnergy = new StaticBody(this, CollectEnergy);
            collectEnergy.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            collectEnergy.addImage(new BodyImage("data/Both/Coin.gif", 1f));
            CoinCollisionListener ecl = new CoinCollisionListener(getCharacter());
            collectEnergy.addCollisionListener(ecl);
        }

        // Gems
        Shape GemRed = new BoxShape(0.75f, 0.75f);
        StaticBody red = new StaticBody(this, GemRed);
        red.setPosition(new Vec2(-25f, 17));
        red.addImage(new BodyImage("data/Both/Red_gem.gif", 1.5f));

        Shape GemBlue = new BoxShape(0.75f, 0.75f);
        StaticBody blue = new StaticBody(this, GemBlue);
        blue.setPosition(new Vec2(16, 7));
        blue.addImage(new BodyImage("data/Both/Blue_gem.gif", 1.5f));

        Shape GemGreen = new BoxShape(0.75f, 0.75f);
        StaticBody green = new StaticBody(this, GemGreen);
        green.setPosition(new Vec2(-20, -14));
        green.addImage(new BodyImage("data/Both/Green_gem.gif", 1.5f));


        // Collisions
        WaterCollisionListener wcl = new WaterCollisionListener(getCharacter());
        waterObstacle.addCollisionListener(wcl);
        waterObstacle2.addCollisionListener(wcl);

        GhostCollisionListener scl = new GhostCollisionListener((getCharacter()));
        movingGhost.addCollisionListener(scl);

        GemCollisionListener gcl = new GemCollisionListener(getCharacter());
        red.addCollisionListener(gcl);
        blue.addCollisionListener(gcl);
        green.addCollisionListener(gcl);

        FlashlightCollisionListener fcl = new FlashlightCollisionListener(getCharacter());
        movingGhost.addCollisionListener(fcl);
    }

    /**
     * Method to add a platform to the level.
     */
    public void addPlatform() {
        Shape AddedPlatform = new BoxShape(2f, 0.75f);
        StaticBody addedPlatform = new StaticBody(this, AddedPlatform);
        addedPlatform.setPosition(new Vec2(-32, 13));
        addedPlatform.addImage(new BodyImage("data/Level1/Platform_2.png", 1.5f));
    }

    /**
     * Indicates whether the level is complete.
     * This method overrides the {@code isComplete()} method in the superclass which always returns {@code true}
     * @return {@code true} indicating the level is complete.
     */
    @Override
    public boolean isComplete() {
        return true;
    }
}