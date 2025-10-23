package racingcar.View;

import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {
    OutputView outputView;
    private PrintStream originalout;
    private ByteArrayOutputStream bytearrayout;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        originalout = System.out;
        bytearrayout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytearrayout));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalout);
    }

    @Nested
    @DisplayName("출력 테스트")
    class 출력_테스트 {
        @Test
        void 입력요구_출력_테스트() {
            outputView.requestInput(); // 나중에 만들 출력 메서드(println)
            String requestMessage = bytearrayout.toString(); // 메서드의 반환(출력)이 바이트 배열에 저장된 것을 문자열 형태로 반환(toString)
            assertThat(requestMessage).isEqualTo(Message.REQUESTINPUT.getMessage());
            // 레드코드 상태에선 바이트 배열에 저장된 값이 아무것도 없으므로 오류 뜸(파일끝에 도달했다는 메세지 출력)
        }
    }
}
