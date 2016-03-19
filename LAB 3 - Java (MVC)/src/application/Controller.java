package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Paint;

public class Controller {
	@FXML
	private TextArea textAreaLabel;
	@FXML
	private Button memResultButton;

	private Calculator calculator = new Calculator();

	public void backspaceButtonClicked() {
		String text = textAreaLabel.getText().trim();
		if (!(text.equals("")))
			textAreaLabel.setText(text.substring(0, text.length() - 1).trim());
	}

	public void clearButtonClicked() {
		textAreaLabel.setText("");
	}

	public void clearAllButtonClicked() {
		textAreaLabel.setText("");
	}

	public void memClearButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.memoryClear();
		memResultButton.setTextFill(Paint.valueOf("black"));
	}

	public void memResultButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.memoryResult();
		String[] tokens = text.split(" ");
		if (tokens.length < 2)
			textAreaLabel.setText(result + "");
		else if (tokens.length == 2)
			textAreaLabel.setText(text + result);
	}

	public void memSaveButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		memResultButton.setTextFill(Paint.valueOf("red"));
		double result = calculator.memorySave(text);
	}

	public void memAddButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		memResultButton.setTextFill(Paint.valueOf("red"));
		double result = calculator.memoryPlus(text);
	}

	public void atanButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.arcTangent(text);
		textAreaLabel.setText(result + "");
	}

	public void tanButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.tangent(text);
		textAreaLabel.setText(result + "");
	}

	public void cosButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.cosinus(text);
		textAreaLabel.setText(result + "");
	}

	public void sinButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.sinus(text);
		textAreaLabel.setText(result + "");
	}

	public void zeroButtonClicked() {
		String text = textAreaLabel.getText();
		try {
			double number = Double.parseDouble(text);
			if (number != 0)
				textAreaLabel.setText(text + "0");
		} catch (NumberFormatException e) {
			textAreaLabel.setText(text + "0");
		}
	}

	public void oneButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "1");
	}

	public void twoButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "2");
	}

	public void threeButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "3");
	}

	public void fourButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "4");
	}

	public void fiveButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "5");
	}

	public void sixButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "6");
	}

	public void sevenButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "7");
	}

	public void eightButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "8");
	}

	public void nineButtonClicked() {
		String text = textAreaLabel.getText();
		textAreaLabel.setText(text + "9");
	}

	public void pointButtonClicked() {
		String text = textAreaLabel.getText();
		String[] tokens = text.split(" ");
		if (tokens[0] != null && tokens[0].indexOf(".") < 0)
			textAreaLabel.setText(text + ".");

		if (tokens.length > 2 && tokens[2].indexOf(".") < 0)
			textAreaLabel.setText(text + ".");
	}

	public void changeSignButtonClicked() {
		String text = textAreaLabel.getText();

		try {
			double number = Double.parseDouble(text);
			number *= -1;
			textAreaLabel.setText("" + number);
		} catch (NumberFormatException e) {

		}

	}

	public void equalSignButtonClicked() {
		String text = textAreaLabel.getText();
		double result;
		if (calculator.isEvaluable(text)) {
			result = calculator.evaluateExpression(text);
			textAreaLabel.setText(result + "");
		}
	}

	public void constantPiButtonClicked() {
		String text = textAreaLabel.getText();
		String[] tokens = text.split(" ");
		if (tokens.length == 2 || tokens[0].length() == 0)
			textAreaLabel.setText(text + Math.PI);
	}

	public void constantEulerButtonClicked() {
		String text = textAreaLabel.getText();
		String[] tokens = text.split(" ");
		if (tokens.length == 2 || tokens[0].length() == 0)
			textAreaLabel.setText(text + Math.E);
	}

	public void rootButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.sqrt(text);
		textAreaLabel.setText(result + "");
	}

	public void squareButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.sqr(text);
		textAreaLabel.setText(result + "");
	}

	public void nthPowerButtonClicked() {
		equalSignButtonClicked();
		setAndChangeOperatorIfNeeded("^");
	}

	public void subtrationButtonClicked() {
		equalSignButtonClicked();
		setAndChangeOperatorIfNeeded("-");
	}

	private void setAndChangeOperatorIfNeeded(String operator) {
		String text = textAreaLabel.getText();
		String[] tokens = text.split(" ");
		if (tokens.length == 1 && tokens[0].length() > 0)
			textAreaLabel.setText(tokens[0] + " " + operator + " ");

		if (tokens.length > 1) {
			tokens[1] = operator;
			textAreaLabel.setText(tokens[0] + " " + tokens[1] + " ");
		}
		if (tokens.length > 2)
			textAreaLabel.setText(textAreaLabel.getText() + tokens[2]);
	}

	public void additionButtonClicked() {
		equalSignButtonClicked();
		setAndChangeOperatorIfNeeded("+");
	}

	public void multiplicationButtonClicked() {
		equalSignButtonClicked();
		setAndChangeOperatorIfNeeded("*");
	}

	public void divisionButtonClicked() {
		equalSignButtonClicked();
		setAndChangeOperatorIfNeeded("/");
	}

	public void reciprocalButtonClicked() {
		equalSignButtonClicked();
		String text = textAreaLabel.getText();
		double result = calculator.reciprocal(text);
		textAreaLabel.setText(result + "");
	}

}
