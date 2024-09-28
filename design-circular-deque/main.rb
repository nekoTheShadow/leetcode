class MyCircularDeque

=begin
    :type k: Integer
=end
    def initialize(k)
        @k = k
        @count = 0
        @array = Array.new(k)
        @head = k-1
        @tail = 0 
    end


=begin
    :type value: Integer
    :rtype: Boolean
=end
    def insert_front(value)
        return false if self.is_full
        @array[@head] = value
        @head = (@head-1)%@k
        @count += 1
        true
    end


=begin
    :type value: Integer
    :rtype: Boolean
=end
    def insert_last(value)
        return false if self.is_full
        
        @array[@tail] = value
        @tail = (@tail+1)%@k
        @count += 1
        true
    end


=begin
    :rtype: Boolean
=end
    def delete_front()
        return false if self.is_empty
        @head = (@head+1)%@k
        @count -= 1
        true
    end


=begin
    :rtype: Boolean
=end
    def delete_last()
        return false if self.is_empty
        @tail = (@tail-1)%@k
        @count -= 1
        true
    end


=begin
    :rtype: Integer
=end
    def get_front()
        return -1 if self.is_empty
        @array[(@head+1)%@k]
    end


=begin
    :rtype: Integer
=end
    def get_rear()
        return -1 if self.is_empty
        @array[(@tail-1)%@k]
    end


=begin
    :rtype: Boolean
=end
    def is_empty()
        @count == 0
    end


=begin
    :rtype: Boolean
=end
    def is_full()
        @count == @k
    end


end

# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque.new(k)
# param_1 = obj.insert_front(value)
# param_2 = obj.insert_last(value)
# param_3 = obj.delete_front()
# param_4 = obj.delete_last()
# param_5 = obj.get_front()
# param_6 = obj.get_rear()
# param_7 = obj.is_empty()
# param_8 = obj.is_full()
