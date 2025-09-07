package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import musicPlayer.Musicas;

public class MyFrame extends JFrame implements ActionListener, Botoes, Painels, Labels{
	
	ImageIcon tocarIcon;
	ImageIcon pausarIcon;
	ImageIcon passarIcon;
	ImageIcon passarApertadoIcon;
	private int musicaAtual = 0;
	private boolean tocando = false;
	private boolean musicaNafila = false;
	private Clip clip = AudioSystem.getClip();
	private ArrayList<String> musicas = Musicas.addMusicas();
	
	public MyFrame() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
		this.setTitle("");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setResizable(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout(3, 3));
		panels();
		botoes();
		labels();
		playerPanel.add(recomecarBotao);
		playerPanel.add(antBotao);
		playerPanel.add(voltarBotao);
		playerPanel.add(tocarBotao);
		playerPanel.add(passarBotao);
		playerPanel.add(proxBotao);
		playerPanel.add(sairBotao);
		musicNamePanel.add(nomeMusicaAtual, BorderLayout.WEST);
		musicNamePanel.add(tituloPlayer, BorderLayout.NORTH);
		contentPanel.add(musicNamePanel, BorderLayout.SOUTH);
		this.add(contentPanel, BorderLayout.CENTER);
		this.add(playerPanel, BorderLayout.SOUTH);
		this.add(searchPanel, BorderLayout.NORTH);
		this.add(albunsPanel, BorderLayout.WEST);
		this.definirClip();
		this.abrirMusica();
	}
	
	private void abrirMusica() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// Diretorio para abrir o arquivo
		
		// É necessario adicionar o user no diretório. ex.: 'ismael'
		File file = new File("C:\\Users\\ismae\\Music\\musicaswav\\" + musicas.get(musicaAtual));
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip.open(audioStream);
		System.out.println("Musica na fila");
		musicaNafila = true;
		nomeMusicaAtual.setText(musicas.get(musicaAtual));
	}
	
	private void labels() {
		tituloPlayer.setBounds(300, 200, 300, 25);
		tituloPlayer.setVisible(true);
		
		nomeMusicaAtual.setBounds(300, 200, 300, 25);
		nomeMusicaAtual.setForeground(Color.WHITE);
		nomeMusicaAtual.setVisible(true);
	}
	
	private void panels() {
		
		playerPanel.setBackground(new Color(40, 40, 40));
		playerPanel.setPreferredSize(new Dimension(100, 100));
		
		contentPanel.setBackground(new Color(75, 75, 75));
		contentPanel.setPreferredSize(new Dimension(100, 100));
		contentPanel.setLayout(new BorderLayout());
		
		musicNamePanel.setBackground(new Color(100, 100, 100));
		musicNamePanel.setPreferredSize(new Dimension(200, 75));
		musicNamePanel.setLayout(new BorderLayout());
		
		searchPanel.setBackground(new Color(20, 20, 20));
		searchPanel.setPreferredSize(new Dimension(100, 50));
		
		albunsPanel.setBackground(new Color(90, 90, 90));
		albunsPanel.setPreferredSize(new Dimension(175, 100));
	}
	
	private void botoes() {
		tocarIcon = new ImageIcon("icones/tocar.png");
		pausarIcon = new ImageIcon("icones/pausar.png");
		passarIcon = new ImageIcon("icones/passar.png");
		passarApertadoIcon = new ImageIcon("icones/passarApertado.png"); 
		ImageIcon recomecarIcon = new ImageIcon("icones/recomecar.png");
		ImageIcon sairIcon = new ImageIcon("icones/sair.png");
		ImageIcon voltarIcon = new ImageIcon("icones/voltar.png");
		ImageIcon proxIcon = new ImageIcon("icones/prox.png");
		ImageIcon antIcon = new ImageIcon("icones/ant.png");
		
		tocarBotao.setIcon(tocarIcon);
		tocarBotao.setOpaque(false);
		tocarBotao.setContentAreaFilled(false);
	    tocarBotao.setBorderPainted(false);
		tocarBotao.setBounds(0, 150, 20, 20);
		tocarBotao.addActionListener(this);
		tocarBotao.setFocusable(false);
	
		sairBotao.setIcon(sairIcon);
		sairBotao.setOpaque(false);
		sairBotao.setContentAreaFilled(false);
	    sairBotao.setBorderPainted(false);
		sairBotao.setBounds(200, 150, 25, 25);
		sairBotao.addActionListener(this);
		sairBotao.setFocusable(false);

		recomecarBotao.setIcon(recomecarIcon);
		recomecarBotao.setOpaque(false);
		recomecarBotao.setContentAreaFilled(false);
		recomecarBotao.setBorderPainted(false);
		recomecarBotao.setBounds(100, 150, 25, 25);
		recomecarBotao.addActionListener(this);
		recomecarBotao.setFocusable(false);
		
		passarBotao.setIcon(passarIcon);
		passarBotao.setOpaque(false);
		passarBotao.setContentAreaFilled(false);
		passarBotao.setBorderPainted(false);
		passarBotao.setBounds(10, 150, 20, 20);
		passarBotao.addActionListener(this);
		passarBotao.setFocusable(false);
	
		voltarBotao.setIcon(voltarIcon);
		voltarBotao.setOpaque(false);
		voltarBotao.setContentAreaFilled(false);
	    voltarBotao.setBorderPainted(false);
		voltarBotao.setBounds(400, 150, 20, 20);
		voltarBotao.addActionListener(this);
		passarBotao.setFocusable(false);
		
		proxBotao.setIcon(proxIcon);
		proxBotao.setOpaque(false);
		proxBotao.setContentAreaFilled(false);
	    proxBotao.setBorderPainted(false);
		proxBotao.setBounds(400, 150, 25, 25);
		proxBotao.addActionListener(this);
		proxBotao.setFocusable(false);
		
		antBotao.setIcon(antIcon);
		antBotao.setOpaque(false);
		antBotao.setContentAreaFilled(false);
	    antBotao.setBorderPainted(false);
		antBotao.setBounds(700, 150, 25, 25);
		antBotao.addActionListener(this);
		antBotao.setFocusable(false);
	}
	private void definirClip() throws LineUnavailableException {
		clip = AudioSystem.getClip();
	}
	
	public void actionPerformed(ActionEvent e) {
		long tempo;
		
		if(e.getSource()==tocarBotao) {
			if(!tocando) {
				clip.start();
				tocarBotao.setIcon(pausarIcon);
				tocando = true;
			}else {
				clip.stop();
				tocarBotao.setIcon(tocarIcon);
				tocando = false;
			}
			
		}
		if(e.getSource()==sairBotao) {
			clip.close();
			tocarBotao.setIcon(tocarIcon);
			tocando = false;
			musicaNafila = false;
		}
		
		if(e.getSource()==recomecarBotao) {
			if(tocando) {
				clip.setMicrosecondPosition(1);
			}else if(musicaNafila){
				clip.start();
				tocarBotao.setIcon(pausarIcon);
				tocando = true;
			}else {
				try {
					this.abrirMusica();
					clip.start();
					tocarBotao.setIcon(pausarIcon);
					tocando = true;
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==passarBotao) {
			tempo = clip.getMicrosecondPosition();
			clip.setMicrosecondPosition(tempo+5000000);
		}
		if(e.getSource()==voltarBotao) {
			tempo = clip.getMicrosecondPosition();
			clip.setMicrosecondPosition(tempo-5000000);
		}
		if(e.getSource()==proxBotao) {
			try {
				if(!(musicaAtual==musicas.size()-1)) {
					clip.close();
					musicaAtual++;
					this.abrirMusica();
					tocarBotao.setIcon(tocarIcon);
					tocando = false;
				}else {
					throw new Exception();
				}
			}catch(UnsupportedAudioFileException erroArquivo) {
				System.out.println("Arquivo de audio não suportado");
			}catch(LineUnavailableException erroLinha) {
				System.out.println("Linha não disponível");
			}catch(Exception err) {
				System.out.println("Música inválida");
			}
		}
		if(e.getSource()==antBotao) {
			try {
				if(!(musicaAtual==0)) {
					clip.close();
					musicaAtual--;
					this.abrirMusica();
					tocarBotao.setIcon(tocarIcon);
					tocando = false;
				}else {
					throw new Exception();
				}
			}catch(UnsupportedAudioFileException erroArquivo) {
				System.out.println("Arquivo de audio não suportado");
			}catch(LineUnavailableException erroLinha) {
				System.out.println("Linha não disponível");
			}catch(Exception erro) {
				System.out.println("Música inválida");
			}
		}
	}
}
