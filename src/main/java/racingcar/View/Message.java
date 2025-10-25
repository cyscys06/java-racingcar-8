package racingcar.View;

public enum Message {
    // 자동으로 내부 객체 만들어줌(enum 클래스가)
    // 처음 만든 열거형 인덱스 0부터 시작
    COLON(" : "),
    HYPHEN("-"),
    WINNER("최종 우승자"),
    INPUTREQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPTSREQUEST("시도할 횟수는 몇 회인가요?"),
    RESULT("실행 결과");

    private final String message;

    // 생성자
    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
