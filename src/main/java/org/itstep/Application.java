package org.itstep;

public class Application {

	public static void main(String[] args) {
		// FIXME: проверяйте класс MyArrayList здесь
		MyArrayList<String> list = new MyArrayList<String>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");

		list.shuffle();
	}

}
