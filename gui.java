import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class gui extends JFrame {
    
    private JPanel mainMenu;
    private JPanel startGame;
    private JPanel credits;
    private JPanel highscore;
    private JPanel options;
    private JPanel UI;

    private static int initialSpeed =0;
    private static int speedCap =0;
    private static String lineCap ="0";
    private static int gameStyle =-1;
    private static String alghorhtmType=null;

    private static final String[] PHOTOS_NAME_STRINGS = {"placeholder1.png"}; 
    private static final String[] PHOTOS_DESCRIPTION_STRINGS = {"placeholder1"};
    private static final Integer[] INITIAL_SPEED_INTEGERS = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; 
    private static final Integer[] SPEED_CAP_INTEGERS = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; 
    private static final String[] LINE_CAP_STRINGS = {"150","300","No Cap"}; 
    private static final String[] ALGORITHM_TYPES_STRINGS = {"placeholder1","placeholder2","placeholder3"}; 


    gui(){
        this.setTitle("Pentomino-style Tetris");
        this.setSize(850,400);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        uiInit();
        mainMenuInit();
        startGameInit();
        creditsInit();
        highscoreInit();
        optionsInit();

        showMainMenu();
        this.setVisible(true);

    }

    

    private void mainMenuInit() {
        mainMenu= new JPanel();
        mainMenu.setLayout(new GridLayout(0,5,5,5));
        JLabel logoLabel = new JLabel(new ImageIcon("logo.png"));

        JButton startGameButton = new JButton("Start Game");
        JButton creditsButton = new JButton("Credits");
        JButton highscoreButton = new JButton("Highscore");
        JButton exitButton = new JButton("Exit");

        startGameButton.setFocusable(false);
        creditsButton.setFocusable(false);
        highscoreButton.setFocusable(false);
        exitButton.setFocusable(false);

        startGameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showStartGame();
            }
            
        });
        creditsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showCredits();
            }
            
        });
        highscoreButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showHighscore();
            }
            
        });
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(-1);
            }
            
        });
        mainMenu.add(logoLabel);
        mainMenu.add(startGameButton);
        mainMenu.add(creditsButton);
        mainMenu.add(highscoreButton);
        mainMenu.add(exitButton);

        add(mainMenu);

    }

    
    private void startGameInit() {
        startGame= new JPanel();
        startGame.setLayout(new GridLayout());
        JRadioButton playerButton = new JRadioButton("Human Player");
        JRadioButton botButton = new JRadioButton("Bot Player");
        ButtonGroup playerSelectionGroup = new ButtonGroup();
        // playerButton.setPreferredSize(new Dimension(150,75));
        // botButton.setPreferredSize(new Dimension(150,75));
        playerSelectionGroup.add(playerButton);
        playerSelectionGroup.add(botButton);
        playerButton.setFocusable(false);
        botButton.setFocusable(false);
        JComboBox _algorithmType = new JComboBox<>(ALGORITHM_TYPES_STRINGS);
        // algorithmType.setPreferredSize(new Dimension(150,75));
        _algorithmType.setVisible(false);

        JButton acceptButton = new JButton("Confirm");
        // acceptButton.setPreferredSize(new Dimension(150,75));
        startGame.add(playerButton);
        startGame.add(botButton);
        startGame.add(_algorithmType);
        startGame.add(acceptButton);
        
        _algorithmType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                alghorhtmType=(String) _algorithmType.getSelectedItem();
            }
        });
        
        playerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerButton.isSelected()==true)
                {
                    _algorithmType.setVisible(false);
                }
          }
            
        });

        botButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (botButton.isSelected()) {
                    _algorithmType.setVisible(true);
                }
            }
        });
        acceptButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(playerButton.isSelected()==true)
                {
                    gameStyle=1;
                    showOptions();
                }
                else if(botButton.isSelected()==true)
                {
                    gameStyle=2;
                    showOptions();
                }
               
                else
                {
                    JOptionPane.showMessageDialog(startGame, "Please select a playing style.");
                }
            }
            
        });
//        this.pack();
    }

    private void optionsInit(){
        options= new JPanel();
        options.setLayout(new GridLayout(0,2));
        JComboBox _initialSpeed = new JComboBox<>(INITIAL_SPEED_INTEGERS);
        JComboBox _speedCap = new JComboBox<>(SPEED_CAP_INTEGERS);
        JComboBox _lineCap = new JComboBox<>(LINE_CAP_STRINGS);
        JButton confirmButton = new JButton("Confirm");
        
        JLabel label1 = new JLabel("Initial Speed:");
        JLabel label2 = new JLabel("Speed Cap:");
        JLabel label3 = new JLabel("Line Cap:");

        options.add(label1);
        options.add(_initialSpeed);
        options.add(label2);
        options.add(_speedCap);
        options.add(label3);
        options.add(_lineCap);
        options.add(new Label("Confirm button ->"));
        options.add(confirmButton);
//        this.pack();
        _initialSpeed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                initialSpeed=(int) _initialSpeed.getSelectedItem();
            }
        });
        _speedCap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speedCap=(int) _speedCap.getSelectedItem();
            }
        });
        _lineCap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineCap=(String) _lineCap.getSelectedItem();
            }
        });

        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showTetrisUI();
            }
            
        });
    }

    private void creditsInit() {
        credits = new JPanel();
        credits.setBackground(new Color(0xFAF0E6));

        JPanel photos = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        for(int i=0;i<PHOTOS_NAME_STRINGS.length;i++)
        {
            ImageIcon iconPhoto = new ImageIcon(PHOTOS_NAME_STRINGS[i]);
            JLabel photoLabel = new JLabel(iconPhoto);
            photoLabel.setBorder(new LineBorder(Color.black));

            JLabel textLabel = new JLabel(PHOTOS_DESCRIPTION_STRINGS[i]);

            JPanel photoPanel = new JPanel();

            photoPanel.setLayout(new BoxLayout(photoPanel, BoxLayout.Y_AXIS));
            photoPanel.add(photoLabel);
            photoPanel.add(textLabel);

            photos.add(photoPanel);
        }
        
        credits.add(photos);

        JButton goBack = new JButton("Go back");
        goBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
            
        });
        credits.add(goBack);

    }
    private void highscoreInit() {
        highscore = new JPanel();  
        JButton goBack = new JButton("Go back");
        goBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
            
        });
        highscore.add(goBack);
    }
    private void uiInit(){
        UI = new JPanel();
        UI.add(new JLabel(" tetris game placeholder"));
    }
    
    
    private void showOptions(){
        this.setContentPane(options);
        this.revalidate();
        this.repaint();
    }
    private void showStartGame() {
        this.setContentPane(startGame);
        this.revalidate();
        this.repaint();
    }
    /* frame.remove(currentScene);
        currentScene = newScene;
        frame.add(currentScene, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint(); */
    private void showMainMenu() {
        this.setContentPane(mainMenu);
        this.revalidate();
        this.repaint();
    }
    private void showCredits() {
        this.setContentPane(credits);
        this.revalidate();
        this.repaint();
    }
    private void showHighscore() {
        this.setContentPane(highscore);
        this.revalidate();
        this.repaint();
    }
    private void showTetrisUI(){
        this.setContentPane(UI);
        this.revalidate();
        this.repaint();
    }

}
