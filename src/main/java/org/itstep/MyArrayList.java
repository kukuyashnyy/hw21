package org.itstep;

import java.util.Arrays;
import java.util.Random;

public class MyArrayList<T> implements Cloneable {

	private T[] data;
	private int size;
	private int capacity;

	// Задание 1 Создать два конструктора.
	/**
	 * По умолчанию (без параметров). Который выделяет память под массив на 10 элементов,
	 * равных нулю (capacity = 10, size = 0). Переиспользовать конструктор с параметрами
	 * для уменьшения кода
	 */
	public MyArrayList() {
		this(10);
	}

	/**
	 * С параметром типа int. Задающего начальную емкость массива. Принимает один параметр
	 * (задает capacity), выделяет память под массив (size = 0).
	 * @param capacity - размер списка
	 */
	public MyArrayList(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		data = (T[]) new Object[capacity];
	}

	// Задание 2 Реализовать методы

	/**
	 * геттеры для size. Сеттера для size не должно быть!
	 * @return размер списка
	 */
	public int getSize() {
		return size;
	}

	/**
	 * переопределить метод toString и реализовать строковое представление элементов
	 * массива через пробел.
	 * @return строковое представление списка
	 */
	@Override
	public String toString() {
		if (data == null) return "[]";
		if (this.size == 0) return "[]";

		StringBuilder tmp = new StringBuilder("[");
		for (int i = 0; ; i++) {
			if(data[i] != null) tmp.append(data[i]);
				if ((i + 1) == this.size) {
					return tmp.append(']').toString();
				}
			tmp.append(", ");
		}
	}

	/**
	 * ensureCapacity – закрытый метод! проверяет, достаточно ли резерва памяти для
	 * хранения указанного в параметре количества элементов. Если значение параметра
	 * меньше текущего capacity, то ничего не происходит. Если значение параметра больше
	 * текущего capacity, то массив пересоздает- ся, памяти выделяется в 1,5 раза + 1
	 * элемент больше. Существующие элементы переносятся в новый массив. Существующие
	 * элементы не должны быть потеряны.
	 */
	private void ensureCapacity() {
		if (this.size > this.capacity) {
			data = Arrays.copyOf(data, ((int) (data.length * 1.5)) + 1);
			this.capacity = data.length;
		}
	}

	// Задание 3. Реализовать методы

	/**
	 * добавление элемента в конец массива. Должна быть проверка, достаточно ли памяти!
	 * Если памяти не достаточно увеличить емкость массива данных
	 * @param item элемент списка
	 */
	public void pushBack(T item) {
//		ensureCapacity();
		this.data[this.size] = item;
		this.size += 1;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * удаление первого элемента из массива
	 * @return удаленный элемент списка
	 */
	public T popFront() {
		T firstItem = data[0];
		if (firstItem == null) return (T) "";
		for (int i = 0; i < size; i++) {
			data[i] = data[i+1];
		}
		if (size > 0) {
			data[size - 1] = null;
			size--;
		}
		return firstItem;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * добавление нового элемента в начало массива
	 * @param item элемент списка
	 */
	public void pushFront(T item) {
		pushBack(item);
		if (size > 1) {
			for (int i = size; i > 0; i--) {
				data[i] = data[i -1];
			}
			data[0] = item;
		}
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * вставка нового элемента в массив по указанному индексу, с проверкой на выход за
	 * пределы массива
	 * @param item элемент списка
	 * @param index индекс вставки
	 */
	public void insert(T item, int index) {
		pushBack(item);
		if (size > 1) {
			for (int i = size; i > index; i--) {
				data[i] = data[i -1];
			}
			data[index] = item;
		}
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * удаление одного элемента по указанному индексу. Должна быть проверка на
	 * допустимость индекса
	 * @param index индекс массива
	 * @return удаленный элемент или null
	 */
	public T removeAt(int index) {
		if (index > size) {
			return null;
		}

		T tmp = data[index];

		for (int i = index; i < size; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return tmp;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * удаление одного элемента, значение которого совпадает со значением переданного
	 * параметра
	 * @param item элемент массива
	 * @return индекс удаленного элемента или -1
	 */
	public int remove(T item) {
		for (int i = 0; i < size; i++) {
			if (data[i] == item) {
				removeAt(i);
				return i;
			}
		}
		return -1;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * удаление всех элементов, значения которых совпадает со значением переданного
	 * параметра
	 */
	public void removeAll() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * удаление последнего элемента из массива
	 * @return удаленный элемент с конца списка или null
	 */
	public T popBack() {
		T tmp;

		if(size < 1) {
			tmp = data[size];
			removeAt(size);
		} else {
			tmp = data[size - 1];
			removeAt(size - 1);
		}

		return tmp;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * обнуление массива – всем элементам массива по индексам от 0 до size-1 присвоить
	 * значение null, полю size присвоить значение 0
	 */
	public void сlear() {
		removeAll();
//		throw new RuntimeException("Not implemented yet");
	}

	// Задание 4 Реализовать методы:
	/**
	 * Проверка на пустой список
	 * @return метод возвращает true, если size = 0, и false в обратном случае
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * метод подгоняет значение capacity под size, естественно с перевыделением памяти
	 */
	public void trimToSize() {
		data = Arrays.copyOf(data, size);
		capacity = size;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * линейный поиск слева направо первого вхождения в массив указанного значения.
	 * @param item элемент списка
	 * @return элемента, а eсли ничего не найдено, вернуть -1
	 */
	public int indexOf(T item) {
		for (int i = 0; i < size; i++) {
			if (data[i] == item) {
				return i;
			}
		}
		return -1;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * линейный поиск справа налево вхождения в массив указанного значения.
	 * @param item элемент списка
	 * @return В результате работы вернуть индекс найденного элемента, а eсли ничего не
	 * найдено, вернуть -1
	 */
	public int lastIndexOf(T item) {
		for (int i = size - 1; i >= 0; i--) {
			if (data[i] == item) {
				return i;
			}
		}
		return -1;
//		throw new RuntimeException("Not implemented yet");
	}

	// Задание 5 Реализовать методы:
	/**
	 * изменение порядка следования элементов в массиве на противоположный
	 */
	public void reverse() {
		T[] tmp = Arrays.copyOf(data, data.length);
		for (int i = 0; i < size; i++) {
			tmp[(size - 1) - i] = data[i];
		}
		data = Arrays.copyOf(tmp, tmp.length);
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * случайное перемешивание элементов массива
	 */
	public void shuffle() {
		Random random = new Random();
		T tmp;
		int rndInx;

		for (int i = 0; i < size; i++) {
			rndInx = random.nextInt(size - i) + i;
			tmp = data[rndInx];
			data[rndInx] = data[i];
			data[i] = tmp;
		}
//		throw new RuntimeException("Not implemented yet");
	}

	// Задание 6 Реализовать методы
	/**
	 * Метод сравнивает массивы не только по количеству элементов, но и по их содержимому
	 * @param other - в качестве параметра передается ссылка на другой объект класса
	 * MyArrayList.
	 * @return true - если элементы одинаковы по количеству и по содержимому
	 */
	public boolean equals(MyArrayList<T> other) {
		if (other.getSize() != size) return false;

		for (int i = 0; i < size; i++) {
			if (other.getElementAt(i) != data[i]) return false;
		}

		return true;
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * возврат копии элемента массива по указанному индексу, с проверкой на выход за
	 * пределы массива
	 * @param index - индекс списка
	 * @return найденный элемент списка или null
	 */
	public T getElementAt(int index) {
		return data[index];
//		throw new RuntimeException("Not implemented yet");
	}

	/**
	 * переопределить метод clone – метод создает точную копию MyArrayList и возвращает
	 * ссылку на эту копию (неглубокое копирование).
	 * @return копию списка
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
