
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.text.*;
import java.sql.Time;


// Note : When structure of the Object type (the class file) in the list changed
// the Serialized file may fail.
public class SerializeDB
{
	public static List readSerializedObject(String filename) {
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static List insertSerializedObject(String filename, Object obj) {
		List list = null;
		int i;
		try	{
				// read from serialized file the list of professors
				list = (ArrayList)SerializeDB.readSerializedObject(filename);

				list.add(obj);  // remove the object from the list

				SerializeDB.writeSerializedObject(filename, list);
				//SerializeDB.deleteSerializedObject(".\\data\\professor.dat", p);

		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
		return list;
	}
	
	public static List updateSerializedObject(String filename, Object obj) {
		List list = null;
		int i;
		try	{
			// read from serialized file the list of professors
			list = (ArrayList)SerializeDB.readSerializedObject(filename);
			for (i = 0 ; i < list.size() ; i++) {
				//Professor p = (Professor)list.get(i);
				Object p = list.get(i);
				
				if (p.equals(obj)) {
					list.remove(p);
					list.add(i, obj);   //Add modified data
					break;
				} 
			}
			SerializeDB.writeSerializedObject(filename, list);
		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
		return list;
	}
	
	public static List deleteSerializedObject(String filename, Object obj) {
		List list = null;
		int i, j;
		try	{
				// read from serialized file the list of professors
				list = (ArrayList)SerializeDB.readSerializedObject(filename);

				list.remove(obj);  // remove the object from the list

				SerializeDB.writeSerializedObject(filename, list);
				//SerializeDB.deleteSerializedObject(".\\data\\professor.dat", p);

		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
		return list;
	}

	public static void main(String[] args) {
		List list = null;
		List newList = null;
		int i, j;
		
		/*******************Insert data of Movie*******************************
		List data = new ArrayList<>();
		String filename = ".\\data\\movie.dat";
		ArrayList<String> cast = new ArrayList<>();
		cast.add("Ryan Potter");      cast.add("Honey Lemon");
		ArrayList<MovieReview> movieReviews = new ArrayList<>();
		MovieReview review = new MovieReview("John","Very touching",4);   movieReviews.add(review);
		review = new MovieReview("Andy","A meaningful movie",5);          movieReviews.add(review);
		
		Movie movie = new Movie("Big Hero 6","Showing","A nice movie for family","Don Hall, Chris Williams",4.8,
				"Blockbuster",cast,movieReviews);
		data.add(movie);
		SerializeDB.writeSerializedObject(filename, data);  //Write data
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		//Call to update status
		//movie.updateStatus("Upcoming");
		
		for (i = 0 ; i < list.size() ; i++) {
			Movie m = (Movie)list.get(i);
			System.out.println("Title: " + m.getTitle() );
			System.out.println("Status: " + m.getStatus());
		}
		**********************************************************************/		
		
		/**********Insert data of Vendor, Cineplex, Cinema, Seat, ShowTime*********************/
		Vendor vendor = new Vendor();
		
		vendor.addCineplex("50 Jurong Gateway Road - Level 5, Jem - Singapore 608549");
		
		Cineplex cineplex = vendor.getCineplexAt(0);
		
		cineplex.addCinema(1);
		
		Cinema cinema = cineplex.getCinemaAt(0);
		
		int rowSize = cinema.getRowSize();
		int colSize = cinema.getColSize();
		for (i = 0 ; i < rowSize ; i++) {
			for (j = 0 ; j < colSize ; j++) {
				cinema.setSeatAt(i, j, "Standard");
			}
		}
		
		cinema.addShowTime("Big Hero 6", 10, 2, 2018, 10, 30);
		cinema.addShowTime("Big Hero 6", 15, 2, 2018, 15, 45);
		
		List data = new ArrayList<>();
		String filename = ".\\data\\vendor.dat";
		
		data.add(vendor);
		SerializeDB.writeSerializedObject(filename, data);  //Write data
		list = (ArrayList)SerializeDB.readSerializedObject(filename);  //Read data
		
		//Call to update status
		//movie.updateStatus("Upcoming");
		
		for (i = 0 ; i < list.size() ; i++) {
			Vendor v = (Vendor)list.get(i);
			System.out.println("VendorName: " + v.getVendorName() );
			//System.out.println("Status: " + m.getStatus());
		}
		/**********************************************************************/	
		
		/************************************************************************
		try	{
				// read from serialized file the list of professors
				//list = (ArrayList)SerializeDB.readSerializedObject(".\\data\\professor.dat"); 
				
				//Insert data
				//Professor insertedProf = new Professor("Joseph","jos@ntu.edu.sg",67909999);
				//list = (ArrayList)SerializeDB.insertSerializedObject(".\\data\\professor.dat", insertedProf);
				
				//Delete data
				//Professor deletedProf = new Professor("Joseph","jos@ntu.edu.sg",67909999);
				//list = (ArrayList)SerializeDB.deleteSerializedObject(".\\data\\professor.dat", deletedProf);
				
				//Update data
				Professor updatedProf = new Professor("Joseph","jos@ntu.edu.sg",3);
				list = (ArrayList)SerializeDB.updateSerializedObject(".\\data\\professor.dat", updatedProf);
				
				for (i = 0 ; i < list.size() ; i++) {
					Professor p = (Professor)list.get(i);
					System.out.println("name is " + p.getName() );
					System.out.println("contact is " + p.getContact() );
				}

		}  catch ( Exception e ) {
					System.out.println( "Exception >> " + e.getMessage() );
		}
		***************************************************/
	}
}