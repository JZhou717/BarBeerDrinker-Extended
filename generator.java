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
		
		ArrayList<String> names = nameGenerator();
		ArrayList<String> bars = bars();
		ArrayList<String> sells = pattern3(sells());
		ArrayList<String> issues = pattern2(bars, issues());
		ArrayList<String> includes = on(sells, issues);
		
		BarsCSV(bars);
		DrinkersCSV(drinkers(names));
		ItemsCSV(items());
		FrequentsCSV(frequents(names));
		IssuesCSV(issues);
		SellsCSV(sells);
		Billed_toCSV(billed_to(names));
		OnCSV(includes);
		BillsCSV(bills(includes, sells, issues));
		
		
		System.out.println("All done!");
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
				"A Clean Well-Lighted Place", "The Gold Room", "Paddy's Pub", "Boar's Head Tavern", "The Gem Saloon", "Korova Milk Bar",
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
			System.out.println("Bars: " + i);
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
			System.out.println("Names: " + i);
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
			System.out.println("Drinkers: " + i);
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
		String[] beers = {"Stella Artios,Anheuser-Busch", "Landshark Lager,Anheuser-Busch", "Hoegaarden,Anheuser-Busch", "Icehouse,MillerCoors", 
				"Blue Moon,MillerCoors" , "Pilsner,MillerCoors", "Heineken,Heineken USA", 
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
				"Hop Slam, Bell's Brewery", "La Roja,Jolly Pumpkin Artisan Ales", "Coors,MillerCoors", "PseudoSue,Toppling Goliath", "Budweiser,Anheuser-Busch"};
		String[] other = {"Hamburger", "Fries", "Hot Dog", "Lemonade", "Coke", "Mountain Dew", "Pretzels",
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
	
	public static ArrayList<String> frequents(ArrayList<String> drinkers) {
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
				"A Clean Well-Lighted Place", "The Gold Room", "Paddy's Pub", "Boar's Head Tavern", "The Gem Saloon", "Korova Milk Bar",
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
		
		
		
		ArrayList<String> f = new ArrayList<String>();
		String tuple = "";
		
		//for each drinker in our list
		for(int i = 0; i < drinkers.size(); i++) {
			tuple = drinkers.get(i);
			ArrayList<Integer> usedIndexes = new ArrayList<Integer>();
			
			//create a random amount of bars that that drinker frequents
			int rnd = new Random().nextInt(50);
			for(int j = 0; j < rnd; j++) {
				int randomBar = new Random().nextInt(bars.length);
				if(usedIndexes.indexOf(randomBar) == -1) {			//if the drinker does not already frequent the bar
					tuple += "," + bars[randomBar];
					f.add(tuple);
					tuple = drinkers.get(i);
					usedIndexes.add(randomBar);
				}
				else {
					rnd++;
				}
			}
			System.out.println("Frequents: " + i);
			
		}
		
		return f;
	}
	
	public static void FrequentsCSV(ArrayList<String> Frequents) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Frequents.csv"));
		String header = "drinker,bar";
		pw.println(header);
		for(int i = 0; i < Frequents.size(); i++) {
			pw.println((Frequents.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> issues() {
		ArrayList<String> issues = new ArrayList<String>();
		
		String[] time = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02"};
		String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
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
				"A Clean Well-Lighted Place", "The Gold Room", "Paddy's Pub", "Boar's Head Tavern", "The Gem Saloon", "Korova Milk Bar",
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
		
		String tuple;
		for(int i = 0; i < 20000; i++) {
			tuple = Integer.toString(i);
			int barRnd = new Random().nextInt(bars.length);
			tuple += "," + bars[barRnd];
			int timeEnd1 = new Random().nextInt(6);
			int timeEnd2 = new Random().nextInt(10);
			int timeRnd = new Random().nextInt(time.length);
			tuple += "," + time[timeRnd] + ":" + Integer.toString(timeEnd1) + Integer.toString(timeEnd2);
			int dayRnd = new Random().nextInt(7);
			tuple += "," + day[dayRnd];
			issues.add(tuple);
			System.out.println("Issues: " + i);
		}
		return issues;
	}
	
	public static void IssuesCSV(ArrayList<String> Issues) throws FileNotFoundException{

		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Issues.csv"));
		String header = "bill_ID,bar,time,day";
		pw.println(header);
		for(int i = 0; i < Issues.size(); i++) {
			pw.println((Issues.get(i)).toString());
		}
		pw.close();
	}
	
	public static  ArrayList<String> pattern2(ArrayList<String> bars, ArrayList<String> ogIssues) {
		ArrayList<String> issues = ogIssues;
		//What we have to do for this one, check the time on the issues tuple, go to that bar in the bars ArrayList, check to see if the time is outside of bounds
		//If it is, just reduce the hour by 1 until it is within bounds of the bar
		
		/*
		 * Bar times
		 * String[] opening_hours = {"10:00", "12:00", "10:30", "11:00", "11:30"};
		 * String [] closing_hours = {"00:00", "01:00", "01:30", "02:00", "02:30"};
		 */
		
		/*Issues times
		 * String[] time = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02"};
		 * int timeEnd1 = new Random().nextInt(6);
			int timeEnd2 = new Random().nextInt(10);
			int timeRnd = new Random().nextInt(time.length);
			tuple += "," + time[timeRnd] + ":" + Integer.toString(timeEnd1) + Integer.toString(timeEnd2);
		 */
		
		/*
		 * Here is how we can do this, rewrite the times into an arraylist so that we have a hierarchy of times from 10 to 02
		 * See what hour the bill was issued
		 * if the time on the bill is greater than the time the bar closes, but less than the time the bar opens, it means it is not valid
		 * Just make the hour on the bill within the range the bar is open for sure
		 */
		
		String[] hours = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02"};
		ArrayList<String> Hierarchy = new ArrayList<String>();
		for(int i = 0; i < hours.length; i++) {
			Hierarchy.add(hours[i]);
		}
		
		//Now check the time on all instances of issues
		for(int i = 0; i < issues.size(); i++) {
			
			//This gives us the info we need for the bill
			String[] issuesTuple = issues.get(i).split(",", 4);
			String bar = issuesTuple[1];
			String billTime = issuesTuple[2];
			//System.out.println(bar);
			
			
			//This gives us the info we need for the bar
			String openingTime = "NULL";
			String closingTime = "NULL";
			//Finding the right bar
			for(int j = 0; j < bars.size(); j++) {
				//System.out.println(j);
				String[] barTuple = bars.get(j).split(",", 4);
				
				if(barTuple[0].equals(bar)) {
					openingTime = barTuple[2];
					closingTime = barTuple[3];
					
				}
			}
			
			/*if(openingTime.equals("NULL")) {
				System.out.println("There is something really wrong here, couldn't find the bar in bars");
				System.exit(0);
			}*/
			
			//boolean flag = false;
			
			//if the time on the bill is greater than the time the bar closes, but less than the time the bar opens, it means it is not valid
			while(billTime.compareTo(closingTime) > 0 && billTime.compareTo(openingTime) < 0) {
				/*flag = true;
				System.out.println(billTime);
				System.out.println(openingTime);
				System.out.println(closingTime);
				System.out.println("Time invalid\n");*/
				
				String[] billSplit = billTime.split(":", 2);
				String billHour = billSplit[0];
				String billDig = billSplit[1];
				
				int hourIndex = Hierarchy.indexOf(billHour);
				if(hourIndex == 0) {
					hourIndex = Hierarchy.size() - 1;
				}
				else {
					hourIndex--;
				}
				billTime = Hierarchy.get(hourIndex) + ":" + billDig;
				
			}
		
			/*if(flag == true) {
				System.out.println(billTime);
				System.out.println(openingTime);
				System.out.println(closingTime);
				System.out.println("Time valid\n");
				System.out.println("billTime.compareTo(closingTime): " + billTime.compareTo(closingTime));
				System.out.println("billTime.compareTo(openingTime): " + billTime.compareTo(openingTime));
				System.out.println("finished i: " + i + "\n");
				flag = false;
			}*/
		
			String newTuple = issuesTuple[0] + "," + issuesTuple[1] + "," + billTime + "," + issuesTuple[3];
			issues.set(i, newTuple);
			System.out.println("Pattern 2: " + i);
		}
		
		return issues;
	}
	
	public static ArrayList<String> sells() {
		ArrayList<String> sells = new ArrayList<String>();
		
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
				"A Clean Well-Lighted Place", "The Gold Room", "Paddy's Pub", "Boar's Head Tavern", "The Gem Saloon", "Korova Milk Bar",
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
		
		String[] beers = {"Stella Artios,Anheuser-Busch", "Landshark Lager,Anheuser-Busch", "Hoegaarden,Anheuser-Busch", "Icehouse,MillerCoors", 
				"Blue Moon,MillerCoors" , "Pilsner,MillerCoors", "Heineken,Heineken USA", 
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
				"Hop Slam, Bell's Brewery", "La Roja,Jolly Pumpkin Artisan Ales", "Coors,MillerCoors", "PseudoSue,Toppling Goliath", "Budweiser,Anheuser-Busch"};
		
		//Since all beers have their manf by default as the item, we will need a function to grab just the first value before the ,
		for(int i = 0; i < beers.length; i ++) {
			String[] beer = beers[i].split(",", 2);
			beers[i] = beer[0];
		}
		
		String[] other = {"Hamburger", "Fries", "Hot Dog", "Lemonade", "Coke", "Mountain Dew", "Pretzels",
				"Goldfish", "Coffee", "Soup", "Wings", "Nachos", "French Dip", "Grilled Cheese", "Fat Sandwich",
				"Buffalo Chicken Sandwich", "Cheesesteak", "Mac n Cheese", "Dumplings", "Key Lime Pie", "Cheesecake", "Chocolate Cake", "Spaghetti",
				"Penne Vodka", "Calamari", "Pancakes", "Waffle", "Bacon Egg and Cheese", "Lobster", "Crab"};
		
		for(int i = 0; i < bars.length; i++) {
			
			int beerAmount = (new Random().nextInt(10)) + 10;
			int itemAmount = (new Random().nextInt(5)) + 7;
			
			ArrayList<Integer> usedBeers = new ArrayList<Integer>();
			ArrayList<Integer> usedItems = new ArrayList<Integer>();
			
			//This creates beers tuples in sells
			for(int j = 0; j < beerAmount; j++) {
				String beerTuple = bars[i];
				int beerNum = new Random().nextInt(beers.length);
				if(usedBeers.indexOf(beerNum) == -1) {
					
					int price = new Random().nextInt(6) + 3;
					beerTuple += "," + beers[beerNum] + "," + price;
					sells.add(beerTuple);
					usedBeers.add(beerNum);
				}
				else {
					beerAmount++;
				}
			}
			
			//This creates item tuples in sells
			for(int k = 0; k < itemAmount; k++) {
				String itemTuple = bars[i];
				int itemNum = new Random().nextInt(other.length);
				if(usedItems.indexOf(itemNum) == -1) {
					int price = new Random().nextInt(7) + 6;
					itemTuple += "," + other[itemNum] + "," + price;
					sells.add(itemTuple);
					usedItems.add(itemNum);
				}
				else {
					itemAmount++;
				}
			}
			System.out.println("Sells: " + i);
		}
		return sells;
	}
	
	public static ArrayList<String> pattern3(ArrayList<String> orig) {
		ArrayList<String> sells = orig;
		/*
		 * What we need to do:
		 * There needs to be a hierarchy of beers, easy enough since we just need to put the items array into an arraylist and that is the hierarchy
		 * For each of the tuples in the orig arrayList, check the price
		 * Then using an inner loop, check all tuples after it in the arraylist
		 * if the beer in that inner tuple comes after the beer in the outer tuple, then we must lower the price
		 * Important to know that beers go for 3 to 8 dollars
		 * Food go for 6 to 12 dollars
		 */
		
		//This if for the beer hierarchy
		String[] beers = {"Stella Artios,Anheuser-Busch", "Landshark Lager,Anheuser-Busch", "Hoegaarden,Anheuser-Busch", "Icehouse,MillerCoors", 
				"Blue Moon,MillerCoors" , "Pilsner,MillerCoors", "Heineken,Heineken USA", 
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
				"Hop Slam, Bell's Brewery", "La Roja,Jolly Pumpkin Artisan Ales", "Coors,MillerCoors", "PseudoSue,Toppling Goliath", "Budweiser,Anheuser-Busch"};
		
		for(int i = 0; i < beers.length; i ++) {
			String[] beer = beers[i].split(",", 2);
			beers[i] = beer[0];
		}
		
		String[] other = {"Lobster", "Crab", "Calamari", "Hamburger","Penne Vodka", "Pancakes", "Waffle",  "Bacon Egg and Cheese",
				"Goldfish", "Coffee", "Soup", "Wings", "Nachos", "Hot Dog", "Grilled Cheese", "Fat Sandwich",
				"Buffalo Chicken Sandwich", "Cheesesteak", "Mac n Cheese", "Dumplings", "Key Lime Pie", "Cheesecake", "Chocolate Cake", "Spaghetti",
				 "Mountain Dew", "Lemonade", "Pretzels", "Coke", "Fries", "French Dip"};
		
		ArrayList<String> Hierarchy = new ArrayList<String>();
		for(int i = 0; i < beers.length; i++) {
			Hierarchy.add(beers[i]);
		}
		for(int j = 0; j < other.length; j++) {
			Hierarchy.add(other[j]);
		}
		
		/*
		 * We have a problem where if the beers highest in the hierarchy are sold for minimal price of 3, then all beers have to be sold for 3 or lower
		 * We must manipulate the prices so that beers highest in the hierarchy are sold for more than beers lowest in the hierarchy
		 * We will have the highest beers cost 6-8, second 5-7, third 4-6, and fourth 3-5
		 * As for items, the highest items cost 10-12, second 9-11, third 8-10, fourth 7-9, and last 6-10
		 */
		
		for(int i = 0; i < sells.size(); i++) {
			String[] tuple = sells.get(i).split(",", 3);
			String beerName = tuple[1];
			int price = 0;
			int index = Hierarchy.indexOf(beerName);
			if(index < (beers.length / 4)) {
				price = 6;
			}
			else if(index < (beers.length / 2)) {
				price = 5;
			}
			else if(index < (beers.length * (3/4))) {
				price = 4;
			}
			else if(index < (beers.length)) {
				price = 3;
			}
			else if(index < (beers.length + (other.length / 5))) {
				price = 10;
			}
			else if(index < (beers.length + (other.length * (2/5)))) {
				price = 9;
			}
			else if(index < (beers.length + (other.length * (3/5)))) {
				price = 8;
			}
			else if(index < (beers.length + (other.length * (4/5)))) {
				price = 7;
			}
			else {
				price = 6;
			}
			price += new Random().nextInt(3);
			String newTuple = tuple[0] + "," + tuple[1] + "," + price;
			sells.set(i, newTuple);
		}
		
		//Now the outer loop checking the beer at each point
		for(int i = 0; i < sells.size(); i++) {
			String[] outerTuple = sells.get(i).split(",", 3);
			String outerBeer = outerTuple[1];
			//System.out.println(beer);
			String outerPrice = outerTuple[2];
			//System.out.println(price);
			
			
			//Now for the inner loop
			for(int j = i; j < sells.size(); j++) {
				String[] innerTuple = sells.get(j).split(",", 0);
				String innerBeer = innerTuple[1];
				String innerPrice = innerTuple[2];
				
				boolean outIsBeer;
				int outerIndex = Hierarchy.indexOf(outerBeer);
				if(outerIndex < beers.length) {
					outIsBeer = true;
				}
				else {
					outIsBeer = false;
				}
				
				boolean inIsBeer;
				int innerIndex = Hierarchy.indexOf(innerBeer);
				if(innerIndex < beers.length) {
					inIsBeer = true;
				}
				else {
					inIsBeer = false;
				}
				//Now that we have the loops, make the check about the prices
				//We have to be careful about separating beers from items
				//What we should do is check to see if the outer item is a beer, 1 if it is, 0 if it is an item, we should then check to see if it is the same for inner and outer
				//If it is not, ignore it
				//If the price of the inner thing is greater than the price of the outer thing and the inner thing has a higher index than the outer thing, change it
				//If it is, set the price of the inner thing to be 0-2 less than the outer thing
				if(outIsBeer == inIsBeer) {
					if(innerIndex > outerIndex &&
					   Integer.parseInt(innerPrice) > Integer.parseInt(outerPrice)) {
						/*System.out.println("Outerbeer and index and price: " + outerBeer + "," + Hierarchy.indexOf(outerBeer) + "," + outerPrice + "\n"
								+ "Innerbeer and index: " + innerBeer + "," + Hierarchy.indexOf(innerBeer) + "," + innerPrice + "\n"); */
						int newPrice = Integer.parseInt(outerPrice);
						String newTuple = innerTuple[0] + "," + innerTuple[1] + "," + newPrice;
						sells.set(j, newTuple);
					}
				}
			}
			System.out.println("Pattern 3: " + i);
		}
		
		//We now have the problem where beers in the beginning of the hierarchy are too cheap, so we have to manipulate the prices
		
		return sells;
	}
	
	public static void SellsCSV(ArrayList<String> Sells) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Sells.csv"));
		String header = "bar,item,price";
		pw.println(header);
		for(int i = 0; i < Sells.size(); i++) {
			pw.println((Sells.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> billed_to(ArrayList<String> names) {
		ArrayList<String> bt = new ArrayList<String>();
		for(int i = 0; i < 20000; i++) {
			int rand = new Random().nextInt(names.size());
			String billed_tuple = Integer.toString(i);
			billed_tuple += "," + names.get(rand);
			bt.add(billed_tuple);
			System.out.println("Billed_to: " + i);
		}
		return bt;
	}
	
	public static void Billed_toCSV(ArrayList<String> Billed_to) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Billed_to.csv"));
		String header = "bill_ID,drinker";
		pw.println(header);
		for(int i = 0; i < Billed_to.size(); i++) {
			pw.println((Billed_to.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> on(ArrayList<String> sells, ArrayList<String> issues) {
		String[] beers = {"Stella Artios,Anheuser-Busch", "Landshark Lager,Anheuser-Busch", "Hoegaarden,Anheuser-Busch", "Icehouse,MillerCoors", 
				"Blue Moon,MillerCoors" , "Pilsner,MillerCoors", "Heineken,Heineken USA", 
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
				"Hop Slam, Bell's Brewery", "La Roja,Jolly Pumpkin Artisan Ales", "Coors,MillerCoors", "PseudoSue,Toppling Goliath", "Budweiser,Anheuser-Busch"};
		
		//Since all beers have their manf by default as the item, we will need a function to grab just the first value before the ,
		ArrayList<String> beersList = new ArrayList<String>();
		//ArrayList<String> itemsList = new ArrayList<String>();
		
		for(int i = 0; i < beers.length; i ++) {
			String[] beer = beers[i].split(",", 2);
			beers[i] = beer[0];
			beersList.add(beers[i]);
			//System.out.println(beers[i]);
		}
		
		
		/*String[] other = {"Hamburger", "Fries", "Hot Dog", "Lemonade", "Coke", "Mountain Dew", "Pretzels",
				"Goldfish", "Coffee", "Soup", "Wings", "Nachos", "French Dip", "Grilled Cheese", "Fat Sandwich",
				"Buffalo Chicken Sandwich", "Cheesesteak", "Mac n Cheese", "Dumplings", "Key Lime Pie", "Cheesecake", "Chocolate Cake", "Spaghetti",
				"Penne Vodka", "Calamari", "Pancakes", "Waffle", "Bacon Egg and Cheese", "Lobster", "Crab"};*/
		
		ArrayList<String> on = new ArrayList<String>();
		
		String tuple;
		for(int i = 0; i < 20000; i++) { 		//for each bill
			
			int rand = new Random().nextInt(3) + 2;
			
			//ArrayList<Integer> usedItems = new ArrayList<Integer>();
			//ArrayList<Integer> usedBeers = new ArrayList<Integer>();
			
			String[] barTuple = issues.get(i).split(",", 4);
			//System.out.println(issues.get(bill_id));
			String bar_name = barTuple[1];
			
			ArrayList<String> barSells = new ArrayList<String>();
			for(int j = 0; j < sells.size(); j++) {
				String[] sellsTuple = sells.get(j).split(",", 3);
				if(sellsTuple[0].equals(bar_name)) {			//If the bar is the same one as the bill
					barSells.add(sellsTuple[1]);
					//System.out.println(i + ": " + "Bar Sells: " + sellsTuple[1]);
					//System.out.println(sellsTuple[1]);
					//System.out.println(sells.get(j));
				}
			}
			
			for(int j = 0; j < rand; j++) {
				int thingIndex = new Random().nextInt(barSells.size());
				String item = barSells.get(thingIndex);
				//System.out.println(item + ", index: " + beersList.indexOf(item));
				int quantity;
				if(beersList.indexOf(item) < 0) {	//if this item is an other, not a beer
					quantity = new Random().nextInt(2) + 1;
					//	System.out.println("DO WE EVEN GET HERE?");
				}
				else {
					quantity = new Random().nextInt(4) + 1;
					//System.out.println("BUT WE DO GET HERE THO?");
				}
				tuple = i + "," + barSells.get(thingIndex) + "," + quantity;
				on.add(tuple);
				barSells.remove(thingIndex);
			}
			
			System.out.println("Includes: " + i);
		}
		
		return on;
	}
	
	/*public static ArrayList<String> actuallyOn(ArrayList<String> on, ArrayList<String> sells, ArrayList<String> issues) {
		ArrayList<String> includes = on;
		
		//What we must do
		//Go through every tuple in the includes arrayList
		//Check to see if that item is actually sold at the bar
		//If it is, all good
		//If it is not:
			//If there are more than one item on the bill, just remove that item
			//If it is the last item on the bill, just change the item to something that the bar does sell
		
		for(int i = 0; i < includes.size(); i++) {		//For every item in the includes tuple
			String[] includesTuple = includes.get(i).split(",", 3);
			int  bill_id = Integer.parseInt(includesTuple[0]);
			String bill_item = includesTuple[1];
			String bill_quantity = includesTuple[2];
			//System.out.println(includes.get(i));
			
			//Find the bar that the item is sold at
			
			String[] barTuple = issues.get(bill_id).split(",", 4);
			//System.out.println(issues.get(bill_id));
			String bar_name = barTuple[1];
			//System.out.println(bar_name);
			
			
			//Grab all the items that are sold at the bar and store it here
			ArrayList<String> barSells = new ArrayList<String>();
			for(int j = 0; j < sells.size(); j++) {
				String[] sellsTuple = sells.get(j).split(",", 3);
				if(sellsTuple[0].equals(bar_name)) {			//If the bar is the same one as the bill
					barSells.add(sellsTuple[1]);
					//System.out.println(sellsTuple[1]);
					//System.out.println(sells.get(j));
				}
			}
			
			if(barSells.indexOf(bill_item) == -1) {		//if the bar does not sell this item
				//Make the item something that the bar does sell
				int RandomItemIndex = new Random().nextInt(barSells.size());
				bill_item = barSells.get(RandomItemIndex);
				
				//change the tuple
				String newTuple = bill_id + "," + bill_item + "," + bill_quantity;
				includes.set(i, newTuple);
			}
			
			//System.out.println("Actually on: " + i);
		}
		
		return includes;
	}*/
	
	public static void OnCSV(ArrayList<String> On) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Includes.csv"));
		String header = "bill_ID,item,quantity";
		pw.println(header);
		for(int i = 0; i < On.size(); i++) {
			pw.println((On.get(i)).toString());
		}
		pw.close();
	}
	
	public static ArrayList<String> bills(ArrayList<String> includes, ArrayList<String> sells, ArrayList<String> issues) {
		ArrayList<String> bills = new ArrayList<String>();
		String[] tips = {".15", ".18", ".20", ".25"};
		
		//we must generate the total price, what we must do is go through every tuple in includes, and then multiple the price of that item
		//which is in sells, with the quantity, and add it to the sum of that bill
		
		String tuple;
		for(int i = 0; i < 20000; i++) {
			int totalPrice = 0;
			
			//we are going to need everything in includes that has the same id as i, we must parse the tuple into 3 fields, the id, the item, and the quantity
			//we are then going to find the bar that issues that bill
			//we are then going to check the price of that item at that bar and multiply it to the quantity and add it to the totalprice
				//This is assuming that all items on the bill are sold at that bar
			
			ArrayList<String[]> itemsIncluded = new ArrayList<String[]>();
			for(int j = 0; j < includes.size(); j++) {
				String[] includesTuple = includes.get(j).split(",", 3);
				if(Integer.parseInt(includesTuple[0]) == i) {
					itemsIncluded.add(includesTuple);
					//System.out.println(i + ": " + includesTuple[0] + "," + includesTuple[1] + "," + includesTuple[2]);
				}
				else if(Integer.parseInt(includesTuple[0]) > i) {
					break;
				}
			}
			
			String[] barTuple = issues.get(i).split(",", 3);
			String bar = barTuple[1];
			//System.out.println(i + ": " + barTuple[0] + "," + barTuple[1] + "," + barTuple[2]);
			ArrayList<String[]> barSells = new ArrayList<String[]>();
			for(int j = 0; j < sells.size(); j++) {
				String[] sellsTuple = sells.get(j).split(",", 3);
				if(sellsTuple[0].equals(bar)) {
					barSells.add(sellsTuple);
					//System.out.println(i + ": " + sellsTuple[0] + "," + sellsTuple[1] + "," + sellsTuple[2]);
				}
			}
			
			for(int j = 0; j < itemsIncluded.size(); j++) {
				String[] includesTuple = itemsIncluded.get(j);
				String item = includesTuple[1];
				int quantity = Integer.parseInt(includesTuple[2]);
				//System.out.println(i + ": Item: " + item + ". Quantity: " + quantity);
				
				int price = 0;
				String[] priceTuple;
				//find the tuple about that item
				for(int k = 0; k < barSells.size(); k++) {
					priceTuple = barSells.get(k);
					if(priceTuple[1].equals(item)) {
						price = Integer.parseInt(priceTuple[2]);
						//System.out.println(i + ": " + "Price: " + price);
						break;
					}
					else {
						price = 0;
					}
					
				}
				totalPrice += (quantity * price);
				
				
				//System.out.println(i + ": " + "TotalPrice: " + totalPrice);
				
			}
			
			if(totalPrice != 0) {
				tuple = Integer.toString(i) + "," + totalPrice + ",";
				int rand = new Random().nextInt(tips.length);
				tuple += tips[rand];
				bills.add(tuple);
			}
			System.out.println("Bills: " + i);
		}
		
		return bills;
	}
	
	public static void BillsCSV(ArrayList<String> Bills) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("c:/Users/Jake/Desktop/School/Fall 2018/Data Management/Project/Bills.csv"));
		String header = "ID,total_price,tip";
		pw.println(header);
		for(int i = 0; i < Bills.size(); i++) {
			pw.println((Bills.get(i)).toString());
		}
		pw.close();
	}
	
}