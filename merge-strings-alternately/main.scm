
(define (merge-alternately word1 word2)
  (list->string (merge (string->list word1) (string->list word2))))

(define (merge lst1 lst2)
  (cond
    ((null? lst1) lst2)
    ((null? lst2) lst1)
    (else (cons (car lst1) (cons (car lst2) (merge (cdr lst1) (cdr lst2)))))))

(define (main args)
  (print (merge-alternately "abc" "pqr"))
  (print (merge-alternately "ab" "pqrs"))
0)