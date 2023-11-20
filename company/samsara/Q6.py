## use python to solve q6
## this method is introduced by chatgpt


def pop_game(bubbles, operations):
    rows = len(bubbles)
    cols = len(bubbles[0])

    # helper function to check if a position is valid
    def is_valid(r, c):
        return 0 <= r < rows and 0 <= c < cols

    def pop_bubbles(r, c):
        color = bubbles[r][c]
        bubbles[r][c] = 0 

        # check diangonal bubbles to pop
        dirs = [(-1,-1), (-1,1), (1,-1), (1,1)]
        for dr,dc in dirs:
            nr, nc = r + dr, c + dc
            while is_valid(nr, nc) and bubbles[nr][nc] == color:
                bubbles[nr][nc] = 0
                nr += dr
                nc += dc

    def drop_bubbles():
        # check each row from bottom to top
        for j in range(cols):
            empty_row = rows - 1
            for i in reversed(range(rows)):
                if bubbles[i][j] != 0:
                    bubbles[empty_row][j] = bubbles[i][j]
                    if empty_row != i:
                        bubbles[i][j] = 0
                    empty_row -= 1


    # process the operations
    for operation in operations:
        i,j = operation
        if bubbles[i][j] != 0:
            pop_bubbles(i,j)
            drop_bubbles()
    
    return bubbles



bubbles = [
    [1, 2, 3, 1, 2],
    [3, 1, 2, 3, 3],
    [2, 3, 1, 2, 1],
    [1, 1, 2, 3, 3],
    [2, 2, 3, 1, 2]
]


operations =[(1, 1), (2, 2), (3, 3), (4, 4)]


print(pop_game(bubbles, operations))

    

        