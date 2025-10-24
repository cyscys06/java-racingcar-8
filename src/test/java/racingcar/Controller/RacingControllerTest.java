package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingControllerTest {
    RacingController racingController;
    @BeforeEach
    void setUp() {
        racingController = new RacingController();
    }
    @Nested
    @DisplayName("경기 진행 테스트")
    class 경기_진행_테스트 {
        @Test
        void 무작위_수_생성_테스트() {
            int randomNumber = racingController.getRandomNumber();
            assertThat(randomNumber).isBetween(0, 9);
        }
    }
}
