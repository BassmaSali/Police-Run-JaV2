package CollisionListeners;

import Entities.Character;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 * A collision listener for handling collisions with trampolines.
 * This listener applies an impulse to the character when it collides with a trampoline.
 */
public class TrampolineCollisionListener implements CollisionListener {

    /**
     * Constructs a new TrampolineCollisionListener.
     * @param character the character object associated with the collision
     */
    private Character character;

    public TrampolineCollisionListener(Character s) {
        this.character = s;
    }

    /**
     * Handles collision events involving trampolines.
     * @param e the collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Character) {
            character.applyImpulse(new Vec2(0, 300));
        }
    }
}
