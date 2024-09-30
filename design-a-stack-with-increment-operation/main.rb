class CustomStack

=begin
    :type max_size: Integer
=end
    def initialize(max_size)
        @stack = []
        @increment = []
        @max_size = max_size
    end


=begin
    :type x: Integer
    :rtype: Void
=end
    def push(x)
        return if @stack.size == @max_size
        @stack << x 
        @increment << 0
    end


=begin
    :rtype: Integer
=end
    def pop()
        return -1 if @stack.empty?

        @increment[-2] += @increment[-1] if @increment.size > 1
        @stack.pop + @increment.pop
    end


=begin
    :type k: Integer
    :type val: Integer
    :rtype: Void
=end
    def increment(k, val)
        k = [k, @stack.size].min
        return if k == 0
        @increment[k-1] += val
    end


end
