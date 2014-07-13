package chapter02.item03.nonstantiable;

public class UtilityClass
{

	public UtilityClass() {
		throw new AssertionError("This class can't be initialized");
	}
	
}
