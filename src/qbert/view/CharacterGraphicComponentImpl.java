package qbert.view;

import java.awt.image.BufferedImage;
import qbert.model.utilities.Position2D;
import qbert.view.animations.Animation;

/**
 * A generic implementation of {@link CharacterGraphicComponent}.
 */
public abstract class CharacterGraphicComponentImpl implements CharacterGraphicComponent {

    private BufferedImage sprite;

    private Position2D spritePos;
    private Position2D spawnPos;

    private Animation animation;

    /**
     * @param sprite the {@link BufferedImage} containing the {@link Character}'s current sprite
     * @param startSpritePos the first position (physic) of the {@link Character}
     */
    public CharacterGraphicComponentImpl(final BufferedImage sprite, final Position2D startSpritePos) {
        this.sprite = sprite;
        this.spritePos = new Position2D(startSpritePos);
        this.spawnPos = new Position2D(startSpritePos);
    }

    @Override
    public final BufferedImage getSprite() {
        return this.sprite;
    }

    @Override
    public final void setSprite(final BufferedImage newSprite) {
        this.sprite = newSprite;
    }

    @Override
    public final int getSpriteHeight() {
        return this.sprite.getHeight();
    }

    @Override
    public final int getSpriteWidth() {
        return this.sprite.getWidth();
    }

    @Override
    public final Position2D getPosition() {
        return this.spritePos;
    }

    @Override
    public final void setPosition(final Position2D newPos) {
        this.spritePos = new Position2D(newPos);
    }

    @Override
    public final Position2D getSpawnPosition() {
        return this.spawnPos;
    }

    @Override
    public final void setSpawnPosition(final Position2D newPos) {
        this.spawnPos = new Position2D(newPos);
    }

    @Override
    public final Animation getCurrentAnimation() {
        return this.animation;
    }

    @Override
    public final void setCurrentAnimation(final Animation animation) {
        this.animation = animation;
    }

    @Override
    public abstract void setStandingAnimation();

    @Override
    public final void setSpawnPosToCurrentPos() {
        this.spawnPos = new Position2D(this.spritePos.getX(), this.spritePos.getY());
    }

    @Override
    public abstract void setSpawnAnimation();

    @Override
    public abstract void setFallAnimation();

    @Override
    public abstract void setMoveDownLeftAnimation();

    @Override
    public abstract void setMoveDownRightAnimation();

    @Override
    public abstract void setMoveUpLeftAnimation();

    @Override
    public abstract void setMoveUpRightAnimation();

    @Override
    public final void updateGraphics(final float graphicsSpeed) {
        this.setPosition(this.animation.updateAnimation(graphicsSpeed));
    }
}
