package View;

public class UpdatePublicHolidaysView extends ManageSystemSettingsView {

    @Override
    public void enterView() {
        boolean loop = true;
        int choice, index;
        double price = 0;

        while(loop) {
            System.out.println("*************************************");
            System.out.println("Admin - Update Public Holidays");
            System.out.println("*************************************");
            System.out.println("1) Add a Public Holiday");
            System.out.println("2) Remove a Public Holiday");
            System.out.println("3) Go back\n");
            choice = readInt(false);
            if (choice == -1) continue;
            else if (choice<=0 || choice >3){
                System.out.println("Please enter a number between 1 to 3.");
                continue;
            } else {
                System.out.println("Enter");
            }
        }
    }
}
