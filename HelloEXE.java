import javax.swing.*;
import java.awt.*;

public class HelloEXE {
    static boolean buttonClicked = false;

    public static void main(String[] args) {
        // Run GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello.EXE");
            frame.setIconImage(new ImageIcon("world.png").getImage());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null); // Center on screen
            
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Hello, World! Yeah...");
            JButton button = new JButton("Button");

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            // make the button work!
            button.addActionListener(e -> {
                if (!buttonClicked) {
                    buttonClicked = true;
                    label.setText("Button clicked!");
                }
                else {
                    buttonClicked = false;
                    label.setText("Oh! You clicked the button again!");
                }
            });

            
            panel.add(label);
            panel.add(button);
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}

// how do make the exe????
// 1. run 
//    javac HelloEXE.java 
//    to compile this baby and make the .class file

// 2. run 
//    jar --create --file HelloEXE.jar --main-class HelloEXE HelloEXE.class 
//    to make the .jar file...

// 3. put the jar in its own folder (input) then run...
//    jpackage --input input --name HelloEXE --main-jar HelloEXE.jar --main-class HelloEXE --type app-image
