import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameTest {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(new FlowLayout());
		Button button = new Button("button");
		frame.add(button);
		frame.setVisible(true);
		
		/*frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});*/
/*		
		button.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
*/		
		/*button.addMouseListener(new MouseAdapter() {
			int count=0;
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println(count++);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				System.out.println(count++);
			}
		});
		*/
		
		
		
		
		button.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				System.out.println(e.getKeyCode());
			}
			
		});
		
		
		
	}
}
