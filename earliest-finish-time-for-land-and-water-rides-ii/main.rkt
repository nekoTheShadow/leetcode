#lang racket

(define (earliest-finish-time landStartTime landDuration waterStartTime waterDuration)
  (define t1 (solve landStartTime landDuration waterStartTime waterDuration))
  (define t2 (solve waterStartTime waterDuration landStartTime landDuration))
  (min t1 t2))

(define (solve start1 duration1 start2 duration2)
  (define t1 1000000000)
  (for ([s start1]
        [d duration1])
    (set! t1 (min t1 (+ s d))))

  (define t2 1000000000)
  (for ([s start2]
        [d duration2])
    (if (<= s t1)
        (set! t2 (min t2 (+ t1 d)))
        (set! t2 (min t2 (+ s d)))))
  t2)

(module+ test
  (require json
           rackunit)
  (test-case "Example1"
    (define landStartTime (string->jsexpr "[2,8]"))
    (define landDuration (string->jsexpr "[4,1]"))
    (define waterStartTime (string->jsexpr "[6]"))
    (define waterDuration (string->jsexpr "[3]"))
    (define output 9)
    (check-equal? (earliest-finish-time landStartTime landDuration waterStartTime waterDuration)
                  output))
  (test-case "Example2"
    (define landStartTime (string->jsexpr "[5]"))
    (define landDuration (string->jsexpr "[3]"))
    (define waterStartTime (string->jsexpr "[1]"))
    (define waterDuration (string->jsexpr "[10]"))
    (define output 14)
    (check-equal? (earliest-finish-time landStartTime landDuration waterStartTime waterDuration)
                  output)))
