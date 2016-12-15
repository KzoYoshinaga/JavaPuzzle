package exception;

public class ExceptionHandling {

	public void questinon1() {
		// Integer.parseInt(String) が文字列を数値に変換出来ないのは例外か？

		/* Jeffrey Richter氏の「例外」の定義
		 *
		 * ”例外とは、あるメンバーが、その名前から期待される処理を完了できなかった時に起こる”。
		 */

		// この定義によればInteger.parseInt(String)が文字列を数値に変換できなのは例外ある

		// しかしInteger.parseInt(NumericString)ならどうか？

		// つまり数値に変換できる文字列を数値に変換出来ない場合のエラーと
		// 数値に変換できるか分からない文字列を数値に変換出来なかった場合のエラーは
		// 同じ例外なのか？

		/*
		 * 文字－＞数値の変換はいつ使う？
		 *
		 * ・・・外部ファイルからの読み込み
		 * ・・・標準入力から
		 * プログラム内では、数値は数値、文字は文字
		 * プログラム内で生成された文字を数値に変換すること自体が例外的状況では？
		 * 文字列が期待されている以上の処理をさせることに他ならない。
		 *
		 * // 前判定して分岐
		 * if (isNumeric(s)) {
		 * 		Number n = toNumber(s); // throw FatalException 変換出来るものが出来なかった場合の例外
		 * } esle {
		 * 		// 変換出来なかった場合の処理
		 * }
		 *
		 * // やってみてダメだったら分岐
		 * try {
		 * 		Number n = Integer.parseInt(s);
		 * } catch(NumberFormatException e) {  // 変換出来るか分からないものが変換出来なかった例外
		 *      // 変換出来なかった場合の処理
		 *      // 変換ロジックに問題があろうが無かろうが
		 *      // 例外を投げられたら同様にハンドリング
		 * }
		 *
		 */



	}
}
