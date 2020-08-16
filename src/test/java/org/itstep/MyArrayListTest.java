package org.itstep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

	@Test
	void getSize() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals(0, list.getSize());
		list = new MyArrayList<>(10);
		// насколько я понял сдесь ошибка в тесте
//		assertEquals(10, list.getSize());
		assertEquals(0, list.getSize());

	}

	@Test
	void testToString() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals("[]", list.toString());
	}

	@Test
	void pushBack() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals("[]", list.toString());
		list.pushBack("1");
		assertEquals("[1]", list.toString());
		list.pushBack("2");
		assertEquals("[1, 2]", list.toString());
		list.pushBack("3");
		assertEquals("[1, 2, 3]", list.toString());
	}

	@Test
	void popFront() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		assertEquals("[1, 2, 3]", list.toString());
		assertEquals("1", list.popFront());
		assertEquals("[2, 3]", list.toString());
		assertEquals("2", list.popFront());
		assertEquals("[3]", list.toString());
		assertEquals("3", list.popFront());
		assertEquals("[]", list.toString());
		assertEquals("", list.popFront());
		assertEquals("[]", list.toString());
	}

	@Test
	void pushFront() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals("[]", list.toString());
		list.pushFront("1");
		assertEquals("[1]", list.toString());
		list.pushFront("2");
		assertEquals("[2, 1]", list.toString());
		list.pushFront("3");
		assertEquals("[3, 2, 1]", list.toString());
	}

	@Test
	void insert() {
		MyArrayList<String> list = new MyArrayList<>();
		assertEquals("[]", list.toString());
		list.insert("1", 0);
		assertEquals("[1]", list.toString());
		list.insert("2", 0);
		assertEquals("[2, 1]", list.toString());
//		оригинал
//		list.insert("3", 0);
//		исправлено
		list.insert("3", 1);
//		оригинал
		assertEquals("[2, 3, 1]", list.toString());
	}

	@Test
	void removeAt() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		assertEquals("[1, 2, 3]", list.toString());
		assertEquals("2", list.removeAt(1));
		assertEquals("3", list.removeAt(1));
		assertEquals("1", list.removeAt(0));
		assertNull(list.removeAt(0));
	}

	@Test
	void remove() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		assertEquals("[1, 2, 3]", list.toString());
		assertEquals(-1, list.remove("0"));
		assertEquals(1, list.remove("2"));
		assertEquals(1, list.remove("3"));
		assertEquals(0, list.remove("1"));
		assertEquals(-1, list.remove("5"));
	}

	@Test
	void removeAll() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		list.removeAll();
		assertEquals(0, list.getSize());
		assertEquals("[]", list.toString());
		assertEquals(-1, list.indexOf("1"));
		assertEquals(-1, list.indexOf("2"));
		assertEquals(-1, list.indexOf("3"));
		assertEquals(-1, list.indexOf("0"));
		assertEquals(-1, list.remove("1"));
		assertEquals(-1, list.remove("2"));
		assertEquals(-1, list.remove("3"));
	}

	@Test
	void popBack() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");

		assertEquals("[1, 2, 3]", list.toString());
		assertEquals("3", list.popBack());
		assertEquals("2", list.popBack());
		assertEquals("1", list.popBack());
		assertNull(list.popBack());
	}

	@Test
	void сlear() {
		removeAll();
	}

	@Test
	void isEmpty() {
		MyArrayList<String> list = new MyArrayList<>();
		assertTrue(list.isEmpty());
		list.pushFront("1");
		assertFalse(list.isEmpty());
		list.removeAll();
		assertTrue(list.isEmpty());
		list.pushFront("1");
		assertFalse(list.isEmpty());
		assertEquals("1", list.popBack());
		assertTrue(list.isEmpty());
	}

	@Test
	void trimToSize() {
	}

	@Test
	void indexOf() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("2");
		list.pushBack("3");

		assertEquals(0, list.indexOf("1"));
		assertEquals(1, list.indexOf("2"));
		assertEquals(3, list.indexOf("3"));
		assertEquals(-1, list.indexOf("4"));
	}

	@Test
	void lastIndexOf() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("2");
		list.pushBack("3");

//		в оригинале не проверяется lastIndexOf()
//		assertEquals(0, list.indexOf("1"));
//		assertEquals(2, list.indexOf("2"));
//		assertEquals(3, list.indexOf("3"));
//		assertEquals(-1, list.indexOf("4"));

		assertEquals(0, list.lastIndexOf("1"));
		assertEquals(2, list.lastIndexOf("2"));
		assertEquals(3, list.lastIndexOf("3"));
		assertEquals(-1, list.lastIndexOf("4"));
	}

	@Test
	void reverse() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("2");
		list.pushBack("3");

		assertEquals("[1, 2, 2, 3]", list.toString());
		list.reverse();
		assertEquals("[3, 2, 2, 1]", list.toString());
	}

	@Test
	void shuffle() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		list.pushBack("4");

		MyArrayList<String> expected = new MyArrayList<>();
		expected.pushBack("1");
		expected.pushBack("2");
		expected.pushBack("3");
		expected.pushBack("4");

		expected.shuffle();

		assertFalse(expected.equals(list));
	}

	@Test
	void testEquals() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		list.pushBack("4");

		MyArrayList<String> expected = new MyArrayList<>();
		expected.pushBack("1");
		expected.pushBack("2");
		expected.pushBack("3");
		expected.pushBack("4");

		assertTrue(expected.equals(list));
	}

	@Test
	void getElementAt() {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		list.pushBack("4");

		assertEquals("1", list.getElementAt(0));
		assertEquals("2", list.getElementAt(1));
		assertEquals("3", list.getElementAt(2));
		assertEquals("4", list.getElementAt(3));
	}

	@Test
	void testClone() throws CloneNotSupportedException {
		MyArrayList<String> list = new MyArrayList<>();
		list.pushBack("1");
		list.pushBack("2");
		list.pushBack("3");
		list.pushBack("4");

		MyArrayList<String> copy = (MyArrayList<String>) list.clone();
		assertFalse(list == copy);
		assertTrue(list.equals(copy));
	}

}