import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Game {

    public static final int btnSize = 100;

    private JFrame frame;
    private final int width, height;

    private ArrayList<Component> menuComponents;
    private ArrayList<Component> gameComponents;

    private boolean isEnded;;
    private boolean isPlayersTurn;
    private int sum = 0;

    public Game(int width, int height){
        this.width = width;
        this.height = height;
        this.frame = new JFrame();

        menuComponents = new ArrayList<Component>();
        gameComponents = new ArrayList<Component>();

        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
    }

    public void run(){
        initComponents();
        mainMenu();
    }

    private void mainMenu(){
        System.out.println("in main menu");
        isEnded = false;
        for(Component c : menuComponents) c.setVisible(true);
        for(Component c : gameComponents) c.setVisible(false);
    }

    private void playGame(){
        System.out.println("in game");
        for(Component c : menuComponents) c.setVisible(false);
        for(Component c : gameComponents) c.setVisible(true);
    }

    private void initComponents(){
        //
        //  Main menu
        //
        JLabel whoGoesFirst = new JLabel("Who will go first?", SwingConstants.CENTER);
        JButton playerBtn = new JButton("Me");
        JButton aiBtn = new JButton("Computer");
        whoGoesFirst.setBounds(0, 100, frame.getWidth(), 100);
        playerBtn.setBounds(100,350, btnSize, btnSize);
        aiBtn.setBounds(300, 350, btnSize, btnSize);

        menuComponents.add(whoGoesFirst);
        menuComponents.add(playerBtn);
        menuComponents.add(aiBtn);

        playerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPlayersTurn = true;
                playGame();
            }
        });
        aiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPlayersTurn = false;
                playGame();
            }
        });

        frame.add(whoGoesFirst);
        frame.add(playerBtn);
        frame.add(aiBtn);
    }

    private void makeTurn(int number){
        sum += number;
    }

    public boolean getEnded(){
        return isEnded;
    }

    public void resetGame(){
        isEnded = false;
        sum = 0;
        mainMenu();
    }
}