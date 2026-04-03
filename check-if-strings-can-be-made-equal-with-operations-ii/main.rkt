#lang racket

(define (check-strings s1 s2)
  (define vec1 (make-vector 26 0))
  (define vec2 (make-vector 26 0))

  (for ([(ch i) (in-indexed s1)])
    (define x (- (char->integer ch) (char->integer #\a)))
    (if (even? i)
        (vector-set! vec1 x (+ (vector-ref vec1 x) 1))
        (vector-set! vec2 x (+ (vector-ref vec2 x) 1))))

  (for ([(ch i) (in-indexed s2)])
    (define x (- (char->integer ch) (char->integer #\a)))
    (if (even? i)
        (vector-set! vec1 x (- (vector-ref vec1 x) 1))
        (vector-set! vec2 x (- (vector-ref vec2 x) 1))))

  (and (for/and ([v vec1])
         (= 0 v))
       (for/and ([v vec2])
         (= 0 v))))

(module+ main
  (define s1 "abcdba")
  (define s2 "cabdab")
  (writeln (check-strings s1 s2)))

(module+ test
  (require rackunit)
  (test-case "Example 1:"
    (define s1 "abcdba")
    (define s2 "cabdab")
    (check-true (check-strings s1 s2)))
  (test-case "Example 2:"
    (define s1 "abe")
    (define s2 "bea")
    (check-false (check-strings s1 s2))))
