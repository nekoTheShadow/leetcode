#lang racket

(struct tree-node (val left right) #:mutable #:transparent)

(define (make-tree-node [val 0])
  (tree-node val #f #f))

(define (create-tree vals)
  (define xs (list->vector vals))
  (define n (vector-length xs))
  (define (build-tree i)
    (if (< i n)
        (tree-node (vector-ref xs i) (build-tree (+ (* 2 i) 1)) (build-tree (+ (* 2 i) 2)))
        #f))
  (build-tree 0))

; ----

(define (sum-root-to-leaf root)
  (dfs root 0))

(define (dfs node x)
  (if node
      (let ([y (+ (* 2 x) (tree-node-val node))])
        (if (is-leaf node)
            y
            (+ (dfs (tree-node-left node) y) (dfs (tree-node-right node) y))))
      0))

(define (is-leaf node)
  [and (not (tree-node-left node)) (not (tree-node-right node))])

; ----

(provide sum-root-to-leaf
         create-tree)

(module+ main
  (println (create-tree '(1 0 1 0 1 0 1))))
