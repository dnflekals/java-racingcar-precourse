package racingcar;

import java.util.Scanner;

public class RaceGame {

    private void inputCarName() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(inputString);
    }

    void startGame() {
        inputCarName();
    }
}
