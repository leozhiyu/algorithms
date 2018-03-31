/**
 * @author:Leo
 * @create 2018/3/30
 * @desc
 * QuickFind 算法
 * 特点是 find 只需要访问一次数组
 * 但是 union 需要每次遍历数组
 * 时间复杂度是 O(N^2)
 */
package fundamentals.unionfind;

public class QuickFind {
    /**
     * 分量id(以触点作为索引)，对应数组的值保存的是所在的连通分量
     */
    private int[] id;

    /**
     * 连通分量的数量
     */
    private int count;

    /**
     * 构造分量，初始化为数组下标
     * @param N
     */
    public QuickFind(int N){
        id = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * 判断两个分量是否属于同一个连通分量
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 获取连通分量的个数
     * @return
     */
    int count() {
        return count;
    }

    /**
     * 查找 p 对应的连通分量
     * 直接返回该分量对应的值即可
     * @param p
     * @return
     */
    int find(int p) {
        return id[p];
    }

    /**
     * 将 p 和 q 连通起来
     * 将所有与 p 所在相同连通分量的分量，都改为与 q 相同的连通分量
     * 需要每次遍历数组所有元素
     *
     * @param p
     * @param q
     */
    void union(int p, int q) {
        // 获得 p 所在的连通分量，用来寻找所有与 p 在同一个连通分量的分量
        int pID = id[p];
        int qID = id[q];
        // 如果 p 和 q已经在相同的分量中则不需要采取行动
        if (pID == qID) {
            return;
        }
        // 将 p 的分量重命名为 q 的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        int[][] arr = {{4,3},{3,8},{6,5},{9,4},{2,1},{5,0},{7,2},{6,1}};
        QuickFind quickFind = new QuickFind(10);
        for (int i = 0; i < arr.length; i++) {
            int p = arr[i][0];
            int q = arr[i][1];
            if (quickFind.find(p) != quickFind.find(q)) {
                quickFind.union(p,q);
            }
            System.out.println(p + " : " + q);
        }
        System.out.println(quickFind.count + " components");
    }

}
