package java2017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class LabelAsButtonS extends JFrame
{
	private Container container;
	private BackgroundPanel backgroundP;
	
	private JLabel startGame;	//開始遊戲
	private JLabel gameManual;	//遊戲說明
	private JLabel readOldFile;	//讀檔
	private JLabel exit;		//離開
	
	private MouseAdapter startGameMA;	
	private MouseAdapter gameManualMA;	
	private MouseAdapter readOldFileMA;	
	private MouseAdapter exitMA;		
	
	private JPanel option1;
	private JPanel option2;
	private JLabel back;
	
	public static int tag=0;
	public static int TAG=0;
	
	PlayMusic startMusic;
	PlayMusic buttonMusic;
	public LabelAsButtonS()
	{	super("JAVA期末專案");
		setLayout(null);
		startMusic = new PlayMusic("title.mp3");
		startMusic.play();
		container=this.getContentPane(); 
    	
		//設定圖片--開始遊戲
		ImageIcon startGameIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/StartGame.png"));
		Image optionAdjust = startGameIcon.getImage();
		optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
		startGameIcon=new ImageIcon(optionAdjust);
		
		startGame=new JLabel();
		startGame.setIcon(startGameIcon); 
		
		startGameMA=new MouseAdapter() {
			//進入遊戲
			@Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if(tag%2==0) {
                ReadMapFile.readfile("C:\\Users\\ibob0625\\Desktop\\java\\Final\\map\\map.map");
                MainFrame mf = new MainFrame();
                add(mf.init1());
                add(mf.init2());
                addKeyListener(mf.init3());
                add(mf.init4());
                 mf.init5();
                mf.init0();
                
                remove(option1);
                remove(option2);
                startMusic.playMusic=false;
                startMusic.close();
                remove(backgroundP);}
            }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				if(tag%2==0) {
				ImageIcon startGameEIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/StartGameE.png"));
				Image optionAdjust=startGameEIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				startGameEIcon=new ImageIcon(optionAdjust);
				
				startGame.setIcon(startGameEIcon);}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(tag%2==0) {
				ImageIcon startGameIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/StartGame.png"));
				Image optionAdjust=startGameIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				startGameIcon=new ImageIcon(optionAdjust);
				
				startGame.setIcon(startGameIcon);}
			}
		};
		
		startGame.addMouseListener(startGameMA);
		//startGame.setBounds(200, 200,400,200);
		//container.add(startGame);
		
		
		
		
		
		
		
		
		//設定圖片--遊戲說明
		ImageIcon gameManualIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/GameManual.png"));
		optionAdjust=gameManualIcon.getImage();
		optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
		gameManualIcon=new ImageIcon(optionAdjust);
		
		gameManual=new JLabel();
		gameManual.setIcon(gameManualIcon);
		
		gameManualMA=new MouseAdapter() {
			//
			@Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
               // StartFrame w=new StartFrame();
              //  container.add(w.getPanel());
                tag++;
                if(tag%2==1) {
                StartFrame w=new StartFrame();
                add(w.getPanel());
	            w.start();}
                
                else
                {
                	StartFrame w=new StartFrame();
	                add(w.getPanel());
		            w.start();}
               
            }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				if(tag%2==0) {
				ImageIcon gameManualEIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/GameManualE.png"));
				Image optionAdjust=gameManualEIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				gameManualEIcon=new ImageIcon(optionAdjust);
				
				gameManual.setIcon(gameManualEIcon);}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(tag%2==0) {
				ImageIcon gameManualIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/GameManual.png"));
				Image optionAdjust=gameManualIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				gameManualIcon=new ImageIcon(optionAdjust);
				
				gameManual.setIcon(gameManualIcon);}
			}
		};
		gameManual.addMouseListener(gameManualMA);
		//add(gameManual);
		
		//設定圖片--讀檔
		ImageIcon readOldFileIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/ReadOldFile.png"));
		optionAdjust=readOldFileIcon.getImage();
		optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
		readOldFileIcon=new ImageIcon(optionAdjust);
		
		readOldFile=new JLabel();
		readOldFile.setIcon(readOldFileIcon);
		
		readOldFileMA=new MouseAdapter() {
			//
			@Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if(tag%2==0) {
                ReadMapFile.readfile("C:\\Users\\ibob0625\\Desktop\\java\\Final\\map\\mapload.map");
                MainFrame mf = new MainFrame();
                add(mf.init1());
                add(mf.init2());
                addKeyListener(mf.init3());
                add(mf.init4());
                mf.init5();
                remove(option1);
                remove(option2);
                remove(backgroundP);
                startMusic.playMusic=false;
                startMusic.close();}
               
            }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				if(tag%2==0) {
				ImageIcon readOldFileEIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/ReadOldFileE.png"));
				Image optionAdjust=readOldFileEIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				readOldFileEIcon=new ImageIcon(optionAdjust);
				
				readOldFile.setIcon(readOldFileEIcon);}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(tag%2==0) {
				ImageIcon readOldFileIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/ReadOldFile.png"));
				Image optionAdjust=readOldFileIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				readOldFileIcon=new ImageIcon(optionAdjust);
				
				readOldFile.setIcon(readOldFileIcon);}
			}
		};
		readOldFile.addMouseListener(readOldFileMA);
		//add(readOldFile);
		

		//設定圖片--讀檔
		ImageIcon exitIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/Exit.png"));
		optionAdjust=exitIcon.getImage();
		optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
		exitIcon=new ImageIcon(optionAdjust);
		
		exit=new JLabel();
		exit.setIcon(exitIcon);
		
		exitMA=new MouseAdapter() {
			//
			@Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if(tag%2==0) {
               System.exit(0);
                }
            }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				if(tag%2==0) {
				ImageIcon exitEIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/ExitE.png"));
				Image optionAdjust=exitEIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				exitEIcon=new ImageIcon(optionAdjust);
				
				exit.setIcon(exitEIcon);}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(tag%2==0) {
				ImageIcon exitIcon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/Exit.png"));
				Image optionAdjust=exitIcon.getImage();
				optionAdjust=optionAdjust.getScaledInstance(200,40,java.awt.Image.SCALE_SMOOTH);
				exitIcon=new ImageIcon(optionAdjust);
				
				exit.setIcon(exitIcon);}
			}
		};
		exit.addMouseListener(exitMA);
		//add(exit);
		
		
		
		option1=new JPanel();
		option1.setLayout(new GridLayout(1,2));
	
		option1.add(startGame);
		option1.add(gameManual);
		option1.setOpaque(false);
		option1.setBounds(80,430,400,100);
		container.add(option1);
		
		option2=new JPanel();
		option2.setLayout(new GridLayout(1,2));
		
		option2.add(readOldFile); 
		option2.add(exit);
		option2.setOpaque(false);  
		option2.setBounds(220,500,400,100);
		container.add(option2);
		
		//.setComponentZOrder(b1, 0);
		
		//設定背景------------------------------------------------------------
		 
		ImageIcon Icon=new ImageIcon(ClassLoader.getSystemResource("java2017/RPG/background.png"));
		optionAdjust=Icon.getImage();
		
        
		backgroundP=new BackgroundPanel(Icon.getImage());  
		backgroundP.setBounds(0,0,700,700); 
		backgroundP.setBackground(null);
		backgroundP.setOpaque(false);
        container.add(backgroundP);
		
		
	}
	
	public KeyListenner key()
    {
    	KeyListenner plis = new KeyListenner();  
    	return plis;
    }
	///////////////////////////////////////////////////////////
	class KeyListenner extends KeyAdapter{  
        //按下按鍵 
        public void keyPressed(KeyEvent e){  
            int code = e.getKeyCode();  
            if(tag%2==1){  
                switch (code) {  
                case KeyEvent.VK_Z:  
                	TAG=0;
                    tag=0;
                    StartFrame w=new StartFrame();
                    add(w.getPanel());
    	             w.start();
                    break; 
                    
                default:  
                    break;  
                }
            }
              
        }  
        //按鍵放開 
        public void keyReleased(KeyEvent e){  
            if(tag%2==1){  
                int code = e.getKeyCode();  
                switch (code) {  
                case KeyEvent.VK_Z:  
                    /* TAG=0;
                     tag=0;
                     StartFrame w=new StartFrame();
                     add(w.getPanel());
     	             w.start();*/
                    break;  
                  
                default:  
                    break;  
                }  
            }  
        }  
    }
	//////////////////////////////////////////////////////////
	
	
	
	
	public class BackgroundPanel extends JPanel   
	{  
		Image im;  
	    public BackgroundPanel(Image im)  
	    {  
	        this.im=im;  
	        this.setOpaque(false);  
	    }  
	    public void change(Image im)
	    {  
	        this.im=im;  
	        this.setOpaque(true);  
	    }  
	    //Draw the back ground.  
	    public void paintComponent(Graphics g)  
	    {  
	        super.paintComponents(g);  
	        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);     
	    }  
	}  
}
