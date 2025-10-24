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
        System.out.println(car.getCarName());
    }
}
