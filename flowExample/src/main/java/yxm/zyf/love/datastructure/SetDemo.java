package yxm.zyf.love.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;


/**  
 *  @description 几个set的比较  
 *    HashSet：哈希表是通过使用称为散列法的机制来存储信息的，元素并没有以某种特定顺序来存放；  
 *    LinkedHashSet：以元素插入的顺序来维护集合的链接表，允许以插入的顺序在集合中迭代；  
 *    TreeSet：提供一个使用树结构存储Set接口的实现，对象以升序顺序存储，访问和遍历的时间很快。   
 *    ArrayList 顺序表存储，访问快，插入和删除慢
 *    ArrayDeque 双向顺序存储，集成栈和队列方法，访问快，插入和删除慢
 *    LinkedList 双向链式表，集成栈和队列方法，访问慢，插入和删除快
 */ 
public class SetDemo {  
  
    public static void main(String[] args) {  
  
        HashSet<String> hs = new HashSet<String>();  
        hs.add("B");  
        hs.add("A");  
        hs.add("D");  
        hs.add("E");  
        hs.add("C");  
        hs.add("E");  
        System.out.println("HashSet 顺序:\n"+hs);  
          
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();  
        lhs.add("B");  
        lhs.add("A");  
        lhs.add("D");  
        lhs.add("E");  
        lhs.add("C");  
        lhs.add("E");  
        System.out.println("LinkedHashSet 顺序:\n"+lhs);  
          
        TreeSet<String> ts = new TreeSet<String>();  
        ts.add("B");  
        ts.add("A");  
        ts.add("D");  
        ts.add("E");  
        ts.add("C");  
        ts.add("E");  
        System.out.println("TreeSet 顺序:\n"+ts);  
        
        ArrayList<String> al = new ArrayList<String>();
        al.add("B");  
        al.add("A");  
        al.add("D");  
        al.add("E");  
        al.add("C");  
        al.add("E");
        System.out.println("ArrayList 链表顺序:\n"+al);
        
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.push("B");
        ad.push("A");
        ad.push("D");
        ad.push("E");
        ad.push("C");
        ad.push("E");
        System.out.println("ArrayDeque 栈顺序:\n"+ad);
        
        ArrayDeque<String> ad2 = new ArrayDeque<String>();
        ad2.offer("B");
        ad2.offer("A");
        ad2.offer("D");
        ad2.offer("E");
        ad2.offer("C");
        ad2.offer("E");
        System.out.println("ArrayDeque 队列顺序:\n"+ad2);
    }  
}
