package model;

public class Department {
	private String id;
	private String name;
	private String description;
	private String managerId;

	public Department(String id, String name, String description, String managerId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.managerId = managerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", managerId='" + managerId + '\'' +
				'}';
	}
}
