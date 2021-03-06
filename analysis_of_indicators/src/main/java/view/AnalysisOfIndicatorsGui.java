package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controler.ProtocoleHandler;
import model.SessionInformation;
import model.query.DynamiqueResearchQuery;
import model.query.RepaymentsQuery;
import model.response.AverageDurationResponse.AverageClass;
import model.response.DynamiqueResearchResponse.SumInterest;
import model.response.RepaymentsResponse;
import model.response.SumOfInterestResponse.Interest;
import model.response.evolutionOfTheSimulationsResponse.ListResult;
import serverCommunication.ServerCommunication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndiaye
 */
public class AnalysisOfIndicatorsGui extends Tab {

	/**
	 * Creates new form AnalyseOfIndicatorsGui
	 */
	Socket socket = null;

	public AnalysisOfIndicatorsGui() {
		super("Analyse des indicateurs", 3);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	ScrollPane pane = new ScrollPane();

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		indicateur = new javax.swing.JComboBox<>();
		date = new javax.swing.JComboBox<>();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		typeOfLoan = new javax.swing.JComboBox<>();
		// start = new javax.swing.JButton();
		textArea = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		resultatTable = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jLabel6 = new javax.swing.JLabel();
		trancheAge = new javax.swing.JComboBox<>();
		labelIndi = new javax.swing.JLabel();
		labelDate = new javax.swing.JLabel();
		LabelPret = new javax.swing.JLabel();
		labelAge = new javax.swing.JLabel();
		validate = new javax.swing.JButton();

		// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(0, 153, 153));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setForeground(new java.awt.Color(0, 204, 204));
		setPreferredSize(new java.awt.Dimension(1200, 950));

		jPanel1.setBackground(new java.awt.Color(0, 153, 153));
		jPanel1.setPreferredSize(new java.awt.Dimension(1500, 1500));

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Analyse des indicateurs relatifs à l'activité \"prêt\" de l'agence");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("Selectionnez l'incateur à analyser");

		indicateur.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { " ", "Somme des intérêts sur un type de prêt","Total des Empreints / Total des Remboursements","Somme des intérêts à une année", "detail des intérêts perçus","Le type de prêt le plus simulé",
						"Durée Moyenne des prêts par type de prêt","Évolution mois par mois du nombre de simulation","Évolution mois par mois du nombre de prêts",
						"Recherche dynamique sur les intérêts", "Le type de prêt le moins simulé" }));

		date.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { " ","2011","2012","2013", "2014", "2015", "2016", "2017","2018" }));

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("Selectionnez l'année");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Selectionnez le type de prêt");

		// start.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		// start.setForeground(new java.awt.Color(0, 0, 153));
		// start.setText("Lancer L'analyse");
		// start.setActionCommand("Lancer l'analyse");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("Résultat de l'analyse");

		resultatTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3" }));
		jScrollPane1.setViewportView(resultatTable);

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		jLabel6.setText("Tranche d'âge");

		trancheAge.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { " ", "inférieur à 25 ans", "entre 25 ans et 50 ans", "50 ans et plus" }));

		labelIndi.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
		labelIndi.setForeground(new java.awt.Color(0, 153, 153));
		labelIndi.setText("Renseignez l'indicateur");

		labelDate.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
		labelDate.setForeground(new java.awt.Color(0, 153, 153));
		labelDate.setText("Selectionnez l'année");

		LabelPret.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
		LabelPret.setForeground(new java.awt.Color(0, 153, 153));
		LabelPret.setText("Selectionnez le type de pret");

		labelAge.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
		labelAge.setForeground(new java.awt.Color(0, 153, 153));
		labelAge.setText("Selectionnez la tranche d'âge");

		validate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		validate.setForeground(new java.awt.Color(0, 153, 153));
		validate.setText("Lancer l'analyse\n");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout
												.createSequentialGroup().addGap(319, 319, 319).addComponent(jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 650,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(validate,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(typeOfLoan,
																javax.swing.GroupLayout.Alignment.LEADING, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel5,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 307,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(date, javax.swing.GroupLayout.Alignment.LEADING,
																0, javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(indicateur,
																javax.swing.GroupLayout.Alignment.LEADING, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel4,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 307,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 307,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE, 307,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														// .addComponent(start,
														// javax.swing.GroupLayout.Alignment.LEADING,
														// javax.swing.GroupLayout.DEFAULT_SIZE,
														// 361, Short.MAX_VALUE)
														.addComponent(trancheAge,
																javax.swing.GroupLayout.Alignment.LEADING, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGap(18, 18, 18)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(labelIndi,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 199,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(labelDate,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(LabelPret,
																		javax.swing.GroupLayout.DEFAULT_SIZE, 227,
																		Short.MAX_VALUE))
														.addComponent(labelAge, javax.swing.GroupLayout.PREFERRED_SIZE,
																236, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(103, 103, 103)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE,
																171, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE, 614,
																Short.MAX_VALUE)
														.addComponent(textArea))))
								.addContainerGap(448, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(62, 62, 62)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(textArea, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(indicateur).addComponent(labelIndi,
														javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
										.addGap(27, 27, 27).addComponent(jLabel4)))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(labelDate))
										.addGap(29, 29, 29).addComponent(jLabel5).addGap(34, 34, 34)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(typeOfLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(LabelPret, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(30, 30, 30).addComponent(jLabel6).addGap(26, 26, 26)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(trancheAge, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(labelAge))
										.addGap(32, 32, 32)
										.addComponent(validate, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19,
														Short.MAX_VALUE)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														366, Short.MAX_VALUE)))
						// .addComponent(start,
						// javax.swing.GroupLayout.PREFERRED_SIZE, 51,
						// javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(505, Short.MAX_VALUE))
				.addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1790,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1574,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		
		
				
		indicateur.addActionListener(new ActionListener() {

			public void change() {
				labelAge.setForeground(new java.awt.Color(153, 0, 0));
				labelDate.setForeground(new java.awt.Color(153, 0, 0));
				LabelPret.setForeground(new java.awt.Color(153, 0, 0));
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				String choix = (String) indicateur.getSelectedItem();
				// TODO
			
				if (choix =="Évolution mois par mois du nombre de simulation") {
					labelDate.setForeground(new java.awt.Color(153, 0, 0));
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(0, 153, 153));
			
				}
				
				
				else if (choix =="Évolution mois par mois du nombre de prêts") {
					labelDate.setForeground(new java.awt.Color(153, 0, 0));
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(0, 153, 153));
				}
				else if(choix=="Total des Empreints / Total des Remboursements"){
					labelDate.setForeground(new java.awt.Color(153, 0, 0));
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(0, 153, 153));
				}
				else if(choix=="Somme des intérêts sur un type de prêt"){
					labelDate.setForeground(new java.awt.Color(0, 153, 153));
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(153, 0, 0));
				}
				else if(choix=="Somme des intérêts à une année"){
					labelDate.setForeground(new java.awt.Color(153, 0, 0));
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(0, 153, 153));
				}
				else if(choix=="Total des Empreints / Total des Remboursements"){
					labelDate.setForeground(new java.awt.Color(153, 0, 0));
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(0, 153, 153));
				}
				else if (choix == "Recherche dynamique sur les intérêts") {
					change();
				} else {
					labelAge.setForeground(new java.awt.Color(0, 153, 153));
					labelDate.setForeground(new java.awt.Color(0, 153, 153));
					LabelPret.setForeground(new java.awt.Color(10, 153, 153));
				}
			}
		});

		validate.addActionListener(new ActionListener() {
			public void remove() {
				textArea.setText("");

				Object[][] object = new Object[50][50];
				ArrayList<String> array = new ArrayList<String>();
				int t = 0;
				if (array.size() != 0) {
					for (String string : array) {

						object[t][0] = "";
						object[t][1] = "";

						t++;

					}
				}
				resultatTable.setModel(new DefaultTableModel(object, new String[] { "", "", ""

				}));
				}
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String choix = (String) indicateur.getSelectedItem();
				ProtocoleHandler protocole = new ProtocoleHandler();

				if (choix == "Le type de prêt le plus simulé") {
					textArea.setText("");
					String reponse = protocole.mustSimulatedLoan(socket);
					textArea.setFont(new Font("Serif", Font.BOLD, 20));
					textArea.setText("Le type de prêt le plus simulé dans cette agence est : \n\n" + reponse);

				}

				
				else if (choix == "Le type de prêt le moins simulé") {
					textArea.setText("");
					protocole = new ProtocoleHandler();
					String reponse = protocole.worseSimulatedLoan(socket);
					textArea.setFont(new Font("Serif", Font.BOLD, 20));
					textArea.setText("Le type de prêt le moins simulé dans cette agence est :" + reponse);

				} 


				else if (choix == "detail des intérêts perçus") {

					ArrayList<Interest> array = new ArrayList<Interest>();

					array = protocole.SumofInterest(socket);
					Object[][] object = new Object[50][50];
					int t = 0;
					float total = 0;
					if (array.size() != 0) {
						for (Interest inte : array) {
							total = (total + inte.getSum());
							object[t][0] = inte.getDate();
							object[t][1] = inte.getName();
							object[t][2] = inte.getSum();
							t++;

						}
						
						
					}
					textArea.setText("");
					textArea.setFont(new Font("Serif", Font.BOLD, 20));
					textArea.setText("Total des intérêts :" + total);
					resultatTable.setModel(new DefaultTableModel(object, new String[] { "Année", "Type de prêt", "Somme"

					}));

				}

			else if (choix =="Total des Empreints / Total des Remboursements"){

					
					RepaymentsResponse repaymentResponse = new RepaymentsResponse();
					RepaymentsQuery repaymentQuery = new RepaymentsQuery((String) date.getSelectedItem());
					repaymentResponse = protocole.getRepayments(socket, repaymentQuery);
					Object[][] object = new Object[50][50];
				
					
					
							object[0][0] =date.getSelectedItem();
							object[0][1] = repaymentResponse.getTotalLoans();
							object[0][2] = repaymentResponse.getTotalRepayments();
						

						
			
			textArea.setText("");
		
		
			resultatTable.setModel(new DefaultTableModel(object, new String[] { "Résumé de l'année ", "Total des empreints","Total des remboursements"

			}));
				}

				else if (choix =="Total des Empreints / Total des Remboursements"){

					
					RepaymentsResponse repaymentResponse = new RepaymentsResponse();
					RepaymentsQuery repaymentQuery = new RepaymentsQuery((String) date.getSelectedItem());
					repaymentResponse = protocole.getRepayments(socket, repaymentQuery);
					Object[][] object = new Object[50][50];
				
					
					
							object[0][0] =date.getSelectedItem();
							object[0][1] = repaymentResponse.getTotalLoans();
							object[0][2] = repaymentResponse.getTotalRepayments();
						

						
			
			textArea.setText("");
		
		
			resultatTable.setModel(new DefaultTableModel(object, new String[] { "Résumé de l'année ", "Total des empreints","Total des remboursements"

			}));
				}
				else if (choix == "Somme des intérêts à une année") {

					ArrayList<Interest> array = new ArrayList<Interest>();
					
					array = protocole.SumofInterest(socket);
					Object[][] object = new Object[50][50];
					int t = 0;
					float total = 0;
					if (array.size() != 0) {
						for (Interest inte : array) {
							if(inte.getDate().equals(date.getSelectedItem())){
								total = (total + inte.getSum());
								object[t][0] = inte.getDate();
								object[t][1] = inte.getName();
								object[t][2] = inte.getSum();
								t++;
							}
					
							

						}

					}
					textArea.setText("");
					textArea.setFont(new Font("Serif", Font.BOLD, 20));
					textArea.setText("Total des intérêts :" + total);
					resultatTable.setModel(new DefaultTableModel(object, new String[] { "Année", "Type de prêt", "Somme"

					}));

				}
				
				else if (choix == "Somme des intérêts sur un type de prêt") {

					ArrayList<Interest> array = new ArrayList<Interest>();
					
					array = protocole.SumofInterest(socket);
					Object[][] object = new Object[50][50];
					int t = 0;
					float total = 0;
					if (array.size() != 0) {
						for (Interest inte : array) {
							if(inte.getName().equals(typeOfLoan.getSelectedItem())){
								total = (total + inte.getSum());
								object[t][0] = inte.getDate();
								object[t][1] = inte.getName();
								object[t][2] = inte.getSum();
								t++;
							}
					
							

						}

					}
					textArea.setText("");
					textArea.setFont(new Font("Serif", Font.BOLD, 20));
					textArea.setText("Total des intérêts :" + total);
					resultatTable.setModel(new DefaultTableModel(object, new String[] { "Année", "Type de prêt", "Somme"

					}));
				}


				else if (choix == "Durée Moyenne des prêts par type de prêt") {
					remove();
					ArrayList<AverageClass> average = new ArrayList<AverageClass>();
					protocole = new ProtocoleHandler();
					average = protocole.AverageLoan(socket);
					Object[][] object = new Object[10][10];
					int t = 0;
					if (average.size() != 0) {
						for (AverageClass inte : average) {

							object[t][0] = inte.getName();
							object[t][1] = inte.getAverage();

							t++;

						}

					}
					resultatTable.setModel(new DefaultTableModel(object, new String[] { "Type de Prêt", "Durée Moyenne(en année)"

					}));

				}

				if (choix == "Recherche dynamique sur les intérêts") {
					remove();
					String Choicedate = (String) date.getSelectedItem();
					String typeOfLan = (String) typeOfLoan.getSelectedItem();
					String ageClass = (String) trancheAge.getSelectedItem();
					DynamiqueResearchQuery interest = null;

					if (ageClass == "inférieur à 25 ans") {
						interest = new DynamiqueResearchQuery(typeOfLan, 25, Choicedate);

					}

					else if (ageClass == "entre 25 ans et 50 ans") {
						interest = new DynamiqueResearchQuery(typeOfLan, 50, Choicedate);
					} else if (ageClass == "50 ans et plus") {
						interest = new DynamiqueResearchQuery(typeOfLan, 51, Choicedate);
					}
					ArrayList<SumInterest> array = null;
					try {
						array = protocole.InterestBySegment(interest, socket);
					} catch (Exception z) {
						System.out.println("Aucun résultat");
					}

					Object[][] object = new Object[40][40];
					int t = 0;
					if (array.size() != 0) {
						for (SumInterest inte : array) {

							object[t][0] = inte.getTypeOfLoans();
							object[t][1] = inte.getDate();
							object[t][2] = inte.getSum();
							t++;

						}

						resultatTable.setModel(new DefaultTableModel(object,
								new String[] { "Type de prêt", "Année", "Somme des Inte", ""

								}));

					}

				}

				if (choix == "Évolution mois par mois du nombre de prêts") {
					remove();
					// this.remove();
					ArrayList<ListResult> array = new ArrayList<ListResult>();

					ArrayList<ListResult> string = new ArrayList<ListResult>();

					String dateChoice = (String) date.getSelectedItem();

					array = protocole.evolutionOfTheSimulations(dateChoice, socket);

					Object[][] object = new Object[60][60];
					int t = 0;
					if (array.size() != 0) {
						for (ListResult inte : array) {

							object[t][0] = inte.getDate();
							object[t][1] = inte.getCount();

							t++;

						}

						resultatTable
								.setModel(new DefaultTableModel(object, new String[] { "Type de Prêt", "Nombre de prêt"

						}));

					}
				}
				
				
				if (choix == "Évolution mois par mois du nombre de simulation") {
					remove();
					// this.remove();
					ArrayList<ListResult> array = new ArrayList<ListResult>();

					ArrayList<ListResult> string = new ArrayList<ListResult>();

					String dateChoice = (String) date.getSelectedItem();

					array = protocole.evolutionOfTheSimulation(dateChoice, socket);
					

					Object[][] object = new Object[60][60];
					int t = 0;
					if (array.size() != 0) {
						for (ListResult inte : array) {

							object[t][0] = inte.getDate();
							object[t][1] = inte.getCount();
							

							t++;

						}

						resultatTable
								.setModel(new DefaultTableModel(object, new String[] { "Type de Prêt", "Nombre de simulation"

						}));

					}
				}
			
			}

		});

	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AnalysisOfIndicatorsGui.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AnalysisOfIndicatorsGui.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AnalysisOfIndicatorsGui.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AnalysisOfIndicatorsGui.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AnalysisOfIndicatorsGui().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel LabelPret;
	private javax.swing.JComboBox<String> date;
	private javax.swing.JComboBox<String> indicateur;
	private javax.swing.JButton validate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel labelAge;
	private javax.swing.JLabel labelDate;
	private javax.swing.JLabel labelIndi;
	private javax.swing.JTable resultatTable;
	// private javax.swing.JButton start;
	private javax.swing.JTextField textArea;
	private javax.swing.JComboBox<String> trancheAge;
	private javax.swing.JComboBox<String> typeOfLoan;
	// End of variables declaration

	@Override
	public void setSessionInformation(SessionInformation sessionInformation) {
		initComponents();
		socket = sessionInformation.getSocket();

		ServerCommunication servercommunication = new ServerCommunication();

		typeOfLoan.addItem(" ");

		typeOfLoan.setSelectedIndex(0);

		ArrayList<String> array = new ArrayList<String>();
		array = servercommunication.getAlltypeofLoan(socket);
		for (String string : array) {
			System.out.println(string);
			typeOfLoan.addItem(string);
		}
	}
}
