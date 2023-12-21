///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         27/10/2023
//
// Class: DJ.java
// Description: Class extending avatar.java for the DJ in charge of music
//
///////////////////////////////////////////////////////////////////////////////

package com.simulation.avatar;

import java.awt.Color;

import com.simulation.enums.Direction;
import com.simulation.enums.Shape;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DJ extends Avatar {
	ArrayList<String> musicList;
	private Clip currentClip;

	private Random random;
    private JFrame frame;
	Runnable runningMusic;;


	public DJ(Shape shape, Color color, int borderWidth, int avatarId) {
		super(shape, color, borderWidth);
		musicList = new ArrayList<>();
		// Consider adding full paths to the music files
		// musicList.add("Music\\Latina.wav");
		// musicList.add("Music\\Spice.wav");
		File musicDirectory = new File("Music");
        File[] musicFiles = musicDirectory.listFiles();
        if (musicFiles != null) {
            for (File file : musicFiles) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".wav")) {
                    System.out.println(file.getPath());
					musicList.add(file.getPath());
					
                }
            }
        }
		
        random = new Random();
		
    
	}

	public void playMusic() {
		System.out.println("Music starts");
		playNextTrack(0); // Start with the first track
	}

	private void playNextTrack(int trackIndex) {
		if (trackIndex >= musicList.size()) {
			System.out.println("Finished playing all tracks. Restarting playlist.");
			playNextTrack(0); // Loop back to the first track
			return;
		}
		
		String musicFile = musicList.get(trackIndex);

		// playWav(musicFile, () -> playNextTrack(trackIndex + 1));
	}

	public void playSpecificMusic(String musicName) {
		String musicFile = "Music" + File.separator + musicName + ".wav";
		if (musicList.contains(musicFile)) {
			stopMusic(); // Stop the current music if any
			// playWav(musicFile, this::playMusic); // Play the specific music and set the callback to playMusic
		} else {
			System.out.println("Music not found");
		}
	}

	private void playWav(String filename, Runnable onEnd) {
		try {
			stopMusic();

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filename));
			runningMusic = onEnd;

			currentClip = AudioSystem.getClip();
			currentClip.open(audioStream);
			currentClip.addLineListener(event -> {
				if (event.getType() == LineEvent.Type.STOP) {
					event.getLine().close();
					if (runningMusic != null ) {
						//Matrix.stopButtonClicked = true;
						// onEnd.run(); // Run the callback after the track has finished playing
						runningMusic.run();
					}
				}
			});
			currentClip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void stopMusic() {
		if (currentClip != null) {
			if (currentClip.isRunning()) {
				currentClip.stop();
			}
			currentClip.close();
			runningMusic = null;
				
			
		}
	}

	public Direction moveAvatar() {
		return Direction.IDLE;
	}

    public void changeRandomMusic() {
        int randomIndex = random.nextInt(musicList.size());
        stopMusic();
        playWav(musicList.get(randomIndex), this::playMusic);
    }

	public void changeMusicByUserInput() {
		String requestedMusic = JOptionPane.showInputDialog("Enter the name of the music you want to play:");
		String musicPath = "Music" + File.separator + requestedMusic + ".wav";
    if (musicList.contains(musicPath)) {
        stopMusic();

        playWav(musicPath, this::playMusic);
    } else {
        JOptionPane.showMessageDialog(frame, "Sorry! I don’t have the music in my playlist.");
    }
}

	public List<String> getMusicList() {
        List<String> filenames = new ArrayList<>();
        for (String path : musicList) {
            File file = new File(path);
            filenames.add(file.getName().replaceFirst("[.][^.]+$", ""));
        }
		// System.out.println("Filemames");
		for(String filename : filenames){
			System.out.println(filename);

		}
        return filenames;
    }

	public void handleUserMusicRequest() {
        String[] options = {"Randomly", "By specifying the music name"};
        int choice = JOptionPane.showOptionDialog(frame,
                "How do you want to change the music?",
                "Change Music",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {
            case 0:
                changeRandomMusic();
                break;
            case 1:
            	changeMusicByUserInput();
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Invalid choice. Music will not be changed.");
        }
    }

}
