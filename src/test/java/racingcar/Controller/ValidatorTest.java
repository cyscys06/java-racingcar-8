package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.View.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private Validator validator;
    @BeforeEach
    void setUp() {
        validator = new Validator();
    }
    @Nested
    @DisplayName("입력값 검증 테스트")
    class 입력값_검증_테스트 {
        @Test
        void 자동차_이름에_빈_문자열_있는지_검증_테스트() {
            String input = "";
            assertThatIllegalArgumentException().isThrownBy(() -> validator.checkCarNameisEmpty(input))
                    .withMessageContaining(ErrorMessage.EMPTYCARNAME.getMessage());
        }

        @Test
        void 자동차_이름_5글자_이상인지_검증_테스트() {
            String[] carnamearray = new String[] {"pobi", "asdasd", "woni"};
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validator.checkCarNameLengthMorethan5(carnamearray))
                    .withMessageContaining(ErrorMessage.CARNAMELENGTHMORETHAN5.getMessage());
        }

        @Test
        void 자동차_이름_개수가_5를_넘는지_검증_테스트() {
            String[] carnamearray = new String[] {"pobi", "jun", "woni", "cys", "asda", "sgsdv"};
            assertThatIllegalArgumentException().isThrownBy(() ->
                            validator.checkCarNameArraySizeMorethan5(carnamearray))
                    .withMessageContaining(ErrorMessage.CARNAMEARRAYSIZEMORETHAN5.getMessage());
        }

        @Test
        void 입력한_이동시도횟수가_숫자가_아닌지_검증_테스트() {
            String attempts = "a";
            assertThatIllegalArgumentException().isThrownBy(()
                    -> validator.checkAttemptsCountisNotNumber(attempts))
                    .withMessageContaining(ErrorMessage.ATTEMPTSCOUNTISNOTNUMBER.getMessage());
        }

        @Test
        void 숫자로_변환한_이동시도횟수가_1_미만인지_검증_테스트() {
            int attemptsCount = -1;
            assertThatIllegalArgumentException().isThrownBy(()
                    -> validator.checkAttemptsCountisLessthan1(attemptsCount))
                    .withMessageContaining(ErrorMessage.ATTEMPTSCOUNTISLESSTHAN1.getMessage());
        }

        @Test
        void 숫자로_변환한_이동시도횟수가_10_초과인지_검증_테스트() {
            int attemptsCount = 13;
            assertThatIllegalArgumentException().isThrownBy(()
                            -> validator.checkAttemptsCountisMorethan10(attemptsCount))
                    .withMessageContaining(ErrorMessage.ATTEMPTSCOUNTISMORETHAN10.getMessage());
        }
    }
}
