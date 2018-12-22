package java2017;

import javax.swing.ImageIcon;

public class GetMap implements GameConfig{  
    //§ä¨ì¹Ï¤ù 
        static ImageIcon int2icon(int num){  
        	if(num==0)return icon0;//ªÅ¥Õ
			if(num==1)return icon1;//¯ó		
			if(num==2)return icon2;//¦a¿j	
			if(num==3)return icon3;//ªh¿A	
			if(num==4)return icon4;
			if(num==5)return icon5; 
  		    if(num==100)return icon100;//¬õ¾ğ	
			if(num==101)return icon101;//ºñ¾ğ	
		    if(num==102)return icon102;//ºñ¦Ë	
			if(num==103)return icon103;//°ªºñ¾ğ	
			if(num==150)return icon150;//©¥¼ß
			if(num==201)return npc201;
			if(num==205)return npc205;
			if(num==207)return npc207;
			if(num==208)return npc208;
			if(num==209)return npc209;
			if(num==210)return npc210;
			if(num==211)return npc211;
			if(num==212)return npc212;
			if(num==215)return npc215;
			if(num==228)return npc228;
			if(num==233)return npc233; 
			if(num==234)return npc234;
			if(num==239)return npc239;
			if(num==240)return npc240;
			if(num==241)return npc241;
			if(num==242)return npc242;
			if(num==246)return icon246;
			if(num==301)return npc301;
			if(num==302)return npc302;
			if(num==303)return npc303;
			if(num==304)return npc304;
			if(num==305)return npc305; 
			if(num==306)return npc306;
			if(num==307)return npc307;
			if(num==308)return npc308;
			if(num==309)return icon309;
			if(num==310)return icon310;
			if(num==311)return npc311;
			if(num==312)return icon312;
			if(num==313)return icon313;
			if(num==314)return icon314;
			if(num==315)return icon315;
			if(num==105)return icon105;
			if(num==106)return icon106;
			if(num==247)return icon247;
			if(num==401)return npc401;
			if(num==402)return npc402;
			if(num==600)return npc600;
            return null;  
        }  
        static ImageIcon int2npc(int num){
        	if(num==401)return npc401;
			if(num==402)return npc402;
        	if(num==100)return icon100;
			if(num==201)return npc201;
			if(num==205)return npc205;
			if(num==207)return npc207;	
			if(num==208)return npc208;
			if(num==209)return npc209;
			if(num==210)return npc210;
			if(num==211)return npc211;
			if(num==212)return npc212;
			if(num==215)return npc215;
			if(num==228)return npc228;
			if(num==233)return npc233;
			if(num==239)return npc239;
			if(num==240)return npc240;
			if(num==241)return npc241;
			if(num==242)return npc242;
			if(num==301)return npc301;
			if(num==302)return npc302;
			if(num==303)return npc303;
			if(num==304)return npc304;
			if(num==305)return npc305;
			if(num==306)return npc306;
			if(num==307)return npc307;
			if(num==308)return npc308;
			if(num==311)return npc311;
			if(num==600)return npc600;
			return null;
		}
   
}  