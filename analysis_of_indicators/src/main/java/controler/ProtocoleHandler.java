package controler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.query.DynamiqueResearchQuery;;
import model.query.MustSimulatedLoanQuery;
import model.query.RepaymentsQuery;
import model.query.evolutionOfTheSimulationsQuery;
import model.response.AverageDurationResponse;
import model.response.AverageDurationResponse.AverageClass;
import model.response.DynamiqueResearchResponse;
import model.response.DynamiqueResearchResponse.SumInterest;
import model.response.MustSimulatedLoanResponse;
import model.response.NumberOfLoanResponse;
import model.response.RepaymentsResponse;
import model.response.RepaymentsResponse.*;
import model.response.SumOfInterestResponse;
import model.response.SumOfInterestResponse.Interest;
import model.response.evolutionOfTheSimulationsResponse;
import model.response.evolutionOfTheSimulationsResponse.ListResult;
import model.response.worseSimulatedLoanResponse;



public class ProtocoleHandler {
	
	
	public RepaymentsResponse getRepayments(Socket socket,RepaymentsQuery repaymentsQuery){
		
		
		RepaymentsResponse repayement = new RepaymentsResponse();
	
		
		try{

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		
			Gson gson = new Gson();
			String query = "repayments " + gson.toJson(repaymentsQuery);
			System.out.print(query);
		
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();


			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			repayement= gson.fromJson(content, RepaymentsResponse.class);
		
			
		}catch(Exception e){
			e.toString();
		}
		
		return repayement;
	}
	
	public ArrayList<SumInterest>  InterestBySegment(DynamiqueResearchQuery InterestQuery,Socket socket){
		ArrayList<SumInterest> array= new ArrayList<SumInterest>();
		
		
		 DynamiqueResearchResponse DynResponse = null  ;
		try{

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		
			Gson gson = new Gson();
			String query = "InterestBySegment " + gson.toJson(InterestQuery);
			System.out.print(query);
		 System.out.println( InterestQuery.toString());
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();

			System.out.println("reeponse "+response);

			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			DynResponse= gson.fromJson(content, DynamiqueResearchResponse.class);
			System.out.println("toc"+DynResponse.toString());
			
		}catch(Exception e){
			e.toString();
		}
		
		return DynResponse.getArray();
	}
	
	public ArrayList<Interest> SumofInterest(Socket socket){
		
		 SumOfInterestResponse sumResponse = null ;
		try{
			

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			

			model.query.SumOfInterestQuery sumInterest = new model.query.SumOfInterestQuery();
			Gson gson = new Gson();
			String query = "SumOfInterest " + gson.toJson(sumInterest);
		
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();

			System.out.println(response);

			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			 sumResponse= gson.fromJson(content, SumOfInterestResponse.class);
			System.out.println(sumResponse.toString());
			
		}catch(Exception e){
			e.toString();
		}
		return sumResponse.getArray();	
	}
	
	public ArrayList<AverageClass> AverageLoan(Socket socket){

	
		
		 AverageDurationResponse averageLoan = null ;
		try{
			

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			

			model.query.AverageDurationQuery average = new model.query.AverageDurationQuery();
		//	System.out.println(	"evolution"+evSimulation.toString());
			Gson gson = new Gson();
			String query = "AverageDuration " + gson.toJson(average);
		
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();

			System.out.println(response);

			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			 averageLoan = gson.fromJson(content, AverageDurationResponse.class);
			System.out.println(averageLoan.toString());
			
		}catch(Exception e){
			e.toString();
		}
		return averageLoan.getArray();	
	}
	
	public int NumberOfLoanQuery(String date,Socket socket){

		
		 NumberOfLoanResponse numberLoans = null ;
		try{
			
			

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			

			model.query.NumberOfLoanQuery numberOfLoanQuery = new model.query.NumberOfLoanQuery(date);
		//	System.out.println(	"evolution"+evSimulation.toString());
			Gson gson = new Gson();
			String query = "NumberOfLoanQuery " + gson.toJson(numberOfLoanQuery);
			
			System.out.println(query);
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();

			System.out.println(response);

			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			 numberLoans = gson.fromJson(content, NumberOfLoanResponse.class);
			System.out.println(numberLoans.toString());
			
		}catch(Exception e){
			e.toString();
		}
		return numberLoans.getNumberOfLoans();
		
		
	}
	
public String mustSimulatedLoan(Socket socket){
	
	 MustSimulatedLoanResponse evolution = null ;
	try{
		
	
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		

		MustSimulatedLoanQuery loan = new MustSimulatedLoanQuery();
	//	System.out.println(	"evolution"+evSimulation.toString());
		Gson gson = new Gson();
		String query = "MustSimulatedLoan " + gson.toJson(loan);
		System.out.println(query);
		
		out.println(query);

		
		// manage the response of the server
		
		String response = in.readLine();

		System.out.println(response);

		int prefixEnd = response.indexOf(' ');

		String prefix = response.substring(0, prefixEnd);
		

		String content = response.substring(prefixEnd + 1);
		
	
		 evolution = gson.fromJson(content, MustSimulatedLoanResponse.class);
		 
		System.out.println(content);
		
	}catch(Exception e){
		e.toString();
	}
	return evolution.getMessage();
		
	
	
	}


public String worseSimulatedLoan(Socket socket){

 worseSimulatedLoanResponse evolution = null ;
try{
	

	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	

	MustSimulatedLoanQuery loan = new MustSimulatedLoanQuery();
//	System.out.println(	"evolution"+evSimulation.toString());
	Gson gson = new Gson();
	String query = "worseSimulatedLoan " + gson.toJson(loan);
	System.out.println(query);
	
	out.println(query);

	
	// manage the response of the server
	
	String response = in.readLine();

	System.out.println(response);

	int prefixEnd = response.indexOf(' ');

	String prefix = response.substring(0, prefixEnd);
	

	String content = response.substring(prefixEnd + 1);
	

	 evolution = gson.fromJson(content, 
			 worseSimulatedLoanResponse.class);
	 
	System.out.println(content);
	
}catch(Exception e){
	e.toString();
}
return evolution.getMessage();
	


}


	// evolution of the simulation year by year
	public ArrayList<ListResult> evolutionOfTheSimulations(String date,Socket socket){

		 evolutionOfTheSimulationsResponse evolution = null ;
		 
		try{
			

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			

			evolutionOfTheSimulationsQuery evSimulation = new evolutionOfTheSimulationsQuery(date);
		//	System.out.println(	"evolution"+evSimulation.toString());
			Gson gson = new Gson();
			evSimulation.setDate(date);
			String query = "evolutionOfTheSimulations " + gson.toJson(evSimulation);
			
			System.out.println(query);
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();

			System.out.println("reponse"+response);

			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			 evolution = gson.fromJson(content, evolutionOfTheSimulationsResponse.class);
			 
			System.out.println(evolution.toString());
			
		}catch(Exception e){
			e.toString();
		}
		return evolution.getArray();
		
		
	
	}
	
	public ArrayList<ListResult> evolutionOfTheSimulation(String date,Socket socket){

		 evolutionOfTheSimulationsResponse evolution = null ;
		 
		try{
			

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			

			evolutionOfTheSimulationsQuery evSimulation = new evolutionOfTheSimulationsQuery(date);
		//	System.out.println(	"evolution"+evSimulation.toString());
			Gson gson = new Gson();
			evSimulation.setDate(date);
			String query = "evolutionOfTheSimulation " + gson.toJson(evSimulation);
			
			System.out.println(query);
			out.println(query);

			
			// manage the response of the server
			
			String response = in.readLine();

			System.out.println("reponse"+response);

			int prefixEnd = response.indexOf(' ');

			String prefix = response.substring(0, prefixEnd);
			

			String content = response.substring(prefixEnd + 1);
			
		
			 evolution = gson.fromJson(content, evolutionOfTheSimulationsResponse.class);
			System.out.println(evolution.toString());
			
		}catch(Exception e){
			e.toString();
		}
		return evolution.getArray();
		
		
	
	}
}
