package com.exempel.martin.client;

import com.google.gwt.user.client.Window;

public class Calculate {

	private double div1;
	private double div2;
	ExempelProjekt div = new ExempelProjekt();
	
	public Calculate(){
		
	}
	public Calculate(ExempelProjekt div){
		this.div= div;
	}
	
	public Calculate(double div1, double div2){
		this.div1= div1;
		this.div2= div2;
	}

	/*
	public double getDiv() {	
		final String operator = div.operatorTextBox.getText().trim();
		div.calculateButton.setFocus(true);
		if (!operator.equals("/") || !isInteger(div.operand1TextBox.getText().trim())|| !isInteger(div.operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
		}
		double operandDiv1=Integer.parseInt(div.operand1TextBox.getText());
		double operandDiv2=Integer.parseInt(div.operand2TextBox.getText());
		double divAnswer;
		//Division
		if (operator.equals("/"))
		{
			divAnswer=operandDiv1/operandDiv2;
			if(operandDiv2 == 0) {
				Window.alert(operandDiv1 + " is not divisible by " + operandDiv2);
			}

			else {
				Window.alert("The answer is: " + divAnswer);
			}

		}
		return div1/div2;
	}
*/

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
	
}
