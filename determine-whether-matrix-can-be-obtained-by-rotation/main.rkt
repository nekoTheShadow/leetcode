#lang racket

(define (find-rotation mat target)
  (call/ec (lambda (return)
             (for ([i (in-range 4)])
               (when (equal? (rotate-clockwise mat i) target)
                 (return #t)))
             #f)))

(define (rotate-clockwise matrix count)
  (for/fold ([acc matrix]) ([_i (in-range count)])
    (define h (length acc))
    (define w (length (list-ref acc 0)))
    (for/list ([j (in-range w)])
      (for/list ([i (in-range h)])
        (list-ref (list-ref acc (- h i 1)) j)))))

(module+ test
  (require rackunit
           json)

  (test-case "Example 1"
    (define mat "[[0,1],[1,0]]")
    (define target "[[1,0],[0,1]]")
    (check-true (find-rotation (string->jsexpr mat) (string->jsexpr target))))

  (test-case "Example 2"
    (define mat "[[0,1],[1,1]]")
    (define target "[[1,0],[0,1]]")
    (check-false (find-rotation (string->jsexpr mat) (string->jsexpr target))))

  (test-case "Example 3"
    (define mat "[[0,0,0],[0,1,0],[1,1,1]]")
    (define target "[[1,1,1],[0,1,0],[0,0,0]]")
    (check-true (find-rotation (string->jsexpr mat) (string->jsexpr target)))))
