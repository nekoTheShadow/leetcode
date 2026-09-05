#lang racket

(define (min-operations grid x)
  (define vec (list->vector (sort (flatten grid) <)))
  (define q (vector-ref vec (quotient (vector-length vec) 2)))

  (if (for/and ([p vec])
        (= (modulo p x) (modulo q x)))
      (for/sum ([p vec]) (quotient (abs (- p q)) x))
      -1))

(module+ test
  (require rackunit
           json)
  (test-case "example1"
    (define grid "[[2,4],[6,8]]")
    (define x 2)
    (define output 4)
    (check-equal? (min-operations (string->jsexpr grid) x) output))
  (test-case "example2"
    (define grid "[[1,5],[2,3]]")
    (define x 1)
    (define output 5)
    (check-equal? (min-operations (string->jsexpr grid) x) output))
  (test-case "example3"
    (define grid "[[1,2],[3,4]]")
    (define x 2)
    (define output -1)
    (check-equal? (min-operations (string->jsexpr grid) x) output)))
