package co.grand.country;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class CountriesApp {
	static Scanner scan = new Scanner(System.in);

	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) throws IOException {
		

		Path  path = Paths.get("countries.txt");
		
		
		int pop;
		

		
		
		String name ="";
		
			
		System.out.println("Main Menue\n1. Show List\n2. Add Country\n3. Remove\n4. Exit");
		System.out.println("Select an option: ");
		int userChoice = scan.nextInt();
		scan.nextLine();
		
		do {
		
		switch (userChoice) {
		case 1:	
			
			List<Country> country = CountriesTextFile.readFile();
		for (Country c: country) {
			System.out.println(c.getName() + " population " + c.getPopulation());
		}
		break;
		
		case 2:
			
			do {
				System.out.print("Enter the name of a country: ");
				 name = scan.nextLine();
				System.out.print("Enter " + name + "'s population: ");
				int population = scan.nextInt();
				scan.nextLine();
				
				Country newCountry = new Country(name, population);
				try {
					CountriesTextFile.appendToFile(newCountry);
				} catch (IOException e) {
					System.out.println("Could not edit file.");
				}
				
				System.out.println("Would you like to add another country(y/n)?: ");
				
			}while(name.equalsIgnoreCase("y")||name.equalsIgnoreCase("Y"));
			
			break;
		case 3:
			
				removeCountry( );
				break;
		}
		}while (userChoice != 4); 
			System.out.println("Shutting down... Goodbye.");
			
		scan.nextLine();
		
		
		}

	private static void ensureFilesExist() throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
	}

	public static void removeCountry() throws IOException {
		String name = Validator.getString(scan, "What country would you like to remove?");
		List<Country> toRemove = CountriesTextFile.readFile();
		for (int i = 0; i < toRemove.size(); i++) {
			if (toRemove.get(i).getName().equals(name)) {
				toRemove.remove(i);
			}
		}
		CountriesTextFile.rewriteFile(toRemove);
		System.out.println("Country has been destroyed");
	}

}
