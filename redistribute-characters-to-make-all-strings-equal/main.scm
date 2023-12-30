(define (make-equal words)
  (define n (length words))
  (define counter (make-hash))
  (for-each
    (lambda (word) 
      (string-for-each 
        (lambda (ch) (hash-set! counter ch (+ (hash-ref counter ch 0) 1)))
        word))
    words)
  (all? (lambda (v) (= (modulo v n) 0)) (hash-values counter)))

(define (string-for-each proc str)
  (define n (string-length str))
  (let loop ((i 0))
    (cond ((< i n) (proc (string-ref str i)) (loop (+ i 1))))))

(define (all? proc lst)
  (if (null? lst)
    #t
    (and (proc (car lst)) (all? proc (cdr lst)))))
