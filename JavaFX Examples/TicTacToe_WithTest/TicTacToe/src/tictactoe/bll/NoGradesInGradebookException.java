package tictactoe.bll;

import java.util.*;

public class NoGradesInGradebookException extends RuntimeException {
    public NoGradesInGradebookException() {
        super();
    }

    public NoGradesInGradebookException(String message) {


        super(message);
    }

    public NoGradesInGradebookException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGradesInGradebookException(Throwable cause) {
        super(cause);
    }

    protected NoGradesInGradebookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
