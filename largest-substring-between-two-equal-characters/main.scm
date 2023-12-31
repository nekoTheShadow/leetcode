(define (max-length-between-equal-characters s)
  (define ht (make-hash))
  (let loop ((i 0) (ret -1))
    (if (= i (string-length s))
      ret
      (let ((ch (string-ref s i)))
        (if (hash-has-key? ht ch)
          (loop (+ i 1) (max ret (- i (hash-ref ht ch) 1)))
          (begin
            (hash-set! ht ch i)
            (loop (+ i 1) ret)))))))
