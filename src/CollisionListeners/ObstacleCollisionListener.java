package CollisionListeners;

import Entities.Character;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import javax.swing.*;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A collision listener for handling collisions with obstacles.
 * This listener plays a grunt sound effect, decreases the character's lives,
 * and checks if the character has lost all lives.
 */
public class ObstacleCollisionListener implements CollisionListener {

    private Character character;

    private static SoundClip gruntSound;

    static {
        try {
            gruntSound = new SoundClip("data/Sound/Grunt.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a new ObstacleCollisionListener.
     * @param s the character object associated with the collision
     */
    public ObstacleCollisionListener(Character s) {
        this.character = s;
    }

    /**
     * Handles collision events involving obstacles.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
//            e.getOtherBody().destroy();
            gruntSound.play();
            character.livesDecrease();
            character.checkLives();
        }
    }
}
