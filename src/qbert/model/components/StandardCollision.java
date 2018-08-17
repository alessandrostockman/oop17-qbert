package qbert.model.components;

import qbert.model.characters.Player;
import qbert.model.characters.Character;

public class StandardCollision implements Collision {

    private final boolean pauseEntities;

    public StandardCollision(final boolean pauseEntities) {
        this.pauseEntities = pauseEntities;
    }

    @Override
    public boolean check(final Player qbert, final Character entity) {
        return qbert.getCurrentPosition().equals(entity.getNextPosition()) && qbert.getNextPosition().equals(entity.getCurrentPosition())
                || (qbert.getCurrentPosition().equals(entity.getCurrentPosition()) && qbert.getNextPosition().equals(entity.getNextPosition()) && this.pauseEntities)
                || ((qbert.getCurrentPosition().getX() - 1 == entity.getCurrentPosition().getX() ||  qbert.getCurrentPosition().getX() + 1 == entity.getCurrentPosition().getX()) && qbert.getCurrentPosition().getY() + 1 == entity.getCurrentPosition().getY() && !entity.isMoving() && !qbert.isMoving());
    }

}
