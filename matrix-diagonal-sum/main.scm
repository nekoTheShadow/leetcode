(define (diagonal-sum mat)
  (define n (length mat))

  (define (sum lst x p q)
    (cond ((null? lst) 0)
          ((= x p) (+ (car lst) (sum (cdr lst) (+ x 1) p q)))
          ((= x q) (+ (car lst) (sum (cdr lst) (+ x 1) p q)))
          (else (sum (cdr lst) (+ x 1) p q))
    )
  )

  (define (solve mat p q)
    (if (null? mat) 
      0
      (+ (sum (car mat) 0 p q) (solve (cdr mat) (+ p 1) (- q 1)))
    )
  )

  (solve mat 0 (- n 1))
)

(define (main args)
  (print (diagonal-sum '[[1 2 3]  [4 5 6]  [7 8 9]]))
  (print (diagonal-sum '[[1 1 1 1] [1 1 1 1] [1 1 1 1] [1 1 1 1]]))
  (print (diagonal-sum '[[5]]))
0)