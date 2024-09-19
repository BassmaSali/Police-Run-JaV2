package Entities;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *  Flashlight projectile that can be shot by the character.
 * It extends DynamicBody, meaning it is affected by physics in the game world.
 */
public class FlashlightShoot extends DynamicBody {
    private static Shape flashLight = new BoxShape(1, 0.75f);
    private static BodyImage lightImage = new BodyImage("data/Both/Flashlight_On.png", 1f);

    /**
     * Constructs a FlashlightShoot object in the given world.
     * It creates a flashlight shape and sets its image, as well as its initial velocity.
     * @param world The world in which the flashlight will exist.
     */
    public FlashlightShoot(World world){
        super(world, flashLight);
        addImage(lightImage);
        this.setGravityScale(0);
        this.setLinearVelocity(new Vec2(40, 0));
    }
}
