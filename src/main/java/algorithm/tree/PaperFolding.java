package algorithm.tree;

/**
 * 二叉树折纸问题（微软面试题）
 * 将纸条向上对折N次，从上往下打印全部折痕的类型（凹/凸）
 */
public class PaperFolding {

    public static void printAllFolds(int N) {
        process(1, N, true);
        System.out.println();
    }

    /**
     * 通过递归中序打印整棵树
     * 核心逻辑：第N层折痕为：第N-1层的每个节点左右分别加一个“凹”，“凸”节点形成
     *
     * @param i    当前节点所在层
     * @param N    总共的层数
     * @param down true表示凹
     */
    private static void process(int i, int N, boolean down) {
        if (i > N) return;
        process(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 5;
        for (int i = 1; i < N; i++) {
            printAllFolds(i);
        }
    }

}