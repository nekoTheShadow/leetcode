
class MountainArray
  def initialize(a)
    @a = a
  end

   def get(index)
    @a[index]
   end

   def length()
    @a.size
 end
end

# @param {int} int
# @param {MountainArray} mountain_arr
# @return {int}
def findInMountainArray(target, mountain_arr)
  n = mountain_arr.length
  x = (0..n-2).bsearch{|i| mountain_arr.get(i) > mountain_arr.get(i+1)} || n-1

  a = (0..x).bsearch{|i| mountain_arr.get(i) >= target}
  b = (x+1..n-1).bsearch{|i| mountain_arr.get(i) <= target}
  
  return a if !a.nil? && target==mountain_arr.get(a)
  return b if !b.nil? && target==mountain_arr.get(b)
  -1
end

p findInMountainArray(3, MountainArray.new([1,2,3,4,5,3,1]))
p findInMountainArray(3, MountainArray.new([0,1,2,4,2,1]))
p findInMountainArray(1, MountainArray.new([0,5,3,1]))
