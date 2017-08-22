package com.exempel.martin.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;

public class Calculate {

	private TextBox operand1TextBox = new TextBox();
	private TextBox operand2TextBox = new TextBox();
	private MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	private SuggestBox operatorTextBox = new SuggestBox(oracle);
	/*private Button multiply = new Button("*");
	private Button modulo = new Button("%");
	private Button division = new Button("/");
	private Button subtraction = new Button("-");
	private Button addition = new Button("+");*/
	private Button calculateButton = new Button("Calculate");
	private TextBox resultTextBox = new TextBox();
	private double operandMulti1;
	private double operandMulti2;
	private double answer;
	
	public Calculate(){
		
	}
	
	public Calculate(double answer){
		this.answer = answer;
	}
	
	public Calculate(double operandMulti1, double operandMulti2) {
			this.operandMulti1 = operandMulti1;
			this.operandMulti2 = operandMulti2;
	}
	

	
	public void calcMulti() {
		final String operator = operatorTextBox.getText().trim();
		 calculateButton.setFocus(true);
		if ((!operator.equals("*")) || !isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");

			
		}
	
		 operandMulti1 = Double.parseDouble(operand1TextBox.getText());
		 operandMulti2 = Double.parseDouble(operand2TextBox.getText());
		double multiAnswer;
		/*if(operator.equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			String stringAnswer = Double.toString(multiAnswer);
			resultTextBox.setText(stringAnswer);
		}*/
		if(operator.equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			Window.alert("The answer is " + multiAnswer);
		}
	
	}
	

	public double getAnswer() {
		return answer;
	}
	
	public void setAnswer(Double answer) {
	      this.answer = answer;
	   }
	
	public double getOperandMulti1() {
		return operandMulti1;
	}
	
	public double getOperandMulti2() {
		return operandMulti2;
	}
	
	
	//Checks if a String could be seen as an integer
		public boolean isInteger( String input )
		{
			try
			{
				Integer.parseInt( input );
				return true;
			}
			catch(NumberFormatException e)
			{
				return false;
			}
		}

		//Checks if a String could be seen as double
		public boolean isDouble( String input )

		{
			try
			{
				Double.parseDouble( input );
				return true;
			}
			catch(NumberFormatException e)
			{
				return false;
			}
		}

		
}
