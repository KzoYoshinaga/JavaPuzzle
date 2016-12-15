package loop;

import java.util.ArrayList;
import java.util.Arrays;

public class Loop {
	public static void main(String...args) {
		test1();
		test2();
		System.out.println("\n" +
				"結論:ArrayListは削除要求時点でリストを繰り上げる\n" +
				"そのため、イテレータでの要素削除において連続した重複要素は１つしか削除されない。\n\n" +
				"そして、内部イテレータは初期状態との違いを検出し例外を上げる\n" +
				"しかし、終了判定を先に行うため最後から２番目の要素を消し繰り上げた\n"
				+ "時点で終了判定を行い、一見外部イテレータと同じ動作を行うように見える");
	}

	public static void test1() {
		// 外部イテレータと内部イテレータの挙動の違い
		ArrayList<String> strings;

		// リストに重複がない場合 ************************

		// 外部イテレータの内部でremoveしてみる
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","6 "));
		System.out.println("重複なしリスト：外部イテレータ：３番目の要素");
		strings.forEach(System.out::print);
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("3 ")) {
				strings.remove(strings.get(i));
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 4 5 6
		System.out.println("\n");

		// 外部イテレータ最後から２番目の要素
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","6 "));
		System.out.println("重複なしリスト：外部イテレータ：最後から２番目の要素");
		strings.forEach(System.out::print);
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("5 ")) {
				strings.remove(strings.get(i));
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 3 4 5
		System.out.println("\n");

		// 外部イテレータ最後の要素
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","6 "));
		System.out.println("重複なしリスト：外部イテレータ：最後の要素");
		strings.forEach(System.out::print);
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("6 ")) {
				strings.remove(strings.get(i));
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 3 4 5
		System.out.println();


		// 内部イテレータの内部でremove
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","6 "));
		System.out.println("\n重複なしリスト：内部イテレータ：３番目の要素");
		strings.forEach(System.out::print);
		for (String s: strings) {
			if (s.equals("3 ")) {
				//strings.remove(s); //  java.util.ConcurrentModificationException
			}
		}
		System.out.print(" => ");
		System.out.println("java.util.ConcurrentModificationException");

		// 内部イテレータの内部で配列の最後から２番目の要素をremove
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","6 "));
		System.out.println("\n重複なしリスト：内部イテレータ：最後から２番目の要素");
		strings.forEach(System.out::print);
		for (String s: strings) {
			if (s.equals("5 ")) {
				strings.remove(s);
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 3 4 6
		System.out.println();

		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","6 "));
		System.out.println("\n重複なしリスト：内部イテレータ：最後の要素");
		strings.forEach(System.out::print);
		for (String s: strings) {
			if (s.equals("6 ")) {
				//strings.remove(s); //  java.util.ConcurrentModificationException
			}
		}
		System.out.print(" => ");
		System.out.println("java.util.ConcurrentModificationException");
		System.out.println();
	}

	public static void test2() {
		// 外部イテレータと内部イテレータの挙動の違い
		ArrayList<String> strings;

		// リストに連番で重複がある場合 ************************

		// 外部イテレータ：重複が中腹にある場合
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","2 ","4 ","5 ","6 "));
		System.out.println("連番重複ありリスト：外部イテレータ：中腹にある場合");
		strings.forEach(System.out::print);
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("2 ")) {
				strings.remove(strings.get(i));
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 4 5 6
		System.out.println("\n");

		// 外部イテレータ：重複が最後から２番目、３番目にある場合
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","5 ","5 ","6 "));
		System.out.println("連番重複ありリスト：外部イテレータ：最後から２番目と３番目の要素");
		strings.forEach(System.out::print);
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("5 ")) {
				strings.remove(strings.get(i));
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 3 5 6
		System.out.println("\n");

		// 外部イテレータ：重複が最後と最後から２番目の要素にある場合
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","5 "));
		System.out.println("連番重複ありリスト：外部イテレータ：最後と最後から２番目の要素");
		strings.forEach(System.out::print);
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals("5 ")) {
				strings.remove(strings.get(i));
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 3 4 5
		System.out.println();


		// 内部イテレータ：重複が中腹にある場合
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","2 ","4 ","5 ","6 "));
		System.out.println("\n連番重複ありリスト：内部イテレータ：中腹にある場合");
		strings.forEach(System.out::print);
		for (String s: strings) {
			if (s.equals("2 ")) {
				// strings.remove(s); //  java.util.ConcurrentModificationException
			}
		}
		System.out.print(" => ");
		System.out.println("java.util.ConcurrentModificationException");

		// 内部イテレータ：重複が最後から２番目と３番目にある場合
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","5 ","5 ","6 "));
		System.out.println("\n連番重複ありリスト：内部イテレータ：最後から２番目と３番目の要素");
		strings.forEach(System.out::print);
		for (String s: strings) {
			if (s.equals("5 ")) {
				// strings.remove(s); //  java.util.ConcurrentModificationException
			}
		}
		System.out.print(" => ");
		System.out.println("java.util.ConcurrentModificationException");

		// 内部イテレータ：重複が最後と最後から２番目の要素にある場合
		strings = new ArrayList<>(Arrays.asList("1 ","2 ","3 ","4 ","5 ","5 "));
		System.out.println("\n連番重複ありリスト：内部イテレータ：最後と最後から２番目の要素");
		strings.forEach(System.out::print);
		for (String s: strings) {
			if (s.equals("5 ")) {
				strings.remove(s); //  java.util.ConcurrentModificationException
			}
		}
		System.out.print(" => ");
		strings.forEach(System.out::print); // 1 2 3 4 5
		System.out.println();
	}
}







































