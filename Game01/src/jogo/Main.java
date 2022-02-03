package jogo;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	//ATRIBUTOS
	private static final long serialVersionUID = 1L;

	//METODO_CONSTRUTOR
	public Main() {
		
	add(new Level());
	setTitle("Aventura no espaço");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,520);//padrao 500,520
	setResizable(false);//padrao = false
	setLocationRelativeTo(null);
	setVisible(true);
	}
	
	public static void main(String args[]) {
		
		new Main();
	}
	
}

//828