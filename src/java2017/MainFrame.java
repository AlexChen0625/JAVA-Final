package java2017;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.KeyAdapter;  
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;  
import javax.swing.JPanel;  
  

public class MainFrame implements GameConfig{  
	//遊戲狀態 1為行走 2為問答 3為劇情  
    static int tag = 1;  
    //遊戲面板
    JPanel panel;  
    //對話面板
    JPanel tpanel;  
    //劇情面板
    JPanel storyPanel;
    //音樂
    PlayMusic mainMusic;
    String mainMusicFile="mainMusic.mp3";
    PlayMusic effectMusic;
    String effectMusicFile="";
    static PlayMusic typeMusic;
    PlayMusic stepMusic;
    PlayMusic chatMusic;
    PlayMusic switchMusic;
    int num=0;
    static boolean ctr=false;
    public void init0() {
    	typeMusic = new PlayMusic("type.mp3");
    	
    	typeMusic.playMusic=true;
    	typeMusic.play();
    	tag=3;
    	
    }
    public JPanel init1() {
    
    	 tpanel = settpanel();  
         return tpanel;  
    }
    
    public JPanel init2()
    {
    	//遊戲畫面  
        panel = setpanel();
        return panel;
    }
    
    public PanelListenner init3()
    {
    	PanelListenner plis = new PanelListenner();  
        return plis;  
    }
    
    public JPanel init4()
    {
    	storyPanel = setttpanel();
        return storyPanel;
    }
    public void init5()
    {
    	//音樂
    	typeMusic = new PlayMusic("type.mp3");
    	mainMusic = new PlayMusic(mainMusicFile);
    	mainMusic.playMusic=true;
    	mainMusic.play();
    	stepMusic = new PlayMusic("step.mp3");
    	chatMusic = new PlayMusic("chat.mp3");
    	switchMusic = new PlayMusic("switch.mp3");
    	//effectMusic = new PlayMusic(effectMusicFile);
    	//人物
        Player player = new Player();  
        player.start();  
        Player.x=(ReadMapFile.playerX)*50+(playersize/2);
        Player.y=(ReadMapFile.playerY)*50+(playersize/2);
          
        //畫面刷新  
        UpdateThread ut = new UpdateThread(panel,tpanel,storyPanel);  
        ut.start();
    }
  
    public JPanel setpanel(){  
        JPanel panel = new MyPanel();  
        panel.setBounds(0, 0, 700, 700);  
//      panel.setPreferredSize(new Dimension(panelX, panelY));  
        panel.setLayout(null);  
        panel.setBackground(Color.black);  
          
        return panel;  
    }  
    /*對話框*/ 
    public JPanel settpanel(){  
        JPanel tpanel = new TalkPanel();  
        return tpanel;  
    }  
    /*劇情框*/
    public JPanel setttpanel() {
    	JPanel storyPanel = new Story();
    	return storyPanel;
    }
      
    /*按鍵*/  
    class PanelListenner extends KeyAdapter{  
        //按下按鍵 
        public void keyPressed(KeyEvent e){  
            int code = e.getKeyCode();  
            if(tag==3) {
            	switch (code) {  
                case KeyEvent.VK_SPACE:   
                	typeMusic.playMusic=false;
                	typeMusic.close();
                    tag=1;  
                    Story.currentWord=0;
                    if(Story.finish) {
                    	System.exit(0);
                    }
                    /*
                    mainMusic.playMusic=true;
                    mainMusic.play();
                    */
                    break;  
            	}
            }
            if(tag==1){  
                switch (code) {  
                case KeyEvent.VK_UP: 
                	stepMusic.playMusic=true;
                	//stepMusic.play();
                    Player.up = true;  
                    Player.towards = 1;  
                    break;  
                case KeyEvent.VK_DOWN:  
                    Player.down = true;  
                    Player.towards = 2;  
                    break;  
                case KeyEvent.VK_LEFT:  
                    Player.left = true;  
                    Player.towards = 3;  
                    break;  
                case KeyEvent.VK_RIGHT:  
                    Player.right = true;  
                    Player.towards = 4;  
                    break;  
                case KeyEvent.VK_CONTROL:
                	ctr=true;
                	break;
                /***********存檔**************/
                case KeyEvent.VK_S:  
              	  
               	 
              	  try{ 
              		  if(ctr) {
              			  ReadMapFile.readfile("C:\\Users\\ibob0625\\Desktop\\java\\Final\\map\\mapload.map");  
              			  Player.x=(ReadMapFile.playerX)*50+(playersize/2);
              		         Player.y=(ReadMapFile.playerY)*50+(playersize/2);
              		         Player.resetAll();
              			  ctr=false;
              		  }else {
                        FileOutputStream fos = new FileOutputStream("C:\\Users\\ibob0625\\Desktop\\java\\Final\\map\\mapload.map");  
                        DataOutputStream dos = new DataOutputStream(fos);  
                        int i = 40;  
                        int j = 40;  
                        dos.writeInt(i);  
                        dos.writeInt(j);  
                        for(int ii=0;ii<i;ii++){  
                            for(int jj=0;jj<j;jj++){  
                                dos.writeInt(ReadMapFile.map1[ii][jj]);  
                                dos.writeInt(ReadMapFile.map2[ii][jj]);  
                                dos.writeInt(ReadMapFile.map3[ii][jj]);  
                            }  
                        }  
                        int saveX=Player.getJ();
                        int saveY=Player.getI();           
                        System.out.print(saveX);
                        System.out.print(saveY);
                        dos.writeInt(saveX);
                        dos.writeInt(saveY);
                        dos.flush();  
                        dos.close();  
                        System.out.println("保存完成");  
              		  }
                        }catch(Exception ef){  
                            ef.printStackTrace();  
                        }  
                      break;
                    /*************對話**********/
                case KeyEvent.VK_G:
                	
                    if(Player.towards==1){//角色朝上
                    	num = ReadMapFile.map3[Player.y/elesize-1][Player.x/elesize];  
                        if(num!=0){//上方有npc      
                        	chatMusic.playMusic=true;
                        	chatMusic.play();
                            GetNPC.getnpc(num);  
                            TalkPanel.gettalknpc(num);  
                            tag = 2;  
                            tpanel.setBounds(28, 500, 630, 150);  
                            tpanel.repaint();       
                        }  
                    }else if(Player.towards==2){//角色朝下 
                        num = ReadMapFile.map3[Player.y/elesize+1][Player.x/elesize];
                        if(ReadMapFile.map3[Player.y/elesize+1][Player.x/elesize]!=0){//下方有npc  
                        	if(num!=0) {
                        		chatMusic.playMusic=true;
                            	chatMusic.play();
                        		GetNPC.getnpc(num); 
                        		
                                TalkPanel.gettalknpc(num);  
                        		tpanel.setBounds(28, 500, 630, 150);  
                        		tag = 2;//進入對話模式  
                        		tpanel.repaint();  
                        	}
                        }  
                    }else if(Player.towards==3){//左
                    	num = ReadMapFile.map3[Player.y/elesize][Player.x/elesize-1];
                        if(ReadMapFile.map3[Player.y/elesize][Player.x/elesize-1]!=0){//左方有npc  
                        	chatMusic.playMusic=true;
                        	chatMusic.play();
                        	GetNPC.getnpc(num);  
                            TalkPanel.gettalknpc(num);  
                    		tpanel.setBounds(28, 500, 630, 150);  
                    		tag = 2;//進入對話模式  
                    		tpanel.repaint();   
                        }  
                    }else if(Player.towards==4){//下
                    	num = ReadMapFile.map3[Player.y/elesize][Player.x/elesize+1];
                        if(ReadMapFile.map3[Player.y/elesize][Player.x/elesize+1]!=0){//右方有npc  
                        	chatMusic.playMusic=true;
                        	chatMusic.play();
                        	GetNPC.getnpc(num);  
                            TalkPanel.gettalknpc(num);  
                    		tpanel.setBounds(28, 500, 630, 150);  
                    		tag = 2;//進入對話模式  
                    		tpanel.repaint();  
                        }  
                    }  
                   System.out.printf("%d",num);
                    /**************遊戲流程*******************/
                    if(num==207) {
                    	
                    	ReadMapFile.map3[16][3]=241;
                    }
                    if(num==241) {
                    	ReadMapFile.map3[9][4]=208;
                    	ReadMapFile.map3[16][3]=0;
                    	
                	}
                    if(num==208) {
                    	ReadMapFile.map3[5][6]=242;
                    	ReadMapFile.map3[9][4]=0;
                    }
                    if(num==242) {
                    	ReadMapFile.map2[5][6]=0;
                    	ReadMapFile.map3[5][6]=0;
                    }
                    if(num==301||num==302) {
                    	switchMusic.playMusic=true;
                    	switchMusic.play();
                    	if(ReadMapFile.map2[3][11]==301){
                    		ReadMapFile.map2[3][11]=302;
                    		ReadMapFile.map3[3][11]=302;}
                    	else if(ReadMapFile.map2[3][11]==302){
                    		ReadMapFile.map2[3][11]=301;
                    		ReadMapFile.map3[3][11]=301;}
                    	if(ReadMapFile.map2[3][15]==303){
                    		ReadMapFile.map2[3][15]=304;
                    		ReadMapFile.map3[3][15]=304;}
                    	else if(ReadMapFile.map2[3][15]==304){
                    		ReadMapFile.map2[3][15]=303;
                    		ReadMapFile.map3[3][15]=303;}
                    	if(ReadMapFile.map2[7][11]==305){
                    		ReadMapFile.map2[7][11]=306;
                    		ReadMapFile.map3[7][11]=306;}
                    	else if(ReadMapFile.map2[7][11]==306){
                    		ReadMapFile.map2[7][11]=305;
                    		ReadMapFile.map3[7][11]=305;}
                    }
                    if(num==305||num==306) {
                    	switchMusic.playMusic=true;
                    	switchMusic.play();
                    	if(ReadMapFile.map2[7][11]==305){
                    		ReadMapFile.map2[7][11]=306;
                    		ReadMapFile.map3[7][11]=306;}
                    	else if(ReadMapFile.map2[7][11]==306){
                    		ReadMapFile.map2[7][11]=305;
                    		ReadMapFile.map3[7][11]=305;}
                    	if(ReadMapFile.map2[7][15]==307){
                    		ReadMapFile.map2[7][15]=308;
                    		ReadMapFile.map3[7][15]=308;}
                    	else if(ReadMapFile.map2[7][15]==308){
                    		ReadMapFile.map2[7][15]=307;
                    		ReadMapFile.map3[7][15]=307;}
                    	if(ReadMapFile.map2[3][15]==303){
                    		ReadMapFile.map2[3][15]=304;
                    		ReadMapFile.map3[3][15]=304;}
                    	else if(ReadMapFile.map2[3][15]==304){
                    		ReadMapFile.map2[3][15]=303;
                    		ReadMapFile.map3[3][15]=303;}
                    }
                    if(num==303||num==304) {
                    	switchMusic.playMusic=true;
                    	switchMusic.play();
                    	if(ReadMapFile.map2[3][15]==303){
                    		ReadMapFile.map2[3][15]=304;
                    		ReadMapFile.map3[3][15]=304;}
                    	else if(ReadMapFile.map2[3][15]==304){
                    		ReadMapFile.map2[3][15]=303;
                    		ReadMapFile.map3[3][15]=303;}
                    	if(ReadMapFile.map2[7][15]==307){
                    		ReadMapFile.map2[7][15]=308;
                    		ReadMapFile.map3[7][15]=308;}
                    	else if(ReadMapFile.map2[7][15]==308){
                    		ReadMapFile.map2[7][15]=307;
                    		ReadMapFile.map3[7][15]=307;}
                    }
                    if(num==307||num==308) {
                    	switchMusic.playMusic=true;
                    	switchMusic.play();
                    	if(ReadMapFile.map2[7][11]==305){
                    		ReadMapFile.map2[7][11]=306;
                    		ReadMapFile.map3[7][11]=306;}
                    	else if(ReadMapFile.map2[7][11]==306){
                    		ReadMapFile.map2[7][11]=305;
                    		ReadMapFile.map3[7][11]=305;}
                    	if(ReadMapFile.map2[7][15]==307){
                    		ReadMapFile.map2[7][15]=308;
                    		ReadMapFile.map3[7][15]=308;}
                    	else if(ReadMapFile.map2[7][15]==308){
                    		ReadMapFile.map2[7][15]=307;
                    		ReadMapFile.map3[7][15]=307;}
                    }
                    if(ReadMapFile.map2[3][11]==302&&ReadMapFile.map2[3][15]==304&&ReadMapFile.map2[7][11]==306&&ReadMapFile.map2[7][15]==308){
                    	ReadMapFile.map2[5][17]=0;
                		ReadMapFile.map3[5][17]=0;
                    }
                    if(num==600) {
                    	ReadMapFile.map2[3][11]=301;
                    	ReadMapFile.map3[3][11]=301;
                    	ReadMapFile.map2[3][15]=303;
                    	ReadMapFile.map3[3][15]=303;
                    	ReadMapFile.map2[7][11]=305;
                    	ReadMapFile.map3[7][11]=305;
                    	ReadMapFile.map2[7][15]=307;
                    	ReadMapFile.map3[7][15]=307;
                    }
                    if(num==211) {
                    	ReadMapFile.map3[5][32]=0;
                    	ReadMapFile.map3[5][36]=233;
                    }
                    if(num==233) {
                    	ReadMapFile.map2[5][36]=234;
                    	ReadMapFile.map3[5][36]=0;
                    }
                    if(num==228) {
                    	Story.currentWord=0;
                    	Story.storySection=2;
                    	tag=3;
                    	mainMusic.playMusic=false;
                    	mainMusic.close();
                    	typeMusic.playMusic=true;
                    	typeMusic.play();
                    	ReadMapFile.map2[9][36]=0;
                    	ReadMapFile.map3[9][36]=0;
                    	
                    }
                    if(num==212) {
                    	ReadMapFile.map2[18][25]=0;
                    	ReadMapFile.map3[18][25]=0;
                    	ReadMapFile.map3[35][12]=401;
                    }
                    if(num==401) {
                    	switchMusic.playMusic=true;
                    	switchMusic.play();
                    	ReadMapFile.map2[35][12]=402;
                    	ReadMapFile.map3[35][12]=402;
                    	ReadMapFile.map2[33][21]=0;
                    }
                    if(num==215) {
                    	
                    }
                    Player.reset();
                    
                    break;  
  
                default:  
                    break;  
                }  
            }else if(tag==2){  
                if(code==KeyEvent.VK_G){  
                    tag=1;  
                    tpanel.setBounds(28, 500, 0, 0); 
                    if(num==215) {
                    	Story.currentWord=0;
                    	Story.storySection=3;
                    	tag=3;	
                    	mainMusic.playMusic=false;
                    	mainMusic.close();
                    	typeMusic.playMusic=true;
                    	typeMusic.play();
                    	
                    }
                }  
            }  
              
        }  
        //按鍵放開 
        public void keyReleased(KeyEvent e){ 
        	int code = e.getKeyCode();  
            if(tag==1){  
                
                switch (code) {  
                case KeyEvent.VK_UP:  
                	stepMusic.playMusic=false;
                	stepMusic.close();
                    Player.up = false;  
                    Player.up1 = 0;  
                    break;  
                case KeyEvent.VK_DOWN:  
                    Player.down = false;  
                    Player.down1 = 0;  
                    break;  
                case KeyEvent.VK_LEFT:  
                    Player.left = false;  
                    Player.left1 = 0;  
                    break;  
                case KeyEvent.VK_RIGHT:  
                    Player.right = false;  
                    Player.right1 = 0;  
                    break;  
                case KeyEvent.VK_CONTROL:
                	ctr=false;
                	break;
                default:  
                    break;  
                }   
            }else if(tag==2) {
            	switch (code) {  
                case KeyEvent.VK_G:  
                	chatMusic.playMusic=false;
                	chatMusic.close();
                	switchMusic.playMusic=false;
                	switchMusic.close();
                    break;  
            	}
            }
        }  
    }  
    /*遊戲面板*/  
    class MyPanel extends JPanel{  
        
		private static final long serialVersionUID = 1L;

		@Override  
        public void paint(Graphics g) {  
            super.paint(g);  
            //角色周圍圖案
            for(int i=Player.getI()-6;i<=Player.getI()+6;i++){  
                for(int j=Player.getJ()-6;j<=Player.getJ()+6;j++){  
                    //無超界  
                    if(i>=0&&j>=0&&i<ReadMapFile.map1.length&&j<ReadMapFile.map1[0].length){  
                        //畫第一層  
                        ImageIcon icon = GetMap.int2icon(ReadMapFile.map1[i][j]);  
                        g.drawImage(icon.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);  
                        //第二層
                        if(ReadMapFile.map2[i][j]!=0){  
                            ImageIcon icon2 = GetMap.int2icon(ReadMapFile.map2[i][j]);  
                            g.drawImage(icon2.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);  
                        }  
                        //第三曾  
                        if(ReadMapFile.map3[i][j]!=0){  
                            ImageIcon icon3 = GetMap.int2npc(ReadMapFile.map3[i][j]);  
                            g.drawImage(icon3.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);  
                        }  
                          
                    }  
                }  
            }  
            Player.draw(g);  
            g.drawImage(shadow2.getImage(), 0, 0, 650, 650, null);  
        }  
    }  
    

}