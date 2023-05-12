import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    public   class Node{
        public  K key;
        public V value;
        private int size=1;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public void put(K key, V val){
        root=privatePut(root, key,val);
    }
    private Node privatePut(Node node, K key, V val){
        if (node == null)
            return new Node(key, val);
        int compare_to = key.compareTo(node.key);
        if (compare_to < 0) {
            node.left = privatePut(node.left, key, val);
        }
        else if (compare_to > 0) {
            node.right = privatePut(node.right, key, val);
        }
        else {
            node.value = val;
        }
        node.size= getNodeSize(node.left) + getNodeSize(node.right) + 1 ;
        return node;
    }
    private int getNodeSize(Node n) {
        return n!=null? n.size : 0;
    }

    public int size() {
        return root.size;
    }
    public V get(K key){
        Node node = privateGet(root, key);
        return node != null ? node.value : null;
    }
    private Node privateGet(Node node, K key){
        if(node==null){
            return null;
        }
        int compare_to = key.compareTo(node.key);
        if(compare_to==0){
            return node;
        }
        else if (compare_to>0){
            return privateGet(node.right, key);
        }else return privateGet(node.left, key);
    }
    public void delete(K key){
        root = privateDelete(root, key);
    }

    private Node privateDelete(Node node, K key){
        int compare_to = key.compareTo(node.key);
        if(node==null){
            return null;
        }else if(compare_to > 0){
            node.right = privateDelete(node.right, key);
        }else if(compare_to < 0){
            node.left= privateDelete(node.left, key);
        } else {
            if(node.left==null&node.right==null)  return null;
            else if (node.left == null)  node = node.right;
            else if (node.right == null) node = node.left;
            else {
                Node t = max(node.left);
                node.key = t.key;
                node.value = t.value;
                node.right = privateDelete(node.right, t.key);
                node.left = t.left;
            }
        }
        node.size--;
        return node;
    }

    private Node max(Node n){
        while(n.right!=null) {
            n = n.right;
        }
        return n;
    }

    public void output(){
        output(root);
    }
    private void output(Node n){
        if(n==null){
            return;
        }
        output(n.left);
        System.out.println("This is key: "+ n.key + " This is value : " + n.value);
        output(n.right);
    }

    @Override
    public Iterator<Node> iterator() {
        ArrayList<Node> list = new ArrayList<>();
        inOrder(root, list);
        return list.iterator();
    }

    private void inOrder(Node node, ArrayList<Node> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node);
            inOrder(node.right, list);
        }
    }
}
