package CollisionListeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import Entities.Character;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A collision listener for handling collisions with coins.
 * This listener destroys the coin object upon collision, increments the character's coin counter,
 * and plays a sound effect.
 */
public class CoinCollisionListener implements CollisionListener {
    private Character character;
    private static SoundClip coinSound;

    static {
        try {
            coinSound = new SoundClip("data/Sound/Coin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a new CoinCollisionListener.
     * @param character the character object to interact with coins
     */
    public CoinCollisionListener(Character character){
        this.character = character;
    }

    /**
     * Handles collision events between coins and other bodies.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
            e.getReportingBody().destroy();
            character.coinCounterIncrement();
            coinSound.play();

        }
    }
}
