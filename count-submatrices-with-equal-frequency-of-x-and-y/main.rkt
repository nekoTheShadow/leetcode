#lang racket

(define (number-of-submatrices grid)
  (define mat
    (for/vector ([item grid])
      (list->vector item)))
  (define h (vector-length mat))
  (define w (vector-length (vector-ref mat 0)))

  (define x-mat
    (for/vector ([_i (in-range (+ h 1))])
      (make-vector (+ w 1) 0)))
  (define y-mat
    (for/vector ([_i (in-range (+ h 1))])
      (make-vector (+ w 1) 0)))

  ; s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
  (for* ([i (in-range h)]
         [j (in-range w)])
    (define x-val (bool->int (equal? (m-ref mat i j) #\X)))
    (define y-val (bool->int (equal? (m-ref mat i j) #\Y)))

    (m-set! x-mat
            (+ i 1)
            (+ j 1)
            (- (+ [m-ref x-mat i (+ j 1)] [m-ref x-mat (+ i 1) j] x-val) [m-ref x-mat i j]))
    (m-set! y-mat
            (+ i 1)
            (+ j 1)
            (- (+ [m-ref y-mat i (+ j 1)] [m-ref y-mat (+ i 1) j] y-val) [m-ref y-mat i j])))

  (for*/sum ([i (in-range 1 (+ h 1))] [j (in-range 1 (+ w 1))])
            (define x-count (m-sum x-mat 0 0 i j))
            (define y-count (m-sum y-mat 0 0 i j))
            (bool->int (and (> x-count 0) (= x-count y-count)))))

(define (m-ref mat i j)
  (vector-ref (vector-ref mat i) j))

(define (m-set! mat i j v)
  (vector-set! (vector-ref mat i) j v))

;  s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1]
(define (m-sum mat x1 y1 x2 y2)
  [- [+ (m-ref mat x2 y2) (m-ref mat x1 y1)] [+ (m-ref mat x1 y2) (m-ref mat x2 y1)]])

(define (bool->int test)
  (if test 1 0))

(provide number-of-submatrices)

