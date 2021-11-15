package racingcar;

import java.util.Scanner;

public class RaceGame {
    private String inputString;

    private void inputCarName() {
        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine();
    }

    void startGame() {
        inputCarName();
    }
}
