package Basics.level2.class_object.method.lectures;

public class Method02 {
    public static void main(String[] args) {
        int[][] map = {{1,1,1}, {2,2,2}, {3,3,3}};
        myTools myTools = new myTools();
        myTools.printArr(map);
    }
}

class myTools {
    public void printArr(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}