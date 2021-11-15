package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RaceGame {

    Scanner scanner = new Scanner(System.in);
    private String inputString;
    private int moveCount;
    private List<String> carNames;
    private final ArrayList<Car> carMembers = new ArrayList<>();
    private final ArrayList<String> winner = new ArrayList<>();

    private void inputCarName() {
        inputString = scanner.nextLine();
    }

    private void splitInputString() {
        carNames = new ArrayList<>(Arrays.asList(inputString.split(",")));
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
                System.out.println("[ERROR] 5글자 이하로 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicatedName() {
        Set<String> set = new HashSet<>();

        for (String carName : carNames) {
            if (set.contains(carName)) {
                System.out.println("[ERROR] 중복된 이름이 입력됐습니다.");
                return false;
            }
            set.add(carName);
        }
        return true;
    }

    private void makeCarObject() {
        for (String carName : carNames) {
            carMembers.add(new Car(carName));
        }
    }

    private void inputMoveCount() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("시도할 회수는 몇회인가요?");
            String inputString = scanner.nextLine();
            isContinue=!isNumber(inputString);
            if(isContinue){
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            } else{
                moveCount = Integer.parseInt(inputString);
            }
        }
    }

    private boolean isNumber(String inputCount){
        boolean isNumeric =  inputCount.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

    private void moveCar() {
        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {
            for (Car carMember : carMembers) {
                carMember.move();
            }
            System.out.println();
        }
    }

    private void setWinner() {
        int maxPosition = 0;
        for (Car carMember : carMembers) {
            int position = carMember.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
                winner.clear();
                String name = carMember.getName();
                winner.add(name);
            } else if (position == maxPosition) {
                String name = carMember.getName();
                winner.add(name);
            }
        }
    }

    private void getWinner() {
        String result = String.join(", ", winner);
        System.out.print("최종 우승자: " + result);
    }

    void startGame() {
        boolean isContinue = true;

        while (isContinue) {
            System.out.println("경주할 자동차 이름을 입력하세요.");
            inputCarName();
            splitInputString();
            isContinue = checkValidation();
        }
        makeCarObject();
        inputMoveCount();
        moveCar();
        setWinner();
        getWinner();
    }
}
