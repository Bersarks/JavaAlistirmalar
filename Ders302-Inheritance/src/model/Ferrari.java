package model;

public class Ferrari extends Car {

    @Override
    public void useGas() {
        if (this.getSpeed() + 60 <= getMaxSpeed()) {
            this.setSpeed(this.getSpeed() + 60);
        } else {
            this.setSpeed(getMaxSpeed());
        }
    }

    @Override
    public void useBreak() {
        this.setSpeed(0);
    }
}
