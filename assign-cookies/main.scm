(define (find-content-children g s)
  (let loop ((G (sort g <))
             (S (sort s <))
             (c 0))
    (if (or (null? G) (null? S))
      c
      (if (<= (car G) (car S))
        (loop (cdr G) (cdr S) (+ c 1))
        (loop G (cdr S) c)))))
