import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level1CodingExam implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	public void run() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button1.setBackground(Color.GREEN);
		button1.setOpaque(true);
		button2.setBackground(Color.RED);
		button2.setOpaque(true);
		button3.setBackground(Color.YELLOW);
		button3.setOpaque(true);
		button4.setBackground(Color.BLUE);
		button4.setOpaque(true);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == button1) {
			speak("Green");
		}
		else if(arg0.getSource() == button2) {
			speak("Red");
		}
		else if(arg0.getSource() == button3) {
			speak("Yellow");
		}
		else if(arg0.getSource() == button4) {
			speak("Blue");
		}
	}
	 static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }
}
