bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target) {
    int row = matrixSize - 1, col = 0;

    while (row >= 0 && col < *matrixColSize) {
        if (matrix[row][col] == target) {
            return true;
        }
        else if (matrix[row][col] > target) {
            row--;
        }
        else {
            col++;
        }
    }

    return false;
}