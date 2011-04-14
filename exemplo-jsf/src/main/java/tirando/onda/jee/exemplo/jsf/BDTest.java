package tirando.onda.jee.exemplo.jsf;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class BDTest {

	public static void main(String[] args) throws Exception {
//		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.getDefault());
//		BigDecimal payment = new BigDecimal("1523.3221");
//		payment = payment.setScale(2,RoundingMode.CEILING);
//		
//		System.out.println(payment.doubleValue());
//
//		System.out.println(n.format(payment.doubleValue()));
//
//		System.out.println(n.format(payment.add(new BigDecimal("0.5")).doubleValue()));


//        String value = "1.523,32";
        
        Locale locale = Locale.getDefault();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        System.out.println(symbols.getDecimalSeparator());
        System.out.println(symbols.getGroupingSeparator());
        
		DecimalFormat f = new DecimalFormat("#,##0.00", symbols);
		System.out.println(f.format(new BigDecimal("1523.32")));
		
		
//		Number num = f.parse(value);
//		System.out.println(num);
		

	}

}
