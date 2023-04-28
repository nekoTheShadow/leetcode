(define (make-parents n)
  (let loop ((i 0) (parents (make-vector n)))
    (cond 
      ((= i n) parents)
      (else
        (vector-set! parents i i)
        (loop (+ i 1) parents)))))

(define (find parents i)
  (cond 
    ((= i (vector-ref parents i)) i)
    (else
      (vector-set! parents i (find parents (vector-ref parents i)))
      (vector-ref parents i))))

(define (union parents x y)
  (set! x (find parents x))
  (set! y (find parents y))
  (cond ((not (= x y)) (vector-set! parents x y))))


(define (same-group? s1 s2)
  (let loop ((c1 (string->list s1)) (c2 (string->list s2)) (n 0))
    (if (null? c1)
      (<= n 2)
      (if (equal? (car c1) (car c2))
        (loop (cdr c1) (cdr c2) n)
        (loop (cdr c1) (cdr c2) (+ n 1))))))

(define (num-similar-groups strs)
  (define n (length strs))
  (define parents (make-parents n))
  (define counter (make-vector n #f))
  
  (let loop ((s strs) (i 0))
    (cond ((< i n)
      (for-each-with-index
        (lambda (c2 j) (cond ((same-group? (car s) c2) (union parents i j))))
        (cdr s)
        (+ i 1))
      (loop (cdr s) (+ i 1)))))

  (let loop ((i 0))
    (if (= i n)
      (vector-count counter)
      (let ((x (find parents i)))
        (vector-set! counter x #t)
        (loop (+ i 1))))))

(define (for-each-with-index proc lst start)
  (cond ((not (null? lst))
    (proc (car lst) start)
    (for-each-with-index proc (cdr lst) (+ start 1)))))

(define (vector-count v)
  (let loop ((i 0) (c 0))
    (if (= i (vector-length v))
      c
      (if (vector-ref v i) 
        (loop (+ i 1) (+ c 1)) 
        (loop (+ i 1) c)))))


(define (main args)
  (print (num-similar-groups '("tars" "rats" "arts" "star")))
  (print (num-similar-groups '("omv" "ovm")))
0)
