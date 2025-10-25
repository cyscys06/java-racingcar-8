package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Model.CarModel;
import racingcar.Controller.RacingController;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingControllerTest {
    RacingController racingController;
    private CarModel car1, car2, car3;
    private CarModel[] carModels;
    private List<CarModel> carList;
    @BeforeEach
    void setUp() {
        racingController = new RacingController();

        car1 = new CarModel("pobi");
        car2 = new CarModel("woni");
        car3 = new CarModel("jun");

        car1.moveCar();
        car2.moveCar();
        carModels = new CarModel[] {car1, car2, car3};
        carList = new ArrayList<>(List.of(carModels));
    }

    @Nested
    @DisplayName("경기 진행 테스트")
    class 경기_진행_테스트 {
        @Test
        void 무작위_수_생성_테스트() {
            int[] randomNumberArray = new int[30];
            for (int randomNumber : randomNumberArray) {
                randomNumber = racingController.getRandomNumber();
                assertThat(randomNumber).isBetween(0, 9);
            }
        }

        @Test
        void 자동차들의_이동횟수_중_최댓값_찾기_테스트() {
            int maxMovementCount = racingController.getMaxMovementCount(carList);
            assertThat(maxMovementCount).isEqualTo(car2.getMovementCount());
        }

        @Test
        void 이동횟수_최댓값과_같은값_가진_자동차_찾기_테스트() {
            List<String> winnersList = racingController.getWinnerList(carList);
            List<String> result = new ArrayList<>();
            result.add("pobi");
            result.add("woni");
            assertThat(winnersList).isEqualTo(result);
        }
    }
}
