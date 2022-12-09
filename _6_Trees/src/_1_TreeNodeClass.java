public class _1_TreeNodeClass {
}
    Create Project: Trees

        Create Package: default

Create class: TreeNode
        ----------------------------------------------
        import java.util.ArrayList;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        children = new ArrayList<>();
    }
}
----------------------------------------------
        Create class: TreeUse
        ----------------------------------------------
public class TreeUse {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(4);
        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
        TreeNode<Integer> node4 = new TreeNode<Integer>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);

        System.out.println(root);
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
        System.out.println(node4);
    }
}
----------------------------------------
        Output:
        TreeNode@65ab7765
        TreeNode@1b28cdfa
        TreeNode@eed1f14
TreeNode@7229724f
        TreeNode@4c873330