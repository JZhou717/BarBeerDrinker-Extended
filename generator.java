import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class generator {
/*
 * We are going to be generating random data for BarBeerDrinker database	
 */
	public static void main(String[] args) throws Exception{
		
		//ArrayList<String> names = nameGenerator();
		
		//BarsCSV(bars());
		//DrinkersCSV(drinkers(names));
		//ItemsCSV(items());
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
				"Mos Eisley Cantina", "Rick's Cafe Americanain", "Moe's Tavern", "Salty Squid", "Inky Stink", "Leaky Faucet", "Rusted Furnace", 
				"Mystic Island Casino", "Tucker's Tavern", "Mickey's Pub", "Weenie Hut Jr's", "Bean Bag", "Lighthouse Bar and Grill", "Burnt Toast", 
				"Lefty's Pub", "Element", "Oyster Creek Inn", "Scarlet Pub", "Clydz", "Corner Tavern", "Barca City", "The Dogg House", "Steve Vo's", 
				"Caribbean Breeze", "Cajun Cabin", "Jazzy B's", "Coffeecake", "Street Dips", "Just Off Vine", "El Tenedor", "Wilma's", "Jimmy D's", 
				"Jalapeno Brothers", "Off the Hook", "The Rolling Hunger", "Fast Eddie's", "Bernie's Burger Bus", "Mr. Sizzles", "1836 Grill", 
				"Burgers Ya Heard", "The Boxcar", "The Store", "Lil Phil's Grill", "Victory", "The Hideout Theatre", "Midnight Cowboy", 
				"The Roosevelt Room", "Firehouse Lounge", "HandleBar", "Garage", "Friends Bar", "Whisler's", "Dive Bar and Lounge", "Seven Grand", 
				"Craft Pride", "Knomad Bar", "The Townsend", "The Jackalope", "Half Step", "Full Circle Bar", "The Skylark Lounge",
				"The Crazy Horse", "Mikkeller Bar", "Bourbon and Branch", "Smuggler's Cove", "Pacific Cocktail Haven", "Benjamin Cooper", 
				"Rickhouse", "Holy Water", "Trick Dog", "Comstock Saloon", "Whitechapel", "Black Horse London Pub", "15 Romolo", "Novela", 
				"Forgery Bar", "Cityscape", "Local Edition", "Bar Fluxus", "Zeitgeist", "Tonga Room", "Top of the Mark", "Fireside Bar", 
				"Library Bar", "Last Call Bar", "The Alembic", "Kozy Kar", "Rock Bar", "Zam Zam", "Toronado", "Bar 821", "The House of shields", 
				"Buddha Lounge", "Wildhawk", "Tempest", "BlackBird", "Third Rail", "Cold Drinks Bar", "Madrone Art Bar", "Clock Bar", 
				"Aunt Charlie's Lounge", "Linden Room", "Bender's", "The Page", "The Starlight Room", "The Monk's Kettle", "Bond Bar", 
				"Dalva", "White Cap", "Canela Bistro and Wine Bar", "Bus Stop", "Press Club", "Hazel Southern Bar", "Monaghan's Bar", 
				"Noc Noc", "Oddjob", "The Sea Star", "Resolute", "The Beer Hall", "Hi Tops", "Union Square Sports Bar", "Blondie's Bar", 
				"Brass Tracks", "Bar San Pancho", "The Pied Piper", "Charmaine's", "The Chapel"};
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
		/*for(int i = 0; i < Bars.size(); i++) {
			System.out.println(Bars.get(i));
		}*/
		
		return Bars;
	}
	
	public static void BarsCSV(ArrayList<String> Bars) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Bars.csv"));
		String header = "name,location,opening_hours,closing_hours";
		pw.println(header);
		for(int i = 0; i < Bars.size(); i++) {
			pw.println((Bars.get(i)).toString());
		}
		pw.close();
	}
	
	//This function reads the txt file of names that we found and extracts just the name from each line
	public static ArrayList<String> nameGenerator() throws Exception{
		ArrayList<String> list = new ArrayList<String>();
		File file = new File("C:/Users/Jake/myWorkspace/databases/src/nameList.txt");
		Scanner sc = new Scanner(file);
		String buffer;
		
		for(int i = 0; i < 1500; i++) {
			buffer = sc.nextLine();
			String[] line = buffer.split("\\s+", 2);
			String name = line[0];
			
			//System.out.println(name);
			name = name.charAt(0) + name.substring(1).toLowerCase();
			//System.out.println(name);
			
			list.add(name);
		}
		sc.close();
		return list;
	}
	
	public static ArrayList<String> drinkers(ArrayList<String> names) {

		String[] address = {"Connecticut", "Delaware", "Massachusetts", "Maryland", "New Hampshire", "Pennsylvania", "New Jersey", "New York", 
				"Virginia", "Tennessee", "Florida", "Georgia", "Ohio", "Iowa", "Mississippi", "Lousiana", "Maine", "Rhode Island", "Vermont", 
				"Alabama", "Kentucky", "North Carolina", "South Carolina", "West Virginia"};
		
		ArrayList<String> Drinkers = new ArrayList<String>();
		for(int i = 0; i < names.size(); i++) {
			int rnd = new Random().nextInt(address.length);
			Drinkers.add(names.get(i) + "," + address[rnd]);
		}
		
		/*for(int i = 0; i < Drinkers.size(); i++) {
			System.out.println(Drinkers.get(i));
		}*/
		
		return Drinkers;
	}
	
	public static void DrinkersCSV(ArrayList<String> Drinkers) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Drinkers.csv"));
		String header = "name,address";
		pw.println(header);
		for(int i = 0; i < Drinkers.size(); i++) {
			pw.println((Drinkers.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> items() {
		String[] beers = {"Budweiser,Anheuser-Busch", "Stella Artios,Anheuser-Busch", "Landshark Lager,Anheuser-Busch", "Hoegaarden,Anheuser-Busch", 
				"Coors,MillerCoors", "Icehouse,MillerCoors", "Blue Moon,MillerCoors" , "Pilsner,MillerCoors", "Heineken,Heineken USA", 
				"Dos Equis,Heineken USA", "Corona,Constellation Brands", "Tsingtao,Constellation Brands", "Pabst Blue Ribbon,Pabst", 
				"Lone Star,Pabst", "Samuel Adams,Boston Beer Co.", "Guinness,Diageo North America", "Fat Tire,New Belgium", "Miller Light,Miller Brewing", 
				"Red Stripe,Desnoes & Geddes", "Celis White,Pierre Celis", "Dale's Pale Ale,Oskar Blues", "Vanilla Porter,Breckenridge", 
				"Brooklyn Brewery Lager,Brooklyn Brewery", "Surly Brewing Darkness,Surly", "Dogfish Head,Dogfish Head", "Pipeworks Citra,Pipeworks", 
				"Hefeweizen,Widmer Brother", "Saison Rue,The Bruery", "Uncle Jacob's Stout,Avery Brewing", "Focal Banger,The Alchemist", "Abner,Hill Farmstead", "Gose,Westbrook", "Union Jack,Firestone Walker",
				"Cold Mountain Winter Ale,Highland Brewing", "Allagash White,Allagash", "Anchor Steam Beer,Anchor Brewing", 
				"Craftsman Cabernale,Craftsman Brewing", "Bell's Two Hearted,Bell's Brewing", "Honry Devil,Alesmith Brewing", 
				"Bitter American,21st Amendment Brewery", "Nugget Nectar,Troegs Brewing", "Upslope Brown Ale,Upslope Brewing", 
				"Shakespeare Oatmeal Stout,Rogue Ales and Spirits", "Fancy Lawnmower,Saint Arnold Brewing", "Schnickelfritz,Urban Chestnut", 
				"Fullsteam Carver,Fullsteam Brewery", "Hop Head Red,Green Flash Brewing", "Blind Pig IPA,Russian River Brewing", 
				"Hop Slam, Bell's Brewery", "La Roja,Jolly Pumpkin Artisan Ales", "PseudoSue,Toppling Goliath"};
		String[] other = {"Hamburger", "Frie", "Hot Dog", "Lemonade", "Coke", "Mountain Dew", "Pretzels",
				"Goldfish", "Coffee", "Soup", "Wings", "Nachos", "French Dip", "Grilled Cheese", "Fat Sandwich",
				"Buffalo Chicken Sandwich", "Cheesesteak", "Mac n Cheese", "Dumplings", "Key Lime Pie", "Cheesecake", "Chocolate Cake", "Spaghetti",
				"Penne Vodka", "Calamari", "Pancakes", "Waffle", "Bacon Egg and Cheese", "Lobster", "Crab"};
		
		ArrayList<String> Items = new ArrayList<String>();
		for(int i = 0; i < beers.length; i++) {
			Items.add(beers[i]);
		}
		for(int j = 0; j < other.length; j++) {
			Items.add(other[j] + ",");
		}
		
		/*for(int i = 0; i < Items.size(); i++) {
			System.out.println(Items.get(i));
		}*/
		
		return Items;
	}
	
	public static void ItemsCSV(ArrayList<String> Items) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Items.csv"));
		String header = "name,manufacturer";
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