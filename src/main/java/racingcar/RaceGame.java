package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        boolean isValidation;

        isValidation = isNameLessThanFiveLetters();
        if (!isValidation) {
            return true;
        }

        isValidation = checkDuplicatedName();
        if (!isValidation) {
            return true;
        }

        return false;
    }

    private boolean isNameLessThanFiveLetters() {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                System.out.println("5글자 이하로 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicatedName() {
        Set<String> set = new HashSet<>();

        for (String carName : carNames) {
            if (set.contains(carName)) {
                System.out.println("중복된 이름이 입력됐습니다.");
                return false;
            }
            set.add(carName);
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
