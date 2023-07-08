package model;

import java.util.ArrayList;

public class Movie {
	private String movieName;
	private String movieDirector;
	private int movieYear;
	private ArrayList<Category> categoryArray;
	private String movieTime;
	private ArrayList<Platform> platformArray;

	public Movie(String movieName, String movieDirector, int movieYear, ArrayList<Category> categoryArray, String movieTime, ArrayList<Platform> platformArray) {
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieYear = movieYear;
		this.categoryArray = categoryArray;
		this.movieTime = movieTime;
		this.platformArray = platformArray;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}


	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public ArrayList<Category> getCategoryArray() {
		return categoryArray;
	}

	public void setCategoryArray(ArrayList<Category> categoryArray) {
		this.categoryArray = categoryArray;
	}

	public ArrayList<Platform> getPlatformArray() {
		return platformArray;
	}

	public void setPlatformArray(ArrayList<Platform> platformArray) {
		this.platformArray = platformArray;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	private String platformArrayToString() {
		String platformArrayString = "";
		for (int i = 0; i < platformArray.size(); i++) {
			platformArrayString += platformArray.get(i).getName() + ", ";
		}
		return platformArrayString;
	}
	private String categoryArrayToString() {
		String categoryArrayString = "";
		for (int i = 0; i < categoryArray.size(); i++) {
			categoryArrayString += categoryArray.get(i).getName() + ", ";
		}
		return categoryArrayString;
	}

	@Override
	public String toString() {
		return "Movie{" +
				"Film İsmi='" + movieName + '\'' +
				", Film Yılı=" + movieYear +
				", Bulunduğu Kategoriler=" + categoryArrayToString() +
				", Film Süresi='" + movieTime + '\'' +
				", Bulunduğu Platformlar=" + platformArrayToString() +
				'}';
	}
}
