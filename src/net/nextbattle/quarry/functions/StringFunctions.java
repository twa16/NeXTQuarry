/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nextbattle.quarry.functions;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Bodhi
 */
public class StringFunctions {
    private static SecureRandom random = new SecureRandom();
    public static String generateRandomID() {
        return new BigInteger(130, random).toString(32);
    }
}
