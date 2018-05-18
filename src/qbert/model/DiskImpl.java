package qbert.model;

import qbert.model.utilities.Position2D;
import qbert.view.DiskGC;

/**
 * The implementation of {@link DiskGC}.
 */
public class DiskImpl implements Disk {

    private Position2D position;
    private DiskGC graphics;
    private boolean dead;
    
    /**
     * @param position the {@link Position2D} of the disk
     * @param graphics the linked {@link DiskGC}
     */
    public DiskImpl(final Position2D position, final DiskGC graphics) {
        this.position = position;
        this.graphics = graphics;
    }

    @Override
    public Position2D getCurrentPosition() {
        return this.position;
    }

    @Override
    public void setCurrentPosition(final Position2D newPos) {
        this.position = newPos;
    }

    @Override
    public DiskGC getDiskGraphicComponent() {
        return this.graphics;
    }

    @Override
    public void setDead() {
        this.dead = true;
    }

    @Override
    public boolean isDead() {
        return this.dead;
    }

    @Override
    public void update(final float elapsedTime) {
        this.graphics.update(elapsedTime);
    }
}
