package racingcar.Controller;

import racingcar.View.ErrorMessage;

public class Validator {
    public void checkCarNameisEmpty(String carname) { // 빈 문자열인지 검증
        if (carname.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTYCARNAME.getMessage());
        }
    }

    public void checkCarNameLengthMorethan5(String[] carnamearray) {
        int MAXIMUMLEGNTH = 5;
        for (String carname : carnamearray) {
            if (carname.length() > MAXIMUMLEGNTH) {
                throw new IllegalArgumentException(ErrorMessage.CARNAMELENGTHMORETHAN5.getMessage());
            }
        }
    }

    public void checkCarNameArraySizeMorethan5(String[] carnamearray) {
        int MAXIMUMSIZE = 5;
        if (carnamearray.length > MAXIMUMSIZE) {
            throw new IllegalArgumentException(ErrorMessage.CARNAMEARRAYSIZEMORETHAN5.getMessage());
        }
    }

    public void checkAttemptsCountisNotNumber(String attemptscount) {
        try {
            Integer.parseInt(attemptscount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPTSCOUNTISNOTNUMBER.getMessage());
        }
    }

    public void checkAttemptsCountisLessthan1(int attemptscount) {
        if (attemptscount < 1) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPTSCOUNTISLESSTHAN1.getMessage());
        }
    }

    public void checkAttemptsCountisMorethan10(int attemptscount) {
        if (attemptscount > 10) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPTSCOUNTISMORETHAN10.getMessage());
        }
    }

    public boolean checkCarMoveable(int pickedNumber) {
        return pickedNumber >= 4;
    }
}
