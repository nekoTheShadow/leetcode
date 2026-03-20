#lang racket

(define (count-submatrices grid k)
  (define mat
    (for/vector ([item grid])
      (list->vector item)))
  (define h (vector-length mat))
  (define w (vector-length (vector-ref mat 0)))

  (define s
    (for/vector ([_i (in-range (+ h 1))])
      (make-vector (+ w 1) 0)))

  ; s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
  (for* ([i (in-range h)]
         [j (in-range w)])
    (m-set! s
            (+ i 1)
            (+ j 1)
            (- (+ [m-ref s i (+ j 1)] [m-ref s (+ i 1) j] [m-ref mat i j]) [m-ref s i j])))

  (for*/sum ([i (in-range 1 (+ h 1))] [j (in-range 1 (+ w 1))]) (bool->int (<= (m-sum s 0 0 i j) k))))

(define (m-ref mat i j)
  (vector-ref (vector-ref mat i) j))

(define (m-set! mat i j v)
  (vector-set! (vector-ref mat i) j v))

;  s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1]
(define (m-sum mat x1 y1 x2 y2)
  [- [+ (m-ref mat x2 y2) (m-ref mat x1 y1)] [+ (m-ref mat x1 y2) (m-ref mat x2 y1)]])

(define (bool->int test)
  (if test 1 0))

(provide count-submatrices)
