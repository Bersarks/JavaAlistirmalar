import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
	public static List<String> addElementsInList(List<String> list, String[] element) {
		for (String x : element) {
			list.add(x);
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		List<String> studentNames = new ArrayList<>();
		List<String> studentNames1 = new ArrayList<>();
		List<String> studentNames2 = new ArrayList<>();
		List<String> studentNames3 = new ArrayList<>();
		String[] names = {"Mehmet Aydın", "İsmet Işık", "Ayhan Köse", "Orhan İzmirli"};
		String[] names1 = {"Aylin Kısa", "Adem Elmas", "Korhan Kaya", "Osman Kızıl"};
		String[] names2 = {"Orhan Kalaba", "Ayşe Ulus", "Kazım Kalaba", "Pakize Kuzu"};
		String[] names3 = {"Ayhan Orhan", "Hayriye Kuzu", "Şahin Madımak", "Rasim Ozan"};

		addElementsInList(studentNames, names);
		addElementsInList(studentNames1, names1);
		addElementsInList(studentNames2, names2);
		addElementsInList(studentNames3, names3);


		Map<String, List<String>> studentInfo = new HashMap<>();
		studentInfo.put("1-A", studentNames);
		studentInfo.put("2-A", studentNames1);
		studentInfo.put("3-A", studentNames2);
		studentInfo.put("4-A", studentNames3);

		for (String name : studentInfo.keySet()) {
			System.out.println(name);
			for (String student : studentInfo.get(name)) {
				String[] splitter = student.split(" ");
				if (splitter[0].endsWith("an"))
					System.out.println(student);
			}
		}
	}
}