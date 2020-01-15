/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unrolledlinkedlist;

import java.util.LinkedList;

/**
 *
 * @author Dominykas
 */
public class Greitaveika {
    void greitisPagalTalpa() {
        
        UnrolledLinkedList<String> listas1 = new UnrolledLinkedList<>(32);
        UnrolledLinkedList<String> listas2 = new UnrolledLinkedList<>(16);
        UnrolledLinkedList<String> listas3 = new UnrolledLinkedList<>(8);
        UnrolledLinkedList<String> listas4 = new UnrolledLinkedList<>(4);
        int size = 4000;
        
        long t0 = System.nanoTime();

        for(int i = 1; i < size; i++)
            listas1.add(Integer.toString(i));
        
        long t1 = System.nanoTime();
        
        for(int i = 1; i < size; i++)
            listas2.add(Integer.toString(i));
        
        long t2 = System.nanoTime();
        
        for(int i = 1; i < size; i++)
            listas3.add(Integer.toString(i));
        
        long t3 = System.nanoTime();
        
        for(int i = 1; i < size; i++)
            listas4.add(Integer.toString(i));
        
        long t4 = System.nanoTime();
        
        System.out.printf("nodeCount - %d | nodeCapacity - %d | elementsInserted - %d | duration - %7.4f\r\n", listas1.size(), listas1.getNodeSize(), listas1.dataSize(), (t1 - t0) / 1e9);
        System.out.printf("nodeCount - %d | nodeCapacity - %d | elementsInserted - %d | duration - %7.4f\r\n", listas2.size(), listas2.getNodeSize(), listas2.dataSize(), (t2 - t1) / 1e9);
        System.out.printf("nodeCount - %d | nodeCapacity - %d | elementsInserted - %d | duration - %7.4f\r\n", listas3.size(), listas3.getNodeSize(), listas3.dataSize(), (t3 - t2) / 1e9);
        System.out.printf("nodeCount - %d | nodeCapacity - %d | elementsInserted - %d | duration - %7.4f\r\n", listas4.size(), listas4.getNodeSize(), listas4.dataSize(), (t4 - t3) / 1e9);

        
    }
    
    void palyginimasSuLinkedList() {
        UnrolledLinkedList<String> unrolled = new UnrolledLinkedList<>(8);
        LinkedList<String> linked = new LinkedList<>();
        int size = 4000;
        
        System.out.println("I sarasus pridedama po 4000 elementu");
        long t0 = System.nanoTime();
        
        for(int i = 1; i < size; i++)
            unrolled.add(Integer.toString(i));
        
        long t1 = System.nanoTime();
        
        for(int i = 1; i < size; i++)
            linked.add(Integer.toString(i));
        
        long t2 = System.nanoTime();
        
        System.out.printf("Unrolled Linked List | nodeCount - %d | duration - %7.4f\r\n", unrolled.size(), (t1 - t0) / 1e9);
        System.out.printf("Linked List | nodeCount - %d | duration - %7.4f\r\n", linked.size(), (t2 - t1) / 1e9);
        
        
        long t3 = System.nanoTime();
        unrolled.contains("3000");
        long t4 = System.nanoTime();
        linked.contains("3000");
        long t5 = System.nanoTime();
        
        System.out.println("\r\nIeskomas 3000-asis elementas");
        System.out.printf("Unrolled Linked List | duration - %7.4f\r\n", (t4 - t3) / 1e9);
        System.out.printf("Linked List | duration - %7.4f\r\n", (t5 - t4) / 1e9);
        
        
        long t6 = System.nanoTime();
        unrolled.remove("3000");
        long t7 = System.nanoTime();
        linked.remove("3000");
        long t8 = System.nanoTime();
        
        System.out.println("\r\nSalinamas 3000-asis elementas");
        System.out.printf("Unrolled Linked List | duration - %7.4f\r\n", (t7 - t6) / 1e9);
        System.out.printf("Linked List | duration - %7.4f\r\n", (t8 - t7) / 1e9);

    }
    
    void tyrimas() {
        //greitisPagalTalpa();
        palyginimasSuLinkedList();
    }
    public static void main(String[] args) throws InterruptedException {
		new Greitaveika().tyrimas();
	}
}
