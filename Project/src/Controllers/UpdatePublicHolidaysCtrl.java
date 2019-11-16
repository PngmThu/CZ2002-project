package Controllers;

import Entities.PublicHoliday;

public class UpdatePublicHolidaysCtrl {
    public static boolean addPublicHoliday(int year, int month, int day) {
        String date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);
        if (PublicHoliday.publicHolidayExist(date)){
            return false;
        }
        PublicHoliday.addPublicHolidaysData(date);
        return true;
    }
    public static boolean deletePublicHoliday(int year, int month, int day) {
        String date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);
        if ((PublicHoliday.publicHolidayExist(date)))
            PublicHoliday.deletePublicHolidaysData(date);
        else return false;
        return true;
    }
}
