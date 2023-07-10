package service;


import model.Category;
import model.Movie;
import model.Platform;

import java.util.ArrayList;
import java.util.Scanner;

public class PanelService {
	CategoryService categoryService = new CategoryService();
	PlatformService platformService = new PlatformService();
	MovieService movieService = new MovieService();

	public void userPanel(ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList, ArrayList<Movie> movieArrayList) {
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
					categoryService.showCategories(categoryArrayList, movieArrayList);
					break;
				case 2:
					platformService.showPlatforms(platformArrayList);
					break;
				case 3:
					movieService.showMovies(movieArrayList);
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

	public void adminPanel(ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList, ArrayList<Movie> movieArrayList) {
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
					categoryService.addCategory(categoryArrayList);
					break;
				case 2:
					platformService.addPlatform(platformArrayList);
					break;
				case 3:
					if (categoryArrayList.size() == 0 || platformArrayList.size() == 0) {
						System.out.println("You must add at least one category and platform before adding a movie!");
						break;
					}
					int movieStatus = 1;
					while (movieStatus == 1) {
						newMovie = movieService.addMovie(categoryArrayList, platformArrayList);
						movieArrayList.add(newMovie);
						System.out.println("Would you like to add another movie? (1 for yes, 0 for no)");
						try {
							movieStatus = scn.nextInt();
							if (movieStatus != 0 && movieStatus != 1) {
								System.out.println("Invalid input detected, exiting to admin panel");
								break;
							}
						} catch (Exception e) {
							System.out.println("Invalid input detected, exiting to admin panel");
							movieStatus = 0;
						}
					}
					break;
				case 4:
					categoryService.showCategories(categoryArrayList, movieArrayList);
					break;
				case 5:
					platformService.showPlatforms(platformArrayList);
					break;
				case 6:
					movieService.showMovies(movieArrayList);
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
	}
}
