package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.CarModel;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.lang.Math;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private OutputView outputView;
    private InputView inputView;
    private PrepareRaceController prepareRaceController;
    private Validator validator;
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

    public void run() {
        outputView.requestInput();
        String input = inputView.getInput();

        validator.checkCarNameisEmpty(input);

        String[] carNameArray = prepareRaceController.makeCarNameArray(input);
        validator.checkCarNameLengthMorethan5(carNameArray);

        validator.checkCarNameArraySizeMorethan5(carNameArray);

        List<CarModel> carList = prepareRaceController.makeCarList(carNameArray);

        outputView.requestAttemptsCount();
        String atteptsInput = inputView.getAttemptsCount();

        validator.checkAttemptsCountisNotNumber(atteptsInput);
        int attemptsCount = prepareRaceController.changeStringtoNumber(atteptsInput);
        validator.checkAttemptsCountisLessthan1(attemptsCount);
        validator.checkAttemptsCountisMorethan10(attemptsCount);
        for (int i = 0; i < attemptsCount; i++) {
            for (CarModel car : carList) {
                if (validator.checkCarMoveable(getRandomNumber())) {
                    car.moveCar();
                }
            }
            outputView.printCarData(carList);
        }

        List<String> winnerList = getWinnerList(carList);

        outputView.printWinner(winnerList);
    }
}
