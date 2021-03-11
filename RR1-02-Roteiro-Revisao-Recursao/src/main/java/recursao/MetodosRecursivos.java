package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;

		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY

		if (array.length > 0) {
			result = calcularSomaArrayRecursivo(array, 0);
		}

		return result;
	}

	private int calcularSomaArrayRecursivo(int[] array, int indice) {
		int soma = array[indice];

		if (indice != array.length-1) {
			soma += calcularSomaArrayRecursivo(array, indice + 1);
		}

		return soma;
	}

	public long calcularFatorial(int n) {
		long result = 1;

		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS

		if (n > 1) {
			result = n * calcularFatorial(n-1);
		}

		System.out.println(result);

		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;

		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS

		System.out.println(1);

		if (n == 1 || n == 2) {
			return 1;
		} else {
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}

		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;

		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO

		result = countNotNullRecursivo(array, 0);

		return result;
	}

	private int countNotNullRecursivo(Object[] array, int indice) {
		int count = 0;

		if (array.length != indice) {
			if (array[indice] == null) {
				count += 1;
			}
			return count + countNotNullRecursivo(array, indice+1);
		}

		return count;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;

		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2

		if (expoente != 0) {
			result = 2 * (int) potenciaDe2(expoente-1);
		}

		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;

		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		if (n <= 1) {
			result = termoInicial;
		} else {
			return progressaoAritmetica(termoInicial + razao, razao, n - 1);
		}

		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;

		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO

		if (n <= 1) {
			result = termoInicial;
		} else {
			return progressaoGeometrica(termoInicial * razao, razao, n-1);
		}

		return result;
	}
	
	
}
