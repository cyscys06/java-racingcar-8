package racingcar.View;

public class OutputView {
    public void requestInput() {
        System.out.println(Message.INPUTREQUEST.getMessage());
    }

    public void requestAttemptsCount() {
        System.out.println(Message.ATTEMPTSREQUEST.getMessage());
    }
}
