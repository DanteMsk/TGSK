package com.example.tgsk.LayoutLogic;

public class ValidationData {

    public boolean checkDate(String dateBirth) {
        char[] dateBirthArray = dateBirth.toCharArray();
        if (dateBirthArray.length == 8 && dateBirthArray[2] == '.' && dateBirthArray[5] == '.') {
            return true;
        } else return false;
    }

}
