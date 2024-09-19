package Levels;

import CollisionListeners.ObstacleCollisionListener;
import CollisionListeners.PortalCollisionListener;
import Entities.Character;
import Entities.Portal;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Game;
import org.jbox2d.common.Vec2;

import java.awt.*;


/**
 * Represents a game level.
 * Creates the base of different levels in the game.
 */
public abstract class GameLevel extends World{
    private Character character;
    private Portal portal;
    private Game game;

    float hue = 32.0f / 360.0f;
    float saturation = 52.0f / 100.0f;
    float brightness = 30.0f / 100.0f;

    /**
     * Constructs a GameLevel object.
     * @param game The game instance to which this level belongs.
     */
    public GameLevel(Game game) {

        int rgbColor = Color.HSBtoRGB(hue, saturation, brightness);

        //2. populate the GameWorld with bodies (ex: platforms, collectibles, characters)
        this.game = game;

        Shape End_Platform = new BoxShape(3.5f, 0.8f);
        StaticBody end_platform = new StaticBody(this, End_Platform);
        end_platform.setPosition(new Vec2(-38f,12));
        end_platform.addImage(new BodyImage("data/Level1/Stone_plat2.png", 1.5f));

        portal = new Portal(this);
        portal.setPosition(new Vec2(-38, 15f));

        character = new Character(this);
        character.setPosition(new Vec2(16,-7));
        character.addCollisionListener(new PortalCollisionListener(this, game));

        Shape Torch1 = new BoxShape(1f, 1f);
        StaticBody torch1 = new StaticBody(this, Torch1);
        torch1.setPosition(new Vec2(-41, 20));
        torch1.addImage(new BodyImage("data/Both/Torch_Gif.gif", 2f));

        Shape Torch2 = new BoxShape(1f, 1f);
        StaticBody torch2 = new StaticBody(this, Torch2);
        torch2.setPosition(new Vec2(-35, 20));
        torch2.addImage(new BodyImage("data/Both/Torch_Gif.gif", 2f));

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
        ObstacleCollisionListener ocl = new ObstacleCollisionListener(getCharacter());
        finalPlatform.addCollisionListener(ocl);
    }

    /**
     * Gets the character object in the level.
     * @return The character object.
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Checks if the level is complete.
     * @return True if the level is complete, otherwiase it returns false.
     */
    public abstract boolean isComplete();
}
