import model.*;

public class Main {
    public static void main(String[] args) {
        Ferrari ferrari = new Ferrari();
        ferrari.setAutomatic(true);
        ferrari.setColor(ColorType.RED);
        Engine engine = new Engine(5000, 350, FuelType.OIL);
        ferrari.setEngine(engine);
        ferrari.setModel("Ferrari");
        ferrari.setCaseType(CaseType.HATCHBACK);
        ferrari.setFromZeroToHundredSec(3);
        ferrari.setSpeed(0);
        ferrari.setMaxSpeed(250);

        ferrari.useGas();
        System.out.println(ferrari);
        ferrari.useGas();
        System.out.println(ferrari);
        ferrari.useBreak();
        System.out.println(ferrari);


        Porsche porsche = new Porsche();
        porsche.setAutomatic(true);
        porsche.setColor(ColorType.WHITE);
        Engine engine2 = new Engine(4000, 300, FuelType.OIL);
        porsche.setEngine(engine2);
        porsche.setModel("Porsche");
        porsche.setCaseType(CaseType.HATCHBACK);
        porsche.setFromZeroToHundredSec(4);
        porsche.setSpeed(0);
        porsche.setMaxSpeed(220);


        porsche.useGas();
        System.out.println(porsche);
        porsche.useGas();
        System.out.println(porsche);
        porsche.useBreak();
        System.out.println(porsche);
    }

}