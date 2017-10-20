package controller;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.CabyflowerException;
import util.ObjectUtil;


/**
 * @author Pedro Cotta
 *
 */
public class CabyflowerController implements Serializable {

    private static final long serialVersionUID = -6673042185930635030L;

    /**
     * @param clazz
     * @return
     */
    protected Logger getLogger(final Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    /**
     * @param object
     * @return
     */
    protected Response ok(final Object object) {
        return Response.ok(object).build();
    }
    
    /**
     * @param 
     * @return
     */
    protected Response badRequest() {
    		return Response.serverError().build();
    }

    /**
     * @param _class
     * @param message
     * @param throwable
     * @throws CabyflowerException
     */
    protected <T> void error(final Class<T> _class, final String message, final Throwable throwable) throws CabyflowerException {
    	CabyflowerException cabyflowerException = ((CabyflowerException.class.isAssignableFrom(throwable.getClass())
                ? (CabyflowerException) throwable : new CabyflowerException(message, throwable)));
        getLogger(getClass()).error("Message: " + cabyflowerException.getMessage()
                + ((cabyflowerException.getCause() != null && ObjectUtil.getInstance().isNotEmptyOrNull(cabyflowerException.getCause().getMessage()))
                        ? "Cause: " + cabyflowerException.getCause().getMessage() : ""),
                cabyflowerException);

        throw cabyflowerException;
    }
	
	

}
