package racingcar.View;

public class ValidationView {
    public boolean checkCarNameisEmpty(String carname) {
        if (carname.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTYCARNAME.getMessage());
        }
        return false;
    }

    public boolean checkCarNameLengthMorethan5(String[] carnamearray) {
        Integer MAXIMUMLEGNTH = 5;
        for (String carname : carnamearray) {
            if (carname.length() > MAXIMUMLEGNTH) {
                throw new IllegalArgumentException(ErrorMessage.CARNAMELENGTHMORETHAN5.getMessage());
            }
        }
        return false;
    }

    public void checkCarNameArraySizeMorethan5(String[] carnamearray) {
        Integer MAXIMUMSIZE = 5;
        if (carnamearray.length > MAXIMUMSIZE) {
            throw new IllegalArgumentException(ErrorMessage.CARNAMEARRAYSIZEMORETHAN5.getMessage());
        }
    }
}
