package view;

public class BookingHistoryView extends MoblimaViews{ //Allow Moviegoers to view booking history
    public void enterView() {
        //Call BookingHistoryController
    }
    //DO NOT have to implement login, as we can simply use their email address and mobile number to go the entity to
    //grab their booking history. Pass this to BookingHistoryCtrl to get all their past bookings
}
