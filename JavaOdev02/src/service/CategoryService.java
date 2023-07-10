package service;

import model.Category;
import model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryService {
	public void listCategories(ArrayList<Category> categoryArrayList) {
		if (categoryArrayList.size() == 0) {
			System.out.println("There are no categories");
			return;
		}
		for (int i = 0; i < categoryArrayList.size(); i++) {
			System.out.println(i + ". " + categoryArrayList.get(i).toString());
		}
	}

	public void showCategories(ArrayList<Category> categoryArrayList, ArrayList<Movie> movieArrayList) {
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
		while (exitStatus == 1) {
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

	static void addCategory(ArrayList<Category> categoryArrayList) {
		int exitStatus = 1;
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
}
