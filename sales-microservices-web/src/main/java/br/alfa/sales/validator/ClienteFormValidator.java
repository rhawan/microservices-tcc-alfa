package br.alfa.sales.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.alfa.sales.vo.ClienteVO;

@Component
public class ClienteFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "NotEmpty.clientevo.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpfCnpj", "NotEmpty.clientevo.cpfCnpj");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipoPessoa", "NotEmpty.clientevo.tipoPessoa");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefone", "NotEmpty.clientevo.telefone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco", "NotEmpty.clientevo.endereco");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cidade", "NotEmpty.clientevo.cidade");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "UF", "NotEmpty.clientevo.UF");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.clientevo.email");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valorLimiteCredito", "NotEmpty.clientevo.valorLimiteCredito");
	}

}
