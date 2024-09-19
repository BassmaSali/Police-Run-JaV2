package Levels;

import CollisionListeners.*;
import Entities.MovingGhostEnemy;
import Entities.VerticalMovingPlatforms;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Game;
import org.jbox2d.common.Vec2;

/**
 * The second level of my game.
 * It defines all the layout, obstacles, and entities.
 */
public class Level2 extends GameLevel {


    /**
     * Constructs a Level2 object.
     * @param game The game instance.
     */
    public Level2(Game game) {
        super(game);

        // Adding platform type 1 (short; grey)
        Vec2[] platformPositions1 = {
                new Vec2(-31, -8)
        };

        for (Vec2 position : platformPositions1) {
            Shape platformShape1 = new BoxShape(1.5f, 0.75f);
            StaticBody platform1 = new StaticBody(this, platformShape1);
            platform1.setPosition(position);
            platform1.addImage(new BodyImage("data/Level1/Stone_plat.png", 1.5f));
        }

        // Adding platform type 2 (long; grey)
        Vec2[] platformPositions2 = {
                new Vec2(5, -12),
                new Vec2(-2, -12),
                new Vec2(-19, 2),
                new Vec2(-12, 2),
                new Vec2(13, 4),
        };


        for (Vec2 position : platformPositions2) {
            Shape platformShape2 = new BoxShape(3.5f, 0.8f);
            StaticBody platform2 = new StaticBody(this, platformShape2);
            platform2.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform2.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));
        }


        //Adding platform type 2 (long; brown)
        Vec2[] platformPositions3 = {
                new Vec2(-20, -11),
                new Vec2(2, -1),
        };

        for (Vec2 position : platformPositions3) {
            Shape platformShape3 = new BoxShape(2f, 0.75f);
            StaticBody platform3 = new StaticBody(this, platformShape3);
            platform3.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform3.addImage(new BodyImage("data/Level1/Platform_2.png", 1.5f));
        }

        //Adding platform type 2 (short; brown)
        Vec2[] platformPositions4 = {
                new Vec2(1.5f, -8),
                new Vec2(-7, -5),

        };

        for (Vec2 position : platformPositions4) {
            Shape platformShape4 = new BoxShape(1.5f, 0.75f);
            StaticBody platform4 = new StaticBody(this, platformShape4);
            platform4.setPosition(position);
            //platform.setFillColor(new Color(rgbColor));
            platform4.addImage(new BodyImage("data/Level1/Platform_1.png", 1.5f));
        }

        Shape Tree = new BoxShape(1.5f, 2.5f);
        StaticBody tree = new StaticBody(this, Tree);
        tree.setPosition(new Vec2(21, -13));
        tree.addImage(new BodyImage("data/Level2/jungle_tree_9.png", 5f));

        //Add moving platforms
        VerticalMovingPlatforms movingPlatforms2 = new VerticalMovingPlatforms(this, new Vec2(-25, -9), 0.03f, 1.5f, 0.75f);
        movingPlatforms2.addImage(new BodyImage("data/Level1/Platform_1.png", 1.5f));

        VerticalMovingPlatforms movingPlatforms3 = new VerticalMovingPlatforms(this, new Vec2(-26, 4), 0.03f, 3.5f, 0.8f);
        movingPlatforms3.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        MovingGhostEnemy movingGhost = new MovingGhostEnemy(this);
        movingGhost.setPosition(new Vec2(-15.5f, 4));

//        // Movable crate
//        Shape WoodenCrate = new BoxShape(1f,1f);
//        DynamicBody woodenCrate = new DynamicBody(this, WoodenCrate);
//        woodenCrate.setPosition(new Vec2(-20, 7));
//        woodenCrate.addImage(new BodyImage("data/Level1/WoodenBox.png", 2));

        // Obstacles
        Shape WaterObstacle = new BoxShape(9f, 10f);
        StaticBody waterObstacle = new StaticBody(this, WaterObstacle);
        waterObstacle.setPosition(new Vec2(-1.5f, -25));
        waterObstacle.addImage(new BodyImage("data/Level1/Water.jpg", 20));

        Shape WaterObstacle2 = new BoxShape(9f, 10f);
        StaticBody waterObstacle2 = new StaticBody(this, WaterObstacle2);
        waterObstacle2.setPosition(new Vec2(-38.5f, -25));
        waterObstacle2.addImage(new BodyImage("data/Level1/Water.jpg", 20));

        Shape SpikesObstacle = new BoxShape(1f, 0.5f);
        StaticBody spikesObstacle = new StaticBody(this, SpikesObstacle);
        spikesObstacle.setPosition(new Vec2(5, -10.8f));
        spikesObstacle.addImage(new BodyImage("data/Level2/Spikes.png", 1f));

        Shape SpikesObstacle2 = new BoxShape(1f, 0.5f);
        StaticBody spikesObstacle2 = new StaticBody(this, SpikesObstacle2);
        spikesObstacle2.setPosition(new Vec2(-2, -10.8f));
        spikesObstacle2.addImage(new BodyImage("data/Level2/Spikes.png", 1f));

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
        red.setPosition(new Vec2(-31, -6));
        red.addImage(new BodyImage("data/Both/Red_gem.gif", 1.5f));

        Shape GemBlue = new BoxShape(0.75f, 0.75f);
        StaticBody blue = new StaticBody(this, GemBlue);
        blue.setPosition(new Vec2(16, 7));
        blue.addImage(new BodyImage("data/Both/Blue_gem.gif", 1.5f));

        Shape GemGreen = new BoxShape(0.75f, 0.75f);
        StaticBody green = new StaticBody(this, GemGreen);
        green.setPosition(new Vec2(1.5f, -5));
        green.addImage(new BodyImage("data/Both/Green_gem.gif", 1.5f));

        //Collisions
        ObstacleCollisionListener ocl = new ObstacleCollisionListener(getCharacter());
        spikesObstacle.addCollisionListener(ocl);
        spikesObstacle2.addCollisionListener(ocl);

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
