#lang racket

(define (get-min-distance nums target start)
  (for/fold ([ret 1000000]) ([(num i) (in-indexed nums)])
    (if (= num target)
        (min ret (abs (- i start)))
        ret)))

(module+ test
  (require rackunit
           json)

  (test-case "example1"
    (define nums (string->jsexpr "[1,2,3,4,5]"))
    (define target 5)
    (define start 3)
    (define output 1)
    (check-equal? (get-min-distance nums target start) output))

  (test-case "example2"
    (define nums (string->jsexpr "[1]"))
    (define target 1)
    (define start 0)
    (define output 0)
    (check-equal? (get-min-distance nums target start) output))

  (test-case "example3"
    (define nums (string->jsexpr "[1,1,1,1,1,1,1,1,1,1]"))
    (define target 1)
    (define start 0)
    (define output 0)
    (check-equal? (get-min-distance nums target start) output)))
