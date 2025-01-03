import javax.swing.*;//Contains useful methods for creating GUI
import java.awt.*;//Contains useful methods for doing something when GUI is interacted with
import java.awt.event.*;

public class Main implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numButtons = new JButton[10];
    JButton[] operButtons=new JButton[13];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton,sqrButton,pwrButton,tempButton,temp2Button;
    JPanel panel;
    
    

    Font myFont = new Font("sans-serif",Font.BOLD,18);

    double num1=0,num2=0,result=0;
    String error1="Div By Zero Error";
    char operator;
    
    Main(){
        //Creating the Frame
        frame =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,650);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        //Creating The Textfield
        textfield=new JTextField();
        textfield.setBounds(50,25,400,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //Creating all the number and operation buttons
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("DEL");
        clrButton=new JButton("CLR");
        negButton=new JButton("(-)");
        sqrButton=new JButton("sqr()");
        pwrButton=new JButton("^");
        tempButton=new JButton("");
        temp2Button=new JButton("");





        operButtons[0]=addButton;
        operButtons[1]=subButton;
        operButtons[2]=mulButton;
        operButtons[3]=divButton;
        operButtons[4]=decButton;
        operButtons[5]=equButton;
        operButtons[6]=delButton;
        operButtons[7]=clrButton;
        operButtons[8]=negButton;
        operButtons[9]=sqrButton;
        operButtons[10]=pwrButton;
        operButtons[11]=tempButton;
        operButtons[12]=temp2Button;

        

        //Formatting the Buttons and adding ActionListener
        for(int i=0;i<operButtons.length;i++){
            operButtons[i].addActionListener(this);
            operButtons[i].setFont(myFont);
            operButtons[i].setFocusable(false);
            operButtons[i].setForeground(Color.WHITE);
            operButtons[i].setBackground(Color.DARK_GRAY);
        }
        for(int i=0;i<10;i++){
            numButtons[i]=new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
            numButtons[i].setForeground(Color.WHITE);
            numButtons[i].setBackground(Color.DARK_GRAY);
        }
        negButton.setBounds(75,530,100,50);
        delButton.setBounds(200,530,100,50);
        clrButton.setBounds(325,530,100,50);


        // Creating the panel to hold the buttons
        panel=new JPanel();
        panel.setBounds(50,100,400,400);
        panel.setLayout(new GridLayout(4,5,5,5));
        panel.setBackground(Color.BLACK);
        //Adding buttons to Panel
        panel.add(sqrButton);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(pwrButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(tempButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(temp2Button);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        
        
        
        //Adding all elements to frame making them visble
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Main calc=new Main();
    }
    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++){
            if(e.getSource()==numButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat(String.valueOf(".")));
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        if(e.getSource()==pwrButton){
            num1 = Double.parseDouble(textfield.getText());
            operator='^';
            textfield.setText("");
        }
        if(e.getSource()==sqrButton){
            textfield.setText(textfield.getText()+"sqrt(");
            operator ='s';
            
        }
       
        if(e.getSource()==equButton){
            switch (operator) {
                case ('+'):
                    num2=Double.parseDouble(textfield.getText());
                    result=num1+num2;
                    textfield.setText(String.valueOf(result));
                    break;
                case ('-'):
                    num2=Double.parseDouble(textfield.getText());
                    result=num1-num2;
                    textfield.setText(String.valueOf(result));
                    break;
                case ('*'):
                    num2=Double.parseDouble(textfield.getText());
                    result=num1*num2;
                    textfield.setText(String.valueOf(result));
                    break;
                case('/'):
                    num2=Double.parseDouble(textfield.getText());
                    if(num2==0.0){
                        textfield.setText(error1);
                    }
                    else{
                        result=num1/num2;
                        textfield.setText(String.valueOf(result));
                    }
                    break;
                case('^'):
                    num2=Double.parseDouble(textfield.getText());
                    result=Math.pow(num1,num2);
                    textfield.setText(String.valueOf(result));
                    break;
                case('s'):
                    num2 =Double.parseDouble(textfield.getText().substring(5));
                    result=Math.sqrt(num2);
                    textfield.setText(String.valueOf(result));
                    break;
                default:         
                    break;
                }
            num1=result;
        }
        if(e.getSource()==clrButton){
            textfield.setText("");
        }
        if(e.getSource()==delButton){
            String string = textfield.getText();
            textfield.setText("");
            for (int i=0; i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            textfield.setText(textfield.getText()+"-");
        }       
    }
}

