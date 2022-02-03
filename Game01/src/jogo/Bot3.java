package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bot3 {
	
	//ATRIBUTOS
	private Image imagem;
	private int x,y;
	private int largura,altura;
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	private boolean isVisivel;
	private static final int LARGURA_DA_TELA = 500;
	private static final int ALTURA_DA_TELA = 0;
	private static final int VELOCIDADE = 2;//modificado padrao = 2
	
	//METODO_CONSTRUTOR
	public Bot3(int x,int y) {
		
		this.x = x;
		this.y = y;
		ImageIcon referencia = new  ImageIcon("res\\NaveTesteInimigo03.gif");
		imagem = referencia.getImage();
		isVisivel= true;
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
		
	}
	
	//MOVIMENTACAO
	public void mexer2() {
		
		if(this.y > 500) {
			this.y = ALTURA_DA_TELA;
		}else {
			this.y += VELOCIDADE;         
		}
		if(this.x < 0) {
			this.x = LARGURA_DA_TELA;
			
		}else {
			this.x -= VELOCIDADE;
		}
		
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
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
