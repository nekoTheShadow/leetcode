def spiral_matrix(m, n, head)
    matrix = Array.new(m){Array.new(n, -1)}
    d = {
        [0, 1] => [1, 0],
        [1, 0] => [0, -1],
        [0, -1] => [-1, 0],
        [-1, 0] => [0, 1]
    }


    x = 0
    y = 0
    dx = 0
    dy = 1
    while head
        matrix[x][y] = head.val
        dx, dy = d[[dx, dy]] unless 0<=(x+dx)&&(x+dx)<m&&0<=(y+dy)&&(y+dy)<n&&matrix[x+dx][y+dy]==-1

        x += dx
        y += dy
        head = head.next
    end
    matrix
end
