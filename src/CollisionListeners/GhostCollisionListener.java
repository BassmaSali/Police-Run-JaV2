package CollisionListeners;

import Entities.Character;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A collision listener for handling collisions with ghosts.
 * This listener plays sound effects, decreases the character's lives,
 * and checks if the character has lost all lives.
 */
public class GhostCollisionListener implements CollisionListener {

    private Character character;

    private static SoundClip gruntSound;
    private static SoundClip ghostSound;

    static {
        try {
            gruntSound = new SoundClip("data/Sound/Grunt.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        try {
            ghostSound = new SoundClip("data/Sound/Ghost.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a new GhostCollisionListener.
     * @param s the character object associated with the collision
     */
    public GhostCollisionListener(Character s) {
        this.character = s;
    }

    /**
     * Handles collision events involving ghosts.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
            gruntSound.play();
            ghostSound.play();
            character.livesDecrease();
            character.checkLives();
        }
    }
}
