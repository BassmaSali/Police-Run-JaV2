package Entities;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A class representing horizontally moving platforms in the game world.
 * These platforms move back and forth within a specified range.
 * They extend StaticBody and implement StepListener to control their movement.
 */
public class HorizontalMovingPlatforms extends StaticBody implements StepListener{
    private Vec2 startPosition;
    private float left, right;
    private float delta;

    /**
     * Constructs a HorizontalMovingPlatforms object in the given world with the specified parameters.
     * @param world         The world in which the platform exists.
     * @param startPosition The starting position of the platform.
     * @param delta         The speed at which the platform moves.
     * @param width         The width of the platform.
     * @param height        The height of the platform.
     */
    public HorizontalMovingPlatforms(World world, Vec2 startPosition, float delta, float width, float height) {
        super(world, new BoxShape(width, height));
        this.startPosition = startPosition;
        this.left = startPosition.x;
        this.right = startPosition.x + 8.5f;
        this.delta = delta;
        setPosition(startPosition);
        world.addStepListener(this);
    }

    /**
     * Called before each simulation step.
     * Moves the platform back and forth within the specified range.
     * @param e The event associated with the step.
     */
    @Override
    public void preStep(StepEvent e) {
        if (getPosition().x < left) {
            setPosition(startPosition);
            delta *= -1;
        }
        if (getPosition().x > right) {
            delta *= -1;
        }
        setPosition(new Vec2(getPosition().x + delta, getPosition().y));
    }

    /**
     * Called after each simulation step.
     * @param e The event associated with the step.
     */
    @Override
    public void postStep(StepEvent e) {
    }
}
