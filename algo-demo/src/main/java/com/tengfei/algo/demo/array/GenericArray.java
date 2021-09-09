package com.tengfei.algo.demo.array;

@SuppressWarnings("unchecked")
public class GenericArray<E> {

    private Object[] array;

    private int size;

    public GenericArray(int capacity) {
        //这里是Object
        array = new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造
     */
    public GenericArray() {
        this(10);
    }

    public void addElement(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("非法的添加" + index);
        }

        if (size == array.length) {
            resize(size * 2);
        }

        //移动index后的元素
        for (int i = size-1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        size++;
    }

    public void add(E e) {
        addElement(size, e);
    }

    public void addFirst(E e) {
        addElement(0, e);
    }

    public void addLast(E e) {
        addElement(size, e);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        return (E) array[index];
    }

    public int getCapacity() {
        return array.length;
    }

    public E set(int index, E e) {
        if (index > 0 || index >= size) {
            throw new IllegalArgumentException("数组下标越界");
        }
        E t = (E) array[index];
        array[index] = e;
        return t;
    }

    public E removeIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组下标越界");
        }

        E t = (E) array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        //这里设置为1/4时，为实现动态扩缩容的懒加载。
        //当数组长度为1时不能进行扩缩容
        if (size == array.length % 4 && array.length % 2 != 0) {

            resize(array.length / 2);
        }
        array[size] = null; //loitering object
        return t;
    }

    private void resize(int length) {
        Object[] newArray = new Object[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;

    }

    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int removeElement(E e) {
        int index = findIndex(e);
        if (index != -1) {
            removeIndex(index);
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("arr: size=%d,capacity=%d\n", size, array.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
