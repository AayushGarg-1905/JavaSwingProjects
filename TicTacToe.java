import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToe implements ActionListener {
    JFrame jf;
    JButton[]b;
    JLabel l;
    int chance_flag = 0;  // to count the number of chances
    boolean pl1_chance;
    TicTacToe(){
        jf=new JFrame("TicTacToe");
        jf.setSize(500,500);

        l= new JLabel();
        l.setBounds(100,10,100,25);

        // Jbuttons
        b=new JButton[9];

        b[0]=new JButton();
        b[0].setBounds(50,60,60,60);
        b[0].addActionListener(this);

        b[1]=new JButton();
        b[1].setBounds(110,60,60,60);
        b[1].addActionListener(this);

        b[2]=new JButton();
        b[2].setBounds(170,60,60,60);
        b[2].addActionListener(this);

        b[3]=new JButton();
        b[3].setBounds(50,120,60,60);
        b[3].addActionListener(this);

        b[4]=new JButton();
        b[4].setBounds(110,120,60,60);
        b[4].addActionListener(this);

        b[5]=new JButton();
        b[5].setBounds(170,120,60,60);
        b[5].addActionListener(this);

        b[6]=new JButton();
        b[6].setBounds(50,180,60,60);
        b[6].addActionListener(this);

        b[7]=new JButton();
        b[7].setBounds(110,180,60,60);
        b[7].addActionListener(this);

        b[8]=new JButton();
        b[8].setBounds(170,180,60,60);
        b[8].addActionListener(this);

        // placing in frame
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(l);
        for(int i=0;i<9;i++){
            jf.add(b[i]);
        }

        // initial turn of player
        l.setText("Player X turn");
        pl1_chance=true;
    }
    public void matchCheck() {
        if ((b[0].getText() == "X") && (b[1].getText() == "X") && (b[2].getText() == "X")) {
            xWins();
        } else if ((b[0].getText() == "X") && (b[4].getText() == "X") && (b[8].getText() == "X")) {
            xWins();
        } else if ((b[0].getText() == "X") && (b[3].getText() == "X") && (b[6].getText() == "X")) {
            xWins();
        } else if ((b[1].getText() == "X") && (b[4].getText() == "X") && (b[7].getText() == "X")) {
            xWins();
        } else if ((b[2].getText() == "X") && (b[4].getText() == "X") && (b[6].getText() == "X")) {
            xWins();
        } else if ((b[2].getText() == "X") && (b[5].getText() == "X") && (b[8].getText() == "X")) {
            xWins();
        } else if ((b[3].getText() == "X") && (b[4].getText() == "X") && (b[5].getText() == "X")) {
            xWins();
        } else if ((b[6].getText() == "X") && (b[7].getText() == "X") && (b[8].getText() == "X")) {
            xWins();
        } else if ((b[0].getText() == "O") && (b[1].getText() == "O") && (b[2].getText() == "O")) {
            oWins();
        } else if ((b[0].getText() == "O") && (b[3].getText() == "O") && (b[6].getText() == "O")) {
            oWins();
        } else if ((b[0].getText() == "O") && (b[4].getText() == "O") && (b[8].getText() == "O")) {
            oWins();
        } else if ((b[1].getText() == "O") && (b[4].getText() == "O") && (b[7].getText() == "O")) {
            oWins();
        } else if ((b[2].getText() == "O") && (b[4].getText() == "O") && (b[6].getText() == "O")) {
            oWins();
        } else if ((b[2].getText() == "O") && (b[5].getText() == "O") && (b[8].getText() == "O")) {
            oWins();
        } else if ((b[3].getText() == "O") && (b[4].getText() == "O") && (b[5].getText() == "O")) {
            oWins();
        } else if ((b[6].getText() == "O") && (b[7].getText() == "O") && (b[8].getText() == "O")) {
            oWins();
        } else if (chance_flag == 9) {
            l.setText("Game Draw!!");
            for(int i=0;i<9;i++){
                b[i].setEnabled(false);
            }
        }
    }
    public void xWins()
    {
        for (int i = 0; i < 9; i++)
        {
            b[i].setEnabled(false);
        }
        l.setText("Player X wins");
    }
    public void oWins()
    {
        for (int i = 0; i < 9; i++)
        {
            b[i].setEnabled(false);
        }
        l.setText("Player O Wins");
    }

    public void actionPerformed(ActionEvent e){
                for(int i=0;i<9;i++){
                    if(e.getSource()==b[i]){
                        if(pl1_chance){
                            if(b[i].getText()==""){
                                b[i].setText("X");
                                pl1_chance=false;
                                l.setText("Player O turn");
                                chance_flag++;
                                if(chance_flag>=5){
                                    matchCheck();
                                }

                            }
                        }

                        else{
                            if(b[i].getText()==""){
                                b[i].setText("O");
                                pl1_chance=true;
                                l.setText("Player X turn");
                                chance_flag++;
                                if(chance_flag>=5){
                                    matchCheck();
                                }
                            }
                        }

                    }
                }
            }

    public static void main(String[] args) {
        new TicTacToe();
    }


}
