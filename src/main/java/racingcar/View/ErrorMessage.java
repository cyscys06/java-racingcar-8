package racingcar.View;

public enum ErrorMessage {
    EMPTYCARNAME("빈 문자열을 자동차 이름으로 입력할 수 없습니다."),
    CARNAMELENGTHMORETHAN5("5글자가 넘는 문자열을 자동차 이름으로 입력할 수 없습니다."),
    CARNAMEARRAYSIZEMORETHAN5("최대 5개의 자동차만 경주에 참여할 수 있습니다."),
    ATTEMPTSCOUNTISNOTNUMBER("숫자가 아닙니다."),
    ATTEMPTSCOUNTISLESSTHAN1("1 미만의 수를 이동 시도 횟수로 입력할 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
