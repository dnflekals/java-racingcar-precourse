package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int REFERENCE_POINT = 3;

    public Car(String name) {
        this.name = name;
    }

    void move() {
        boolean goOneStep = canMove();

        if (goOneStep) {
            position++;
        }

        getPositionMessage();
    }

    private boolean canMove() {
        int randomNumber = RandomUtils.nextInt(MIN_VALUE, MAX_VALUE);

        if (randomNumber > REFERENCE_POINT) {
            return true;
        } else {
            return false;
        }
    }

    private void getPositionMessage() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    int getPosition() {
        return this.position;
    }

    String getName() {
        return this.name;
    }
}
