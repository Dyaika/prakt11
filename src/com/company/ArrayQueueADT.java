package com.company;

public class ArrayQueueADT<E> {
    private int size;
    private int start;
    private int end;
    private Object [] queue;

    public ArrayQueueADT() {
        size = 0;
        queue = new Object[10];
        start = end = 0;
    }

    public void enqueue(E element){
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
    public E element(){
        if (size == 0){
            return null;
        }
        return (E)queue[start];
    }
    public E dequeue(){
        E res = null;
        if (size > 0){
            size--;
            res = (E)queue[start];
            start = (start + 1) % queue.length;
        }
        return res;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void clear(){
        size = start = end = 0;
        queue = new Object[10];
    }
    public static void test(){
        System.out.println("Тестирование ArrayQueueADT");
        ArrayQueueADT<Integer> q = new ArrayQueueADT<>();
        Integer el = q.dequeue();
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
        el = q.element();
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
