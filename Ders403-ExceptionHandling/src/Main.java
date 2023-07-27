import service.GeneralService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public  static void main(String[] args) throws Exception{
		Map<String, String> map = new HashMap<>();
		map.put("TR1231234KYS124", "İnsan");
		map.put("TR1543234KYS124", "İnsan1");
		map.put("TR12132412YS124", "İnsan2");
		System.out.println("İnsan".hashCode());
		List<String> list = List.of("İnsan", "İnsan1", "İnsan2");
		list.get(0).equals();
		//@autowired
		//Lombok
	}
}