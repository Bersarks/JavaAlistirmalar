package model;
// ENUM yapısı sürekli değişmeyecek sabit seçeneklerimiz olduğunda kullanılır. Örneğin haftanın günleri sabit değişmez bir liste.
public class Award {
	private String name;
	private int year;
	private AwardTypeEnum awardType;
	private AwardCategoryEnum awardCategory;

	public String getName() {
		return name;
	}

	public Award(String name, int year, AwardTypeEnum awardType, AwardCategoryEnum awardCategory) {
		this.name = name;
		this.year = year;
		this.awardType = awardType;
		this.awardCategory = awardCategory;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public AwardTypeEnum getAwardType() {
		return awardType;
	}

	public void setAwardType(AwardTypeEnum awardType) {
		this.awardType = awardType;
	}

	public AwardCategoryEnum getAwardCategory() {
		return awardCategory;
	}

	public void setAwardCategory(AwardCategoryEnum awardCategory) {
		this.awardCategory = awardCategory;
	}

	@Override
	public String toString() {
		return "Award{" +
				"name='" + name + '\'' +
				", year=" + year +
				", awardType=" + awardType +
				", awardCategory=" + awardCategory +
				'}';
	}
}
