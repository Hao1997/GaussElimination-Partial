 public class GaussRREF{



   public static void main (String[] args){
     double[][] n = {{1,3,4}, {4,2,1}, {1,4,2}};
     GaussRREF g = new GaussRREF(n);
     n = g.getMatrix();

     for (int i= 0 ; i<3;i++){
       System.out.println();
       String seperator = " ";
       for(int j=0 ; j<3; j++){

         System.out.print(seperator+ (int)(n[i][j]));
         seperator = ", ";
     }
   }System.out.println();
   }
  private double [][] matrix;

  public GaussRREF(double[][] matrix){
    int rowsize = matrix[0].length;
    boolean validMatrix = true;
    for (int rownumber = 1; rownumber<matrix.length; rownumber++) {
        if(matrix[rownumber].length != rowsize){
          System.out.println("invalid input");
          validMatrix = false;
        }
        }if(validMatrix){
          this.matrix = matrix;
    }
    RREF(matrix);


  }
  public double [][] getMatrix(){
    return matrix;
  }

  private void RREF(double[][] m){

      for(int col = 0 ; col < m[0].length; col++){
        for(int row = col; row< m.length;row++){
          //keep searching
          if(matrix[col][col] != 0 && col == row){
            double number = matrix[col][col];
            double scalar = 1;
            if(number<0) {
              scalar = -1 / number;
            }else if(number>0){
              scalar = 1 / number;
            }
            scaleRow(col, scalar);
            continue;
          }else if (matrix[col][col] != 0 && col != row) {
            double number = matrix[row][col];
            double scalarChange = 1;
            if(number == 0){
              continue;
            }else if(number<0) {
              scalarChange = -1 / number;
            }else if(number>0){
              scalarChange = -1 / number;
            }
            scaleRow(row, scalarChange);
            addRow(row, col);
          }else if(matrix[col][col] == 0 && matrix[row][col] == 0) {
            continue;
          }else if(matrix[row][col] != 0 && matrix[col][col] == 0){
            switchRow(row, col);
            continue;
          }
        }
      }
  }


  private void switchRow(int row1, int row2){
    double[] temp = matrix[row1];
    this.matrix[row1] = this.matrix[row2];
    this.matrix [row2] = temp;
  }

  private void scaleRow(int row, double scale){
    for(int i = 0; i< matrix[row].length; i++){
      matrix[row][i] = matrix[row][i]  * scale;
    }
  }

  private void addRow(int row1, int row2){
    for(int i = 0; i<matrix[row1].length; i++){
      matrix[row1][i] = matrix[row1][i] + matrix[row2][i];
    }
  }

}
