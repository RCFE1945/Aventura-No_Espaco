package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class EspaçoNave{
	
	//ATRIBUTOS
	private int x,y;
	private int dx,dy;
	private int altura,largura;
	private boolean isVisivel;
	private List<Misseis> misseis;
	private int fj;
	private Image imagem;
	private int VELOCIDADE_EN;//VELOCIDADE_DA_NAVE
	
	private List<Especial> especial;

    //METOSO_CONSTRUTOR
	public EspaçoNave() {
		ImageIcon referencia = new ImageIcon("res\\NaveTeste.gif");
		imagem = referencia.getImage();
	
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	
		misseis = new ArrayList<Misseis>();
		
		especial = new ArrayList<Especial>();
	
		this.x = 250;
		this.y = 450;
		this.VELOCIDADE_EN = 4;
	}

	public int getVELOCIDADE_EN() {
		return VELOCIDADE_EN;
	}

	public void setVELOCIDADE_EN(int vELOCIDADE_EN) {
		this.VELOCIDADE_EN = vELOCIDADE_EN;
	}

	public int getFj() {
		return fj;
	}

	public void setFj(int fj) {
		this.fj = fj;
	}

	public void  mexer() {
		x += dx;//1 a 462
		y += dy;//1 a 340
		if(this.x < 11) {
			x = 11;
		}
		if(this.x > 457) {
			x = 457;
		}
		if(this.y < 9) {
			y = 9;
		}
		if(this.y > 445) {
			y = 445;
		}
	}
	
	public void turbo() {
		
		this.setVELOCIDADE_EN(8);
		
	}
	
	//ATIRA
	public void atira() {
		this.misseis.add(new Misseis(x + largura-largura +4 ,(y + altura  /2) -3 ,1));
		this.misseis.add(new Misseis(x + largura -5,(y + altura   /2)-3 ,0));
	}
	
	public void atira_especial() {
		
		this.especial.add(new Especial(x,altura +y,4));//de
		this.especial.add(new Especial(x + largura,y + altura,2));//dd
		this.especial.add(new Especial(x + (largura / 2),y + altura,1));//v
		this.especial.add(new Especial(x , y ,5));//he
		this.especial.add(new Especial(x + largura,y ,3));//hd
		
	}
	
	//ESPECIAL
	
	//MOVIMENTACAO
	public void KeyPressed(KeyEvent tecla) {
		
		//System.out.print(this.getVELOCIDADE_EN());
		
		int codigo = tecla.getKeyCode();
	
		if(codigo == KeyEvent.VK_P) {
			atira();
		}
		
		if((codigo == KeyEvent.VK_SHIFT)) {
			
			this.turbo();
			
		}
		
		if(codigo == KeyEvent.VK_O) {
			atira_especial();
		}
		
		if(codigo == (KeyEvent.VK_W + KeyEvent.VK_D)) {
			dy =-(getVELOCIDADE_EN());
			dx = (getVELOCIDADE_EN());
			
		}
		if(codigo == (KeyEvent.VK_W + KeyEvent.VK_A)) {
			dy = -(getVELOCIDADE_EN());
			dx = -(getVELOCIDADE_EN());
			
		}
		if(codigo == (KeyEvent.VK_S + KeyEvent.VK_A)) {
			dy =  (getVELOCIDADE_EN());
			dx = -(getVELOCIDADE_EN());
			
		}
		if(codigo == (KeyEvent.VK_S + KeyEvent.VK_D)) {
			dy = (getVELOCIDADE_EN());
			dx = (getVELOCIDADE_EN());
			
		}
	
		if(codigo == KeyEvent.VK_W) {
			dy = -(getVELOCIDADE_EN());
		}
	
		if(codigo == KeyEvent.VK_S) {
			
			dy = (getVELOCIDADE_EN());
		}
		if(codigo == KeyEvent.VK_A) {
			dx = -(getVELOCIDADE_EN());
		}
	
		if(codigo == KeyEvent.VK_D) {
			dx = (getVELOCIDADE_EN());
		}

		if(codigo == (KeyEvent.VK_W + KeyEvent.VK_D + KeyEvent.VK_P)) {
			atira();
			dy = -(getVELOCIDADE_EN());
			dx = (getVELOCIDADE_EN());
			
		}
		if(codigo == (KeyEvent.VK_W + KeyEvent.VK_A+ KeyEvent.VK_P)) {
			atira();
			dy = -(getVELOCIDADE_EN());
			dx = -(getVELOCIDADE_EN());
			
		}
		if(codigo == (KeyEvent.VK_S + KeyEvent.VK_A+ KeyEvent.VK_P)) {
			atira();
			dy =  (getVELOCIDADE_EN());
			dx = -(getVELOCIDADE_EN());
			
		}
		if(codigo == (KeyEvent.VK_S + KeyEvent.VK_D+ KeyEvent.VK_P)) {
			atira();
			dy = (getVELOCIDADE_EN());
			dx = (getVELOCIDADE_EN());
			
		}
	
		if(codigo == (KeyEvent.VK_W+ KeyEvent.VK_P)) {
			atira();
			dy = -(getVELOCIDADE_EN());
		}
	
		if(codigo == (KeyEvent.VK_S+ KeyEvent.VK_P)) {
			atira();
			dy = (getVELOCIDADE_EN());

		}
		if(codigo == (KeyEvent.VK_A+ KeyEvent.VK_P)) {
			atira();
			dx = -(getVELOCIDADE_EN());
		}
	
		if(codigo == (KeyEvent.VK_D+ KeyEvent.VK_P)) {
			atira();
			dx = (getVELOCIDADE_EN());
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		
		return imagem;
	}

	public void KeyReleased(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
	
		if(codigo == KeyEvent.VK_S) {
			dy = 0;
		
		}
		
		if((codigo == KeyEvent.VK_SHIFT)) {
			
			this.setVELOCIDADE_EN(4);
		}
		
		if(codigo == KeyEvent.VK_W){
			dy = 0;
		}
	
		if(codigo == KeyEvent.VK_A) {
			dx = 0;
		}
	
		if(codigo == KeyEvent.VK_D) {
			dx = 0;
		}
	
	}

	public List<Misseis> getMisseis() {
		return misseis;
	}
	
	public List<Especial> getEspecial() {
		return especial;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,largura,altura);
	
	}
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

}
