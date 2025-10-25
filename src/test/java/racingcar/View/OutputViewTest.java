package racingcar.View;

import org.junit.jupiter.api.*;
import racingcar.Model.CarModel;
import racingcar.View.OutputView;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

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
        void 자동차이름_입력요구_출력_테스트() {
            outputView.requestInput(); // 출력이 내부 바이트 배열에 저장됨
            String requestMessage = bytearrayout.toString().trim();
            // 메서드의 반환(출력)이 바이트 배열에 저장된 것을 문자열 형태로 반환(toString)
            // 그냥 toString만 쓰면 println이 개행 출력해서 개행도 같이 바이트 배열에 남음
            // 그냥 print를 쓰기엔 사용자가 입력을 무조건 줄바뀜 후 해야하므로, trim으로 개행문자 제거하기
            assertThat(requestMessage).isEqualTo(Message.INPUTREQUEST.getMessage());
            // 레드코드 상태에선 바이트 배열에 저장된 값이 아무것도 없으므로 오류 뜸(파일끝에 도달했다는 메세지 출력)
        }

        @Test
        void 이동시도횟수_입력요구_출력_테스트() {
            outputView.requestAttemptsCount();
            String requestMessage = bytearrayout.toString().trim();
            assertThat(requestMessage).isEqualTo(Message.ATTEMPTSREQUEST.getMessage());
        }
    }

    @Nested
    @DisplayName("출력 테스트")
    class 경기과정_출력_테스트 {
        private CarModel car1, car2, car3;
        private CarModel[] carList;
        @BeforeEach
        void setUp() {
            car1 = new CarModel("pobi");
            car2 = new CarModel("woni");
            car3 = new CarModel("jun");
            car1.moveCar();
            car2.moveCar();
            car2.moveCar();
            carList = new CarModel[] {car1, car2, car3};
        }

        @Test
        void 자동차_객체_이름_출력_테스트() {
            outputView.printCarName(car1);
            String printedCarName = bytearrayout.toString().trim();
            assertThat(printedCarName).isEqualTo(car1.getCarName());
        }

        @Test
        void 자동차_객체_이동횟수만큼_하이픈_출력_테스트() {
            outputView.printCarMovementCount(car2);
            String printedCarMovementCount = bytearrayout.toString().replace("\n", "");
            assertThat(printedCarMovementCount).isEqualTo(Message.COLON.getMessage() + "--");
        }

        @Test
        void 자동차_객체_정보_출력_테스트() {
            outputView.printCarData(carList);
            String printedCarData = bytearrayout.toString();
            assertThat(printedCarData).isEqualTo(
                    "pobi : -" + System.lineSeparator() +
                            "woni : --" + System.lineSeparator() +
                            "jun : " + System.lineSeparator()
            );
        }

        @Test
        void 우승자_출력_테스트() {
            List<String> winnersList = new ArrayList<>();
            winnersList.add("pobi");
            winnersList.add("woni");
            outputView.printWinner(winnersList);
            String printedWinner = bytearrayout.toString().trim();
            assertThat(printedWinner).contains("pobi,woni");
        }
    }
}
