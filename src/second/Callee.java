package second;

import java.lang.reflect.Method;

public class Callee {
	/**
	 * メソッド自身を取得する
	 * @param  メソッド内で作成した無名クラス
	 * @return メソッド自身
	 */
	static Method callee(Object o) {
		return o.getClass().getEnclosingMethod();
	}

	/**
	 * currentが10になるまで再帰する関数
	 *
	 */
	static void count(int current) {
		System.out.println(current);
		if (current >= 10) {
			return;
		} else {
			try {
				// メソッド自身を取得する
				callee(new Object(){}).invoke(null, current + 1);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}

}
