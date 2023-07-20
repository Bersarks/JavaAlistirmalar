package model;

public class Car {
    /*
    model
    otomatik vites
    hatchback?
    max hız
    color
    0-100 süresi
    motor
    yakıt tipi - elektrik dizel benzin
    fiyat

    increaseSpeed -> saatte 30kmh arttır. Ferraride 60 kmh arttır.
    decreaseSpeed -> defaultta 10kmh, ferraride direkt 0
     */
    private String model;
    private boolean isAutomatic;
    private CaseType caseType;
    private ColorType color;
    private int fromZeroToHundredSec;
    private Engine engine;
    private int speed;
    private int maxSpeed;


    public Car() {
    }

    public Car(String model, boolean isAutomatic, CaseType caseType, ColorType color, int fromZeroToHundredSec, Engine engine) {
        this.model = model;
        this.isAutomatic = isAutomatic;
        this.caseType = caseType;
        this.color = color;
        this.fromZeroToHundredSec = fromZeroToHundredSec;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public int getFromZeroToHundredSec() {
        return fromZeroToHundredSec;
    }

    public void setFromZeroToHundredSec(int fromZeroToHundredSec) {
        this.fromZeroToHundredSec = fromZeroToHundredSec;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", isAutomatic=" + isAutomatic +
                ", caseType=" + caseType +
                ", color=" + color +
                ", fromZeroToHundredSec=" + fromZeroToHundredSec +
                ", engine=" + engine +
                ", speed=" + speed +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public void useGas() {
        if (this.getSpeed() + 30 <= this.maxSpeed) {
            this.setSpeed(this.getSpeed() + 30);
        } else {
            this.setSpeed(this.maxSpeed);
        }
    }

    public void useBreak() {
        if (this.getSpeed() - 10 >= 0) {
            this.setSpeed(this.getSpeed() - 10);
        } else {
            this.setSpeed(0);
        }
    }
}
