package com.company;

public class ArrayQueueModule {
    private static int size;
    private static int start;
    private static int end;
    private static Object [] queue;

    public ArrayQueueModule() {
        size = 0;
        queue = new Object[10];
        start = end = 0;
    }

    public static void enqueue(Object element){
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
    public static Object element(){
        if (size == 0){
            return null;
        }
        return (queue[start]);
    }
    public static Object dequeue(){
        Object res = null;
        if (size > 0){
            size--;
            res = queue[start];
            start = (start + 1) % queue.length;
        }
        return res;
    }
    public static int size(){
        return size;
    }
    public static boolean isEmpty(){
        return size == 0;
    }
    public static void clear(){
        size = start = end = 0;
        queue = new Object[10];
    }
    public static void test(){
        System.out.println("Тестирование ArrayQueueModule");
        ArrayQueueModule q1 = new ArrayQueueModule();
        ArrayQueueModule q2 = new ArrayQueueModule();
        System.out.println("созданы очереди q1 и q2");
        Integer el = (Integer)q1.dequeue();
        System.out.println("q1 size = " + q1.size());
        if (el == null){
            System.out.println("нет элемента");
        } else{
            System.out.println("первый элемент q1 = " + el);
        }
        System.out.println("очередь q1 пустая? " + q1.isEmpty());
        for (int i = 0; i < 15; i++){
            q1.enqueue(i);
        }
        System.out.println("добавили 15 элементов в q1 (0-14)");
        for (int i = 0; i < 5; i++){
            q2.dequeue();
        }
        System.out.println("удалили 5 элементов из q1 (0-4)");
        for (int i = 0; i < 5; i++){
            q2.enqueue(i + 15);
        }
        System.out.println("добавили 5 элементов в q2 (15-19)");
        el = (Integer)q2.element();
        if (el == null){
            System.out.println("нет элемента q2");
        } else{
            System.out.println("первый элемент q2 = " + el);
        }
        System.out.println("очередь q2 пустая? " + q2.isEmpty());
        System.out.println("size q2 = " + q2.size());
        System.out.println("Очередь q2:");
        for (int i = 0; i < 15; i++){
            System.out.print(q2.dequeue() + " ");
        }
        System.out.println();
        System.out.println("size q1 = " + q1.size());
    }
}
