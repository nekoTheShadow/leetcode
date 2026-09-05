#lang racket

(define (two-edit-words queries dictionary)
  (for/list ([w1 queries]
             #:when (for/or ([w2 dictionary])
                      (define count
                        (for/fold ([acc 0])
                                  ([c1 w1]
                                   [c2 w2])
                          (if (equal? c1 c2)
                              acc
                              (+ acc 1))))
                      (<= count 2)))
    w1))

(module+ test
  (require rackunit)
  (test-case "Example 1"
    (define queries '("word" "note" "ants" "wood"))
    (define dictionary '("wood" "joke" "moat"))
    (define output '("word" "note" "wood"))
    (check-equal? (two-edit-words queries dictionary) output))
  (test-case "Example 2"
    (define queries '("yes"))
    (define dictionary '("not"))
    (define output '())
    (check-equal? (two-edit-words queries dictionary) output)))
