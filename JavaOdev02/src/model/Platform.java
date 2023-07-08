package model;

public class Platform {
	private String Name;

	public String getName() {
		return Name;
	}

	public Platform(String name) {
		Name = name;
	}
	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Platform{" +
				"Platform Adı='" + Name + '\'' +
				'}';
	}
}
