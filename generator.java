
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class generator {
/*
 * We are going to be generating random data for BarBeerDrinker database	
 */
	public static void main(String[] args) throws FileNotFoundException{
		BarsCSV(bars());
		DrinkersCSV(drinkers());
		ItemsCSV(items());
		//bars();
		//drinkers();
		//items();
		return;
	}
	
	public static ArrayList<String> bars() {
		String[] bars = {"Atomic Liquors", "Ray's Happy Birthday Bar", "Lee Harvey's",
				"Tin 'n' Lint", "Hot Bird", "The Tipsy Cow", "Fat Angel", "Robert's Western World", "The Fainting Goat", "95 Slide",
				"Murio's Trophy Room", "The Monkey Farm Cafe", "The Pastry War", "The People's Republik","Psycho Suzi's", "Tiki Bar",
				"The Grackle", "Snake and Jake's Christmas Club Lounge", "Bar of the Dogs", "Death and Co",
				"The Surly Wench Pub", "Otto's Shrunken Head", "Hop Sing Laundromat", "The Pitch and Roll", "Hard Times and Misery Saloon", "Brotherhood of Thieves",
				"Marie's Crisis Cafe", "Jumbo's Clown Room", "The Billy goat Tavern", "Smog Cutter", "The Jack Saloon",
				"The Double Deuce", "The Pool Hall", "The Snakehole", "The Dexter Lake Club", "Maccadam's Old Oil House",
				"The Drunken Clam", "Playaz Club", "Cockatoo Inn", "Munden's Bar", "The Brick", "The Crow & Crown", "Tabard Inn", "The Hip Joint",
				"Gaston's", "Levy's", "The Admiral Benbow Inn", "Kelly's Korner", "Ink and Paint Club", "Volpe's", "Harry Hope's Saloon",
				"O'Malley's Bar", "Meibeyer's", "Ten Foward", "The Green Dragon Inn", "Kadie's Club Pecos", "The Bar at Milliways",
				"The Bar", "The Moon Under Water", "The Bang Bang Bar", "Cheers", "Bada Bing!", "Greely's", "Chatsubo", "Bob's Country Bunker", 
				"Club Sugar Ray", "The Hog's Head Inn", "The Last Resort", "The Tiny Twister", "Dino's Bar and Grill", "Winchester Tavern",
				"A Clean, Well-Lighted Place", "The Gold Room", "Paddy's Pub", "Boar's Head Tavern", "The Gem Saloon", "Korova Milk Bar",
				"Mos Eisley Cantina", "Rick's Cafe Americanain", "Moe's Tavern"};
		String[] location = {"Connecticut", "Delaware", "Massachusetts", "Maryland", "New Hampshire", "Pennsylvania", "New Jersey", "New York", 
				"Virginia", "Tennessee", "Florida", "Georgia", "Ohio", "Iowa", "Mississippi", "Lousiana", "Maine", "Rhode Island", "Vermont", 
				"Alabama", "Kentucky", "North Carolina", "South Carolina", "West Virginia"};
		String[] opening_hours = {"10:00", "12:00", "10:30", "11:00", "11:30"};
		String [] closing_hours = {"00:00", "01:00", "01:30", "02:00", "02:30"};
		
		ArrayList<String> Bars = new ArrayList<String>();
		for(int i = 0; i < bars.length; i++) {
			int lrnd = new Random().nextInt(location.length);
			int ornd = new Random().nextInt(opening_hours.length);
			int crnd = new Random().nextInt(closing_hours.length);
			Bars.add(bars[i] + "," + location[lrnd] + "," + opening_hours[ornd] + "," + closing_hours[crnd]);
		}
		for(int i = 0; i < Bars.size(); i++) {
			System.out.println(Bars.get(i));
		}
		
		return Bars;
	}
	
	public static void BarsCSV(ArrayList<String> Bars) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Bars.csv"));
		String header = "name,location,opening_hours,closing_hours" + '\n';
		pw.println(header);
		for(int i = 0; i < Bars.size(); i++) {
			pw.println((Bars.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> drinkers() {
		String[] names = {"Tom","Jake", "Mike", "Carl", "Bob","Joe",
				"Shreya", "Olivia", "Nick", "Ally", "Carly", "Nicole", "Susie",
				"Lily", "Kelly", "Leah", "Lori", "Ryan", "Sarah", "Marley",
				"Jackie", "Abby", "Adam", "AJ", "Akhil", "Amanda", "Ashley", "Austin",
				"Bill", "Brad", "Briana", "Brielle", "Mary", "Chad", "Chris", "Colleen",
				"Danielle", "Deep", "Emmet", "Erica", "Jessica", "Jeff", "Geoff", "George", "Juan", "Griffin",
				"Nicar", "Gustavo", "Sasha", "Hannah", "Hunter", "Harry", "Jason", "Jessie", "John", "Jose", "Julian",
				"Kyle", "Karen", "Liz", "Matt", "Max", "Megan", "Molly", "Nina", "Natalie", "Oliver", "Srid", "Sidd", "Roland",
				"Rosie", "Sage", "Sahara", "Samia", "Sean", "Shawn", "Sue", "Alex", "Shannon", "Kristina", "Caroline", "Terry",
				"Ted", "Tyler", "Wesley", "Xena", "Yash", "Lee", "Bingchen", "Jamar", "Tyrone", "Doran", "David", "William", "Victoria",
				"Michelle", "Myron", "Snoop"};

		String[] address = {"Connecticut", "Delaware", "Massachusetts", "Maryland", "New Hampshire", "Pennsylvania", "New Jersey", "New York", 
				"Virginia", "Tennessee", "Florida", "Georgia", "Ohio", "Iowa", "Mississippi", "Lousiana", "Maine", "Rhode Island", "Vermont", 
				"Alabama", "Kentucky", "North Carolina", "South Carolina", "West Virginia"};
		
		ArrayList<String> Drinkers = new ArrayList<String>();
		for(int i = 0; i < names.length; i++) {
			int rnd = new Random().nextInt(address.length);
			Drinkers.add(names[i] + "," + address[rnd]);
		}
		
		for(int i = 0; i < Drinkers.size(); i++) {
			System.out.println(Drinkers.get(i));
		}
		
		return Drinkers;
	}
	
	public static void DrinkersCSV(ArrayList<String> Drinkers) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Drinkers.csv"));
		String header = "name,address" + '\n';
		pw.println(header);
		for(int i = 0; i < Drinkers.size(); i++) {
			pw.println((Drinkers.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> items() {
		String[] beers = {"Budweiser,Anheuser-Busch", "Stella Artios,Anheuser-Busch", "Landshark Lager,Anheuser-Busch", "Hoegaarden,Anheuser-Busch", "Coors,MillerCoors", "Icehouse,MillerCoors", "Blue Moon,MillerCoors" , "Pilsner,MillerCoors", "Heineken,Heineken USA", "Dos Equis,Heineken USA", "Corona,Constellation Brands", "Tsingtao,Constellation Brands", "Pabst Blue Ribbon,Pabst", "Lone Star,Pabst", "Samuel Adams,Boston Beer Co.", "Guinness,Diageo North America"};
		String[] other = {"Hamburger,NULL", "Frie,NULLs", "Hot Dog,NULL", "Lemonade,NULL", "Coke,NULL", "Mountain Dew,NULL", "Pretzels,NULL", "Goldfish,NULL", "Coffee,NULL", "Soup,NULL", "Wings,NULL", "Nachos,NULL", "French Dip,NULL", "Grilled Cheese,NULL", "Fat Sandwich,NULL"};
		
		ArrayList<String> Items = new ArrayList<String>();
		for(int i = 0; i < beers.length; i++) {
			Items.add(beers[i]);
		}
		for(int j = 0; j < other.length; j++) {
			Items.add(other[j]);
		}
		
		for(int i = 0; i < Items.size(); i++) {
			System.out.println(Items.get(i));
		}
		
		return Items;
	}
	
	public static void ItemsCSV(ArrayList<String> Items) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Items.csv"));
		String header = "name,manufacturer" + '\n';
		pw.println(header);
		for(int i = 0; i < Items.size(); i++) {
			pw.println((Items.get(i)).toString());
		}
		pw.close();
	}
	
	public static void frequents() {
		
		return;
	}
	
	public static void issues() {
		
		return;
	}
	
	public static void sells() {
		
		return;
	}
	
	public static void billed_to() {
		
		return;
	}
	
	public static void on() {
		
		return;
	}
	
	public static void bills() {
		
		return;
	}
	
	
}