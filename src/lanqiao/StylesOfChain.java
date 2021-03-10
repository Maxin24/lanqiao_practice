package lanqiao;

public class StylesOfChain {
    private static int[] colors={0,3,4,5};
    private static final int ALL=12;

    private static int res=0;

    private static void dfs(int pos){
        if(pos==ALL){
            res++;
            return;
        }

        for(int i=1;i<=3;i++){
            if(colors[i]>0){
                colors[i]--;
                dfs(pos+1);
                colors[i]++;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0);
        /**
         * dfs求出了所有线性的排列
         *
         * 串是一个首尾相接的数据结构
         * 把串的任意位置（共12个）拆开 可以得到一种线性的排列
         * 反之 线性排列/12=串的数量
         *
         * 正向排列得到的串==逆向排列得到的串
         * eg：aaabbbbccccc=cccccbbbbaaa
         * 但是它们被计算了两次 所以结果/2
         *
         * /2之前注意到 有的串是对称的 可以任意反转
         * 显然对称的串从两个方向出发都是相同的 这种排列不能/2
         *
         * 找出对称的串的数量 先选1、3号珠珠各一个 分别在12点、6点方向 使珠珠的个数都是偶数 才有可能对称
         * 这时12点、六点方向两侧都是对称的 只要求出一侧的数量 就能确定另一侧
         * 一侧的数量：一共12/2-1共五个位置 需要1号珠珠2/1=1个 2号4/2=2个 3号4/2=2个
         * 先选2号 即C5 2 再选3号 C 3 2 最后1号就一个位置不用选
         * 所以最后的结果是res/12-30，这些顺向逆向重复了 再/2  除完把对称的30个加上
         * 即res=（res/12-30）/2+30
         */
        System.out.println((res/12-30)/2+30);
    }
}
