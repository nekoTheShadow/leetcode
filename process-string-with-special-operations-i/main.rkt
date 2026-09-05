#lang racket

(define (string-pop result)
  (define n (string-length result))
  (if (= n 0)
      result
      (substring result 0 (- n 1))))

(define (string-reverse result)
  (list->string (reverse (string->list result))))

(define (process-str s)
  (for/fold ([result ""]) ([ch s])
    (cond
      [[equal? ch #\*] (string-pop result)]
      [[equal? ch #\#] (string-append result result)]
      [[equal? ch #\%] (string-reverse result)]
      [else (string-append result (string ch))])))

(module+ test
  (require rackunit)
  (check-equal? (process-str "a#b%*") "ba")
  (check-equal? (process-str "z*#") ""))
