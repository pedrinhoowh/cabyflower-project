package exception;


import javax.ejb.ApplicationException;
import javax.ws.rs.core.Response.Status;


/**
 * The base exception type for CabyFlower exceptions.
 * 
 * @author Pedro Cotta
 *
 */
@ApplicationException(rollback = true)
public class CabyflowerException extends Exception {

    private static final long serialVersionUID = -6898569912655093968L;

    private Status status;

    /**
     * Constructs a CabyflowerException using the given exception message.
     * 
     * @param message
     *            The message explaining the reason for the exception.
     */
    public CabyflowerException(final String message) {
        this(message, null);
    }

    /**
     * Constructs a CabyflowerException using the given message and
     * underlying cause.
     * 
     * @param cause
     *            The underlying cause.
     */
    public CabyflowerException(final Throwable cause) {
        this(cause.getMessage(), cause);
    }

    /**
     * Constructs a CabyflowerException using the given status and message.
     * 
     * @param status
     *            The http status of the exception.
     * @param message
     *            The message explaining the reason for the exception.
     */
    public CabyflowerException(final Status status, final String message) {
        this(status, message, null);
    }

    /**
     * Constructs a CabyflowerException using the given status and
     * underlying cause.
     * 
     * @param status
     *            The http status of the exception.
     * @param cause
     *            The underlying cause.
     */
    public CabyflowerException(final Status status, final Throwable cause) {
        this(status, cause.getMessage(), cause);
    }

    /**
     * Constructs a HolicTechnologyException using the given message and
     * underlying
     * cause.
     *
     * @param message
     *            The message explaining the reason for the exception.
     * @param cause
     *            The underlying cause.
     */
    public CabyflowerException(final String message, final Throwable cause) {
        this(Status.INTERNAL_SERVER_ERROR, message, cause);
    }

    /**
     * @param status
     * @param message
     * @param cause
     */
    private CabyflowerException(final Status status, final String message, final Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    /**
     * @return
     */
    public Status getStatus() {
        return status;
    }

}
