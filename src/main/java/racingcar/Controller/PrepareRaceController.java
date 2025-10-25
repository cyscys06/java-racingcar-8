package racingcar.Controller;

import racingcar.Model.CarModel;

import java.util.ArrayList;
import java.util.List;

public class PrepareRaceController {
    public String[] makeCarNameArray(String input) {
        return input.split(",");
    }

    public List<CarModel> makeCarList(String[] carnamearray) {
        List<CarModel> carList = new ArrayList<>(carnamearray.length);
        for (String car : carnamearray) {
            carList.add(new CarModel(car));
        }
        return carList;
    }

    public int changeStringtoNumber(String attemptscountstring) {
        return Integer.parseInt(attemptscountstring);
    }
}
