(define (minimum-abs-difference arr)
  (let loop ([vals (sort arr >)] [min-tpls '()] [min-abs 1000000])
    (let ([tpl (fetch-tpl vals)])
      (if (null? tpl)
        min-tpls
        (let ([cur-abs (abs (apply - tpl))])
          (cond 
            [(< cur-abs min-abs) (loop (cdr vals) (list tpl)          cur-abs)]
            [(= cur-abs min-abs) (loop (cdr vals) (cons tpl min-tpls) min-abs)]
            [else                (loop (cdr vals) min-tpls            min-abs)]
          )
        )
      )
    )
  )
)

(define (fetch-tpl vals)
  (cond
    [(null? vals)       '()]
    [(null? (cdr vals)) '()]
    [else               (list (second vals) (first vals))]
  )
)
