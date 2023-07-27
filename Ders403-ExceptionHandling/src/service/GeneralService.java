package service;

import exceptions.NewException;

public class GeneralService {
	public Integer divideBy(int x, int y) {
		Integer result = null;
		try {
			result = x / y;
			throw new NewException("ArithmeticException"); // custom exception
		}
		catch (NewException ne) {
			ne.printStackTrace();
			System.out.println(ne.getMessage());
			System.out.println("New Exception: ");
		}
		catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException np){ // çoklu hata yakalama
			System.out.println(np.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finally block");
		}
		return result;
	}
}
