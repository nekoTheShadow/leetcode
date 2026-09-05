#lang racket

(define (number-of-special-chars word)
  (define lst-lo (make-hash)) ; 最後の小文字
  (define fst-up (make-hash)) ; 最初の大文字
  (for ([(ch i) (in-indexed word)])
    (if (char-lower-case? ch)
        (hash-set! lst-lo ch i)
        (unless (hash-has-key? fst-up ch)
          (hash-set! fst-up ch i))))

  (define tot 0)
  (for ([(lo i) (in-hash lst-lo)])
    (define up (char-upcase lo))
    (when (hash-has-key? fst-up up)
      (define j (hash-ref fst-up up))
      (when (< i j)
        (set! tot (+ tot 1)))))
  tot)

(module+ test
  (require rackunit)
  (check-equal? (number-of-special-chars "aaAbcBC") 3)
  (check-equal? (number-of-special-chars "abc") 0)
  (check-equal? (number-of-special-chars "AbBCab") 0))
