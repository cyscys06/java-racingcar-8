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
        for (int i = 0; i < carnamearray.length; i++) {
            carList.add(new CarModel(carnamearray[i]));
        }
        return carList;
    }
}
