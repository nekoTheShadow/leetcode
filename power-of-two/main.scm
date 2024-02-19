(define (is-power-of-two n)
  (if (<= n 0)
    #f
    (if (= n 1)
      #t
      (and (= (modulo n 2) 0) (is-power-of-two (quotient n 2)))
    )
  )
)
