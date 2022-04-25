package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int size = 0;
    private int capacity;
    // 缓存map
    private Map<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();
    // 伪头节点 当元素被使用时，方便用来将元素置到头部
    private DLinkNode head;
    // 伪尾节点 当容量不够时删除尾部节点
    private DLinkNode tail;

    class DLinkNode{
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(int key, int val){
            this.key = key;
            this.val = val;
        }
        public DLinkNode(){}
    }

    public LRUCache(int capacity) {
        // 设置初始容量 eg: 2
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        // 不存在返回-1
        if(node == null){
            return -1;
        }
        //存在时 将节点移至头部
        move2Head(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if(node != null){
            node.val = value;
            move2Head(node);
        }else{
            size++;
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            add2Head(newNode);
            // 若当前容量超限
            if(size > capacity){
                // 则移除尾部节点
                DLinkNode rNode = removeTail();
                cache.remove(rNode.key);
                size--;
            }
        }
    }

    void move2Head(DLinkNode node){
        // 1.删除当前节点位置
        removeNode(node);
        // 2.将节点添加到头部
        add2Head(node);
    }
    DLinkNode removeTail(){
        DLinkNode rNode = tail.prev;
        removeNode(rNode);
        return rNode;
    }

    void add2Head(DLinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    void removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
