import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class TaxCalculatorTest
{
	@RunWith(Parameterized.class)
	public static class SuccessfulTests
	{
		private TaxCalculator calculator;
	
		private static final double TOLERANCE = 0.00001;
		private double arg;
		private double expected;
	
		public SuccessfulTests(double arg, double expected)
		{
			this.arg = arg;
			this.expected = expected;
		}
	
	
		@Parameters
		public static Collection<Object []> data()
		{
			return Arrays.asList(new Object[][]
					{ {0, 0},
					  {783.31, 0},
					  {1566.61, 0},
					  {1566.62, 117.4965},
					  {1957.24, 146.793},
					  {2347.85, 176.08875},
					  {2347.86, 352.179},
					  {2739.19, 410.8785},
					  {3130.51, 469.5765},
					  {3130.52, 704.367},
					  {3521.08, 792.243},
					  {3911.63, 880.11675},
					  {3911.64, 1075.701},
					  {1536845.69, 422632.56475}
					});
		}
		
		
		@Before
		public void initialize()
		{
			calculator = new TaxCalculator();
		}
	
		
		@Test
		public void test()
		{
			double tax = calculator.calculaIR(this.arg);
			assertEquals(tax, this.expected, TOLERANCE);
		}
	}
	
	public static class FailingTests
	{
		@Rule
		public ExpectedException exception = ExpectedException.none();
		
		@Test
		public void test_negative()
		{
			exception.expect(IllegalArgumentException.class);
			TaxCalculator calculator = new TaxCalculator();
			calculator.calculaIR(-1566.61);
		}
	}

}
