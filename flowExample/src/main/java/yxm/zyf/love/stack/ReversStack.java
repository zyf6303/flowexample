package yxm.zyf.love.stack;

public class ReversStack<T> {

    class Node<U> {
        private U itemValue; //结点的值

        private Node<U> nextItem; //下一个节点地址

        Node() {
            itemValue = null;
            nextItem = null;
        }

        public Node(U itemValue, Node<U> nextItem) {
            this.itemValue = itemValue;
            this.nextItem = nextItem;
        }

        boolean end() {
            return itemValue == null && nextItem == null;
        }
    }

    private Node<T> top = new Node<>();//最后一个节点

    //进栈
    public void put(T itemValue) {
        top = new Node<T>(itemValue, top);
    }
    
    //出栈
    public T pop(){
        T result = top.itemValue;
        if(!top.end()){
            top=top.nextItem;
        }
        return result;
    }
    
    public static void main(String[] args) {
        ReversStack<String> rs=new ReversStack<String>();
        rs.put("tst1");
        rs.put("tst2");
        rs.put("tst3");
        System.out.println(rs.pop());
        System.out.println(rs.pop());
        System.out.println(rs.pop());
    }
}
