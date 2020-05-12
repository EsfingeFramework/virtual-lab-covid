package org.esfinge.virtuallab.covid;

import java.util.List;

import org.esfinge.virtuallab.api.annotations.ServiceDAO;
import org.esfinge.virtuallab.api.annotations.ServiceMethod;
import org.esfinge.virtuallab.api.annotations.TableReturn;

import net.sf.esfinge.querybuilder.Repository;

@ServiceDAO(
		label = "DAO",
		description = "",
		url = "jdbc:postgresql://localhost:5432/postgres", 
		user = "postgres", 
		password = "postgres", 
		dialect = "org.hibernate.dialect.PostgreSQLDialect")
public interface CoronaDao extends Repository<CoronaDados>
	{
		
		@ServiceMethod(
			label = "Listar todas temperaturas",
			description = "Retorna todos as temperaturas cadastradas no Banco de Dados.")
		@TableReturn
		public List<CoronaDados> getCoronaDados();
		
		@ServiceMethod(
				label = "Listar todas temperaturas",
				description = "Retorna todos as temperaturas cadastradas no Banco de Dados.")
		@TableReturn
		public List<CoronaDados> getCoronaDadosByLocation(String location);
		
		
	}
