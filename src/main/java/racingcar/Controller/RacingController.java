package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.CarModel;
import java.lang.Math;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
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
}
