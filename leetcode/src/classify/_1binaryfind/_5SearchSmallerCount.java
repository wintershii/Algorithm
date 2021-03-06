package classify._1binaryfind;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _5SearchSmallerCount {

    public static void main(String[] args) {
        System.out.println(new _5SearchSmallerCount().countSmaller(new int[]{5,2,6,1}));
    }

    /**
     * 思路一 : 暴力解题 O(n^2)
     * 思路二 : 构建二插排序树并不断插入计算
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        BSTNode root = null;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            res.add(i,0);
        }

        for (int i = nums.length - 1; i >=0; --i) {
            root = insert(root,nums[i],res,i);
        }
        return res;
    }

    public BSTNode insert(BSTNode root, int val, List<Integer> res, int index) {
        if (root == null) {
            return new BSTNode(val);
        }
        if (val <= root.val) {
            root.count++;
            root.left = insert(root.left,val,res,index);
        } else {
            res.set(index, res.get(index) + root.count + 1);
            root.right = insert(root.right,val,res,index);
        }
        return root;
    }
}

class BSTNode {
    BSTNode left;
    BSTNode right;
    int val;
    int count;

    public BSTNode(int val) {
        this.val = val;
    }
}
