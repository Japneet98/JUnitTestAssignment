package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        if (inMatrix == null || inMatrix.length == 0)
            return null;


        int rows = inMatrix.length;
        int columns = 0;

        if (rows > 0) {
            columns = inMatrix[0].length;

            for (int i = 1; i < inMatrix.length; i++) {
                if (columns != inMatrix[i].length) {
                    return null;
                }
            }
        }

        int[][] expOutputMatrix = new int[rows][columns];

        int outputMatrixRowIndex = 0, outputMatrixColumnIndex = 0;
        int inMatrixRowIndex = 0, inMatrixColumnIndex = 0;

        while (outputMatrixRowIndex < rows && outputMatrixColumnIndex < columns) {

            for (int i = outputMatrixColumnIndex; i < columns; ++i) {
                expOutputMatrix[outputMatrixRowIndex][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }

            outputMatrixRowIndex++;
            for (int i = outputMatrixRowIndex; i < rows; ++i) {
                expOutputMatrix[i][columns - 1] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }
            columns--;

            if (outputMatrixRowIndex < rows) {
                for (int i = columns - 1; i >= outputMatrixColumnIndex; --i) {
                    expOutputMatrix[rows - 1][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                rows--;

            }

            if (outputMatrixColumnIndex < columns) {
                for (int i = rows - 1; i >= outputMatrixRowIndex; --i) {
                    expOutputMatrix[i][outputMatrixColumnIndex] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                outputMatrixColumnIndex++;

            }
        }

        return expOutputMatrix;
    }
}