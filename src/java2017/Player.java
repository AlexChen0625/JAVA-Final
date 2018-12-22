package java2017;

import java.awt.Graphics;

 
public class Player extends Thread implements GameConfig{  
    //角色在畫面中心
    static int px = panelX/2;  
    static int py = panelY/2;  
    //角色在地圖中位置 
    static int x = 75;  
    static int y = 75; 
    //角色移動量
    static int mx = 2000;  
    static int my = 2000;  
    //角色的步長  
    static int step = 7;  
    //角色是否移動
    
     
    static boolean up = false;  
    static boolean down = false;  
    static boolean left = false;  
    static boolean right = false;  
    //角色的朝向 (1234代表上下左右)
    static int towards = 2;  
    //腳色移動累積量(控制角色動作循環)  
    static int up1 = 0;  
    static int down1 = 0;  
    static int left1 = 0;  
    static int right1 = 0;  
    public static void reset() {
    	up=false;
    	down=false;
    	left=false;
    	right=false;
    	
    }
    public static void resetAll() {
    	mx = 2000;  
        my = 2000;
        up = false;  
        down = false;  
        left = false;  
        right = false; 
        towards = 2;
        up1 = 0;  
        down1 = 0;  
        left1 = 0;  
        right1 = 0; 
    }
    @Override  
    public void run() {  
        while(true){  
            moveUD();  
            moveLR();  
            try {  
                Thread.sleep(20);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
    /** 
     * 角色上下移動
     */  
    public void moveUD(){  
        if(up){  
            //案上 up+1 up=20設回0
            up1++;  
            if(up1>=20){  
                up1=0;  
            }  
            //角色上方有東西(素材值不為0) 不能動
            if(ReadMapFile.map2[y/elesize-1][x/elesize]!=0){  
                int y1 = (y/elesize-1)*elesize+elesize/2;  
                int x1 = (x/elesize)*elesize+elesize/2;  
                if((y-y1)*(y-y1)>elesize*elesize){  
                    y=y-step;  
                    my=my-step;  
                }  
            }else if(ReadMapFile.map2[y/elesize-1][x/elesize]==0){//上方沒東西 繼續移動
                y=y-step;  
                my=my-step;  
            }  
        }else if(down){  
            down1++;  
            if(down1>=20){  
                down1=0;  
            }  
            if(ReadMapFile.map2[y/elesize+1][x/elesize]!=0){  
                int y1 = (y/elesize+1)*elesize+elesize/2;  
                int x1 = (x/elesize)*elesize+elesize/2;  
                if((y-y1)*(y-y1)>elesize*elesize){  
                    y=y+step;  
                    my=my+step;  
                }  
            }else if(ReadMapFile.map2[y/elesize+1][x/elesize]==0){  
                y=y+step;  
                my=my+step;  
            }  
        }  
    }  
      
    /** 
     * 角色左右移動
     */  
    public void moveLR(){  
        if(left){  
            left1++;  
            if(left1>=20){  
                left1=0;  
            }  
            if(ReadMapFile.map2[y/elesize][x/elesize-1]!=0){  
                int y1 = (y/elesize)*elesize+elesize/2;  
                int x1 = (x/elesize-1)*elesize+elesize/2;  
                if((x-x1)*(x-x1)>elesize*elesize){  
                    x=x-step;  
                    mx=mx-step;  
                }  
            }else if(ReadMapFile.map2[y/elesize][x/elesize-1]==0){  
                x=x-step;  
                mx=mx-step;  
            }  
        }else if(right){  
            right1++;  
            if(right1>=20){  
                right1=0;  
            }  
            if(ReadMapFile.map2[y/elesize][x/elesize+1]!=0){  
                int y1 = (y/elesize)*elesize+elesize/2;  
                int x1 = (x/elesize+1)*elesize+elesize/2;  
                if((x-x1)*(x-x1)>elesize*elesize){  
                    x=x+step;  
                    mx=mx+step;  
                }  
            }else if(ReadMapFile.map2[y/elesize][x/elesize+1]==0){  
                x=x+step;  
                mx=mx+step;  
            }  
        }  
    }  
      
      
    public static void draw(Graphics g){  
        //角色沒有移動
        if(!up&&!down&&!left&&!right){  
            if(towards==1){//角色移動最後朝上 
                g.drawImage(walk1.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 96*3, 96, 96*4, null);  
            }else if(towards==2){//下
                g.drawImage(walk1.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 0, 96, 96, null);  
            }else if(towards==3){//左  
                g.drawImage(walk1.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 96, 96, 96*2, null);  
            }else if(towards==4){//右  
                g.drawImage(walk1.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 96*2, 96, 96*3, null);  
            }  
        }else{//角色移動中  
            if(up){  
                //up1值決定畫哪張
                if(up1<5){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 96*3, 96, 96*4, null);  
                }else if(up1<10){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96, 96*3, 96*2, 96*4, null);  
                }else if(up1<15){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*2, 96*3, 96*3, 96*4, null);  
                }else{  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*3, 96*3, 96*4, 96*4, null);  
                }  
            }else if(down){  
                if(down1<5){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 0, 96, 96, null);  
                }else if(down1<10){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96, 0, 96*2, 96, null);  
                }else if(down1<15){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*2, 0, 96*3, 96, null);  
                }else{  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*3, 0, 96*4, 96, null);  
                }  
            }else if(left){  
                if(left1<5){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 96, 96, 96*2, null);  
                }else if(left1<10){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96, 96, 96*2, 96*2, null);  
                }else if(left1<15){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*2, 96, 96*3, 96*2, null);  
                }else{  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*3, 96, 96*4, 96*2, null);  
                }  
                  
            }else if(right){  
                if(right1<5){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 0, 96*2, 96, 96*3, null);  
                }else if(right1<10){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96, 96*2, 96*2, 96*3, null);  
                }else if(right1<15){  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*2, 96*2, 96*3, 96*3, null);  
                }else{  
                    g.drawImage(walk.getImage(), Player.px-elesize/2-15, Player.py-elesize/2-25, Player.px-elesize/2+65, Player.py-elesize/2+55, 96*3, 96*2, 96*4, 96*3, null);  
                }  
            }  
        }  
    }  
      
    public static int getFixI(){  
        return (y)/50;  
    }  
    //得道角色再度途中位置J 
    public static int getFixJ(){  
        return (x)/50;  
    }  
      
    //得到角色在地圖中位置  
    public static int getI(){  
        return (y-(playersize/2))/50;  
    }  
    //得道角色再度途中位置J 
    public static int getJ(){  
        return (x-(playersize/2))/50;  
    }  
}    