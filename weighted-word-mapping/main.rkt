#lang racket

(define (map-word-weights words weights)
  (define ht
    (for/hash ([(w i) (in-indexed weights)])
      (define ch (integer->char (+ (char->integer #\a) i)))
      (values ch w)))
  (define (calc word)
    (define tot (for/sum ([ch word]) (hash-ref ht ch)))
    (integer->char (+ (char->integer #\a) (- 25 (modulo tot 26)))))

  (list->string (map calc words)))

(module+ main
  (require json)
  (define words (list "abcd" "def" "xyz"))
  (define weights (string->jsexpr "[5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2]"))
  (map-word-weights words weights))

(module+ test
  (require json
           rackunit)
  (test-case "Example 1"
    (define words (list "abcd" "def" "xyz"))
    (define weights (string->jsexpr "[5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2]"))
    (define output "rij")
    (check-equal? (map-word-weights words weights) output))
  (test-case "Example 2"
    (define words (list "a" "b" "c"))
    (define weights (string->jsexpr "[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]"))
    (define output "yyy")
    (check-equal? (map-word-weights words weights) output))
  (test-case "Example 3"
    (define words (list "abcd"))
    (define weights (string->jsexpr "[7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5]"))
    (define output "g")
    (check-equal? (map-word-weights words weights) output)))
