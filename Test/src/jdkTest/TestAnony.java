package jdkTest;

public class TestAnony {
	public static void main(String[] args) {
		String str = "str";
		/*
		 * ◆実質的final
		 * →一度宣言された後，変更がされていない変数をfinalと見なすこと一度でも変更すると下記のようなエラーが出力される
		 * Local variable str defined in an enclosing scope must be final or effectively final
		 * str = "";
		 */
		MyIntarface myIn = new MyIntarface() {
		//匿名クラスの実装	
			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				System.out.println(str);
			}
		};
		MyIntarface myInLamda = () -> { System.out.println("lamda!"); };
		
		MyClass myCls = new MyClass() {
			//匿名クラスでオーバライド
			void walk() {
				System.out.println("walk2!");
			}
		};
		
		myIn.run();
		myCls.walk();
		myInLamda.run();
	}
}

interface MyIntarface {
	void run();
}

class MyClass {
	void walk() {
		System.out.println("walk!");
	}
}