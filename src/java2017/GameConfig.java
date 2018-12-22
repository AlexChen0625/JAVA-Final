package java2017;

import javax.swing.ImageIcon;

public interface GameConfig {    
    String title = "場景移動";  
    //視窗大小
    int frameX = 700;  
    int frameY = 700;   
    //面板大小   
    int panelX = 650;  
    int panelY = 650;  
    //素材大小  
    int elesize = 50;  
    //人物大小  
    int playersize = 50;  
    //------------[遊戲素材]----------  
    //素材
    ImageIcon icon0 = new ImageIcon("000空白.png");
	ImageIcon icon1 = new ImageIcon("001草地.png"); 
	ImageIcon icon2 = new ImageIcon("002地磚.png");
	ImageIcon icon3 = new ImageIcon("003沙漠.png");
	ImageIcon icon4 = new ImageIcon("004.png");
	ImageIcon icon5 = new ImageIcon("005.png");

	ImageIcon icon100 = new ImageIcon("100胖樹.png");
	ImageIcon icon101 = new ImageIcon("101綠樹.png");
	ImageIcon icon102 = new ImageIcon("102高樹.png");
	ImageIcon icon103 = new ImageIcon("103高綠樹.png");
	ImageIcon icon150 = new ImageIcon("150岩漿.png"); 
	ImageIcon icon309 = new ImageIcon("309雕像.png");
	ImageIcon icon310 = new ImageIcon("310火堆.png");
	ImageIcon icon312 = new ImageIcon("312.png");
	ImageIcon icon313 = new ImageIcon("313.png");
	ImageIcon icon314 = new ImageIcon("314.png");
	ImageIcon icon315 = new ImageIcon("315.png");
	ImageIcon icon105 = new ImageIcon("105樹.png"); 
	ImageIcon icon106 = new ImageIcon("106仙人掌.png"); 
	//角色
    ImageIcon walk = new ImageIcon("角色行走.png");
    ImageIcon walk1 = new ImageIcon("角色停止.png");
    //npc
    ImageIcon npc201 = new ImageIcon("201NPC.png");
    ImageIcon npc205 = new ImageIcon("205NPC.png");
    ImageIcon npc207 = new ImageIcon("207NPC.png");
    ImageIcon npc208 = new ImageIcon("207NPC.png");
    ImageIcon npc209 = new ImageIcon("209NPC.png");
	ImageIcon npc210 = new ImageIcon("210NPC.png");
	ImageIcon npc211 = new ImageIcon("211NPC.png");
    ImageIcon npc212 = new ImageIcon("212NPC.png");
    ImageIcon npc215 = new ImageIcon("215NPC.png");
    ImageIcon icon247 = new ImageIcon("247.png"); 
    ImageIcon npc228 = new ImageIcon("228柵欄.png");
    ImageIcon npc233 = new ImageIcon("233物品.png");
    ImageIcon npc234 = new ImageIcon("234物品.png");
    ImageIcon npc239 = new ImageIcon("239石頭.png");
    ImageIcon npc240 = new ImageIcon("240石頭.png");//沒東西石頭
    ImageIcon npc241 = new ImageIcon("240石頭.png");//100原石頭
    ImageIcon npc242 = new ImageIcon("239石頭.png");//石頭破壞
	ImageIcon npc311 = new ImageIcon("311墓碑.png");
	ImageIcon icon246 = new ImageIcon("246牆壁.png");
    ImageIcon npc600 = new ImageIcon("600告示.png");
    //開關 
    ImageIcon npc301 = new ImageIcon("301關.png");
    ImageIcon npc302 = new ImageIcon("302開.png");
    ImageIcon npc303 = new ImageIcon("301關.png");
    ImageIcon npc304 = new ImageIcon("302開.png");
    ImageIcon npc305 = new ImageIcon("301關.png");
    ImageIcon npc306 = new ImageIcon("302開.png");
    ImageIcon npc307 = new ImageIcon("301關.png");
    ImageIcon npc308 = new ImageIcon("302開.png");
    ImageIcon npc401 = new ImageIcon("301關.png");
    ImageIcon npc402 = new ImageIcon("302開.png");
    //鏡頭
    ImageIcon shadow2 = new ImageIcon("鏡頭陰影.png");  
    //對話
    ImageIcon talkbox = new ImageIcon("對話框.png");
      
      
      
}  