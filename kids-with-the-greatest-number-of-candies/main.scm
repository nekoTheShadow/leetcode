(define (kids-with-candies candies extraCandies)
  (let ((top (apply max candies)))
    (map (lambda (v) (<= top (+ v extraCandies)))
         candies
    )
  )
)


(define (main args)
  (print (kids-with-candies '(2 3 5 1 3) 3))
  (print (kids-with-candies '(4 2 1 1 2) 1))
  (print (kids-with-candies '(12 1 12) 10))
0)