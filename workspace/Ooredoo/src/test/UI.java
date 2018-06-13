package test;

public class UI {
	public UI()
	{
	
	}
	public static void main(String[] args)
	{
		String v="orange";
		String b="a";
		if((v.contains("orange")||v.contains("red")||v.contains("blue")) && (b.contains("a")|| b.contains("b")))
		System.out.println("true");
		else
			System.out.println("false");
	}
}
