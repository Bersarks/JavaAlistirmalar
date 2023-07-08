package model;

public class Category {
	private String name;
	private int movieCount = 0;
	public Category() {

	}
	public Category(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMovieCount() {
		return movieCount;
	}

	public void setMovieCount() {
		this.movieCount++;
	}

	@Override
	public String toString() {
		return "Category{" +
				"Kategori Adı='" + name + '\'' +
				", Film Sayısı=" + movieCount +
				'}';
	}
}
