public class TaxCalculator
{
	double calculaIR(double salario)
	{
		if(salario < 0)
		{
			throw new IllegalArgumentException("Valor negativo");
		}
		else if (salario <= 1566.61)
		{
			return 0;
		}
		else if (salario <= 2347.85)
		{
			return salario * 0.075;
		}
		else if (salario <= 3130.51)
		{
			return salario * 0.15;
		}
		else if (salario <= 3911.63)
		{
			return salario * 0.225;
		}
		else
		{
			return salario * 0.275;
		}
	}

}
