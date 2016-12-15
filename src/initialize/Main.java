package initialize;

/*
  	Static
	Static initial block
	Field
	Initialize block
	Constructor
 */
public class Main {

	Someone someone = new Someone("Field");

	static Someone someotwo = new Someone("Static");

	static Someone somethree;

	static {
		somethree = new Someone("Static initial block");
	}

	{
		someone = new Someone("Initialize block");
	}

	public Main() {
		someone = new Someone("Constructor");
	}

	public static void main(String...args) {
		new Main();
	}

}
