package learn.heap;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/19
 * Time: 15:49
 */
public class Array<T> {

    private T[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public Array(T [] arr){
        data = (T[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] =arr[i];
        }
        size = arr.length;
    }
    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(T e){
        add(size, e);
    }

    // 在所有元素前添加一个新元素
    public void addFirst(T e){
        add(0, e);
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, T e){


        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        for(int i = size - 1; i >= index ; i --)
            data[i + 1] = data[i];
        if(size == data.length) {
//            throw new IllegalArgumentException("Add failed. Array is full.");
            resize(2 * data.length);
        }
        data[index] = e;

        size ++;
    }
    public void resize(int len){
        T[] newData =(T[]) new Object[len];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    // 获取index索引位置的元素
    public T get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, T e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(T e){
        for(int i = 0 ; i < size ; i ++){
            if(e.equals(data[i]))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(T e){
        for(int i = 0 ; i < size ; i ++){
            if(e.equals(data[i]))
                return i;
        }
        return -1;
    }
    public void swap(int i, int j){
        if( i < 0 || i >= size || j <0 || j >= size) throw new RuntimeException("dd");
        T t  = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    // 从数组中删除index位置的元素, 返回删除的元素
    public T remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        T ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null;

        if(size < data.length / 3 ) resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public T removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public T removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(T e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}