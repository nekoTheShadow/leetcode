#lang racket

(define (furthest-distance-from-origin moves)
  (max (dist (string-replace moves "_" "R")) (dist (string-replace moves "_" "L"))))

(define (dist moves)
  (abs (for/fold ([acc 0]) ([move moves])
         (if (equal? move #\L)
             (+ acc 1)
             (- acc 1)))))

; (define (furthest-distance-from-origin moves)
;   (define-values (d1 d2)
;     (for/fold ([d1 0]
;                [d2 0])
;               ([move moves])
;       (cond
;         [[equal? move #\L] (values (- d1 1) (- d2 1))]
;         [[equal? move #\R] (values (+ d1 1) (+ d2 1))]
;         [else (values (+ d1 1) (- d2 1))])))
;   (max (abs d1) (abs d2)))

(module+ test
  (require rackunit)
  (check-eq? (furthest-distance-from-origin "L_RL__R") 3)
  (check-eq? (furthest-distance-from-origin "_R__LL_") 5)
  (check-eq? (furthest-distance-from-origin "_______") 7))
