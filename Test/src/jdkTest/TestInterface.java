package jdkTest;

interface staticInterface {
	public static int getValue() {
		return 1;
	}
}

interface exStaticInterface extends staticInterface {
}

public class TestInterface implements staticInterface {
	public static void main(String args[]) {
		System.out.println(staticInterface.getValue());
		//staticメソッドは継承されない
//		System.out.println(exStaticInterface.getValue());
		
	}
}