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

    private boolean checkValidation() {
        boolean isValidation = true;

        isValidation = isNameLessThanFiveLetters();
        if (isValidation == false) {
            return true;
        }

        return false;
    }

    private boolean isNameLessThanFiveLetters() {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                System.out.println("[ERROR] 5글자 이하로 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    void startGame() {
        boolean isContinue = true;

        while (isContinue) {
            inputCarName();
            splitInputString();
            isContinue = checkValidation();
        }

    }
}
