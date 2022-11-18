package movierecsys.bll;

import java.time.LocalDate;

public class InputValidator {

    /**
     *
     * @param text formatted as YYYY
     * @return YYYY as int if year is valid, otherwise return -1
     */
    public int getValidYear(String text) {
        int validYear = -1; // -3242362
        try{
            validYear = Integer.parseInt(text);
        }
        catch (NumberFormatException nfe){
            return -1;
        }

        if (validYear>1600 && validYear < LocalDate.now().getYear()+100){
            return validYear;
        }
        return -1;
    }
}
