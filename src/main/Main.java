package main;

public class Main {
	public static double rice = Double.NaN;
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		System.out.println(012); // => 10 ８進表記

		int count = 0;

		while(rice!=rice) {

			// 無限ループ
			// NaN は 0.0/0.0 などで発生 NaN を使った演算は NaN を返す
			// NaN == NaN は false になる
			System.out.println("loopA: " + count);
			if((count++) == 10) break;
		}

		count = 0;
		while ((rice==rice) == false) {

			System.out.println("loopB: " + count);
			if((count++) == 10) break;
		}

		// インクリメントの罠
		int i = 0;
		i = i++ + ++i + ++i + ++i + i++;
		//  4       4     3     2   0
		//  0       2     3     4   4
		System.out.println(i);

		// 排他的論理和
		Object a = null, b = null;
		if (a == null ^ b == null ) {
			throw null; // ヌルポー
		}

		// ラベル
		I:am:the:last:hoge:{}

		// コードブロック
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}}{{}} ItsMyCodeBlock:{}{}{}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}
		{{}{}{}{{}}{}}{}{}{}{}{{}{}{}}{}{}

		// ステートメント終端文字 + コードブロック + ラベル
		{;};;fsafa:;;{;;};;{{}{}}{};dhjkasdf:;k:jfdsaf:{}{}{}{};;;;;;;;;;;;;

		// ラベル 任意のコードブロックに付けられる
		hoge:{piyo:{foo:{}}}

		// ラベル+コメント
		Http://hoge.com
		while (rice!=rice) {break Http;}
	}
}
