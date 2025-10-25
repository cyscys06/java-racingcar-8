package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.CarModel;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.lang.Math;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final OutputView outputView;
    private final InputView inputView;
    private final PrepareRaceController prepareRaceController;
    private final Validator validator;

    public RacingController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.prepareRaceController = new PrepareRaceController();
        this.validator = new Validator();
    }

    public int getRandomNumber() {
        final int LEASTRANDOMNUMBER = 0;
        final int MAXRANDOMNUMBER = 9;
        return Randoms.pickNumberInRange(LEASTRANDOMNUMBER, MAXRANDOMNUMBER);
    }

    public int getMaxMovementCount(List<CarModel> carList) {
        int MAX = 0;
        for (CarModel car : carList) {
            MAX = Math.max(MAX, car.getMovementCount());
        }
        return MAX;
    }

    public List<String> getWinnerList(List<CarModel> carList) {
        List<String> winnersList = new ArrayList<>();
        int maxMovementCount = getMaxMovementCount(carList);
        for (CarModel car : carList) {
            if (car.getMovementCount() == maxMovementCount) {
                winnersList.add(car.getCarName());
            }
        }
        return winnersList;
    }

    public List<CarModel> getCarList() {
        outputView.requestInput();
        String input = inputView.getInput();
        validator.checkCarNameisEmpty(input);

        String[] carNameArray = prepareRaceController.makeCarNameArray(input);
        validator.checkCarNameLengthMorethan5(carNameArray);
        validator.checkCarNameArraySizeMorethan5(carNameArray);

        List<CarModel> carList = prepareRaceController.makeCarList(carNameArray);

        return carList;
    }

    public int getAttemptsCount() {
        outputView.requestAttemptsCount();
        String atteptsInput = inputView.getAttemptsCount();
        validator.checkAttemptsCountisNotNumber(atteptsInput);

        int attemptsCount = prepareRaceController.changeStringtoNumber(atteptsInput);
        validator.checkAttemptsCountisLessthan1(attemptsCount);
        validator.checkAttemptsCountisMorethan10(attemptsCount);

        return attemptsCount;
    }

    public void moveCarRandomly(List<CarModel> carList) {
        for (CarModel car : carList) {
            if (validator.checkCarMoveable(getRandomNumber())) {
                car.moveCar();
            }
        }
    }

    public void showGameProgress(List<CarModel> carList, int attemptsCount) {
        for (int i = 0; i < attemptsCount; i++) {
            moveCarRandomly(carList);
            outputView.printCarData(carList);
        }
    }

    public void run() {
        List<CarModel> carList = getCarList();
        int attemptsCount = getAttemptsCount();

        showGameProgress(carList, attemptsCount);

        List<String> winnerList = getWinnerList(carList);

        outputView.printWinner(winnerList);
    }
}
