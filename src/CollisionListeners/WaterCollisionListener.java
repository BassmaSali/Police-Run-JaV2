package CollisionListeners;

import Entities.Character;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * A collision listener for handling collisions with water.
 * This listener plays sound effects, decreases the character's lives,
 * and checks if the character has lost all lives.
 */
public class WaterCollisionListener implements CollisionListener {
    private Character character;

    private static SoundClip gruntSound;
    private static SoundClip waterSound;

    static {
        try {
            gruntSound = new SoundClip("data/Sound/Grunt.wav");
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            waterSound = new SoundClip("data/Sound/Splash.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a new WaterCollisionListener.
     * @param s the character object associated with the collision
     */
    public WaterCollisionListener(Character s) {
        this.character = s;
    }

    /**
     * Handles collision events involving water.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
//            e.getOtherBody().destroy();
            gruntSound.play();
            waterSound.play();
            character.livesDecrease();
            character.checkLives();
        }
    }
}
