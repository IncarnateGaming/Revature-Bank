package com.revature.bank.services.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathHelper {
	private MathHelper() {
	}
	public static String doubleTextOut(double input) {
		input = doubleRound2(input);
		return String.format("%.2f", input);
	}
	public static double doubleRound2(double input) {
		return doubleRound(input,2);
	}
	public static double doubleRound8(double input) {
		return doubleRound(input,8);
	}
	private static double doubleRound(double input, int precision) {
		BigDecimal bigDecimal = BigDecimal.valueOf(input);
		bigDecimal = bigDecimal.setScale(precision, RoundingMode.HALF_EVEN);
		return bigDecimal.doubleValue();
	}
}
