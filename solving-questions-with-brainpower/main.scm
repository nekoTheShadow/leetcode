(define (most-points questions)
    (define N (length questions))
    (define DP (make-vector (+ N 1) 0))
    (define (f i Q)
        (cond ((< i N)
            '何もしない
            (vector-set! DP (+ i 1) (max (vector-ref DP (+ i 1)) (vector-ref DP i)))

            '問題を解く
            (let* ((point (car (car Q)))
                   (brainpower (cadr (car Q)))
                   (j (min N (+ i brainpower 1))))
                (vector-set! DP j (max (vector-ref DP j) (+ point (vector-ref DP i)))))
            (f (+ i 1) (cdr Q)))))

    (f 0 questions)
    (vector-ref DP N))

(define (main args)
    (print (most-points '[[3 2] [4 3] [4 4] [2 5]]))
    (print (most-points '[[1 1] [2 2] [3 3] [4 4] [5 5]]))
0)