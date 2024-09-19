package Levels;

import CollisionListeners.*;
import Entities.HorizontalMovingPlatforms;
import Entities.MovingGhostEnemy;
import Entities.VerticalMovingPlatforms;
import Entities.VerticalMovingPlatforms;
import city.cs.engine.Shape;
import game.Game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * The third level of my game.
 * It defines all the layout, obstacles, and entities.
 */
public class Level3 extends GameLevel {
    float hue = 32.0f / 360.0f;
    float saturation = 52.0f / 100.0f;
    float brightness = 30.0f / 100.0f;

    /**
     * Constructs a Level3 object.
     * @param game The game instance.
     */
    public Level3(Game game) {
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

        Shape groundShape5 = new BoxShape(9f, 10f);
        StaticBody ground5 = new StaticBody(this, groundShape5);
        ground5.setPosition(new Vec2(-1.5f, -25));
        ground5.addImage(new BodyImage(("data/Level1/Ground.jpg"), 20));

        Shape FinalPlatform = new BoxShape(60, 0.5f);
        StaticBody finalPlatform = new StaticBody(this, FinalPlatform);
        finalPlatform.setPosition(new Vec2(-10, -50));
        finalPlatform.setFillColor(new Color(rgbColor));

        // Adding platform type 1 (short)
        Vec2[] platformPositions1 = {
                new Vec2(-13, -12),
                new Vec2(-17, -8),
                new Vec2(-21, -4),
        };

        for (Vec2 position : platformPositions1) {
            Shape platformShape1 = new BoxShape(1.5f, 0.75f);
            StaticBody platform1 = new StaticBody(this, platformShape1);
            platform1.setPosition(position);
            platform1.addImage(new BodyImage("data/Level1/Stone_plat.png", 1.5f));
        }

        // Adding platform type 1 (long)
        Vec2[] platformPositions2 = {
                new Vec2(-30, 7),
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
                new Vec2(-29, -2),
                new Vec2(-34, -2),
                new Vec2(-39, -2),
                new Vec2(-8, 4)
        };


        for (Vec2 position : platformPositions3) {
            Shape platformShape3 = new BoxShape(2.5f, 0.75f);
            StaticBody platform3 = new StaticBody(this, platformShape3);
            platform3.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform3.addImage(new BodyImage("data/Level1/Platform_2.png", 1.5f));
        }

        //Adding platform type 2 (short)
        Vec2[] platformPositions4 = {
                new Vec2(16, -4.5f),
                new Vec2(23, 3.5f),
        };


        for (Vec2 position : platformPositions4) {
            Shape platformShape4 = new BoxShape(1.5f, 0.75f);
            StaticBody platform4 = new StaticBody(this, platformShape4);
            platform4.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform4.addImage(new BodyImage("data/Level1/Platform_1.png", 1.5f));
        }

        //Add moving platforms
        VerticalMovingPlatforms movingPlatforms1 = new VerticalMovingPlatforms(this, (new Vec2(1, -2)), 0.03f, 3.5f, 0.8f);
        movingPlatforms1.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        VerticalMovingPlatforms movingPlatforms2 = new VerticalMovingPlatforms(this, (new Vec2(8, -2)), 0.03f, 3.5f, 0.8f);
        movingPlatforms2.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        HorizontalMovingPlatforms movingPlatforms3 = new HorizontalMovingPlatforms(this, (new Vec2(-23, 2)), 0.03f, 3.5f, 0.8f);
        movingPlatforms3.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        MovingGhostEnemy movingGhost = new MovingGhostEnemy(this);
        movingGhost.setPosition(new Vec2(-34, 4));

        MovingGhostEnemy movingGhost2 = new MovingGhostEnemy(this);
        movingGhost2.setPosition(new Vec2(5, 4));

        // Movable crate
//        Shape WoodenCrate = new BoxShape(1f, 1f);
//        DynamicBody woodenCrate = new DynamicBody(this, WoodenCrate);
//        woodenCrate.setPosition(new Vec2(-17, 7));
//        woodenCrate.addImage(new BodyImage("data/Level1/WoodenBox.png", 2));

        // Obstacles
        Shape WaterObstacle2 = new BoxShape(9.5f, 10f);
        StaticBody waterObstacle2 = new StaticBody(this, WaterObstacle2);
        waterObstacle2.setPosition(new Vec2(-38.5f, -25));
        waterObstacle2.addImage(new BodyImage("data/Level1/Water.jpg", 20));

        Shape SpikesObstacle = new BoxShape(1f, 0.5f);
        StaticBody spikesObstacle = new StaticBody(this, SpikesObstacle);
        spikesObstacle.setPosition(new Vec2(5, -14.5f));
        spikesObstacle.addImage(new BodyImage("data/Level2/Spikes.png", 1f));

        Shape SpikesObstacle2 = new BoxShape(1f, 0.5f);
        StaticBody spikesObstacle2 = new StaticBody(this, SpikesObstacle2);
        spikesObstacle2.setPosition(new Vec2(-2, -14.5f));
        spikesObstacle2.addImage(new BodyImage("data/Level2/Spikes.png", 1f));

        Shape SpikesObstacle3 = new BoxShape(1f, 0.5f);
        StaticBody spikesObstacle3 = new StaticBody(this, SpikesObstacle3);
        spikesObstacle3.setPosition(new Vec2(-9, -14.5f));
        spikesObstacle3.addImage(new BodyImage("data/Level2/Spikes.png", 1f));

        Shape Trampoline = new BoxShape(2f, 0.75f);
        StaticBody trampoline = new StaticBody(this, Trampoline);
        trampoline.setPosition(new Vec2(16, -4f));
        trampoline.addImage(new BodyImage("data/Level3/winter_tree_1.png", 1.5f));

        Shape Trampoline2 = new BoxShape(2f, 0.75f);
        StaticBody trampoline2 = new StaticBody(this, Trampoline2);
        trampoline2.setPosition(new Vec2(-32, 7.5f));
        trampoline2.addImage(new BodyImage("data/Level3/winter_tree_1.png", 1.5f));

        // Coins
        Vec2[] coinPositions = {
                new Vec2(12, -12),
                new Vec2(8, -12),
                new Vec2(4, -12),
                new Vec2(-7, -8),
                new Vec2(-9, -6),
        };

        for (Vec2 position : coinPositions) {
            Shape CollectCoins = new BoxShape(0.5f, 0.5f);
            StaticBody collectCoins = new StaticBody(this, CollectCoins);
            collectCoins.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            collectCoins.addImage(new BodyImage("data/Both/Coin.gif", 1f));
            CoinCollisionListener ecl = new CoinCollisionListener(getCharacter());
            collectCoins.addCollisionListener(ecl);
        }


        // Gems
        Shape GemRed = new BoxShape(0.75f, 0.75f);
        StaticBody red = new StaticBody(this, GemRed);
        red.setPosition(new Vec2(-32f, 11));
        red.addImage(new BodyImage("data/Both/Red_gem.gif", 1.5f));

        Shape GemBlue = new BoxShape(0.75f, 0.75f);
        StaticBody blue = new StaticBody(this, GemBlue);
        blue.setPosition(new Vec2(23, 6));
        blue.addImage(new BodyImage("data/Both/Blue_gem.gif", 1.5f));

        Shape GemGreen = new BoxShape(0.75f, 0.75f);
        StaticBody green = new StaticBody(this, GemGreen);
        green.setPosition(new Vec2(-37, 3));
        green.addImage(new BodyImage("data/Both/Green_gem.gif", 1.5f));


        // Collisions
        WaterCollisionListener wcl = new WaterCollisionListener(getCharacter());
        waterObstacle2.addCollisionListener(wcl);

        ObstacleCollisionListener ocl = new ObstacleCollisionListener(getCharacter());
        spikesObstacle.addCollisionListener(ocl);
        spikesObstacle2.addCollisionListener(ocl);
        spikesObstacle3.addCollisionListener(ocl);

        GhostCollisionListener scl = new GhostCollisionListener(getCharacter());
        movingGhost.addCollisionListener(scl);
        movingGhost2.addCollisionListener(scl);

        FlashlightCollisionListener fcl = new FlashlightCollisionListener(getCharacter());
        movingGhost.addCollisionListener(fcl);
        movingGhost2.addCollisionListener(fcl);

        GemCollisionListener gcl = new GemCollisionListener(getCharacter());
        red.addCollisionListener(gcl);
        blue.addCollisionListener(gcl);
        green.addCollisionListener(gcl);

        TrampolineCollisionListener tcl = new TrampolineCollisionListener(getCharacter());
        trampoline.addCollisionListener(tcl);
        trampoline2.addCollisionListener(tcl);
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
