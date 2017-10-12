package util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

public final class ObjectUtil implements Serializable {

	private static final long serialVersionUID = 1805562204084686619L;
	private static ObjectUtil INSTANCE = new ObjectUtil();

	private ObjectUtil() {
	}

	/**
	 * Return the class instance.
	 * 
	 * @return {@link ObjectUtil}
	 */
	public static ObjectUtil getInstance() {
		return INSTANCE;
	}

	/**
	 * Checks whether it is empty or null.
	 * 
	 * @param value
	 *            - {@link String}
	 * @return
	 */
	public static boolean isEmptyOrNull(final String value) {
		return value == null || value.trim().length() == 0;
	}

	/**
	 * Checks whether it is empty or null
	 * 
	 * @param value
	 *            - {@link String}
	 * @return
	 */
	public static boolean isNotEmptyOrNull(final String value) {
		return !isEmptyOrNull(value);
	}

	/**
	 * Checks whether it is empty or null.
	 * 
	 * @param value
	 *            - {@link Collection}
	 * @return
	 */
	public static boolean isEmptyOrNull(final Collection<?> value) {
		return value == null || value.isEmpty();
	}

	/**
	 * Checks whether it is empty or null.
	 * 
	 * @param value
	 *            - {@link Collection}
	 * @return
	 */
	public static boolean isNotEmptyOrNull(final Collection<?> value) {
		return !isEmptyOrNull(value);
	}

	/**
	 * @param s
	 *            {@link String}
	 * @return
	 */
	public static String utf8(String s) {
		return conveterCharset(s, "UTF-8");
	}

	/**
	 * @param s
	 *            {@link String}
	 * @return
	 */
	public static String iso88591(String s) {
		return conveterCharset(s, "ISO-8859-1");
	}

	private static String conveterCharset(String s, final String charSet) {
		if (isNotEmptyOrNull(s)) {
			try {
				s = new String(s.getBytes(charSet));
			} catch (UnsupportedEncodingException e) {
			}
		}
		return s;
	}
}
