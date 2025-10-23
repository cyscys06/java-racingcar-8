package racingcar.View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidationViewTest {
    private ValidationView validationView;
    @Nested
    @DisplayName("입력값 검증 테스트")
    class 입력값_검증_테스트 {
        @Test
        void 자동차_이름에_빈_문자열_있는지_검증_테스트() {
            String input = "pobi; woni;jun";
            assertThatIllegalArgumentException().isThrownBy(() -> validationview.CheckInputHaveWhiteSpace(input))
                    .withMessageContaining(ErrorMessage.EMPTYSTRING.getMessage());
        }
    }
}
