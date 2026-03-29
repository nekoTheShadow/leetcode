#lang racket

(define (can-be-equal s1 s2)
  (define vec1
    (for/vector ([ch (in-string s1)])
      ch))
  (define vec2
    (for/vector ([ch (in-string s2)])
      ch))

  (swap vec1 0 2)
  (swap vec1 1 3)
  (swap vec2 0 2)
  (swap vec2 1 3)

  (equal? vec1 vec2))

(define (swap vec i j)
  (when (char-ci>? (vector-ref vec i) (vector-ref vec j))
    (vector-set*! vec i (vector-ref vec j) j (vector-ref vec i))))

(module+ test
  (require rackunit)

  (test-case "Example 1"
    (define s1 "abcd")
    (define s2 "cdab")
    (check-true (can-be-equal s1 s2)))

  (test-case "Example 2"
    (define s1 "abcd")
    (define s2 "dacb")
    (check-false (can-be-equal s1 s2))))
