import model.Category;
import model.Platform;
import model.Movie;
import service.PanelService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		PanelService panelService = new PanelService();
		int exitStatus = 1, userChoice;
		Category asd = new Category();
		ArrayList<Category> categoryArrayList = new ArrayList<>();
		ArrayList<Platform> platformArrayList = new ArrayList<>();
		ArrayList<Movie> movieArrayList = new ArrayList<>();

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
					panelService.userPanel(categoryArrayList, platformArrayList, movieArrayList);
					break;
				case 2:
					System.out.println("Admin Login Selected");
					panelService.adminPanel(categoryArrayList, platformArrayList, movieArrayList);
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