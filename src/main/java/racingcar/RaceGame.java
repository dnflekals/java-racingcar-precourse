package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RaceGame {

    private String inputString;
    private List<String> carNames;

    private void inputCarName() {
        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine();
    }

    private void splitInputString() {
        carNames = new ArrayList<String>(Arrays.asList(inputString.split(",")));
    }

    void startGame() {
        inputCarName();
        splitInputString();
    }
}
