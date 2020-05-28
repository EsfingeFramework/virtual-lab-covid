package com.covid19.populatedb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CoronaPopulate {
	
	 public static void main(String[] args) {
         EntityManagerFactory factory = Persistence.
                 createEntityManagerFactory("jpa1");
         EntityManager manager = factory.createEntityManager();
         
		 
		 try {
	        URL url;
			url = new URL("https://covid.ourworldindata.org/data/ecdc/full_data.csv");
			URI uri = url.toURI();
	        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	        String s;
	          while ((s = br.readLine()) != null) {
	                if(!(s.equals("date,location,new_cases,new_deaths,total_cases,total_deaths")))
	                {
	                	org.esfinge.virtuallab.covid.CoronaData c1 = new org.esfinge.virtuallab.covid.CoronaData();
		               String[] dados = s.split(",");
		               System.out.println(dados[0]);
		               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		               Date date = sdf.parse(dados[0]);

		               Calendar cal = Calendar.getInstance();

		               cal.setTime(date);
		               c1.setData(cal);
		               
		               c1.setLocation(dados[1]);
		               
		               System.out.println(dados.toString());

		               c1.setNewCases(Integer.parseInt(dados[2]));
		               c1.setNewDeaths(Integer.parseInt(dados[3]));
		               c1.setTotalCases(Integer.parseInt(dados[4]));
		               c1.setTotalDeaths(Integer.parseInt(dados[5]));
		               //coronadata.add(c1);
		               //CoronaDao cd = null;
		               //cd.save(c1);
		               manager.getTransaction().begin();        
		               manager.persist(c1);
		               manager.getTransaction().commit();    

		               System.out.println("ID da tarefa: " + c1.getId());
	                }
	          }
		} catch ( IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         manager.close();
     factory.close();
	}	

	

}
