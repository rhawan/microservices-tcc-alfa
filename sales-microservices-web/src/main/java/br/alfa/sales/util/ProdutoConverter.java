package br.alfa.sales.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.alfa.sales.vo.ProdutoVO;

@FacesConverter("produtoConverter")
public class ProdutoConverter extends SelectItemsConverter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object retorno = null;
		try {
			Long.parseLong(value.trim());
			retorno = super.getAsObject(context, component, value);
		} catch (NumberFormatException e) {
			retorno = null;
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		Long id = ((ProdutoVO)value).getId();
		return String.valueOf(id);
	}

}
