package qbert.view;

import java.awt.image.BufferedImage;
import qbert.model.Dimensions;
import qbert.model.utilities.Position2D;
import qbert.view.animations.DisplaceAnimation;
import qbert.view.animations.Jump;
import qbert.view.animations.MoveAnimation;
import qbert.view.animations.StandingAnimation;

/**
 * CGC stands for CharacterGraphicComponent, this implementation is used to manage characters whose movements are bidirectional and 
 * whose spawn is instant on some position, like Coily (adult) and QBert.
 */
public class DownwardUpwardCGC extends CharacterGraphicComponentImpl {

    private final BufferedImage standSprite;
    private final BufferedImage moveSprite;

    private final int jumpWidth = Dimensions.tileWidth;
    private final int jumpHeight = Dimensions.cubeHeight;

    /**
     * @param standSprite the {@link BufferedImage} containing the {@link Character}'s standing sprite
     * @param moveSprite the {@link BufferedImage} containing the {@link Character}'s moving sprite
     * @param startSpritePos the first position (physic) of the {@link Character}
     */
    public DownwardUpwardCGC(final BufferedImage standSprite, final BufferedImage moveSprite, final Position2D startSpritePos) {
        super(standSprite, startSpritePos);
        this.standSprite = standSprite;
        this.moveSprite = moveSprite;
    }

    @Override
    public final void setStandingAnimation() {
        this.setSprite(this.standSprite);
        this.setCurrentAnimation(new StandingAnimation(this.getPosition()));
    }

    @Override
    public final void setSpawnAnimation() {
        this.setSprite(this.standSprite);
        this.setCurrentAnimation(new DisplaceAnimation(this.getPosition(), this.getSpawnPosition()));
    }

    @Override
    public final void setFallAnimation() {
        this.setSprite(this.moveSprite);
        this.setCurrentAnimation(new MoveAnimation.Down(this.getPosition(), new Position2D(this.getPosition().getX(), Dimensions.deathHeight)));
    }

    @Override
    public final void setMoveDownLeftAnimation() {
        this.setSprite(this.moveSprite);
        this.setCurrentAnimation(new Jump.DownLeft(this.getPosition(), new Position2D(this.getPosition().getX() - this.jumpWidth / 2, this.getPosition().getY() + this.jumpHeight)));
    }

    @Override
    public final void setMoveDownRightAnimation() {
        this.setSprite(this.moveSprite);
        this.setCurrentAnimation(new Jump.DownRight(this.getPosition(), new Position2D(this.getPosition().getX() + this.jumpWidth / 2, this.getPosition().getY() + this.jumpHeight)));
    }

    @Override
    public final void setMoveUpLeftAnimation() {
        this.setSprite(this.moveSprite);
        this.setCurrentAnimation(new Jump.UpLeft(this.getPosition(), new Position2D(this.getPosition().getX() - this.jumpWidth / 2, this.getPosition().getY() - this.jumpHeight)));
    }

    @Override
    public final void setMoveUpRightAnimation() {
        this.setSprite(this.moveSprite);
        this.setCurrentAnimation(new Jump.UpRight(this.getPosition(), new Position2D(this.getPosition().getX() + this.jumpWidth / 2, this.getPosition().getY() - this.jumpHeight)));
    }
}
