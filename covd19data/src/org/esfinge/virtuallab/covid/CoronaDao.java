package org.esfinge.virtuallab.covid;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsExclude;
import org.esfinge.virtuallab.api.annotations.ServiceDAO;
import org.esfinge.virtuallab.api.annotations.ServiceMethod;
import org.esfinge.virtuallab.api.annotations.TableReturn;

import net.sf.esfinge.querybuilder.Repository;
import net.sf.esfinge.querybuilder.annotation.Greater;
import net.sf.esfinge.querybuilder.annotation.GreaterOrEquals;

@ServiceDAO(
		label = "DAO",
		description = "",
		url = "jdbc:postgresql://localhost:5432/postgres", 
		user = "postgres", 
		password = "marco12", 
		dialect = "org.hibernate.dialect.PostgreSQLDialect")
public interface CoronaDao extends Repository<CoronaDados>
	{
		
		@ServiceMethod(
			label = "",
			description = "")
		@TableReturn
		public List<CoronaDados> getCoronaDadosOrderByData();
		
		@ServiceMethod(
				label = "",
				description = "")
		@TableReturn
		public List<CoronaDados> getCoronaDadosByLocationOrderByData(String location);		
		
		@ServiceMethod(
				label = "",
				description = "")
		@TableReturn
		public List<CoronaDados> getCoronaDadosByDataOrderByTotalDeathsDesc(@GreaterOrEquals Calendar data);		
		
		@ServiceMethod(
				label = "",
				description = "")
		@TableReturn
		public List<CoronaDados> getCoronaDadosByDataOrderByNewDeathsDesc(@GreaterOrEquals Calendar data);		

		@ServiceMethod(
				label = "",
				description = "")
		@TableReturn
		public List<CoronaDados> getCoronaDadosByDataOrderByNewCasesDesc(@GreaterOrEquals Calendar data);		

		@ServiceMethod(
				label = "",
				description = "")
		@TableReturn
		public List<CoronaDados> getCoronaDadosByDataOrderByTotalCasesDesc(@GreaterOrEquals Calendar data);		

	
	}
