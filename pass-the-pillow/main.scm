(define (pass-the-pillow n time)
    (let loop ((cur_time 0) (cur_pillow 1) (dir 1))
        (if (= cur_time time)
            cur_pillow
            (let ((nxt_pillow (+ cur_pillow dir)))
                (if (and (< 0 nxt_pillow) (<= nxt_pillow n))
                    (loop (+ cur_time 1) nxt_pillow dir)
                    (loop cur_time cur_pillow (* -1 dir))
                )
            )
        )
    )
)