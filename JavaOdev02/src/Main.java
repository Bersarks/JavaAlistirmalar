import model.Category;
import model.Platform;
import model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static void updateCategoryArray(ArrayList<Category> categoryArrayList, Movie newMovie){
			for (int i = 0; i < newMovie.getCategoryArray().size(); i++) {
				for (int k = 0; k < categoryArrayList.size(); k++) {
					if (newMovie.getCategoryArray().get(i).getName().equals(categoryArrayList.get(k).getName())) {
						categoryArrayList.get(k).setMovieCount();
					}
				}
			}
	}
	static void showPlatforms(ArrayList<Platform> platformArrayList) {
		if (platformArrayList.size() == 0) {
			System.out.println("There are no platforms");
			return;
		}
		for (int i = 0; i < platformArrayList.size(); i++) {
			System.out.println(i + ". " + platformArrayList.get(i).toString());
		}
	}
	static void listCategories(ArrayList<Category> categoryArrayList) {
		if (categoryArrayList.size() == 0) {
			System.out.println("There are no categories");
			return;
		}
		for (int i = 0; i < categoryArrayList.size(); i++) {
			System.out.println(i + ". " + categoryArrayList.get(i).toString());
		}
	}
	static void showCategories(ArrayList<Category> categoryArrayList, ArrayList<Movie> movieArrayList) {
		int exitStatus = 1;
		String input;
		Scanner scn = new Scanner(System.in);
		if (categoryArrayList.size() == 0) {
			System.out.println("There are no categories");
			return;
		}
		for (int i = 0; i < categoryArrayList.size(); i++) {
			System.out.println(i + ". " + categoryArrayList.get(i).toString());
		}
		while (exitStatus == 1){
			System.out.println("Select a category to see movies. Press Q/q to exit");
			try {
				input = scn.nextLine();
				if (input.equals("q") || input.equals("Q")) {
					exitStatus = 0;
					break;
				}
				showSelectedCategoryMovies(movieArrayList, categoryArrayList, Integer.parseInt(input));
			} catch (Exception e) {
				System.out.println("Invalid category index");
				exitStatus = 1;
			}
		}
	}
	static void showSelectedCategoryMovies(ArrayList<Movie> movieArrayList, ArrayList<Category> categoryArrayList, int selectedCategoryIndex) {
		if (categoryArrayList.size() == 0) {
			System.out.println("There are no categories");
			return;
		}
		if (movieArrayList.size() == 0) {
			System.out.println("There are no movies");
			return;
		}
		if (selectedCategoryIndex < 0 || selectedCategoryIndex >= categoryArrayList.size()) {
			System.out.println("Invalid category index");
			return;
		}
		for (int i = 0; i < movieArrayList.size(); i++) {
			for (int k = 0; k < movieArrayList.get(i).getCategoryArray().size(); k++) {
				if (movieArrayList.get(i).getCategoryArray().get(k).getName().equals(categoryArrayList.get(selectedCategoryIndex).getName())) {
					System.out.println(i + ". " + movieArrayList.get(i).toString());
				}
			}
		}
	}
	static void showMovies(ArrayList<Movie> movieArrayList) {
		if (movieArrayList.size() == 0) {
			System.out.println("There are no movies");
			return;
		}
		for (int i = 0; i < movieArrayList.size(); i++) {
			System.out.println(i + ". " + movieArrayList.get(i).toString());
		}
	}
	static Movie addMovie(ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList){
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the name of the movie you would like to add");
		String movieName = scn.nextLine();
		System.out.println("Please enter the director of the movie you would like to add");
		String movieDirector = scn.nextLine();
		System.out.println("Please enter the year of the movie you would like to add");
		int movieYear = scn.nextInt();
		String dummy = scn.nextLine();
		System.out.println("Please enter the time of the movie you would like to add");
		String movieTime = scn.nextLine();
		System.out.println("Please enter the number of categories you would like to add");
		int categoryNumber = scn.nextInt();
		System.out.println("Please enter the number of platforms you would like to add");
		int platformNumber = scn.nextInt();
		ArrayList<Category> movieCategoryArray = new ArrayList<>();
		listCategories(categoryArrayList);
		while (categoryNumber > 0){
			System.out.println("Please enter the number of the category you would like to add");
			int categoryIndex = scn.nextInt();
			movieCategoryArray.add(categoryArrayList.get(categoryIndex));
			categoryNumber--;
		}
		ArrayList<Platform> moviePlatformArray = new ArrayList<>();
		showPlatforms(platformArrayList);
		while (platformNumber > 0){
			System.out.println("Please enter the number of the platform you would like to add");
			int platformIndex = scn.nextInt();
			moviePlatformArray.add(platformArrayList.get(platformIndex));
			platformNumber--;
		}
		return new Movie(movieName, movieDirector, movieYear, movieCategoryArray, movieTime, moviePlatformArray);
	}
	static void addPlatform(ArrayList<Platform> platformArrayList) {
		int exitStatus= 1;
		while (exitStatus == 1) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Please enter the name of the platform you would like to add");
			String platformName = scn.nextLine();
			Platform newPlatform = new Platform(platformName);
			platformArrayList.add(newPlatform);
			System.out.println("Would you like to add another platform? (1 for yes, 0 for no)");
			try {
				exitStatus = scn.nextInt();
				if (exitStatus != 0 && exitStatus != 1) {
					System.out.println("Invalid input detected, exiting to admin panel");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input detected, exiting to admin panel");
				exitStatus = 0;
			}
		}
	}
	static void addCategory(ArrayList<Category> categoryArrayList) {
		int exitStatus= 1;
		while (exitStatus == 1) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Please enter the name of the category you would like to add");
			String categoryName = scn.nextLine();
			Category newCategory = new Category(categoryName);
			categoryArrayList.add(newCategory);
			System.out.println("Would you like to add another category? (1 for yes, 0 for no)");
			try {
				exitStatus = scn.nextInt();
				if (exitStatus != 0 && exitStatus != 1) {
					System.out.println("Invalid input detected, exiting to admin panel");
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid input detected, exiting to admin panel");
				exitStatus = 0;
			}
		}
	}
	static ArrayList<Category> adminPanel(ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList, ArrayList<Movie> movieArrayList) {
		int adminChoice;
		int exitStatus = 1;
		Movie newMovie;
		while (exitStatus == 1) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Please select an option from the menu below");
			System.out.println("1. Add a category");
			System.out.println("2. Add a platform");
			System.out.println("3. Add a movie");
			System.out.println("4. Show categories");
			System.out.println("5. Show platforms");
			System.out.println("6. Show movies");
			System.out.println("7. Exit");
			adminChoice = scn.nextInt();
			switch (adminChoice) {
				case 1:
					addCategory(categoryArrayList);
					break;
				case 2:
					addPlatform(platformArrayList);
					break;
				case 3:
					if (categoryArrayList.size() == 0 || platformArrayList.size() == 0){
						System.out.println("You must add at least one category and platform before adding a movie!");
						break;
					}
					int movieStatus = 1;
					while (movieStatus == 1){
						newMovie = addMovie(categoryArrayList, platformArrayList);
						movieArrayList.add(newMovie);
						updateCategoryArray(categoryArrayList, newMovie);
						System.out.println("Would you like to add another movie? (1 for yes, 0 for no)");
						try{
							movieStatus = scn.nextInt();
							if (movieStatus != 0 && movieStatus != 1) {
								System.out.println("Invalid input detected, exiting to admin panel");
								break;
							}
						}
						catch (Exception e){
							System.out.println("Invalid input detected, exiting to admin panel");
							movieStatus = 0;
						}
					}
					break;
				case 4:
					showCategories(categoryArrayList, movieArrayList);
					break;
				case 5:
					showPlatforms(platformArrayList);
					break;
				case 6:
					showMovies(movieArrayList);
					break;
				case 7:
					System.out.println("Exiting admin panel");
					exitStatus = 0;
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
		return categoryArrayList;
	}
	static void userPanel(ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList, ArrayList<Movie> movieArrayList){
		int userChoice;
		int exitStatus = 1;
		while (exitStatus == 1) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Please select an option from the menu below");
			System.out.println("1. Show categories");
			System.out.println("2. Show platforms");
			System.out.println("3. Show movies");
			System.out.println("4. Exit");
			userChoice = scn.nextInt();
			switch (userChoice) {
				case 1:
					showCategories(categoryArrayList, movieArrayList);
					break;
				case 2:
					showPlatforms(platformArrayList);
					break;
				case 3:
					showMovies(movieArrayList);
					break;
				case 4:
					System.out.println("Exiting user panel");
					exitStatus = 0;
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int exitStatus = 1, userChoice;
		Category asd = new Category();
		ArrayList<Category> categoryArrayList = new ArrayList<>();
		ArrayList<Platform> platformArrayList = new ArrayList<>();
		ArrayList<Movie> movieArrayList= new ArrayList<>();

		System.out.println("Welcome to Movie Finder");
		while (exitStatus != 0) {
			System.out.println("Please select an option from the menu below");
			System.out.println("1. User Login");
			System.out.println("2. Admin Login");
			System.out.println("3. Exit");
			Scanner scn = new Scanner(System.in);
			userChoice = scn.nextInt();
			switch (userChoice) {
				case 1:
					System.out.println("User Login Selected");
					userPanel(categoryArrayList, platformArrayList, movieArrayList);
					break;
				case 2:
					System.out.println("Admin Login Selected");
					categoryArrayList = adminPanel(categoryArrayList, platformArrayList, movieArrayList);
					break;
				case 3:
					System.out.println("Exiting program. Have a nice day!");
					exitStatus = 0;
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		}
	}
}