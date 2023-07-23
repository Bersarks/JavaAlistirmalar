package hw3.util;

public enum Grade {
	A(4), B(3), C(2), D(1), F(0);
	public final int letterGrade;

	private Grade(int letterGrade) {
		this.letterGrade = letterGrade;
	}

/*	@Override
	public String toString() {
		return ;
	}*/
}
