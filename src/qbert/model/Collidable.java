package qbert.model;

import qbert.model.characters.Player;
import qbert.model.components.PointComponent;
import qbert.model.components.TimerComponent;

/**
 * Interface used for entities which can collide with {@link Qbert} and generate some consequences.
 */
public interface Collidable {

    public void checkCollision(final Player qbert, final PointComponent points, final TimerComponent timer);

    /**
     * Event happening on the collision between the entity and {@link Qbert}.
     * @param qbert {@link Player} reference for dealing with deadly collisions
     * @param points reference to {@link PointComponent} to eventually score points in collisions
     * @param timer reference to {@link TimerComponent} for dealing with time flow changing collisions
     */
    void collide(Player qbert, PointComponent points, TimerComponent timer);

}
