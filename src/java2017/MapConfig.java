package java2017;

import javax.swing.ImageIcon;

public interface MapConfig {  
	
	//素材大小
    int eleWidth = 50;  
    int eleHeight = 50;
    //地圖大小
    int MapWidth = 2000;  
    int MapHeight= 2000;  
    
    //地圖儲存位置
    String path = "C:\\Users\\ibob0625\\Desktop\\java\\Final\\map\\map.map";  
      
    //用到的圖片 
    ImageIcon icon0 = new ImageIcon("000空白.png");
	ImageIcon icon1 = new ImageIcon("001草地.png");
	ImageIcon icon2 = new ImageIcon("002地磚.png");
	ImageIcon icon3 = new ImageIcon("003沙漠.png");
	ImageIcon icon4 = new ImageIcon("004.png");
	ImageIcon icon5 = new ImageIcon("005.png");
	ImageIcon icon246 = new ImageIcon("246牆壁.png"); 
	ImageIcon icon100 = new ImageIcon("100胖樹.png"); 
	ImageIcon icon101 = new ImageIcon("101綠樹.png");
	ImageIcon icon102 = new ImageIcon("102高樹.png");
	ImageIcon icon103 = new ImageIcon("103高綠樹.png");
	ImageIcon icon247 = new ImageIcon("247.png"); 
	ImageIcon icon105 = new ImageIcon("105樹.png"); 
	ImageIcon icon106 = new ImageIcon("106仙人掌.png"); 
	ImageIcon icon150 = new ImageIcon("150岩漿.png");
	ImageIcon icon309 = new ImageIcon("309雕像.png");
	ImageIcon icon310 = new ImageIcon("310火堆.png");
	
	//NPC
	ImageIcon npc215 = new ImageIcon("215NPC.png");
	//開關
	ImageIcon npc301 = new ImageIcon("301關.png");
	
	//物品
	ImageIcon npc401 = new ImageIcon("301關.png");
    ImageIcon npc402 = new ImageIcon("302開.png");
	ImageIcon npc239 = new ImageIcon("239石頭.png");
	ImageIcon npc240 = new ImageIcon("240石頭.png");
	ImageIcon npc311 = new ImageIcon("311墓碑.png");
	ImageIcon npc600 = new ImageIcon("600告示.png");
    //把圖片放到陣列
    ImageIcon[] allicons = {npc401,npc402,icon4,icon5,icon246,icon105,icon106,icon0,icon1,icon2,icon3,icon100,icon101,icon102,icon103,icon247,icon150,npc215,npc301,icon309,icon310,npc239,npc240,npc311,npc600};   
}  