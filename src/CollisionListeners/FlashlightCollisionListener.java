package CollisionListeners;

import Entities.Character;
import Entities.FlashlightShoot;
import Entities.MovingGhostEnemy;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * A collision listener for handling collisions involving the flashlight object.
 * This listener reacts to collisions with moving ghost enemies, flashlight shoots,
 * and character objects.
 */
public class FlashlightCollisionListener implements CollisionListener {

    private Character character;

    /**
     * Constructs a new FlashlightCollisionListener.
     * @param character the character object associated with the flashlight
     */
    public FlashlightCollisionListener(Character character) {
        this.character = character;
    }

    /**
     * Handles collision events involving the flashlight.
     * @param e the collision event
     */
    // Method called when collision occurs
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof MovingGhostEnemy) {
            e.getOtherBody().destroy(); // Destroy the ghost
            character.FlashlightDecrease(); // Decrease flashlight count
        }
        if (e.getOtherBody() instanceof FlashlightShoot) {
            e.getOtherBody().destroy();
        }
        if (e.getOtherBody() instanceof Character) {
            e.getReportingBody().destroy();
            if (character.getLights() < 5) {
                character.collectFlashlight();
            }
        }
    }
}

