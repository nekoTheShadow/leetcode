# @param {Integer[]} nums
# @return {Integer}
def min_operations(nums)
  n = nums.size

  # 配列全体の最大公約数が1でない場合は不可能
  return -1 if nums.reduce(:gcd) != 1
  
  # 1が含まれている場合は、残りを1にするだけ
  c1 = nums.count(1)
  return n - c1 if c1 > 0
  
  # 最大公約数が1になる最小区間の長さがkとする
  # 区間から1を作るのに(k - 1)回、残りを1にするのに(n - 1)回の操作が必要になる
  k = 2
  k += 1 until nums.each_cons(k).any?{|sub| sub.reduce(:gcd) == 1}
  (k - 1) + (n - 1)
end