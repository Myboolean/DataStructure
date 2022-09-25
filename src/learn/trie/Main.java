package learn.trie;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/23
 * Time: 10:23
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("asbbasdas");
        trie.add("abc");
        trie.add("abd");
        trie.add("dsd");
        System.out.println(trie.contains("asbbasdas"));
    }
}
