package qbert.model;

import qbert.model.states.CharacterState;
import qbert.model.utilities.Position2D;
import qbert.view.CharacterGraphicComponent;

public class CharacterImpl implements Character {

    private Position2D currentPos;
    private Position2D nextPos;
    private float characterSpeed;

    private CharacterGraphicComponent graphics;

    private CharacterState standingState;
    private CharacterState currentState;

    public CharacterImpl(final Position2D startPos, final float speed, final CharacterGraphicComponent graphics) {
        this.currentPos = startPos;
        this.characterSpeed = speed;
        this.graphics = graphics;
    }

    @Override
    public Position2D getCurrentPosition() {
        return this.currentPos;
    }

    @Override
    public void setCurrentPosition(final Position2D currentGridPos) {
        this.currentPos = currentGridPos;
    }

    @Override
    public Position2D getNextPosition() {
        return this.nextPos;
    }

    @Override
    public void setNextPosition(final Position2D nextGridPos) {
        this.nextPos = nextGridPos;
    }

    @Override
    public float getSpeed() {
        return this.characterSpeed;
    }

    @Override
    public void setSpeed(final float speed) {
        this.characterSpeed = speed;
    }

    @Override
    public CharacterGraphicComponent getGraphicComponent() {
        return this.graphics;
    }

    @Override
    public void setGraphicComponent(final CharacterGraphicComponent graphics) {
        this.graphics = graphics;
    }

    @Override
    public boolean isMoving() {
        return this.currentPos.equals(this.nextPos);
    }

    @Override
    public CharacterState getCurrentState() {
        return this.currentState;
    }

    @Override
    public void setCurrentState(final CharacterState state) {
        this.currentState = state;
    }

    @Override
    public CharacterState getStandingState() {
        return this.standingState;
    }

    @Override
    public void setStandingState(final CharacterState state) {
        this.standingState = state;
    }

    @Override
    public void update(final float dt) {
        this.currentState.update(dt);
    }
}
