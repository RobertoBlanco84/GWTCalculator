package com.exempel.martin.client;

import java.util.ArrayList;

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
import com.google.gwt.user.client.ui.FlexTable;
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
	private HorizontalPanel addPanelOperand1 = new HorizontalPanel();
	private HorizontalPanel addPanelOperators = new HorizontalPanel();
	private HorizontalPanel addPanelOperand2 = new HorizontalPanel();
	private HorizontalPanel addPanelCalcButton = new HorizontalPanel();
	private HorizontalPanel addPanelResult = new HorizontalPanel();
	private HorizontalPanel addPanelResultFlex = new HorizontalPanel();
	private TextBox operand1TextBox = new TextBox();
	private TextBox operand2TextBox = new TextBox();
	private MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
	private Button multiply = new Button("*");
	private Button modulo = new Button("%");
	private Button division = new Button("/");
	private Button subtraction = new Button("-");
	private Button addition = new Button("+");
	private Button calculateButton = new Button("Calculate");
	private TextBox resultTextBox = new TextBox();
	private FlexTable resultFlexTable = new FlexTable();
	private ArrayList<String> result = new ArrayList<String>();
	private String notValid = "Not valid, try again";

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
		resultFlexTable.setText(0, 0, "");

		addPanelOperand1.add(operand1TextBox);
		addPanelOperators.add(multiply);
		addPanelOperators.add(modulo);
		addPanelOperators.add(division);
		addPanelOperators.add(subtraction);
		addPanelOperators.add(addition);
		addPanelOperand2.add(operand2TextBox);
		addPanelCalcButton.add(calculateButton);
		addPanelResult.add(resultTextBox);
		addPanelResultFlex.add(resultFlexTable);

		// TODO Assemble Main panel.	
		mainPanel.add(addPanelOperand1);
		mainPanel.add(addPanelOperators);
		mainPanel.add(addPanelOperand2);
		mainPanel.add(addPanelCalcButton);
		mainPanel.add(addPanelResult);
		mainPanel.add(addPanelResultFlex);

		// TODO Associate the Main panel with the HTML host page.
		RootPanel.get("calc").add(mainPanel);

		operand1TextBox.setFocus(true);
		multiply.setWidth("2.5em");
		modulo.setWidth("2.5em");
		division.setWidth("2.5em");
		subtraction.setWidth("2.5em");
		addition.setWidth("2.5em");
		calculateButton.setWidth("13em");
		
		//ClickHandlers
		multiply.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcMulti();
						//multiply.setFocus(false);
					}});
			}});

		modulo.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcModulo();
						//resultTextBox.setFocus(true);
						modulo.setFocus(false);
					}});
			}});

		division.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcDiv();
						division.setFocus(false);
						//resultTextBox.setFocus(true);
					}});
			}});

		subtraction.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcSub();
						//resultTextBox.setFocus(true);
						subtraction.setFocus(false);
					}});
			}});

		addition.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {	
				calculateButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						calcAdd();
						//resultTextBox.setFocus(true);
						addition.setFocus(false);
					}});
			}});
	
		//KeyHandlers
		operand1TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					calcMulti();
					calcModulo();
					calcDiv();
					calcSub();
					calcAdd();
				}

			}
		});
		
		/*
		operand2TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if(multiply.getText().equals("*")) {
						calcMulti();
						//resultTextBox.setFocus(true);
					}
					if(modulo.getText().equals("%")) {
						calcModulo();
						resultTextBox.setFocus(true);
					}
					if(division.getText().equals("/")) {
						calcDiv();
						resultTextBox.setFocus(true);
					}
					if(subtraction.getText().equals("-")) {
						calcSub();
						resultTextBox.setFocus(true);
					}
					if(addition.getText().equals("+")) {
						calcAdd();
						resultTextBox.setFocus(true);
					}
								
				}

			}
		});*/
		
		/*operand2TextBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				
					if(modulo.getText().equals("%")) {
						calcModulo();
						resultTextBox.setFocus(true);
					}
					if(division.getText().equals("/")) {
						calcDiv();
						resultTextBox.setFocus(true);
					}
					if(subtraction.getText().equals("-")) {
						calcSub();
						resultTextBox.setFocus(true);
					}
					if(addition.getText().equals("+")) {
						calcAdd();
						resultTextBox.setFocus(true);
					}
								
				}

			}
		});*/
	} 

	//Calculate methods
	private void calcMulti() {
		calculateButton.setFocus(true);
		
		if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			resultTextBox.setText(notValid);
			
		}
		
		double operandMulti1 = Double.parseDouble(operand1TextBox.getText());
		double operandMulti2 = Double.parseDouble(operand2TextBox.getText());
		double multiAnswer;
		if(multiply.getText().equals("*")) {
			multiAnswer= operandMulti1 * operandMulti2;
			String stringAnswer = Double.toString(multiAnswer);
			resultTextBox.setText(stringAnswer);
			addResult();
		}
		
		
	} 

	private void calcModulo() {
		calculateButton.setFocus(true);
		if (!isInteger(operand1TextBox.getText().trim())|| !isInteger(operand2TextBox.getText().trim())) {
			resultTextBox.setText(notValid);
		}

		int operatorModulo1 = Integer.parseInt(operand1TextBox.getText());
		int operatorModulo2 = Integer.parseInt(operand2TextBox.getText());
		int moduloAnswer;
		if(modulo.getText().equals("%")) {
			moduloAnswer= operatorModulo1 % operatorModulo2;
			String stringAnswer = Double.toString(moduloAnswer);
			resultTextBox.setText(stringAnswer);
			addResult();
		}

	}

	private void calcDiv() {
		calculateButton.setFocus(true);
		if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			resultTextBox.setText(notValid);
		}

		double operandDiv1 = Double.parseDouble(operand1TextBox.getText());
		double operandDiv2 = Double.parseDouble(operand2TextBox.getText());
		double divAnswer;

		if(division.getText().equals("/")) {
			divAnswer= operandDiv1 / operandDiv2;
			String stringAnswer = Double.toString(divAnswer);
			resultTextBox.setText(stringAnswer);
			addResult();
		}

	} 

	private void calcSub() {
		calculateButton.setFocus(true);
		if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			resultTextBox.setText(notValid);
		}

		double operandSub1 = Double.parseDouble(operand1TextBox.getText());
		double operandSub2 = Double.parseDouble(operand2TextBox.getText());
		double subAnswer;

		if(subtraction.getText().equals("-")) {
			subAnswer= operandSub1 - operandSub2;
			String stringAnswer = Double.toString(subAnswer);
			resultTextBox.setText(stringAnswer);
			addResult();
		}

	} 

	private void calcAdd() {
		calculateButton.setFocus(true);
		if (!isDouble(operand1TextBox.getText().trim())|| !isDouble(operand2TextBox.getText().trim())) {
			resultTextBox.setText(notValid);
		}

		double operandAdd1 = Double.parseDouble(operand1TextBox.getText());
		double operandAdd2 = Double.parseDouble(operand2TextBox.getText());
		double addAnswer;

		if(addition.getText().equals("+")) {
			addAnswer= operandAdd1 + operandAdd2;
			String stringAnswer = Double.toString(addAnswer);
			resultTextBox.setText(stringAnswer);
			 addResult();
		}

	}
	
	private void addResult() {
		final String symbol = resultTextBox.getText();
		resultTextBox.setFocus(true);
		if (symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			resultTextBox.setText(notValid + symbol);
			resultTextBox.selectAll();
			return;
		}
		resultTextBox.setText("");
		if(result.contains(symbol)) {
			return;
		}
		int row = resultFlexTable.getRowCount();
		result.add(symbol);
		resultFlexTable.setText(row, 0, symbol);
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