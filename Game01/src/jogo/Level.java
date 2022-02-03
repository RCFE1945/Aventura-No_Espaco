package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level extends JPanel implements ActionListener {
	
	//ATRIBUTOS 
	private static final long serialVersionUID = 1L;
	private Image image;
	private EspaçoNave ave;
	private Timer timer;
	private boolean emJogo;
	private List<Bot2> inimigos2;
	private List<Bot3> inimigos3;
	private List<Bot> inimigos;
	private Random s;
	private int numInim = 30;//Padrao = 30 
		
	//CONSTRUTOR
	public Level() {
		
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon fundo = new ImageIcon("res\\fundo_anima.gif");//MODIFICADO 
		image = fundo.getImage();
		addKeyListener(new TecladoAdapter());
		ave = new EspaçoNave();
		emJogo = true;
		inicializaInimigos();
		timer = new Timer(16, this);//Padrao = 20
		timer.start();
	
	}
	
	//INIMIGOS
	public void inicializaInimigos() {
		
		inimigos2 = new ArrayList<Bot2>();
		inimigos = new ArrayList<Bot>();
		inimigos3 = new ArrayList<Bot3>();		
		s = new Random();
		
		
		for (int ii = 0; ii < numInim; ii++) {
			
			int a  = -(s.nextInt(500));   
			int e = -(s.nextInt(500));
			inimigos2.add(new Bot2(a,e));
		}
		for (int iii = 0; iii < numInim; iii++) {
			
			int aa  = (s.nextInt(500)+500);   
			int ea = -(s.nextInt(500));
			inimigos3.add(new Bot3(aa,ea));
		}

		for (int i = 0; i < numInim; i++) {
			int as  = (s.nextInt(475));   
			int es = -(s.nextInt(500));
			inimigos.add(new Bot(as,es));
		}

	}
	
	//PINTAR_NA_TELA 
	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(image, 0, 0, null);
		
		if (emJogo) {

			graficos.drawImage(ave.getImagem(), ave.getX(), ave.getY(), this);

			List<Misseis> misseis = ave.getMisseis();
			for (int ij = 0; ij < misseis.size(); ij++) {

				Misseis m = (Misseis) misseis.get(ij);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}
			
			List<Especial> especial = ave.getEspecial();
			for (int ic = 0; ic < especial.size(); ic++) {
				Especial c = (Especial) especial.get(ic);
				graficos.drawImage(c.getImagem(), c.getX(), c.getY(), this);
				
			}
			for (int ir = 0; ir < inimigos2.size(); ir++) {

				Bot2 imw = inimigos2.get(ir);
				graficos.drawImage(imw.getImagem(), imw.getX(), imw.getY(), this);
			}
			for (int ir = 0; ir < inimigos3.size(); ir++) {

				Bot3 imw = inimigos3.get(ir);
				graficos.drawImage(imw.getImagem(), imw.getX(), imw.getY(), this);
			}
			for (int iii = 0; iii < inimigos.size(); iii++) {

				Bot im = inimigos.get(iii);
				graficos.drawImage(im.getImagem(), im.getX(), im.getY(), this);
			}
			
			graficos.setColor(Color.WHITE);
			int tot = inimigos.size() + inimigos2.size() + inimigos3.size();
			graficos.drawString("Inimigos  = " + tot,5 , 15);
			
		}else {
			
			if(ave.getFj() == 1) {
				ImageIcon fimJogo = new ImageIcon("res\\you_won02.png");
				graficos.drawImage(fimJogo.getImage(), 0, 0,null);
			}else {
				ImageIcon fimJogo1 = new ImageIcon("res\\you_failed03.png");
				graficos.drawImage(fimJogo1.getImage(), 0, 0,null);
			}
			
		}
		
		g.dispose();
		
	}
	//REGRA_DO_JOGO
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if ((inimigos2.size() == 0) && (inimigos3.size() == 0) && (inimigos.size() == 0) &&(ave.isVisivel() == true) ){
			emJogo = false;
			ave.setFj(0);
		}else {
			if((inimigos2.size() == 0) && (inimigos3.size() == 0) && (inimigos.size() == 0) &&(ave.isVisivel() == false) ) {
			ave.setFj(1);
			emJogo = false;
			}
		}
		
		List<Misseis> misseis = ave.getMisseis();
		for (int i = 0; i < misseis.size(); i++) {
			Misseis m = (Misseis) misseis.get(i);

			if (m.isVisivel()) {
				m.mexer();
			} else {
				misseis.remove(i);
			}
		}
		
		List<Especial> especial1 = ave.getEspecial();
		for (int i = 0; i < especial1.size(); i++) {
			Especial m = (Especial) especial1.get(i);

			if (m.isVisivel()) {
				m.mexer(1);
			} else {
				especial1.remove(i);
			}
		}
		
		List<Especial> especial2 = ave.getEspecial();
		for (int i = 0; i < especial2.size(); i++) {
			Especial m = (Especial) especial2.get(i);

			if (m.isVisivel()) {
				m.mexer(2);
			} else {
				especial2.remove(i);
			}
		}
		
		List<Especial> especial3 = ave.getEspecial();
		for (int i = 0; i < especial3.size(); i++) {
			Especial m = (Especial) especial3.get(i);

			if (m.isVisivel()) {
				m.mexer(3);
			} else {
				especial3.remove(i);
			}
		}
		List<Especial> especial4 = ave.getEspecial();
		for (int i = 0; i < especial4.size(); i++) {
			Especial m = (Especial) especial4.get(i);

			if (m.isVisivel()) {
				m.mexer(4);
			} else {
				especial4.remove(i);
			}
		}
		List<Especial> especial5 = ave.getEspecial();
		for (int i = 0; i < especial5.size(); i++) {
			Especial m = (Especial) especial5.get(i);

			if (m.isVisivel()) {
				m.mexer(5);
			} else {
				especial5.remove(i);
			}
		}
		
		
		for (int ic = 0; ic < inimigos2.size(); ic++) {
			Bot2 im = inimigos2.get(ic);

			if (im.isVisivel()) {
				im.mexer2();
			} else {
				inimigos2.remove(ic);
			}
		}
		for (int ic = 0; ic < inimigos3.size(); ic++) {
			Bot3 im = inimigos3.get(ic);

			if (im.isVisivel()) {
				
				im.mexer2();
			} else {
				inimigos3.remove(ic);
			}
		}
		for (int iij = 0; iij < inimigos.size(); iij++) {
			Bot iim = inimigos.get(iij);

			if (iim.isVisivel()) {
				iim.mexer();
			} else {
			
				inimigos.remove(iij);
			}
		}
		ave.mexer();
		checarColisoes();
		repaint();
		
	}
	
	//COMANDOS_DO_TECLADO
	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				emJogo = true;
				ave = new EspaçoNave();
				inicializaInimigos();																					
			}
			ave.KeyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {   
			ave.KeyReleased(e);
		}

	}
	
	//CHECAR_AS_COLISÕES
	public void checarColisoes() {

		Rectangle formaNave = ave.getBounds();
		Rectangle formaInimigo;
		Rectangle formaInimigo2;
		Rectangle formaMissel;
		Rectangle formaEspecial;
		Rectangle formaInimigo3;

		for (int iig = 0; iig < inimigos.size(); iig++) {

			Bot tempInimigo = inimigos.get(iig);
			formaInimigo = tempInimigo.getBounds();
			

			if (formaNave.intersects(formaInimigo)) {

				ave.setVisivel(false);
				tempInimigo.setVisivel(false);

				emJogo = false;
			}
		}

		for (int igg = 0; igg < inimigos2.size(); igg++) {

			Bot2 tempInimigo2 = inimigos2.get(igg);
			formaInimigo2 = tempInimigo2.getBounds();

			if (formaNave.intersects(formaInimigo2)) {

				ave.setVisivel(false);
				tempInimigo2.setVisivel(false);

				emJogo = false;
			}
		}
		for (int igg = 0; igg < inimigos3.size(); igg++) {

			Bot3 tempInimigo3 = inimigos3.get(igg);
			formaInimigo3 = tempInimigo3.getBounds();
			

			if (formaNave.intersects(formaInimigo3)) {

				ave.setVisivel(false);
				tempInimigo3.setVisivel(false);

				emJogo = false;
			}
		}

		List<Misseis> misseis = ave.getMisseis();

		for (int imh = 0; imh < misseis.size(); imh++) {

			Misseis tempMissel = misseis.get(imh);
			formaMissel = tempMissel.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {

				Bot tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaMissel.intersects(formaInimigo)) {
					
					ImageIcon referencia = new  ImageIcon("res\\destruicao_inimigo01_lenta01MD011.gif");//Modificado
					inimigos.get(j).setImagem(referencia.getImage());//modificado
					
					tempInimigo.setVisivel(false);
					tempMissel.setVisivel(false);
				}

			}
			for (int jd = 0; jd < inimigos2.size(); jd++) {

				Bot2 tempInimigo2 = inimigos2.get(jd             );
				formaInimigo2 = tempInimigo2.getBounds();

				if (formaMissel.intersects(formaInimigo2)) {
					
					ImageIcon referencia = new  ImageIcon("res\\destruicao_inimigo02_lenta01MD02.gif");//Modificado
					inimigos2.get(jd).setImagem(referencia.getImage());//modificado
					
					
					tempInimigo2.setVisivel(false);
					tempMissel.setVisivel(false);
				}

			}
			for (int jd = 0; jd < inimigos3.size(); jd++) {

				Bot3 tempInimigo3 = inimigos3.get(jd             );
				formaInimigo3 = tempInimigo3.getBounds();

				if (formaMissel.intersects(formaInimigo3)) {
					
					ImageIcon referencia = new  ImageIcon("res\\destruicao_inimigo03_lenta01MD03.gif");//Modificado
					inimigos3.get(jd).setImagem(referencia.getImage());//modificado
					
					
					
					tempInimigo3.setVisivel(false);
					tempMissel.setVisivel(false);
				}

			}

		}
		
		

	}

	
}
