package bddTesting;

import java.util.Stack;
import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefinition {
	
	CreateAStack creatingStack;
	CreateAStack creatingSecondStack;
	Object obj;
	Object obj2;
	Object obj3;
	Stack<Object> temp;
	Stack<Object> temp2;
	
	@Given("^an empty stack$")
	public CreateAStack an_empty_stack() {
	 creatingStack = new CreateAStack();
		temp = creatingStack.newStack();
		return creatingStack;
		
	}
	
	@Given("^a populated stack$")
	public CreateAStack a_populated_stack() {
		creatingSecondStack = new CreateAStack();
		temp2 = creatingSecondStack.newStack();
		obj2 = new Object();
		obj3 = new Object();
		temp2.push(obj2);
		temp2.push(obj3);
		return creatingSecondStack;
	}
	
	@When("^I want to do something$")
	public void i_want_to_do_something() {
		obj = new Object();
		temp.push(obj);
	}
	
	@Then("^I have done something$")
	public void i_have_done_something() {
		int howBig = temp.size();
		assertEquals(1,howBig);
	}
	
	@When("^they call me poppaBear$")
	public void they_call_me_poppaBear() {
		int initSize = temp2.size();
		for(int i = 0; i < initSize; i++) {
			temp2.pop();
		}
	}
	
	@Then("^stack gets popped$")
	public void stack_gets_popped() {
		int bearSize = temp2.size();
		assertEquals(0,bearSize);
	}

}
