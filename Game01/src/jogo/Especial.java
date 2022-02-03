package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Especial  {
	
	//ATRIBUTOS
		private Image imagem;
		private int x,y,num;
		private int largura, altura;
		private boolean isVisivel;
		
		private static final int ALTURA_DA_TELA = 500;
		private static final int LARGURA_DA_TELA = 520;
		private static final int VELOCIDADE = 5;
		
		//CONTRUTOR
		public Especial(int x,int y,int num) {
			
			this.x = x;
			this.y = y;
			//this.cor = cor;
			
			if(num == 1) {
				
				ImageIcon referencia = new  ImageIcon("res\\missel_azul01.png");//padrao "res\\missel_azul01.png"
				imagem = referencia.getImage();
				
			}if(num == 2) {
				
				ImageIcon referencia = new  ImageIcon("res\\missel_amarelo01.png");//padrao "res\\missel_azul01.png"
				imagem = referencia.getImage();	
				
			}if(num == 3){
				
				ImageIcon referencia = new  ImageIcon("res\\missil_01rosa.png");//padrao "res\\missel_azul01.png"
				imagem = referencia.getImage();
				
			}if(num == 4) {
				
				ImageIcon referencia = new  ImageIcon("res\\missel_amarelo01.png");//padrao "res\\missel_azul01.png"
				imagem = referencia.getImage();	
				
			}if(num == 5) {
				
				ImageIcon referencia = new  ImageIcon("res\\missel_01rosa.png");//padrao "res\\missel_azul01.png"
				imagem = referencia.getImage();	
				
			}
			
			/*
			if(this.cor == 1 ) {
			
				ImageIcon referencia = new  ImageIcon("res\\missel_colorido02.gif");//padrao "res\\missel_azul01.png"
				imagem = referencia.getImage();
			}else {
				ImageIcon referencia = new  ImageIcon("res\\missel_colorido02.gif");
				imagem = referencia.getImage();
				
			}*/
			this.largura = imagem.getHeight(null);
			this.altura = imagem.getHeight(null);
			
			isVisivel= true;
			
		}
		
		public void setVisivel(boolean isVisivel) {
			this.isVisivel = isVisivel;
			
		}
		public void mexer (int num){
			
			this.num = num;
			switch (num){
				
			case 1:
				// Missel vertival de String = v  1
				
				this.y -= VELOCIDADE;
				if(this.y > ALTURA_DA_TELA) {
					this.isVisivel = false;
				}
				break;
			
			case 2:
				
				//Missel vertical para esquerda de String = ve  2
				
				this.x -= VELOCIDADE;
				this.y += VELOCIDADE;
				if(this.x < 0 || this.y > ALTURA_DA_TELA) {
					this.isVisivel = false;
				}
				break;
				
			case 3:
				
				//missel horizontal esquerda de String = de  3
				
				this.x -= VELOCIDADE;
				if(this.x < 0) {
					this.isVisivel = false;
				}
				break;
			
			case 4:
				
				//Missel vertical para direita de String = vd   4
				
				this.x += VELOCIDADE;
				this.y += VELOCIDADE;
				if(this.x > LARGURA_DA_TELA || this.y > ALTURA_DA_TELA) {
					this.isVisivel = false;
				}
				break;
			
			case 5:
				
				//missel horizontal direita de String = dd   5
				
				this.x += VELOCIDADE;
				if(this.x > LARGURA_DA_TELA) {
					this.isVisivel = false;
				}
				break;
				
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
