package CollisionListeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;
import Levels.GameLevel;
import Entities.Portal;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * A collision listener for handling collisions with the portal.
 * This listener checks if the character has collided with the portal and if the level is complete.
 * If the level is complete, it plays a sound effect and proceeds to the next level.
 */
public class PortalCollisionListener implements CollisionListener{

    GameLevel level;
    Game game;

    private static SoundClip completeSound;

    static {
        try {
            completeSound = new SoundClip("data/Sound/Complete.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Constructs a new PortalCollisionListener.
     * @param level the current game level
     * @param game the game object
     */
    public PortalCollisionListener(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }

    /**
     * Handles collision events involving the portal.
     * @param e the collision event
     */
    // Method called when collision occurs
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Portal){
            System.out.println("Character collided with portal");
            // Character c = (Character)e.getReportingBody();
            //  s.setCredits(s.getCredits()+15);
            if (level.isComplete()){
                completeSound.play();
                game.nextLevel();
            }
        }
    }
}
