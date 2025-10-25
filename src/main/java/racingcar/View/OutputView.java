package racingcar.View;

import racingcar.Model.CarModel;

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

    public void printCarData(CarModel car) {
        printCarName(car);
        printCarMovementCount(car);
    }
}
