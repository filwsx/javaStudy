package cell;

import javax.swing.*;

public class CellMachine {

	public static void main(String[] args) {

		// 初始化细胞机，cell填充表
		Field field = new Field(30,30);
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				field.place(row, col, new Cell());
			}
		}

		// 随机复活约1/5的cell
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				Cell cell = field.get(row, col);
				if ( Math.random() < 0.2 ) {
					cell.reborn();
				}
			}
		}

		//图形界面初始化
		View view = new View(field);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);

		// 细胞机更新1000次
		for ( int i=0; i<1000; i++ ) {
			// 遍历表格，查看邻近细胞存活情况来决定生死
			for ( int row = 0; row<field.getHeight(); row++ ) {
				for ( int col = 0; col<field.getWidth(); col++ ) {
					Cell cell = field.get(row, col);
					Cell[] neighbour = field.getNeighbour(row, col);
					int numOfLive = 0;
					for ( Cell c : neighbour ) {
						if ( c.isAlive() ) {
							numOfLive++;
						}
					}
					if ( cell.isAlive() ) {
						if ( numOfLive <2 || numOfLive >3 ) {
							cell.die();
						}
					} else if ( numOfLive == 3 ) {
						cell.reborn();
					}
				}
			}
			frame.repaint();
			// 延迟，从而可以观察
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
