package racingcar.View;

public class ValidationView {
    public boolean checkCarNameisEmpty(String carname) {
        if (carname.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTYCARNAME.getMessage());
        }
        return false;
    }
}
