package racingcar.View;

import racingcar.Model.CarModel;

import java.util.List;

public class OutputView {
    public void requestInput() {
        System.out.println(Message.INPUTREQUEST.getMessage());
    }

    public void requestAttemptsCount() {
        System.out.println(Message.ATTEMPTSREQUEST.getMessage());
    }

    public void printCarName(CarModel car) {
        System.out.print(car.getCarName());
    }

    public void printCarMovementCount(CarModel car) {
        System.out.print(Message.COLON.getMessage());
        for (int i = 0; i < car.getMovementCount(); i++) {
            System.out.print(Message.HYPHEN.getMessage());
        }
    }

    public void printCarData(List<CarModel> carList) {
        for (CarModel car : carList) {
            printCarName(car);
            printCarMovementCount(car);
            System.out.println();
        }
    }

    public void printWinner(List<String> winnersList) {
        System.out.println(Message.WINNER.getMessage() +
                Message.COLON.getMessage() +
                String.join("," , winnersList));
    }
}
