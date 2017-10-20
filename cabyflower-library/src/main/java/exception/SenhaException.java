package exception;

import javax.ejb.ApplicationException;

/**
 * The base exception type for Senha exceptions.
 * 
 * @author Pedro Cotta
 *
 */
@ApplicationException(rollback = true)
public class SenhaException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private static final String MSG_SENHA = "Suas senhas nao conferem.";
	
	@Override
    public String getMessage() {
        return MSG_SENHA;
    }

}
