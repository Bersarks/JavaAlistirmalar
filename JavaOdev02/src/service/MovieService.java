package service;

import model.Category;
import model.Movie;
import model.Platform;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieService {
	CategoryService categoryService = new CategoryService();
	PlatformService platformService = new PlatformService();

	public void showMovies(ArrayList<Movie> movieArrayList) {
		if (movieArrayList.size() == 0) {
			System.out.println("There are no movies");
			return;
		}
		for (int i = 0; i < movieArrayList.size(); i++) {
			System.out.println(i + ". " + movieArrayList.get(i).toString());
		}
	}

	public Movie addMovie(ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList) {
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
		categoryService.listCategories(categoryArrayList);
		while (categoryNumber > 0) {
			System.out.println("Please enter the number of the category you would like to add");
			int categoryIndex = scn.nextInt();
			movieCategoryArray.add(categoryArrayList.get(categoryIndex));
			categoryArrayList.get(categoryIndex).setMovieCount();
			categoryNumber--;
		}
		ArrayList<Platform> moviePlatformArray = new ArrayList<>();
		platformService.showPlatforms(platformArrayList);
		while (platformNumber > 0) {
			System.out.println("Please enter the number of the platform you would like to add");
			int platformIndex = scn.nextInt();
			moviePlatformArray.add(platformArrayList.get(platformIndex));
			platformNumber--;
		}
		return new Movie(movieName, movieDirector, movieYear, movieCategoryArray, movieTime, moviePlatformArray);
	}
}
