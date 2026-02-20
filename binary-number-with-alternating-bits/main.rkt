(define (has-alternating-bits n)
  (check n -1)
)


(define (check n pre)
  (if (= n 0)
    #t
    (let ([cur (remainder n 2)])
      (if (= cur pre)
        #f
        (check (quotient n 2) cur)
      )
    )
  )
)
