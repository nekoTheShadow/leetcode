class Trie
    def initialize()
        @root = Node.new(-1)
    end

    def add(n)
        node = @root
        n.digits.reverse.each do |x|
            node.children[x] = Node.new(x) unless node.children.key?(x)
            node = node.children[x]
        end
    end

    def search(n)
        node = @root
        count = 0
        n.digits.reverse.each do |x|
            return count unless node.children.key?(x)
            node = node.children[x]
            count += 1
        end
        count
    end
end

class Node
    def initialize(val)
        @val = val
        @children = {}
    end
    attr_reader :val, :children
end

# @param {Integer[]} arr1
# @param {Integer[]} arr2
# @return {Integer}
def longest_common_prefix(arr1, arr2)
    trie = Trie.new
    arr1.each{|n| trie.add(n)}
    arr2.map{|n| trie.search(n)}.max
end

p longest_common_prefix([1,10,100], [1000])
p longest_common_prefix([1,2,3], [4,4,4])
