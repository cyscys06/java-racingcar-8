package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Model.CarModel;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PrepareRaceControllerTest {
    private PrepareRaceController prepareRaceController;

    @BeforeEach
    public void setUp() {
        prepareRaceController = new PrepareRaceController();
    }

    @Nested
    @DisplayName("컨트롤러 테스트")
    class 자돋차_리스트_생성_컨트롤러_테스트 {
        @Test
        void 자동차이름_배열_생성_테스트() {
            String input = "pobi,woni,jun";
            String[] carnamearray = prepareRaceController.makeCarNameArray(input);
            assertThat(carnamearray).hasSize(3).containsExactly("pobi", "woni", "jun");
        }

        @Test
        void 자동차_리스트_생성_테스트() {
            String[] carnamearray = new String[]{"pobi", "woni", "jun"};
            List<CarModel> carList = prepareRaceController.makeCarList(carnamearray);
            assertThat(carList).hasSize(carnamearray.length);
            for (int i = 0; i < carList.size(); i++) {
                assertThat(carList.get(i).getCarName()).isEqualTo(carnamearray[i]);
                assertThat(carList.get(i).getMovementCount()).isEqualTo(0);
            }
        }

        @Test
        void 문자열_형태로_입력받은_이동시도횟수를_숫자로_변환_테스트() {
            String attemptsCountString = "9";
            int attemptsCountNumber = prepareRaceController.changeStringtoNumber(attemptsCountString);
            assertThat(attemptsCountNumber).isEqualTo(9);
        }
    }
}

