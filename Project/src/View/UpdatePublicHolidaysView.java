package View;

import static Controllers.UpdatePublicHolidaysCtrl.*;

public class UpdatePublicHolidaysView extends ManageSystemSettingsView {

    @Override
    public void enterView() {
        boolean loop = true, publicHolidayExist;
        int choice, index, year=0, month=0, day=0;
        double price = 0;

        while(loop) {
            /*********************Display Menu**************************/
            System.out.println("\n>>>>>>>>>>\n");

            int num = 13;
            String str = " " + "_".repeat(num) + " Staff - UPDATE PUBLIC HOLIDAY " + "_".repeat(num);
            System.out.println(str);
            //System.out.println("str.length() - 3: " + (str.length() - 3));
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "1) Add public holiday");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "2) Remove public holiday");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n", "3) Back to Main Menu");
            System.out.printf("*  %-" + (str.length() - 3) + "s*\n","");

            System.out.println("* ".repeat(str.length() / 2 + 1));
            System.out.println("");
            /***********************************************************/

            System.out.print("Enter your choice: ");
            choice = readInt(1);
            if (choice == -1) continue;
            else if (choice<=0 || choice >3){
                System.out.println("Please enter a number between 1 to 3.");
                continue;
            } else {
                while (loop) {
                    System.out.print("Enter new year: ");
                    year = readInt(1);
                    if (year == -1) continue;
                    else if (year < 2019 || year > 2050) {
                        System.out.println("Please enter a year between 2019 to 2050.\n");
                        continue;
                    }
                    break;
                }
                while (loop){
                    System.out.print("Enter new month: ");
                    month = readInt(1);
                    if (month == -1) continue;
                    else if (month < 1 || month > 12) {
                        System.out.println("Please enter a month between 1 to 12.\n");
                        continue;
                    }
                    break;
                }
                while (loop) {
                    System.out.print("Enter new day: ");
                    day = readInt(1);
                    if (day == -1) continue;
                    else if (day < 1 || day > 31) {
                        System.out.println("Please enter a day between 1 to 31.\n");
                        continue;
                    }
                    break;
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
