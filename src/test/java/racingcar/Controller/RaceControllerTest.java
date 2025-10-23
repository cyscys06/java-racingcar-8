package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RaceControllerTest {
    private CarController carController;

    @BeforeEach
    public void setUp() {
        carController = new CarController();
    }

    @Nested
    @DisplayName("컨트롤러 테스트")
    class 컨트롤러_테스트 {
        @Test
        void 자동차이름_배열_생성_테스트() {
            String input = "pobi,woni,jun";
            String[] carnamearray = carController.makeCarNameArray(input);
            assertThat(carnamearray).hasSize(3).containsExactly("pobi", "woni", "jun");
        }
    }
}
