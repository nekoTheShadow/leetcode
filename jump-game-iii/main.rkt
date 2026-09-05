#lang racket

(define (can-reach arr start)
  (define vec (list->vector arr))
  (define n (vector-length vec))

  (define visited (make-vector n #f))
  (vector-set! visited start #t)

  (define (dfs i)
    (define j1 (+ i (vector-ref vec i)))
    (define j2 (- i (vector-ref vec i)))
    (let/ec return
      (when (= (vector-ref vec i) 0)
        (return #t))

      (when (and (<= 0 j1) (< j1 n) (not (vector-ref visited j1)))
        (vector-set! visited j1 #t)
        (when (dfs j1)
          (return #t)))
      (when (and (<= 0 j2) (< j2 n) (not (vector-ref visited j2)))
        (vector-set! visited j2 #t)
        (when (dfs j2)
          (return #t)))

      (return #f)))

  (dfs start))

(module+ test
  (require rackunit
           json)
  (check-equal? (can-reach (string->jsexpr "[4,2,3,0,3,1,2]") 5) #t)
  (check-equal? (can-reach (string->jsexpr "[4,2,3,0,3,1,2]") 0) #t)
  (check-equal? (can-reach (string->jsexpr "[3,0,2,1,2]") 2) #f)
  
  (check-equal? (can-reach (string->jsexpr "[58,48,64,36,19,19,67,13,32,2,59,50,29,68,50,0,69,31,54,20,22,43,30,9,68,71,20,22,48,74,2,65,27,54,30,5,66,24,64,68,9,31,50,59,15,72,6,49,11,71,12,61,5,66,30,1,2,39,59,35,53,21,76,17,71,40,68,57,64,53,70,21,50,49,25,63,35]") 46) #f)
  )
