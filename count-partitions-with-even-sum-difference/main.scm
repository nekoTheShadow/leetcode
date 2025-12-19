(define (count-partitions nums)
  (if (= (modulo (foldl + 0 nums) 2) 0)
    (- (length nums) 1)
    0
  )
)
