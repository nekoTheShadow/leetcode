(define (pivot-integer n)
  (let* ((x (/ (+ n (* n n)) 2))
         (y (floor (sqrt x))))
    (if (= x (* y y)) y -1)
  )
)