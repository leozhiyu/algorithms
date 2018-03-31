/**
 * @author:Leo
 * @create 2018/3/31
 * @desc
 * QuickUnion 算法
 * 通过树的结构，保存分量所在的树
 * 时间复杂度需要根据情况
 * 最差的情况是把一棵树弄成一条直线
 * 最好的情况是两棵树比较均匀
 */
package fundamentals.unionfind;

public class QuickUnion {
    // 分量结点
    private int[] id;
    // 连通分量的个数
    public int count;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        this.count = N;
    }

    /**
     * 获得连通分量的个数
     * @return
     */
    int count() {
        return count;
    }

    /**
     * 判断两个分量是否在同一个连通分量
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 寻找分量所在的连通分量
     * @param p
     * @return
     */
    int find(int p) {
        // 当分量值与连通分量值相同，说明是根节点
        // 如果不是根节点，需要沿着树依次往上找到根节点，根节点所在分量就是 p 所在的连通分量
        while (p != id[p]) {
            p = id[p]; // id[p] 得到的值实际上就是父节点分量，这样可以依次找到根节点
        }
        return p;
    }

    /**
     * 将两个连通分量合并，只需要将根节点挂到另一棵树上即可
     * @param p
     * @param q
     */
    void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        // 一次访问数组实现分量的合并
        id[pID] = qID;
        count--;
    }

    public static void main(String[] args) {
        int[][] arr = {{4,3},{3,8},{6,5},{9,4},{2,1},{5,0},{7,2},{6,1}};
        QuickUnion quickUnion = new QuickUnion(10);
        for (int i = 0; i < arr.length; i++) {
            int p = arr[i][0];
            int q = arr[i][1];
            if (quickUnion.find(p) != quickUnion.find(q)) {
                quickUnion.union(p,q);
            }
            System.out.println(p + " : " + q);
        }
        System.out.println(quickUnion.count + " components");
    }

}
