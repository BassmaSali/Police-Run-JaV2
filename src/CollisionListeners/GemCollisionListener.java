package CollisionListeners;

import city.cs.engine.CollisionListener;
import city.cs.engine.CollisionEvent;
import Entities.Character;
import game.GameView;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A collision listener for handling collisions with gems.
 * This listener destroys the gem object upon collision, increments the character's gem counter,
 * checks if all gems are collected, and plays a sound effect.
 */
public class GemCollisionListener implements CollisionListener {

    private Character character;
    private static SoundClip gemSound;

    static {
        try {
            gemSound = new SoundClip("data/Sound/Gem.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a new GemCollisionListener.
     * @param character the character object to interact with gems
     */
    public GemCollisionListener(Character character){
        // Takes Character object as an input
        this.character = character;
    }

    /**
     * Handles collision events between gems and other bodies.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
            // Destroy the object of the Reporting Body
            e.getReportingBody().destroy();
            // Call the gemCounterIncrement method
            character.gemCounterIncrement();
            // Call the checkGems method
            character.checkGems();
            gemSound.play();
        }
    }
}

