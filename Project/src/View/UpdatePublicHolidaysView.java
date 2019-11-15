package View;

import static Controllers.UpdatePublicHolidaysCtrl.*;

public class UpdatePublicHolidaysView extends ManageSystemSettingsView {

    @Override
    public void enterView() {
        boolean loop = true, publicHolidayExist;
        int choice, index, year, month, day;
        double price = 0;

        while(loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Update Public Holidays");
            System.out.println("*************************************");
            System.out.println("1) Add a Public Holiday");
            System.out.println("2) Remove a Public Holiday");
            System.out.println("3) Go back\n");
            System.out.print("Enter your choice: ");
            choice = readInt(0);
            if (choice == -1) continue;
            else if (choice<=0 || choice >3){
                System.out.println("Please enter a number between 1 to 3.");
                continue;
            } else {
                while (loop) {
                    System.out.println("---- Enter a new public holiday below ----");
                    System.out.print("Enter new year: ");
                    year = readInt(1);
                    if (year == -1) continue;
                    else if (year < 2019 || year > 2050) {
                        System.out.println("Please enter a year between 2019 to 2050.");
                        continue;
                    }
                    System.out.print("Enter new month: ");
                    month = readInt(1);
                    if (month == -1) continue;
                    else if (month < 1 || month > 12) {
                        System.out.println("Please enter a year between 1 to 12.");
                        continue;
                    }
                    System.out.print("Enter new day: ");
                    day = readInt(1);
                    if (day == -1) continue;
                    else if (day < 1 || day > 31) {
                        System.out.println("Please enter a year between 1 to 31.");
                        continue;
                    }
                    if(choice == 1) {
                        if (!addPublicHoliday(year, month, day))
                            System.out.println("Public holiday Successfully added.");
                        else
                            System.out.println("Public holiday already exist.");
                        break;
                    } else{
                        if(deletePublicHoliday(year, month, day))
                            System.out.println("Public Holiday Successfully Deleted.");
                        else
                            System.out.println("The public holiday do not exist, please try again.");
                        break;
                    }
                }
            }
        }
    }
}
