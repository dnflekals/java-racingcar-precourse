package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    void move() {
        boolean goOneStep = canMove();
        if (goOneStep) {
            position++;
        }
    }

    private boolean canMove() {
        int randomNumber = RandomUtils.nextInt(0, 9);

        if (randomNumber > 3) {
            return true;
        } else {
            return false;
        }
    }
}
