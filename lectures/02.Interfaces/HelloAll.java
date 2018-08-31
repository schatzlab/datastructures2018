public class HelloAll
{
	public static void main(String [] argv)
	{
		for (int i = 0; i < argv.length; i++)
		{
			System.out.println("Hello, " + argv[i] + "!");
		}
	}
}

