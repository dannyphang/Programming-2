import java.util.*;

public class QualificationRound {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Number of Matrix: ");
        int loopNum = in.nextInt();
        int row;
        int column;
        int[][] matrixArray;
        int[][] output = new int[loopNum][3];
        int trace, rowRepeat, columnRepeat, count, count2;

        for(int i = 0; i < loopNum; i++){
            System.out.print("Row: ");
            row = in.nextInt();
            column = row;
            matrixArray = new int[row][column];
            
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    matrixArray[j][k] = in.nextInt();
                }
            }

            trace = 0;
            for(int j = 0; j < row; j++){
                trace += matrixArray[j][j];
            }

            count = 0;
            rowRepeat = 0;
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    for(int l = k + 1; l < row; l++){
                        if(matrixArray[j][k] == matrixArray[j][l]){
                            count += 1;
                        }
                    }
                }
                if(count >= 1){
                    rowRepeat++;
                }
            }

            columnRepeat = 0;
            count2 = 0;
            for(int j = 0; j < row; j++){
                for(int k = 0; k < column; k++){
                    for(int l = k + 1; l < column; l++){
                        if(matrixArray[k][j] == matrixArray[l][j]){
                            count2 += 1;
                            break;
                        }
                    }
                }
                if(count2 >= 1){
                    columnRepeat++;
                }
            }
            
            output[i][0] = trace;
            output[i][1] = rowRepeat;
            output[i][2] = columnRepeat;
        }

        for(int i = 0; i < loopNum; i++){
            System.out.println("Case #" + (i+1) + ": " + output[i][0] + " " + output[i][1] + " " + output[i][2]);
        }
        in.close();
    }
}
