package java2017;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayMusic
{
	private String filename;
	private Player player;
	static boolean playMusic=true;
	// constructor that takes the name of an MP3 file
	public PlayMusic (String filename)
	{
		this.filename = filename;
	}
 
	public void close ()
	{
		if (player != null)
			player.close();
	}

	// play the MP3 file to the sound card
	public void play ()
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e)
		{
			System.out.println("Problem playing file " + filename);
			System.out.println(e);
		}

		// run in new thread to play in background
		new Thread() { 
			public void run ()
			{
				try
				{
					while(playMusic) {
					
					player.play();
					
					FileInputStream fis = new FileInputStream(filename);
					BufferedInputStream bis = new BufferedInputStream(fis);
					player = new Player(bis);
					System.out.print(playMusic);
					
					}
					
				} catch (Exception e)
				{
					System.out.println(e);
				}
				
			}
		}.start();

	}

	
	/*// test client
	public  void  go()
	{
		String filename = "test.mp3";
		PlayMusic mp3 = new PlayMusic(filename);
		mp3.play();

		// do whatever computation you like, while music plays
		

		// when the computation is done, stop playing it
		mp3.close();

		// play from the beginning
		mp3 = new PlayMusic(filename);
		mp3.play();

	}
	*/

}
