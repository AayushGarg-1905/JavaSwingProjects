import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorInSwing implements ActionListener {
    JFrame jf;
    JButton[]b;
    JButton AddB,SubB,MultiB,DivB,ClrB,EqB;
    JTextField tf;
    char operator;
    double num1=0,num2=0,result=0;
    CalculatorInSwing(){
        jf=new JFrame("Calculator");
        jf.setSize(500,500);

        // JTextField
        tf=new JTextField();
        tf.setBounds(50,20,150,20);

        // Jbuttons
        b=new JButton[10];

        // first row buttons
        b[0]=new JButton("0");
        b[0].setBounds(50,67,40,30);
        b[0].addActionListener(this);

        b[1]=new JButton("1");
        b[1].setBounds(90,67,40,30);
        b[1].addActionListener(this);
        b[2]=new JButton("2");
        b[2].setBounds(130,67,42,30);
        b[2].addActionListener(this);
        SubB =new JButton("-");
        SubB.setBounds(170,67,41,30);
        SubB.addActionListener(this);

        // second row buttons
        b[3]=new JButton("3");
        b[3].setBounds(50,96,40,30);
        b[3].addActionListener(this);
        b[4]=new JButton("4");
        b[4].setBounds(90,96,40,30);
        b[4].addActionListener(this);
        b[5]=new JButton("5");
        b[5].setBounds(130,96,42,30);
        b[5].addActionListener(this);
        DivB=new JButton("/");
        DivB.setBounds(170,96,41,30);
        DivB.addActionListener(this);


        // third row buttons
        b[6]=new JButton("6");
        b[6].setBounds(50,125,40,30);
        b[6].addActionListener(this);
        b[7]=new JButton("7");
        b[7].setBounds(90,125,40,30);
        b[7].addActionListener(this);
        b[8]=new JButton("8");
        b[8].setBounds(130,125,42,30);
        b[8].addActionListener(this);
        MultiB=new JButton("*");
        MultiB.setBounds(170,125,41,30);
        MultiB.addActionListener(this);


        // fourth row buttons
        b[9]=new JButton("9");
        b[9].setBounds(50,154,40,30);
        b[9].addActionListener(this);

        ClrB=new JButton("c");
        ClrB.setBounds(90,154,40,30);
        ClrB.addActionListener(this);

        EqB=new JButton("=");
        EqB.setBounds(130,154,42,30);
        EqB.addActionListener(this);

        AddB=new JButton("+");
        AddB.setBounds(170,154,41,30);
        AddB.addActionListener(this);


        // placing in frame
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(tf);
   for(int i=0;i<10;i++){
       jf.add(b[i]);
   }

        jf.add(AddB);
        jf.add(SubB);
        jf.add(MultiB);
        jf.add(DivB);
        jf.add(ClrB);
        jf.add(EqB);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++) {
            if(e.getSource() == b[i]) {
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==AddB) {
            num1 = Double.parseDouble(tf.getText());
            operator ='+';
            tf.setText("");
        }
        if(e.getSource()==SubB) {
            num1 = Double.parseDouble(tf.getText());
            operator ='-';
            tf.setText("");
        }
        if(e.getSource()==MultiB) {
            num1 = Double.parseDouble(tf.getText());
            operator ='*';
           tf.setText("");
        }
        if(e.getSource()==DivB) {
            num1 = Double.parseDouble(tf.getText());
            operator ='/';
            tf.setText("");
        }
        if(e.getSource()==EqB) {
            num2=Double.parseDouble(tf.getText());

            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }

            if(num2==0 && operator=='/'){
                tf.setText("Invalid");
            }
            else{
                tf.setText(String.valueOf(result));
                num1=result;
            }

        }
        if(e.getSource()==ClrB) {
            tf.setText("");
        }
    }
    public static void main(String[] args) {
new CalculatorInSwing();
    }
}
