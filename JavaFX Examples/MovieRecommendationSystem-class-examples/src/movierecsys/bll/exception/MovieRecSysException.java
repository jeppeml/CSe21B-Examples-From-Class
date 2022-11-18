/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.bll.exception;

/**
 *
 * @author pgn
 */
public class MovieRecSysException extends Exception
{

    public MovieRecSysException(String message)
    {
        super(message);
    }

    public MovieRecSysException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieRecSysException(Throwable cause) {
        super(cause);
    }

    public MovieRecSysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MovieRecSysException() {
        super();
    }
}
