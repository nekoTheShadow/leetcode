(define (add-digits num)
  (let ((sum (sum-digits num)))
    (if (< sum 10)
      sum
      (add-digits sum))))

(define (sum-digits num)
  (if (= num 0)
    num
    (+ (sum-digits (quotient num 10)) (modulo num 10))))

(define (main args)
    (print (add-digits 38))
    (print (add-digits 0))
0)

