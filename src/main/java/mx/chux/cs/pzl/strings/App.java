package mx.chux.cs.pzl.strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    
    public static void main( String[] args ) {
        final int lcss = new LongestCommonSubsequence("abcdez").apply("bdz");
        LOGGER.log(Level.INFO, "LCSS: {0}", lcss);
    }
    
}
