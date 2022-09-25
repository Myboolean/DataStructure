package learn.trie;
import java.util.TreeMap;
/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/23
 * Time: 9:45
    Trie的时间复杂度和字符串（字符串可以替换为其他有差不多性质的类 ）的长度相关而和具体条目的数量无关
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }


    public int size() {
        return size;
    }

    /**
     * 添加一个单词 非递归
     * @param word
     */
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null) cur.next.put(c, new Node());
            cur = cur.next.get(c);

        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }

    public void addR(String word){
        addRecursion(word, root, 0);
    }
    /**
     * 递归
     */
    public void addRecursion(String word, Node node, int index){
        if(index >= word.length()){
            if(!node.isWord){
                node.isWord = true;
                size++;
            }
            return;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) node.next.put(c, new Node());
        addRecursion(word, node.next.get(c), index + 1);
    }

    /**
     * 查询单词是否在trie树中
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null ) return  false;
            cur = cur.next.get(c);
        }
        // 这里注意要判断是否是单词结尾
        return cur.isWord;
    }
    public boolean containsR(String word){
       return containsRecursion(word, root, 0);
    }
    /**
     * 查询单词是否在trie树中,递归
     * @param word
     * @return
     */
    public boolean containsRecursion(String word, Node node ,int index){
        if(index >= word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null) return false;
        return containsRecursion(word, node.next.get(c), index + 1);
    }
    /**
     * 查询是否在Trie中有单词以prefix为前缀
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null ) return false;
            cur = cur.next.get(c);
        }
        return true;
    }

}
