public class SecurityLevel {
	final int low = 2;
	final int high = 1;

	public static boolean simple_security (int sb_lvl, int ob_lvl) {
		// to read, subject >= object in terms of security level

		if (sb_lvl <= ob_lvl) {
			return true;
		}
		return false;
	}

	public static boolean star_property (int sb_lvl, int ob_lvl) {
		// to write, subject <= object in terms of security level.
		
		if (sb_lvl >= ob_lvl) {
			return true;
		}		
		return false;
	} 
}