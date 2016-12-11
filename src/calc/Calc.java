package calc;

import jp.hishidama.eval.ExpRuleFactory;
import jp.hishidama.eval.Expression;
import jp.hishidama.eval.Rule;

public class Calc {
	public static void main(String...args) {


		String str = "1+1)(";
		System.out.println("式: " + str);

		Rule rule = ExpRuleFactory.getDefaultRule();
		try {
			Expression exp = rule.parse(str);
			long result = exp.evalLong();
			System.out.println("結果: " + result);
		} catch (Exception e) {}

	}


}
