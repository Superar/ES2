import java.util.*;

public class TaxCalculatorMain
{

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		scanner.useLocale(Locale.US);

		System.out.print("Digite o salário bruto: R$");
		double salario = scanner.nextDouble();
		
		TaxCalculator calculator = new TaxCalculator();

		System.out.println(calculator.calculaIR(salario));
	}

}
