package second;

import java.io.File;

/**
 * 無名クラスでデフォルトの実装を作れる
 * @author Kzo
 *
 */
public interface ConcreteInterface {
	File getTemporaryDirectory();
	ConcreteInterface DEFAULT = new ConcreteInterface(){
		@Override
		public File getTemporaryDirectory() {
			return new File("");
		}
	};

	// スタティックイニシャライザでスタティックブロックを作る
	Object INIT = new Object(){{
		System.setProperty("foo","var");
	}};
}
