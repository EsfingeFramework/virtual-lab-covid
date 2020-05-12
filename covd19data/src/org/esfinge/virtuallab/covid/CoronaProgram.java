package org.esfinge.virtuallab.covid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.esfinge.virtuallab.api.annotations.Inject;
import org.esfinge.virtuallab.api.annotations.ServiceClass;
import org.esfinge.virtuallab.api.annotations.ServiceMethod;
import org.esfinge.virtuallab.api.annotations.TableReturn;


@ServiceClass(
	label = "Dados do Coronavirus",
	description = "Demonstração de recuperação dos dados sobre o coronavirus")
public class CoronaProgram
{
	
	
	@Inject
	private CoronaDao cd;
	
	/*--------------------------------------------------------------------------
	 * Utiliza a anotacao sem parametros.
	 *-------------------------------------------------------------------------*/
	@ServiceMethod(
		label = "Retorna os dados do coronavirus",
		description = "sem parâmetros.")
	@TableReturn
	public List<CoronaDados> listAllData()
	{
 
		return cd.getCoronaDados();
	}
	
	@ServiceMethod(
			label = "Retorna os dados do coronavirus por pais que for selecionado",
			description = "Seleciona os casos dos países")
		@TableReturn
		public List<CoronaDados> listPais(String pais)
		{	
			return cd.getCoronaDadosByLocation(pais);
		}
		
}
