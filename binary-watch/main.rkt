(define (read-binary-watch turnedOn)
  (map fmt
    (filter valid 
      (map to-hm
        (pick '(1 2 4 8 -1 -2 -4 -8 -16 -32) turnedOn)
      )
    )
  )
)

(define (pick xs n)
  (cond [(= n 0) (list '())]
        [(null? xs) '()]
        [else (append (pick (cdr xs) n)
                      (map (lambda (ys) (cons (car xs) ys)) (pick (cdr xs) (- n 1)))
               )
        ]
  )
)

(define (fmt hm)
  (let ([h (car hm)] [m (cadr hm)])
    (format "~a:~a"
        (~r h #:min-width 1 #:pad-string "0")
        (~r m #:min-width 2 #:pad-string "0"))
  )
)

(define (valid hm)
  (let ([h (car hm)] [m (cadr hm)])
    (and (< h 12) (< m 60))
  )
)


(define (to-hm lst)
  (let loop ([xs lst] [h 0] [m 0])
    (if (null? xs)
      (list h (abs m))
      (let ([x (car xs)])
        (if (positive? x)
          (loop (cdr xs) (+ h x) m)
          (loop (cdr xs) h (+ m x))
        )
      )
    )
  )
)
