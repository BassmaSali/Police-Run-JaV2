package Entities;

import Entities.Character;
import city.cs.engine.*;

/**
 * The Portal class represents a portal object in the game world.
 * Portals are static bodies that serve as exit points to the next level.
 */
public class Portal extends StaticBody{

    private static final Shape portalShape = new BoxShape(2f, 2.5f);
    private static final BodyImage image = new BodyImage("data/Both/Door_Closed.png", 5f);

    /**
     * Constructs a new Portal object.
     * @param world the world in which the portal exists
     */
    public Portal(World world) {
        super(world, portalShape);
        addImage(image);
    }
}
