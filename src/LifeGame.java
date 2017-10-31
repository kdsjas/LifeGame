
public class LifeGame{
    private final int HEIGHT=15;//二维游戏世界的大小。HEIGHT*WIDTH 个字符  
    private final int WIDTH =60;  
    private char[][] world = new char[HEIGHT][WIDTH];  
    private final char Y ='*'; //用字符*代表一个细胞  
    private final char No = ' ';  
    /** 
     * 构造器。使用预定义的数据初始化world.  
     */  
    LifeGame(){  
        world[3][4] = world[3][5] = world[3][6] =Y;  
        //glider  
        world[10][4] =  world[10][5] =  world[10][6] =  world[11][6] =  world[12][5] = Y;  
    }  

    private void print(){
        for (int height = 0; height < HEIGHT; height++) {
            for (int width = 0;width < WIDTH; width++) {
                char c = ( world[height][width] == Y) ? Y: No ;
                System.out.print(c);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    private int cellState(int y,int x) {  
        boolean isEmpty = (y < 0 || y >= HEIGHT || x < 0 || x >= WIDTH || world[y][x] != Y ) ;  
        return isEmpty ? 0 : 1 ;  
    }  
      

    private int getNeighbors(int y,int x) {  
        int n = 0; //neighbor  
        n += cellState( y - 1, x - 1);  
        n += cellState( y - 1, x);  
        n += cellState( y - 1, x + 1);  
        n += cellState( y, x - 1);  
        n += cellState( y, x + 1);  
        n += cellState( y + 1, x - 1);  
        n += cellState( y + 1, x);  
        n += cellState( y + 1, x + 1);  
        return n;  
      
      
    }  

    public void nextWorld() {  
        char[][] temp = new char[HEIGHT][WIDTH];  
        int y=0;//坐标位置(x,y)  
        for (char[] rowArr : world){  
            int x=0;  
            for(char colData :rowArr ){  
                int neighbor = getNeighbors(y, x);//习惯(y, x)  
                if (neighbor==3) {  
                    temp[y][x] = Y;  
                }else if (neighbor == 2 && colData == Y){  
                    temp[y][x] = Y;  
                }else{  
                    temp[y][x] = No;   
                }  
                x++;  
            }  
            y++;  
        }  
        world = temp;  
    }
      
    /** 
     * 在BlueJ中，你可以创建一个simpleGOL对象，交替调用其print()、nextWorld()方法。 
     */  
    public static void main(String[] a){  
        LifeGame game = new LifeGame();
        String end;
        int generation = 0;
        game.print();
        java.util.Scanner in = new java.util.Scanner(System.in);
        do{
            System.out.printf("Generation %d\n", ++generation);
            game.nextWorld();
            game.print();
            System.out.printf("Press q to quit or other key to continue: ");
            end = in.next();
        }while(!"q".equals(end));
    }
}

