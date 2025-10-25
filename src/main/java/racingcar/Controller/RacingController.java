package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.CarModel;
import java.lang.Math;

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
}
