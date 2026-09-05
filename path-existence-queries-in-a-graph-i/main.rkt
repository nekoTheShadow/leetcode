#lang racket

; (-> exact-integer? (listof exact-integer?) exact-integer? (listof (listof exact-integer?)) (listof boolean?))
(define (path-existence-queries n nums maxDiff queries)
  (define vec (list->vector nums))

  (define grps (make-vector n 0))
  (define grp 0)
  (for ([i (in-range 1 n)])
    (when (> (- (vector-ref vec i) (vector-ref vec (- i 1)))
             maxDiff) ; nums[i] - nums[i - 1] > maxDiff
      (set! grp (+ grp 1)))
    (vector-set! grps i grp))

  (for/list ([query queries])
    (define u (list-ref query 0))
    (define v (list-ref query 1))
    (= (vector-ref grps u) (vector-ref grps v))))

(module+ test
  (require rackunit
           json)

  (test-case "example 1"
    (define n 2)
    (define nums (string->jsexpr "[1,3]"))
    (define max-diff 1)
    (define queries (string->jsexpr "[[0,0],[0,1]]"))
    (define output (string->jsexpr "[true,false]"))
    (check-equal? (path-existence-queries n nums max-diff queries) output))

  (test-case "example 2"
    (define n 4)
    (define nums (string->jsexpr "[2,5,6,8]"))
    (define max-diff 2)
    (define queries (string->jsexpr "[[0,1],[0,2],[1,3],[2,3]]"))
    (define output (string->jsexpr "[false,false,true,true]"))
    (check-equal? (path-existence-queries n nums max-diff queries) output)))
