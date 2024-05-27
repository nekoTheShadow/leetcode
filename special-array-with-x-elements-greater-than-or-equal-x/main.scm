(define (special-array nums)
  (let loop ((x 1))
    (if (= x 2000)
      -1
      (if (= x (count (lambda (v) (<= x v)) nums))
        x
        (loop (+ x 1))
      )
    )
  )
)
