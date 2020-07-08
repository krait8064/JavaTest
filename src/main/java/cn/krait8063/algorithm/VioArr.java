package cn.krait8063.algorithm;

public class VioArr {


//    简要来说：
//
//    nums[0] <= nums[mid]（0 - mid不包含旋转）且nums[0] <= target <= nums[mid] 时 high 向前规约；
//
//    nums[mid] < nums[0]（0 - mid包含旋转），target <= nums[mid] < nums[0] 时向前规约（target 在旋转位置到 mid 之间）
//
//    nums[mid] < nums[0]，nums[mid] < nums[0] <= target 时向前规约（target 在 0 到旋转位置之间）
//
//    其他情况向后规约
//
//    也就是说nums[mid] < nums[0]，nums[0] > target，target > nums[mid] 三项均为真或者只有一项为真时向后规约。
//    public:
//    int search(vector<int>& nums, int target) {
//        int lo = 0, hi = nums.size() - 1;
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
//                lo = mid + 1;
//            else
//                hi = mid;
//        }
//        return lo == hi && nums[lo] == target ? lo : -1;
//    }

}
