(define (is-trionic nums)
  (equal? '(-1 1 -1) (uniq (map cmp (sliding nums))))
)


(define (uniq lst)
  (uniq-sub (cdr lst) (list (car lst)))
)

(define (uniq-sub lst stack)
  (if (null? lst)
    stack
    (if (= (car stack) (car lst))
      (uniq-sub (cdr lst) stack)
      (uniq-sub (cdr lst) (cons (car lst) stack))
    )
  )
)

(define (sliding xs)
  (let ([x (car xs)] [ys (cdr xs)])
    (if (null? ys)
      '()
      (cons (list x (car ys)) (sliding ys))
    )
  )
)

(define (cmp tpl)
  (sgn (- (car tpl) (cadr tpl)))
)
