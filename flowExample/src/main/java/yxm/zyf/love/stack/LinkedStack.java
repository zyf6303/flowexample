package yxm.zyf.love.stack;

import com.alibaba.fastjson.JSON;

/** 
 *  
 * <p> 
 * 堆栈 
 * <p> 
 *  
 * @author Lqy 
 *  
 */  
public class LinkedStack<T> {  
        //堆栈中的节点  
    class Node<U> {  
          
        private U item;// 节点的值  
        private Node<U> next;// 前一个节点  
  
        Node() {  
            item = null;  
            next = null;  
        }  
  
        Node(U item, Node<U> next) {  
            this.item = item;  
            this.next = next;  
        }  
  
        /** 
         * 用于判断堆栈是否为空，也就是是否遇到了末端哨兵(end sentinel) 
         *  
         * @return 
         */  
        boolean end() {  
            return item == null && next == null;  
        }  
    }  
  
    /** 
     * 末端哨兵<span style="font-size: 1em; line-height: 1.5;">(end sentinel)</span> 
     */  
    private Node<T> top = new Node<T>();  
  
    /** 
     * 入栈 
     *  
     * @param t 
     */  
    public void push(T item) {  
                //当有新值插入的时候，改变top的指向，改变top指向之前先将top往下压。  
        top = new Node<T>(item, top);  
    }  
  
    /** 
     * 出栈 
     *  
     * @return 
     */  
    public T pop() {  
                //出栈的时候，每次都取栈顶的值  
        T result = top.item;  
                //判断是否遇到了末端哨兵  
        if (!top.end()) {  
            top = top.next;  
        }  
        return result;  
    }  
  
    public static void main(String[] args) {  
        LinkedStack<String> stack = new LinkedStack<String>();  
        stack.push("test1"); 
        stack.push("test2");
        stack.push("test3");
        System.out.println(JSON.toJSONString(stack));
        System.out.println(stack.pop());  
        System.out.println(stack.pop());  
        System.out.println(stack.pop());  
    }  
} 