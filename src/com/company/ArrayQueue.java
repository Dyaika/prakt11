package com.company;

public class ArrayQueue {
    private int size;
    private int start;
    private int end;
    private Object [] queue;

    public ArrayQueue() {
        size = 0;
        queue = new Object[10];
        start = end = 0;
    }

    //инвариант цикла - размер очереди не превышает длину массива,
    //длина массива кратна 10,
    //0 <= start, end < длина массива
    //предусловие - элемент существует
    //постусловие - queue[(длина массива + end - 1) mod длина массива] равно элементу
    public void enqueue(Object element){
        if (element == null){
            return;
        }
        if (size + 1 == queue.length){
            Object [] temp = new Object[queue.length * 2];
            int n = size;
            for (int i = 0; i < n; i++){
                temp[i] = dequeue();
            }
            queue = temp;
            start = 0;
            size = n;
            end = n;
        }
        size++;
        queue[end] = element;
        end = (end+1) % queue.length;
    }

    //предусловие - элемент существует
    //постусловие - queue[start] возвращено
    public Object element(){
        if (size == 0){
            return null;
        }
        return (queue[start]);
    }

    //предусловие - размер очереди больше 0
    //постусловие - queue[start] возвращено, размер уменьшился на 1
    public Object dequeue(){
        Object res = null;
        if (size > 0){
            size--;
            res = queue[start];
            start = (start + 1) % queue.length;
        }
        return res;
    }

    //постусловие - size возвращено
    public int size(){
        return size;
    }

    //постусловие - верность пустоты очереди возвращена
    public boolean isEmpty(){
        return size == 0;
    }


    //постусловие - размер очереди 0,
    //размер массива 10, start и end равны 0
    public void clear(){
        size = start = end = 0;
        queue = new Object[10];
    }
    public static void test(){
        System.out.println("Тестирование ArrayQueue");
        ArrayQueue q = new ArrayQueue();
        Integer el = (Integer)q.dequeue();
        System.out.println("size = " + q.size());
        if (el == null){
            System.out.println("нет элемента");
        } else{
            System.out.println("первый элемент = " + el);
        }
        System.out.println("очередь пустая? " + q.isEmpty());
        for (int i = 0; i < 15; i++){
            q.enqueue(i);
        }
        System.out.println("добавили 15 элементов (0-14)");
        for (int i = 0; i < 5; i++){
            q.dequeue();
        }
        System.out.println("удалили 5 элементов (0-4)");
        for (int i = 0; i < 5; i++){
            q.enqueue(i + 15);
        }
        System.out.println("добавили 5 элементов (15-19)");
        el = (Integer)q.element();
        if (el == null){
            System.out.println("нет элемента");
        } else{
            System.out.println("первый элемент = " + el);
        }
        System.out.println("очередь пустая? " + q.isEmpty());
        System.out.println("size = " + q.size());
        for (int i = 0; i < 15; i++){
            System.out.print(q.dequeue() + " ");
        }
        System.out.println();
        System.out.println("size = " + q.size());
    }
}
