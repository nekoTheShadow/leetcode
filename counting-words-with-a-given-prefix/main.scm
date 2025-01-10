(define (prefix-count words pref)
    (if (null? words)
        0
        (let ((word (car words)))
            (if (string-prefix? word pref)
                (+ 1 (prefix-count (cdr words) pref))
                (prefix-count (cdr words) pref)))))
