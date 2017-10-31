
public class LifeGame{
    private final int HEIGHT=15;//��ά��Ϸ����Ĵ�С��HEIGHT*WIDTH ���ַ�  
    private final int WIDTH =60;  
    private char[][] world = new char[HEIGHT][WIDTH];  
    private final char Y ='*'; //���ַ�*����һ��ϸ��  
    private final char No = ' ';  
    /** 
     * ��������ʹ��Ԥ��������ݳ�ʼ��world.  
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
        int y=0;//����λ��(x,y)  
        for (char[] rowArr : world){  
            int x=0;  
            for(char colData :rowArr ){  
                int neighbor = getNeighbors(y, x);//ϰ��(y, x)  
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
     * ��BlueJ�У�����Դ���һ��simpleGOL���󣬽��������print()��nextWorld()������ 
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

