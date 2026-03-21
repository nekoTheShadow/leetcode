#lang racket

(require "./main.rkt"
         rackunit
         json)

(let ([grid "[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]"]
      [x 1]
      [y 0]
      [k 3]
      [expected "[[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]"])
  (check-equal? (reverse-submatrix (string->jsexpr grid) x y k) (string->jsexpr expected)))

(let ([grid "[[3,4,2,3],[2,3,4,2]]"]
      [x 0]
      [y 2]
      [k 2]
      [expected "[[3,4,4,2],[2,3,2,3]]"])
  (check-equal? (reverse-submatrix (string->jsexpr grid) x y k) (string->jsexpr expected)))
