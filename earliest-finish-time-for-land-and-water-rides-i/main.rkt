#lang racket

(define (earliest-finish-time landStartTime landDuration waterStartTime waterDuration)
  (define ret 1000000000)
  (for ([start1 landStartTime]
        [duration1 landDuration])
    (for ([start2 waterStartTime]
          [duration2 waterDuration])
      (define finish1 (get-finish start1 duration1 start2 duration2))
      (define finish2 (get-finish start2 duration2 start1 duration1))
      (set! ret (min ret finish1 finish2))))
  ret)

(define (get-finish start1 duration1 start2 duration2)
  (define end (+ start1 duration1))
  (if (<= start2 end)
      (+ end duration2)
      (+ start2 duration2)))

(module+ test
  (require rackunit
           json)
  (test-case "Example 1"
    (define landStartTime (string->jsexpr "[2,8]"))
    (define landDuration (string->jsexpr "[4,1]"))
    (define waterStartTime (string->jsexpr "[6]"))
    (define waterDuration (string->jsexpr "[3]"))
    (define output 9)
    (check-equal? (earliest-finish-time landStartTime landDuration waterStartTime waterDuration)
                  output))
  (test-case "Example 2"
    (define landStartTime (string->jsexpr "[5]"))
    (define landDuration (string->jsexpr "[3]"))
    (define waterStartTime (string->jsexpr "[1]"))
    (define waterDuration (string->jsexpr "[10]"))
    (define output 14)
    (check-equal? (earliest-finish-time landStartTime landDuration waterStartTime waterDuration)
                  output)))
