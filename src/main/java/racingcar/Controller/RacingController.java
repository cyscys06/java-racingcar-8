package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingController {
    public int getRandomNumber() {
        final int LEASTRANDOMNUMBER = 0;
        final int MAXRANDOMNUMBER = 9;
        return Randoms.pickNumberInRange(LEASTRANDOMNUMBER, MAXRANDOMNUMBER);
    }
}
