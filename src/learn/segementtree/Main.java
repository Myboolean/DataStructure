package learn.segementtree;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 21:36
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegementTree<Integer> segementTree = new SegementTree<>(nums, Integer::sum);
        System.out.println(segementTree);

        System.out.println();
        System.out.println(segementTree.query(0, 5));
    }
}
