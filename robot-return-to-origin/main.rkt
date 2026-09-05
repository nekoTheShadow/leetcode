#lang racket

(define (judge-circle moves)
  (define-values (x y)
    (for/fold ([x 0]
               [y 0])
              ([move moves])
      (cond
        [[char=? move #\U] (values (+ x 1) y)]
        [[char=? move #\D] (values (- x 1) y)]
        [[char=? move #\R] (values x (+ y 1))]
        [[char=? move #\L] (values x (- y 1))])))

  (and (= x 0) (= y 0)))

(module+ main
  (judge-circle "UD"))

(module+ test
  (require rackunit)
  (check-true (judge-circle "UD"))
  (check-false (judge-circle "LL")))


; def judge_circle(moves) = moves.count("U")==moves.count("D")&&moves.count("R")==moves.count("L")