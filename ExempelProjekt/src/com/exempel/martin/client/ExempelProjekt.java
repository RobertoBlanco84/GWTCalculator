package com.exempel.martin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import apple.laf.JRSUIConstants.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class ExempelProjekt implements EntryPoint {
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel addPanel = new HorizontalPanel();
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
	//private Calculate calculator = new Calculate();
	//private Button sender = new Button();

	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		//Suggests the valid operators
		oracle.add("*");
		oracle.add("%");
		oracle.add("/");
		oracle.add("-");
		oracle.add("+");


		addPanel.add(operand1TextBox);
		addPanel.add(operatorTextBox);
		/*addPanel.add(multiply);
		addPanel.add(modulo);
		addPanel.add(division);
		addPanel.add(subtraction);
		addPanel.add(addition);*/
		addPanel.add(operand2TextBox);
		addPanel.add(calculateButton);
		addPanel.add(resultTextBox);

		// TODO Assemble Main panel.
		mainPanel.add(operand1TextBox);
		mainPanel.add(operatorTextBox);
		/*mainPanel.add(multiply);
		mainPanel.add(modulo);
		mainPanel.add(division);
		mainPanel.add(subtraction);
		mainPanel.add(addition);*/
		mainPanel.add(operand2TextBox);
		mainPanel.add(calculateButton);
		mainPanel.add(resultTextBox);

		mainPanel.add(addPanel);
		// TODO Associate the Main panel with the HTML host page.
		RootPanel.get("calc").add(mainPanel);
		// TODO Move cursor focus to the input box.
		
		
		/*calculateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(multiply.getText().equals("*")) {
					calcMulti();
			
				}
				 if(modulo.getText().equals("%")) {
					calcModulo();
				}
			}});
		
		multiply.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				 multiply.setFocus(false);
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcMulti();

					}});
			}});
		
		modulo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				 modulo.setFocus(false);
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcModulo();
					}});
			}});
		*/
		
		
		calculateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final String operator = operatorTextBox.getText().trim();
				switch(operator) {
				case ("*"):
					calcMulti();
				break;
				case ("%"):
					calcModulo();
				break;
				case ("/"):
					calcDiv();
				break;
				case ("-"):
					calcSub();
				break;
				case ("+"):
					calcAdd();
				break;
				}
				
			}});
	
		operand1TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				final String operator = operatorTextBox.getText().trim();
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					switch(operator) {
					case ("*"):
						calcMulti();
					break;
					case ("%"):
						calcModulo();
					break;
					case ("/"):
						calcDiv();
					break;
					case ("-"):
						calcSub();
					break;
					case ("+"):
						calcAdd();
					break;
					}

				}

			}
		});

		operatorTextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				final String operator = operatorTextBox.getText().trim();
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					switch(operator) {
					case ("*"):
						calcMulti();
					break;
					case ("%"):
						calcModulo();
					break;
					case ("/"):
						calcDiv();
					break;
					case ("-"):
						calcSub();
					break;
					case ("+"):
						calcAdd();
					break;
					}
				}

			}
		});
	
		operand2TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				final String operator = operatorTextBox.getText().trim();
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					switch(operator) {
					case ("*"):
						calcMulti();
					break;
					case ("%"):
						calcModulo();
					break;
					case ("/"):
						calcDiv();
					break;
					case ("-"):
						calcSub();
					break;
					case ("+"):
						calcAdd();
					break;
					}
				}

			}
		}); 
	}
	
	/*
	private void calcMulti() {
		 calculateButton.setFocus(true);
		 if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		double operandMulti1 = Double.parseDouble(operand1TextBox.getText());
		double operandMulti2 = Double.parseDouble(operand2TextBox.getText());
		double multiAnswer;
		if(multiply.getText().equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			Window.alert("The answer is " + multiAnswer);
		}
		if(multiply.getText().equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			String stringAnswer = Double.toString(multiAnswer);
			resultTextBox.setText(stringAnswer);
		}
	
	} 
	
	private void calcModulo() {
		calculateButton.setFocus(true);
		if (!isInteger(operand1TextBox.getText().trim())|| !isInteger(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
			return;
		}
	
		int operatorModulo1 = Integer.parseInt(operand1TextBox.getText());
		int operatorModulo2 = Integer.parseInt(operand2TextBox.getText());
		int moduloAnswer;
		if (modulo.getText().equals("%")) {
			moduloAnswer = operatorModulo1%operatorModulo2;
			Window.alert("The answer is " + moduloAnswer);
		}
		if(modulo.getText().equals("%")) {
			moduloAnswer= operatorModulo1 * operatorModulo2;
			String stringAnswer = Double.toString(moduloAnswer);
			resultTextBox.setText(stringAnswer);
		}
		
	} */
	
	
	//Calculate methods
	private void calcMulti() {
		final String operator = operatorTextBox.getText().trim();
		 calculateButton.setFocus(true);
		 if ((!operator.equals("*")) || !isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");

			return;
		}
	
		double operandMulti1 = Double.parseDouble(operand1TextBox.getText());
		double operandMulti2 = Double.parseDouble(operand2TextBox.getText());
		double multiAnswer;
		if(operator.equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			String stringAnswer = Double.toString(multiAnswer);
			resultTextBox.setText(stringAnswer);
		}
	
	}

	private void calcModulo() {
		final String operator = operatorTextBox.getText().trim();
		calculateButton.setFocus(true);
		if ((!operator.equals("%")) || !isInteger(operand1TextBox.getText().trim())|| !isInteger(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");

			return;
		}
	
		int operatorModulo1 = Integer.parseInt(operand1TextBox.getText());
		int operatorModulo2 = Integer.parseInt(operand2TextBox.getText());
		int moduloAnswer;
		if (operator.equals("%")) {
			moduloAnswer = operatorModulo1%operatorModulo2;
			String stringAnswer = Integer.toString(moduloAnswer);
			resultTextBox.setText(stringAnswer);
		}
	}
	
	private void calcDiv() {
		final String operator = operatorTextBox.getText().trim();	
		calculateButton.setFocus(true);

		if (!operator.equals("/") || !isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");

			return;
		}

		double operandDiv1=Double.parseDouble(operand1TextBox.getText());
		double operandDiv2=Double.parseDouble(operand2TextBox.getText());
		double divAnswer;
		//Division
		if (operator.equals("/"))
		{
			divAnswer=operandDiv1/operandDiv2;
			String stringAnswer = Double.toString(divAnswer);
			if(operandDiv2 == 0) {
				Window.alert(operandDiv1 + " is not divisible by " + operandDiv2);
			}

			else {
				resultTextBox.setText(stringAnswer);
			}

		}

	}

	private void calcSub() {
		final String operator = operatorTextBox.getText().trim();	
		calculateButton.setFocus(true);

		if (!operator.equals("-") || !isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");

			return;
		}
		double operandSub1=Double.parseDouble(operand1TextBox.getText());
		double operandSub2=Double.parseDouble(operand2TextBox.getText());
		double subAnswer;

		//Subtraction
		if (operator.equals("-"))
		{
			subAnswer=operandSub1-operandSub2;
			String stringAnswer = Double.toString(subAnswer);
			resultTextBox.setText(stringAnswer);

		}
	}

	private void calcAdd() {
		final String operator = operatorTextBox.getText().trim();	
		calculateButton.setFocus(true);

		if (!operator.equals("+") || !isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");

			return;
		}
		double operandAdd1=Double.parseDouble(operand1TextBox.getText());
		double operandAdd2=Double.parseDouble(operand2TextBox.getText());
		double addAnswer;
		//Addition
		if (operator.equals("+"))
		{
			addAnswer=operandAdd1+operandAdd2;
			String stringAnswer = Double.toString(addAnswer);
			resultTextBox.setText(stringAnswer);

		}
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