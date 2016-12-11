package main;

/**
 * スタティッククロージャを使った実行
 * java8ではmain必須になってる？
 *
 * @author Kzo
 *
 */
public class StaticExecution {
	static {System.out.println("HogeHoge");}
	@SuppressWarnings("unused")
	private static int hoge = Hoge();
	private static int Hoge() {return 0;}
}
