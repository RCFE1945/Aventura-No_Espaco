package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Misseis {
	
	//ATRIBUTOS
	private Image imagem;
	private int x,y,cor;
	private int largura, altura;
	private boolean isVisivel;
	
	private static final int ALTURA_DA_TELA = 500;
	private static final int VELOCIDADE = 5;
	
	//CONTRUTOR
	public Misseis(int x,int y,int cor) {
		
		this.x = x;
		this.y = y;
		this.cor = cor;
		
		if(this.cor == 1 ) {
		
			ImageIcon referencia = new  ImageIcon("res\\missel_colorido02.gif");//padrao "res\\missel_azul01.png"
			imagem = referencia.getImage();
		}else {
			ImageIcon referencia = new  ImageIcon("res\\missel_colorido02.gif");
			imagem = referencia.getImage();
			
		}
		this.largura = imagem.getHeight(null);
		this.altura = imagem.getHeight(null);
		
		isVisivel= true;
		
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	public void mexer() {
		this.y -= VELOCIDADE;
		if(this.y > ALTURA_DA_TELA) {
			this.isVisivel = false;
		}
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isVisivel() {
		return isVisivel;
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,largura,altura);
		
	}

}
