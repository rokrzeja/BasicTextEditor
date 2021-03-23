/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Menu extends JFrame implements ActionListener {
    
    JRadioButtonMenuItem [] ForegroundButtonArray = {
        new JRadioButtonMenuItem ("• Green"),
        new JRadioButtonMenuItem ("• Orange"),
        new JRadioButtonMenuItem ("• Red"),
        new JRadioButtonMenuItem ("• Black"),
        new JRadioButtonMenuItem ("• White"),
        new JRadioButtonMenuItem ("• Yellow"),
        new JRadioButtonMenuItem ("• Blue")  
    };
    
    
    JRadioButtonMenuItem [] backgroundButtonArray = {
        new JRadioButtonMenuItem ("• Green"),
        new JRadioButtonMenuItem ("• Orange"),
        new JRadioButtonMenuItem ("• Red"),
        new JRadioButtonMenuItem ("• Black"),
        new JRadioButtonMenuItem ("• White"),
        new JRadioButtonMenuItem ("• Yellow"),
        new JRadioButtonMenuItem ("• Blue")  
    };
    
    JMenuItem [] fontArray = {
        new JMenuItem ("punkt8"),
        new JMenuItem ("punkt10"),
        new JMenuItem ("punkt12"),
        new JMenuItem ("punkt14"),
        new JMenuItem ("punkt16"),
        new JMenuItem ("punkt18"),
        new JMenuItem ("punkt20"),
        new JMenuItem ("punkt22"),
        new JMenuItem ("punkt24")
    };

    private Condition condition;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem exit;
    private JMenuItem home;
    private JMenuItem work;
    private JMenuItem university;

    private JTextArea textArea;
    private JFrame jframe;
    private JScrollPane jScrollPane;

    private JLabel foregroundSign;
    private JLabel foreground;
    private JLabel backgroundSign;
    private JLabel background;
    private JLabel size;
    private JLabel font;
    private JLabel conditionLabel;
            
    
    public void superMethod(JMenu txt, JRadioButtonMenuItem [] foregroundButtonArray) {

        foregroundButtonArray[0].setForeground(Color.GREEN);
        foregroundButtonArray[1].setForeground(Color.ORANGE);
        foregroundButtonArray[2].setForeground(Color.RED);
        foregroundButtonArray[3].setForeground(Color.BLACK);
        foregroundButtonArray[4].setForeground(Color.WHITE);
        foregroundButtonArray[5].setForeground(Color.YELLOW);
        foregroundButtonArray[6].setForeground(Color.BLUE);
           
        for(int i = 0; i< foregroundButtonArray.length; i++) {

            foregroundButtonArray[i].addActionListener(this);
            txt.add( foregroundButtonArray[i]);
        }
        
    }
    
    public void setFontArray (JMenu txt) {

        int number = 8;
        for(int i = 0; i< fontArray.length; i++) {

            fontArray[i].setFont( new Font ( number + " pts",3, number));
            txt.add( fontArray[i]);
            fontArray[i].addActionListener(this);
            number +=2;
        }
    }
    
   
    public Menu () {
        
       jframe = new JFrame();
       jframe.setTitle("task 17");
       jframe.setLocation(100, 100);
       jframe.setPreferredSize(new Dimension(400, 400));
       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.setVisible(true);
    
       textArea = new JTextArea();
       textArea.setEditable(true);
       jScrollPane = new JScrollPane(textArea);
       jframe.add(jScrollPane);
        
       condition = Condition.New;
       
       JMenuBar jmb = new JMenuBar();
       jframe.setJMenuBar(jmb);

       JMenu file = new JMenu("File");
       jmb.add(file);
       
       open = new JMenuItem ("Open", KeyEvent.VK_T);
       KeyStroke ctrlOKeyStroke = KeyStroke.getKeyStroke("control O");
       open.setAccelerator(ctrlOKeyStroke);
       file.add(open);
       open.addActionListener(this);
       
       save = new JMenuItem ("Save");
       KeyStroke ctrlSKeyStroke = KeyStroke.getKeyStroke("control S");
       save.setAccelerator(ctrlSKeyStroke);
       file.add(save);
       save.addActionListener(this);
            
       saveAs = new JMenuItem ("Save As");
       KeyStroke ctrlAKeyStroke = KeyStroke.getKeyStroke("control A");
       saveAs.setAccelerator(ctrlAKeyStroke);
       file.add(saveAs);
       saveAs.addActionListener(this);
            
       JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
       file.add(sep);
       sep.setBackground(Color.RED);
            
       exit = new JMenuItem ("Exit");
       KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke("control X");
       exit.setAccelerator(ctrlXKeyStroke);
       file.add(exit);
       exit.addActionListener(this);
            
       JMenu edit = new JMenu("Edit");
       jmb.add(edit);
       
       JMenu addresses = new JMenu ("addresses");
       edit.add(addresses);
            
           work = new JMenuItem ("Work");
           KeyStroke cspKeyStroke = KeyStroke.getKeyStroke("control shift W");
           work.setAccelerator(cspKeyStroke);
           addresses.add(work);
           work.addActionListener(this);

           home = new JMenuItem ("Home");
           KeyStroke csdKeyStroke = KeyStroke.getKeyStroke("control shift H");
           home.setAccelerator(csdKeyStroke);
           addresses.add(home);
           home.addActionListener(this);

           university = new JMenuItem ("University");
           KeyStroke cssKeyStroke = KeyStroke.getKeyStroke("control shift U");
           university.setAccelerator(cssKeyStroke);
           addresses.add(university);
           university.addActionListener(this);
                    
       JMenu options = new JMenu("Options");
       jmb.add(options);
       
       JMenu foreground = new JMenu ("Foreground");
       options.add(foreground);
       superMethod(foreground, ForegroundButtonArray);

       JMenu background = new JMenu ("Background");
       options.add(background);
       superMethod(background, backgroundButtonArray);
            
       JMenu fontSize = new JMenu ("Fontsize");
       options.add(fontSize);
            
       setFontArray(fontSize);
                    
       JPanel statusPanel = new JPanel();
       statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
       jframe.add(statusPanel, BorderLayout.SOUTH);
       statusPanel.setPreferredSize(new Dimension(jframe.getWidth(), 20));
       statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
               
            this.foreground = new JLabel(" • ");
            this.foreground.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(this.foreground);
            this.foreground.setVisible(false);
      
            foregroundSign = new JLabel(" foreground  ");
            foregroundSign.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(foregroundSign);
        
            this.background = new JLabel(" • ");
            this.background.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(this.background);
            this.background.setVisible(false);

            backgroundSign = new JLabel(" background   ");
            backgroundSign.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(backgroundSign);

            size = new JLabel(" size  ");
            size.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(size);
            size.setVisible(true);
            
            font = new JLabel();
            font.setHorizontalAlignment(SwingConstants.LEFT);
            statusPanel.add(font);
            font.setVisible(false);
            
            conditionLabel = new JLabel(condition.toString());
            conditionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            statusPanel.add(conditionLabel);

       jframe.pack();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        // set Foreground
		if(source == ForegroundButtonArray[0]) {
			textArea.setForeground(Color.GREEN);
			foreground.setForeground( Color.GREEN );
            foreground.setVisible(true);
		}

		else if(source == ForegroundButtonArray[1]) {
		    textArea.setForeground(Color.ORANGE);
		    foreground.setForeground( Color.ORANGE );
		    foreground.setVisible(true);
		}

		else if(source == ForegroundButtonArray[2]) {
			textArea.setForeground(Color.RED);
			foreground.setForeground( Color.RED );
			foreground.setVisible(true);
		}

		else if(source == ForegroundButtonArray[3]) {
            textArea.setForeground(Color.BLACK);
            foreground.setForeground(Color.BLACK);
            foreground.setVisible(true);
        }
                
		else if(source == ForegroundButtonArray[4]) {
			textArea.setForeground(Color.WHITE);
			foreground.setForeground( Color.WHITE );
			foreground.setVisible(true);
		}
                
		else if(source == ForegroundButtonArray[5]) {
			textArea.setForeground(Color.yellow);
			foreground.setForeground( Color.YELLOW );
			foreground.setVisible(true);
		}
                
		else if(source == ForegroundButtonArray[6]) {
			textArea.setForeground(Color.BLUE);
			foreground.setForeground( Color.BLUE );
			foreground.setVisible(true);
		}
                
        // set foreground
        else if(source == backgroundButtonArray[0]) {
            textArea.setBackground(Color.GREEN);
            background.setForeground( Color.GREEN );
            background.setVisible(true);
        }

        else if(source == backgroundButtonArray[1]) {
            textArea.setBackground(Color.ORANGE);
            background.setForeground( Color.ORANGE );
            background.setVisible(true);
        }

		else if(source == backgroundButtonArray[2]) {
			textArea.setBackground(Color.RED);
			background.setForeground( Color.RED );
			background.setVisible(true);
		}

		else if(source == backgroundButtonArray[3]) {
			textArea.setBackground(Color.BLACK);
			background.setForeground( Color.BLACK);
			background.setVisible(true);
		}
                
		else if(source == backgroundButtonArray[4]) {
			textArea.setBackground(Color.WHITE);
			background.setForeground( Color.WHITE );
			background.setVisible(true);
		}
                
		else if(source == backgroundButtonArray[5]) {
			textArea.setBackground(Color.yellow);
			background.setForeground( Color.YELLOW );
			background.setVisible(true);
		}
                
		else if(source == backgroundButtonArray[6]) {
			textArea.setBackground(Color.BLUE);
			background.setForeground( Color.BLUE );
			background.setVisible(true);
		}


		// set font
        else if (source == fontArray[0]) {
            Font font = new Font("Helvetica", Font.BOLD, 8);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("8");
            this.font.setVisible(true);
        }
                
                    
        else if (source == fontArray[1]) {
            Font font = new Font("Helvetica", Font.BOLD, 10);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("10");
            this.font.setVisible(true);
        }
           
        else if (source == fontArray[2]) {
            Font font = new Font("Helvetica", Font.BOLD, 12);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("12");
            this.font.setVisible(true);
        }
                
                    
        else if (source == fontArray[3]) {
            Font font = new Font("Helvetica", Font.BOLD, 14);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("14");
            this.font.setVisible(true);
        }
                
        else if (source == fontArray[4]) {
            Font font = new Font("Helvetica", Font.BOLD, 16);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("16");
            this.font.setVisible(true);
        }
                
                    
        else if (source == fontArray[5]) {
            Font font = new Font("Helvetica", Font.BOLD, 18);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("18");
            this.font.setVisible(true);
        }
                
        else if (source == fontArray[6]) {
            Font font = new Font("Helvetica", Font.BOLD, 20);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("20");
            this.font.setVisible(true);
        }
                
                    
        else if (source == fontArray[7]) {
            Font font = new Font("Helvetica", Font.BOLD, 22);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("22");
            this.font.setVisible(true);
        }
                
        else if (source == fontArray[8]) {
            Font font = new Font("Helvetica", Font.BOLD, 24);
            textArea.setFont(font);
            size.setVisible(false);
            this.font.setText("24");
            this.font.setVisible(true);
        }
                
        //open
        else if(source == open) {

            condition = Condition.New;
            conditionLabel.setText(condition.toString());

            try {
                String filepath ="C:\\Users\\Home\\Desktop\\javaZAD.txt";
                FileReader fileReader = new FileReader(filepath);
                jframe.setTitle(filepath);
                BufferedReader bufferReader = new BufferedReader(fileReader);
                String line;
   
                while((line = bufferReader.readLine()) != null) {
                    textArea.append(line + '\n');
                }
                fileReader.close();

            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
                    
        }
                
        //save
        else if(source == saveAs || source == save) {

            condition = Condition.Saved;
            conditionLabel.setText(condition.toString());

            try {
                String filepath ="C:\\Users\\Home\\Desktop\\javaZAD.txt";
                PrintWriter zapis = new PrintWriter(filepath);
                jframe.setTitle(filepath);
                zapis.println(textArea.getText());
                zapis.close();
            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            }
  
        }
                
        //exit
        else if (source == exit) {
            System.exit(0);
        }
                
        else if (source == work) {
            textArea.getCaretPosition();
            textArea.append("PJATK Student");
        }
                
        else if (source == university) {
            textArea.getCaretPosition();
            textArea.append("Koszykowa 86");
        }
                
        else if (source == home) {
            textArea.getCaretPosition();
            textArea.append("Ochota, Warszawa");
        }
                

    }
}
