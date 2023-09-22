/*
 * Ayah Saad 
 * 1191334
 */
import java.io.*;
import java.util.*;

public class Driver {
	/* create array list */
	  static ArrayList<Vehicles> vehicles = new ArrayList<>();
	public static void main(String[] args) throws CloneNotSupportedException, IOException {

	    java.util.Scanner in = new java.util.Scanner(System.in);
	    PetroleumType pt = new PetroleumType();
		int Case;
		while (true) {
			System.out.println("Welcome Please chose from the menu");
			System.out.println("1. Read the data about objects from InputData.txt and store in arraylist.");
			System.out.println("2. Set prices of petroleum.");
			System.out.println("3. Print sorted order Vehicles in an ascending order based on costFor100Km.");
			System.out.println("4. Print sorted order Vehicles in an ascending order based on owner name .");
			System.out.println("5. Print sorted order Vehicles in an descending order based on vehicle brand.");
			System.out.println(
					"6. Clone Vehicle without owner. (Ask user to choice one object for cloning from Arraylist, after Listing them to user )");
			System.out.println("7. Turn air-condition on");
			System.out.println("8. Write Output on the “output.txt” file after sort them.");
			System.out.println("9. Exit from System");
			System.out.println("\n**************************************************************");
			Case = in.nextInt();
			switch (Case) {
			case 1: /* Read the data from InputData.txt file and store in array list */
		     		read(in,pt); /* call the method read() to read from file */
	               System.out.println(" file was read and stored the info in an arraylist\n");
				break;

			case 2: /*
					 * we Use Exception Handling to handle errors caused by mismatch filling type of
					 * Petroleum , throw an illegal argument exception
					 */
				try {
					/* Set prices of petroleum there are 2 type of it Gasoline and Diesel */
					for(Vehicles v:vehicles)  /* for loop to set price foe all vehicles and then calculate the cost for each one*/
		               {
		                   v.costFor100km(pt);
		               }
					System.out.print("Please Enter the price of GasoLine:");
					double price = in.nextDouble(); /* read the price */
					pt.setGasolinePrice(price); /* set the price of gasoline */
					System.out.print("Please Enter the price of Diesel:");
					double price1 = in.nextDouble(); /* read the price */
					pt.setDieselPrice(price1); /* set the price of diesel */
					
				} catch (IllegalArgumentException e) {
					System.out.println("errors caused by mismatch filling type of Petroleum");
				}
				break;

			case 3: /* sorted Vehicles in an ascending order based on costFor100Km. */
				/* using Collection.sort method */
				Collections.sort(vehicles);
				System.out.println("sorted Vehicles in an ascending order based on costFor100Km: \n");
				int a = 1;
				for (Vehicles v : vehicles) {
					System.out.println("["+ a + "]" + v.toString() + "\n");/* print the sorted ArrayList */
					a++;
				}
				break;

			case 4: /* sorted Vehicles in an ascending order based on owner name. */
				/*
				 * The compare() method compares two objects of type string based on owner name.
				 */
				vehicles.sort(new Comparator<Vehicles>() {
					@Override
					public int compare(Vehicles v1, Vehicles v2) {
						return -(v1.getOwner().getName().compareTo(v2.getOwner().getName()));
					}
				});
				System.out.println("sorted Vehicles in an ascending order based on owner name: \n");
				int j = 1;
				for (Vehicles v : vehicles) {
					System.out.println("["+ j + "]"+ v.toString() + "\n");/* print the sorted ArrayList */
					j++;
				}
				break;

			case 5: /* sorted Vehicles in an descending order based on vehicle brand. */
				/*
				 * The compare() method compares two objects of type string based on vehicle brand.
				 */
				vehicles.sort(new Comparator<Vehicles>() {
					@Override
					public int compare(Vehicles v1, Vehicles v2) {
						return v1.getBrand().compareTo(v2.getBrand());
					}
				});
				System.out.println("sorted Vehicles in an decending order based on vehicle brand: \n");
				int i = 1;
				for (Vehicles v : vehicles) {
					System.out.println("["+ i + "]"+ v.toString() + "\n");/* print the sorted ArrayList */
					i++;
				}
				break;
			case 6: /* Ask user to choice one object for cloning from Array list. */
				System.out.println("please enter the number of object to clone: ");
				int n = 1;
				/*
				 * for loop to print all info about vehicles with each index to choice from them
				 */
				for (Vehicles v : vehicles) {
					System.out.println("["+ n + "]" + v.toString());
					n++;
				}
				int choice = in.nextInt();
				if (n < vehicles.size()) { /* if statement to clone object if his index was exist */
					Vehicles c = (Vehicles) vehicles.get(choice).clone(); /* clone the vehicle which was chosen */
					vehicles.add(c);
					System.out.println("the cloned vehicle is : \n" + c.toString()); /* to print cloned vehicle */
				} 
				break;
			case 7: /* Turn air-condition on. */
				for (Vehicles v : vehicles) /* for loop for all vehicles object. */
				{
					v.setAirConditionON(); /* set air-condition to on. */
				}
				System.out.println("Air condition was turned ON.");
				break;
			case 8: /* Write Output on the “output.txt” file after sort them. */
				StringBuilder info1 = new StringBuilder();
				for (Vehicles v : vehicles) {
					info1.append(v.toString() + "\n");
				}
				/* Create a file */
				java.io.File file2 = new java.io.File("output.txt");
				java.io.PrintWriter printWriter = new java.io.PrintWriter(file2);
				printWriter.write(new String(info1));
				/* Close the file */
				printWriter.close();
				System.out.println("Info was written to the file");
				break;
			case 9: /* To Exit */
				System.out.println("Exit from the program \n Good Bye");
				System.exit(0);
				break;
			}
		
		}
	}

	 /* method that will read the data about the vehicles */
	@SuppressWarnings("resource")
	private static void read(Scanner In,PetroleumType pt) throws FileNotFoundException
	   {
	          	/* create file to read from it */
				java.io.File file1=new java.io.File("InputData.txt"); 
				/* Create a Scanner for the file */
				In=new Scanner(file1);
				/* Read data from a file */
	       while(In.hasNextLine())
	       {  
	    	    /*
				 * we use hasNextLine() in Scanner to be sure to read all lines 
				 */
	           String line=In.nextLine();
	           String[] line1=line.toString().split(",");
	           if(line1[0].equals("Car"))
	           {
	               Car car=new Car(); 
	               car.setModelName(line1[1]);
	               car.setModelNo(line1[2]);
	               car.setBrand(line1[3]);
	               Owner owner=new Owner("Name");
	               owner.setName(line1[4]);
	               owner.setRegisterionNo(line1[5]);
	               owner.setAddress(line1[6]);
	               owner.setTel(line1[7]);
	               car.setOwner(owner);
	               car.setEngineType(line1[8]);
	               car.setTunkSize(Double.parseDouble(line1[9].trim()));
	               car.setFuel_consumption(Double.parseDouble(line1[10].trim()));
	               car.setNumberOfSeats(Integer.parseInt(line1[11].trim()));
	               vehicles.add(car);
	           }
	           else if(line1[0].equals("Truck"))
	           {
	               Truck truck=new Truck();
	               truck.setModelName(line1[1]);
	               truck.setModelNo(line1[2]);
	               truck.setBrand(line1[3]);
	               Owner owner=new Owner("Name");
	               owner.setName(line1[4]);
	               owner.setRegisterionNo(line1[5]);
	               owner.setAddress(line1[6]);
	               owner.setTel(line1[7]);
	               truck.setOwner(owner);
	               truck.setEngineType(line1[8]);
	               truck.setTunkSize(Double.parseDouble(line1[9].trim()));
	               truck.setFuel_consumption(Double.parseDouble(line1[10].trim()));
	               truck.setNumberOfSeats(Integer.parseInt(line1[11].trim()));
	               truck.setPower(Integer.parseInt(line1[12]));
	               vehicles.add(truck);
	           }
	           else if(line1[0].equals("Minivan"))
	           {
	               Minivan minivan=new Minivan();
	               minivan.setModelName(line1[1]);
	               minivan.setModelNo(line1[2]);
	               minivan.setBrand(line1[3]);
	               Owner owner=new Owner("Name");
	               owner.setName(line1[4]);
	               owner.setRegisterionNo(line1[5]);
	               owner.setAddress(line1[6]);
	               owner.setTel(line1[7]);
	               minivan.setOwner(owner);
	               minivan.setEngineType(line1[8]);
	               minivan.setTunkSize(Double.parseDouble(line1[9].trim()));
	               minivan.setFuel_consumption(Double.parseDouble(line1[10].trim()));
	               minivan.setNumberOfSeats(Integer.parseInt(line1[11].trim()));
	               minivan.setHasAutoDoors(Boolean.valueOf(line1[12]));
	               vehicles.add(minivan);
	           }
	       }
	   }
}
