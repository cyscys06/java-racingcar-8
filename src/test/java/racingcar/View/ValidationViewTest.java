package racingcar.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidationViewTest {
    private ValidationView validationview;
    @BeforeEach
    void setUp() {
        validationview = new ValidationView();
    }
    @Nested
    @DisplayName("입력값 검증 테스트")
    class 입력값_검증_테스트 {
        @Test
        void 자동차_이름에_빈_문자열_있는지_검증_테스트() {
            String input = "";
            assertThatIllegalArgumentException().isThrownBy(() -> validationview.checkCarNameisEmpty(input))
                    .withMessageContaining(ErrorMessage.EMPTYCARNAME.getMessage());
        }

        @Test
        void 자동차_이름_5글자_이상인지_검증_테스트() {
            String[] carnamearray = new String[] {"pobi", "asdasd", "woni"};
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validationview.checkCarNameLengthMorethan5(carnamearray))
                    .withMessageContaining(ErrorMessage.CARNAMELENGTHMORETHAN5.getMessage());
        }
    }
}
