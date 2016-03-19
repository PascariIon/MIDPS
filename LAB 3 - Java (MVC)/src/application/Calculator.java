package application;

public class Calculator {
	private double memory = 0;
	
	public double memoryClear(){
		return memory = 0;
	}
	
	public double memorySave(String text){
		double number = stringToDouble(text);
		return memory = number;
	}
	
	public double memoryPlus(String text){
		double number = stringToDouble(text);
		return memory += number;
	}
	
	public double memoryResult(){
		return memory;
	}
	
	public double evaluateExpression(String expression) {
		double result = 0.0;
		double firstOperand;
		double secondOperand;
		String[] tokens = expression.split(" ");
		try {
			firstOperand = Double.parseDouble(tokens[0]);
			secondOperand = Double.parseDouble(tokens[2]);
		} catch (Exception e) {
			return Double.NaN;
		}

		switch (tokens[1]) {
		case "+":
			result = firstOperand + secondOperand;
			break;
		case "-":
			result = firstOperand - secondOperand;
			break;
		case "*":
			result = firstOperand * secondOperand;
			break;
		case "/":
			result = firstOperand / secondOperand;
			break;
		case "^":
			result = Math.pow(firstOperand, secondOperand);
			break;

		}

		return result;
	}

	public boolean isEvaluable(String expression) {
		double firstOperand;
		double secondOperand;
		String[] tokens = expression.split(" ");
		try {
			firstOperand = Double.parseDouble(tokens[0]);
			secondOperand = Double.parseDouble(tokens[2]);
		} catch (Exception e) {
			return false;
		}

		if (tokens.length != 3) {
			return false;
		}

		if (!tokens[1].equals("+") && !tokens[1].equals("-") && !tokens[1].equals("/") && !tokens[1].equals("*")
				&& !tokens[1].equals("^"))
			return false;

		return true;
	}

	public double sinus(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = Math.sin(firstOperand);
		return result;
	}
	
	public double cosinus(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = Math.cos(firstOperand);
		return result;
	}
	
	public double tangent(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = Math.tan(firstOperand);
		return result;
	}
	
	public double arcTangent(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = Math.atan(firstOperand);
		return result;
	}
	
	public double reciprocal(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = 1 / firstOperand;
		return result;
	}
	
	public double sqrt(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = Math.sqrt(firstOperand);
		return result;
	}
	
	public double sqr(String expression) {
		double result = 0;
		double firstOperand = stringToDouble(expression);
		result = Math.pow(firstOperand, 2);
		return result;
	}

	private double stringToDouble(String expression) {
		double firstOperand;
		String tokens[] = expression.split(" ");
		try {
			firstOperand = Double.parseDouble(tokens[0]);
		} catch (Exception e) {
			return Double.NaN;
		}
		return firstOperand;
	}
}
