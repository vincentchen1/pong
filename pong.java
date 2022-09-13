import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pong extends Frame {
    
    //Variables for the ball
    int ballX = 350;
    int ballY = 250;
    int ballW = 50;
    int ballVx = 6;
    int ballVy = 6; 
    int ballAx = 6;
    int Paddle1X = 1;
    int Paddle1Y = 1;
    int PaddleW = 75;
    int Paddle2X = 1;
    int Paddle2Y = 1;
    int Paddle2W = 75;
    
    int p1Y = 0;
    int p1X = 0;
    int p1Vy = 0;
    
    //scoring variables
    int scoreP1 = 0;
    int scoreP2 = 0;
            
    /* paint is getting called roughly 60x per second */
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        g.setColor( new Color(0, 0, 0 )  );
        g.fillOval(0, 100, 300, 300);
        g.setColor( new Color(255, 0, 255)  );    
        g.fillOval(200,  200, 100, 100);        
        g.drawArc(75, 300, 150, 150, 0, 180);
        g.fillArc(75, 300, 150, 150, 0, 180);
        g.fillOval(0,  200, 100, 100);
        
        g.setColor( new Color(100, 10, 10));
        
        //paint the ping pong
        ballX = ballX + ballVx;
        ballY = ballY + ballVy;
        g.fillOval(ballX, ballY, ballW, ballW);
        
        if(ballX > 740) {
            ballVx = -ballVx;
        }
        if(ballX < 0) {
            ballVx = -ballVx;
        }
        if(ballY > 500) {
            ballVy = -ballVy;
        }
        if(ballY < 0) {
            ballVy = -ballVy;
        }
        
        if (ballX == p1X) {
            ballVx = -ballVx;
            ballVy = -ballVy;
        if (ballX == p1Y) {
            ballVx = -ballVx;
            ballVy = -ballVy;
            }
        }
        
        //Drawing the paddles
        //x,y (top left corner)
        //width and height
        g.fillRect(Paddle1X, Paddle1Y,  25, 100);
        //Drawing the right paddle
        g.fillRect(760, Paddle2Y, 25, 100);
        //Pong Collision Right
        if(ballX >= 740 && (ballY >= p1Y) && ballY <= Paddle1Y + 100) {
            ballVx = - ballVx;
        }
        
        if((ballY >= Paddle1Y + 55 || ballY <= Paddle1Y - 55) && ballX <= 0) {
            scoreP2 ++;
        }else if((ballY >= Paddle2Y + 55 || ballY <= Paddle2Y - 55) && ballX >= 740) {
            scoreP1 ++;
        }
        
        //Left Pong
        
    // set location limits
        if (Paddle1Y <= 0) {
            Paddle1Y = 0;
        }
        if(Paddle1Y >= 460) {
           Paddle1Y = 460;
        }
        if (Paddle2Y <= 0 ) {
            Paddle2Y = 0;
        }
        if (Paddle2Y >= 460) {
            Paddle2Y = 460;
        }
        
        //draw the score on the screen
        Font plainFont = new Font("Serif", Font.PLAIN, 36);
        g.setFont(plainFont);
        g.drawString(scoreP1 + "", 200, 100);
        g.drawString(scoreP2 + "", 550, 100);
    }
    
    
    public void keyPressed(KeyEvent arg0) {
        System.out.println(arg0.getKeyCode());
        //87 is the w key on the keyboard
        if (arg0.getKeyCode() == 87 ) { // 2 equals sign checks equality
            //code between curly runs if condition is true
            Paddle1Y -= 15;
        }
        
        //write a 2nd if statement
        //to detect the S key
        if( arg0.getKeyCode() == 83 ) { // 2 equals sign checks equality
            Paddle1Y += 15;
        }
            
        System.out.println(arg0.getKeyCode());
        //87 is the w key on the keyboard
        if (arg0.getKeyCode() == 38 ) { // 2 equals sign checks equality
            //code between curly runs if condition is true
            Paddle2Y -= 15;
        }
            
        //write a 2nd if statement
        //to detect the S key
        if( arg0.getKeyCode() == 40 ) { // 2 equals sign checks equality
            Paddle2Y += 15;
        }
    }


    public void keyReleased(KeyEvent arg0) {
        System.out.println(arg0.getKeyCode());
        
        //32 is space bar
        //random the velocity values of the ball
        //after pressing the space bar
        //make sure it's never zero in x or y
        //it should be possible to have negative velocities
        
        if (arg0.getKeyCode() == 32) {
            
        }
    }


    public void keyTyped(KeyEvent arg0) {
        
        
    }
    public static void main(String[] arg) {
    Pong p = new Pong();
    
    // Math.random() returns a decimal number in the range [0 1)
    double x = Math.random();
    
    //what if i want a number between 0 and 10? [0 10)
    int x2 = (int)(x*10); // (int) -> explicitly casting a non-integer val as an int
    
    //System.out.print(5/2); //implicit casting is when it's done automagically
    
    System.out.println(x2);
    
    // (int)(Math.random()*12);
    // whats the max number that can be produced?
    // what's the min number that can be produced?
    // min: 0
    // max: 11\
    
    // I want a  random # between 0 and 39 inclusive.
    // What's the line of code using Math.random() to generate this range of #s?
    
    // (int)(Math.random()*(range + 1)) + min
    // [2 7]
    // (int)(Math.random()*(6)) + 2
    
    // - and 2 [-5 2]
    //(int)(Math.random()*(2--5+1))-5
    }
    
}
