package Exercise1;

import java.math.BigInteger;

public class SmallnessOfE {

	public static void main(String[] args) {

		BigInteger N = new BigInteger("230956751003764603539805812976752233730" +
									  "26833410647478222648288977449481620360427");
		BigInteger c = new BigInteger("674472526620593903800497637242400187916753185909");
		BigInteger e = BigInteger.valueOf(3);
		
		
		BigInteger cubeRootOfC = cubeRoot(c);
		
		// Proof
		System.out.println("Cube root of cipher: " + cubeRootOfC);
		System.out.println(cubeRootOfC.pow(3));
		
		String ascii = cubeRootOfC.toString();
		
		String result = "";
		for(int i = 0; i < ascii.length(); i+=2){
			System.out.println(ascii.substring(i, i+2));
			result += (char)(Integer.parseInt(ascii.substring(i, i + 2)));
		}
		
		System.out.println(result);
		
	}
	
	private static final BigInteger THREE = BigInteger.valueOf(3);

	private static BigInteger cubeRoot(BigInteger n) {
	    BigInteger x = BigInteger.ZERO.setBit(n.bitLength() / 3 + 1);
	    while (true) {
	        BigInteger y = x.shiftLeft(1).add(n.divide(x.multiply(x))).divide(THREE);
	        if (y.compareTo(x) >= 0) {
	            break;
	        }

	        x = y;
	    }

	    return x;
	}

}
