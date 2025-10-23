package racingcar.View;

public enum ErrorMessage {
    EMPTYCARNAME("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
