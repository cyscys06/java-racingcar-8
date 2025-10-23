package racingcar.Model;

public class CarModel {
    private final String carName;
    private int movementCount;

    // 이동 횟수는 전용으로 증가하는 메서드가 따로 존재해야함
    CarModel(String carName) {
        this.carName = carName;
        movementCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovementCount() {
        return movementCount;
    }
}
