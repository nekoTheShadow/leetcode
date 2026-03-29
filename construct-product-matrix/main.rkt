#lang racket

(define (construct-product-matrix grid)
  (define mat
    (for/vector ([row grid])
      (list->vector row)))
  (define h (vector-length mat))
  (define w (vector-length (vector-ref mat 0)))

  (define res
    (for/vector ([_i (in-range h)])
      (make-vector w)))

  (define prefix 1)
  (for ([i (in-range h)])
    (for ([j (in-range w)])
      (m-set res i j prefix)
      (set! prefix (modulo (* prefix (m-ref mat i j)) 12345))))

  (define suffix 1)
  (for ([i (in-range (- h 1) -1 -1)])
    (for ([j (in-range (- w 1) -1 -1)])
      (m-set res i j (modulo (* (m-ref res i j) suffix) 12345))
      (set! suffix (modulo (* suffix (m-ref mat i j)) 12345))))

  (for/list ([row res])
    (vector->list row)))

(define (m-ref mat i j)
  (vector-ref (vector-ref mat i) j))

(define (m-set mat i j v)
  (vector-set! (vector-ref mat i) j v))

(module+ main
  (require json)
  (define grid "[[1,2],[3,4]]")
  (writeln (construct-product-matrix (string->jsexpr grid))))

(module+ test
  (require json
           rackunit)
  (check-equal? (construct-product-matrix (string->jsexpr "[[1,2],[3,4]]"))
                (string->jsexpr "[[24,12],[8,6]]"))
  (check-equal? (construct-product-matrix (string->jsexpr " [[12345],[2],[1]]"))
                (string->jsexpr "[[2],[0],[0]]")))
