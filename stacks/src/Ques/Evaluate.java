package Ques;

import java.util.*;

public class Evaluate {
	// helper
	public static int priority(char op) {
		if(op == '/' || op == '*') return 2;
		else if(op == '+' || op == '-') return 1;
		else return 0;
	}
	
	public static String evaluatePre(String val1, String val2, char op) {
		return  "" + op + val1 + val2;
	}
	
	public static String evaluatePost(String val1, String val2, char op) {
		return val1 + val2 + op;
	}
	
	public static int evaluate(int val1, int val2, char op) {
		if(op == '*') {
			return val1 * val2;
		}else if(op == '/') {
			return val1 / val2;
		}else if(op == '+') {
			return val1 + val2;
		}else if(op == '-') {
			return val1 - val2;
		}else {
			return 0;
		}
	}
    // infix
    public static int infixEvaluation(String str) {
    	Stack<Character> operatorSt = new Stack<>();
        Stack<Integer> valueSt = new Stack<>();
        	
        	for(int i = 0; i < str.length(); i++) {
        		char ch = str.charAt(i);
        		if(ch == ' ') continue;
        		else if(ch >= '1' && ch <= '9') valueSt.push((int)(ch - '0'));
        		else if(ch == '(') operatorSt.push(ch);
        		else if(ch == ')') {
        			while(operatorSt.peek() != '(') {
        				int val2 = valueSt.pop();
        				int val1 = valueSt.pop();
        				char op = operatorSt.pop();
        				
        				int res = evaluate(val1, val2, op);
        				valueSt.push(res);
        			}
        			operatorSt.pop();
        		}
        		else {
        			while(operatorSt.size() > 0 && operatorSt.peek() != '(' && priority(operatorSt.peek()) >= priority(ch)) {
        				int val2 = valueSt.pop();
        				int val1 = valueSt.pop();
        				char op = operatorSt.pop();
        				
        				int res = evaluate(val1, val2, op);
        				valueSt.push(res);
        			}
        			operatorSt.push(ch);
        		}
        	}
        	while(operatorSt.size() > 0) {
        		int val2 = valueSt.pop();
    			int val1 = valueSt.pop();
    			char op = operatorSt.pop();
    			
    			int res = evaluate(val1, val2, op);
    			valueSt.push(res);
        	}
        	return valueSt.pop();
    }

    public static void infixToPrefix(String str) {
    	Stack<Character> operatorSt = new Stack<>();
        Stack<String> valueSt = new Stack<>();
        	
        	for(int i = 0; i < str.length(); i++) {
        		char ch = str.charAt(i);
        		if(ch == ' ') continue;
        		else if(ch >= 'a' && ch <= 'z') valueSt.push("" + ch);
        		else if(ch == '(') operatorSt.push(ch);
        		else if(ch == ')') {
        			while(operatorSt.peek() != '(') {
        				String val2 = valueSt.pop();
        				String val1 = valueSt.pop();
        				char op = operatorSt.pop();
        				
        				String res = evaluatePre(val1, val2, op);
        				valueSt.push(res);
        			}
        			operatorSt.pop();
        		}
        		else {
        			while(operatorSt.size() > 0 && operatorSt.peek() != '(' && priority(operatorSt.peek()) >= priority(ch)) {
        				String val2 = valueSt.pop();
        				String val1 = valueSt.pop();
        				char op = operatorSt.pop();
        				
        				String res = evaluatePre(val1, val2, op);
        				valueSt.push(res);
        			}
        			operatorSt.push(ch);
        		}
        	}
        	while(operatorSt.size() > 0) {
        		String val2 = valueSt.pop();
        		String val1 = valueSt.pop();
    			char op = operatorSt.pop();
    			
    			String res = evaluatePre(val1, val2, op);
    			valueSt.push(res);
        	}
        	System.out.println(valueSt.pop());
    }

    public static void infixToPostfix(String str) {
    	Stack<Character> operatorSt = new Stack<>();
        Stack<String> valueSt = new Stack<>();
        	
        	for(int i = 0; i < str.length(); i++) {
        		char ch = str.charAt(i);
        		if(ch == ' ') continue;
        		else if(ch >= 'a' && ch <= 'z') valueSt.push("" + ch);
        		else if(ch == '(') operatorSt.push(ch);
        		else if(ch == ')') {
        			while(operatorSt.peek() != '(') {
        				String val2 = valueSt.pop();
        				String val1 = valueSt.pop();
        				char op = operatorSt.pop();
        				
        				String res = evaluatePost(val1, val2, op);
        				valueSt.push(res);
        			}
        			operatorSt.pop();
        		}
        		else {
        			while(operatorSt.size() > 0 && operatorSt.peek() != '(' && priority(operatorSt.peek()) >= priority(ch)) {
        				String val2 = valueSt.pop();
        				String val1 = valueSt.pop();
        				char op = operatorSt.pop();
        				
        				String res = evaluatePost(val1, val2, op);
        				valueSt.push(res);
        			}
        			operatorSt.push(ch);
        		}
        	}
        	while(operatorSt.size() > 0) {
        		String val2 = valueSt.pop();
        		String val1 = valueSt.pop();
    			char op = operatorSt.pop();
    			
    			String res = evaluatePost(val1, val2, op);
    			valueSt.push(res);
        	}
        	System.out.println(valueSt.pop());
    }

    // prefix
    public static int prefixEvaluation(String str) {
    	Stack<Integer> valueSt = new Stack<>();
    	for(int i = str.length() - 1; i >= 0; i--) {
    		char ch = str.charAt(i);
    		if(ch >= '0' && ch <= '9') {
    			valueSt.push((int)(ch - '0'));
    		}else {
    			int value1 = valueSt.pop();
    			int value2 = valueSt.pop();
    			int res = evaluate(value1, value2, ch);
    			valueSt.push(res);
    		}
    	}
    	return valueSt.pop();
    }

    public static void prefixToInfix(String str) {
    	Stack<String> valueSt = new Stack<>();
    	for(int i = str.length() - 1; i >= 0; i--) {
    		char ch = str.charAt(i);
    		if(ch >= '0' && ch <= '9') {
    			valueSt.push("" + ch);
    		}else {
    			String value1 = valueSt.pop();
    			String value2 = valueSt.pop();
    			String res = "(" + value1 + ch + value2 + ")";
    			valueSt.push(res);
    		}
    	}
    	System.out.println(valueSt.pop());
    }

    public static void prefixToPostfix(String str) {
    	Stack<String> valueSt = new Stack<>();
    	for(int i = str.length() - 1; i >= 0; i--) {
    		char ch = str.charAt(i);
    		if(ch >= '0' && ch <= '9') {
    			valueSt.push("" + ch);
    		}else {
    			String value1 = valueSt.pop();
    			String value2 = valueSt.pop();
    			String res = value1 + value2 + ch;
    			valueSt.push(res);
    		}
    	}
    	System.out.println(valueSt.pop());
    }

    public static int postfixEvaluation(String str) {
    	Stack<Integer> valueSt = new Stack<>();
    	for(int i = 0; i < str.length(); i++) {
    		char ch = str.charAt(i);
    		if(ch >= '0' && ch <= '9') {
    			valueSt.push((int)(ch - '0'));
    		}else {
    			int value2 = valueSt.pop();
    			int value1 = valueSt.pop();
    			int res = evaluate(value1, value2, ch);
    			valueSt.push(res);
    		}
    	}
    	return valueSt.pop();
    }

    public static void postfixToPrefix(String str) {
    	Stack<String> valueSt = new Stack<>();
    	for(int i = 0; i < str.length(); i++) {
    		char ch = str.charAt(i);
    		if(ch >= '0' && ch <= '9') {
    			valueSt.push("" + ch);
    		}else {
    			String value2 = valueSt.pop();
    			String value1 = valueSt.pop();
    			String ph = "" + ch + value1 + value2;
    			valueSt.push(ph);
    		}
    	}
    	System.out.println(valueSt.pop());
    }

    public static void postixToinfix(String str) {
    	Stack<String> valueSt = new Stack<>();
    	for(int i = 0; i < str.length(); i++) {
    		char ch = str.charAt(i);
    		if(ch >= '0' && ch <= '9') {
    			valueSt.push("" + ch);
    		}else {
    			String value2 = valueSt.pop();
    			String value1 = valueSt.pop();
    			String ph = "(" + value1 + ch + value2 + ")";
    			valueSt.push(ph);
    		}
    	}
    	System.out.println(valueSt.pop());
    }
    
    public static void evaluation() {
        String str = "";

    }
    
    public static void main(String[] args) {
        evaluation();    
    }
}
