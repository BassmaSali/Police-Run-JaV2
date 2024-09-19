package Entities;

import Levels.Level2;
import Levels.Level3;
import city.cs.engine.*;
import Levels.Level1;
import city.cs.engine.Shape;
import game.GameView;
import game.Game;
import org.jbox2d.common.Vec2;
import city.cs.engine.SoundClip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;



/**
 * Represents the character entity in the game.
 * This class extends {@link Walker} and encapsulates the character's shape,
 * images, and attributes such as gems, coins, lives, and lights.
 */
public class Character extends Walker{

    private static final Shape characterShape = new BoxShape(0.8f,1.5f);


    private static final BodyImage standingLeft = new BodyImage("data/Both/standing_L.png", 3);
    private static final BodyImage standingRight = new BodyImage("data/Both/standing_R.png", 3);
    private static final BodyImage lookingLeft = new BodyImage("data/Both/Character_L.png", 3);
    private static final BodyImage lookingRight = new BodyImage("data/Both/Character_R.png", 3);

    //Variables
    private boolean facingLeft = true;
    private int totalGems;
    private int totalCoins;
    private int totalLives = 3;
    private int totalLights = 5;

    private static SoundClip gameOverSound;


    /**
     * Constructs a character in the given world with the default shape and initial image.
     * @param world The world in which the character exists.
     */
    public Character(World world){
        super(world, characterShape);
        this.addImage(standingLeft);
    }

    static {
        try {
            gameOverSound = new SoundClip("data/Sound/Game_Over.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }



    /** Getter Methods */
    public BodyImage getLookingLeft(){
        return lookingLeft;
    }

    public BodyImage getLookingRight(){
        return lookingRight;
    }

    public BodyImage getStandingLeft(){
        return standingLeft;
    }

    public BodyImage getStandingRight(){
        return standingRight;
    }

    // Method used to determine whether the character is facing left or right using boolean
    public BodyImage getCurrentImage(){
        if (facingLeft) {
            return standingLeft;
        } else {
            return standingRight;
        }
    }

    // Method to actually set the direction based on whether the previous method is true or false
    public void setFacingLeft(boolean facingLeft) { this.facingLeft = facingLeft;}

    // Method increments totalGems value every time it is called
    public void gemCounterIncrement() { totalGems++; }

    // Method to return the totalGems value when called
    public int getTotalGems() { return totalGems; }

    // Method to return the totalCoins value when called
    public int getTotalCoins() {
        return totalCoins;
    }

    public int getLives() {
        return totalLives;
    }

    public int getLights() {
        return totalLights;
    }

    /**
     * Checks the number of collected gems and performs specific actions if a certain condition is met.
     * If the total number of gems collected is equal to 3, this method checks the current world instance
     * and adds a platform accordingly.
     */
    public void checkGems() {
        if (totalGems == 3) {
            World currentWorld = getWorld();
            if (currentWorld instanceof Level1) {
                Level1 level1 = (Level1) currentWorld;
                level1.addPlatform();
            }
            else if (currentWorld instanceof Level2) {
                Level2 level2 = (Level2) currentWorld;
                level2.addPlatform();
            }

        }
    }
    /**
     * Checks the remaining lives of the character.
     * If the total number of lives reaches 0, it triggers the game over sequence,
     * including playing the game over sound, stopping the game music, displaying
     * a game over message dialog, and terminating the application.
     */
    public void checkLives() {
        if (totalLives == 0) {
            gameOverSound.play();
            Game.gameMusic.stop();
            JOptionPane.showMessageDialog(null, "Game Over!");
            System.exit(0);
        }
    }

    /**
     * Increases the total count of collected coins by one.
     */
    public void coinCounterIncrement() { totalCoins++; }

    /**
     * Decreases the total count of available flashlights by one.
     */
    public void FlashlightDecrease() {
        totalLights--;
    }

    /**
     * Decreases the total count of remaining lives by one and resets the character's position to the default.
     */
    public void livesDecrease() {
        totalLives--;
        defaultPosition();
    }

    /**
     * Resets the character's position to the default coordinates (16, -7).
     */
    public void defaultPosition() {
        setPosition(new Vec2(16, -7));
    }

    /**
     * Increases the total count of available flashlights by one.
     */
    public void collectFlashlight() {
        totalLights++;
    }

    /**
     * Creates a new flashlight entity and shoots it from the character's position with a velocity based on its facing direction.
     * If the character is facing left, the flashlight moves left; otherwise, it moves right.
     */
    public void shootFlashlight() {
        FlashlightShoot flashlight = new FlashlightShoot(getWorld());
        if (facingLeft) {
            flashlight.setLinearVelocity(new Vec2(-30, 0));
        } else {
            flashlight.setLinearVelocity(new Vec2(30, 0));
        }
        flashlight.setPosition(getPosition());
    }
}