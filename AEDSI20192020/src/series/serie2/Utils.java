package series.serie2;

import java.util.Stack;

public class Utils {
	public static int evaluateRPN(String expression){
	Stack<String> stack= new Stack<String>();
		if(expression.length()==0) return 0;
	String[] parts=expression.split("\\s+");
		if(parts.length==0) return 0;
	int i=0;
		while(i<parts.length){

		if(isNumber(parts[i])){
			stack.push(parts[i]);
		}
		else{
			if(isOperator(parts[i])){
				if(stack.isEmpty())  throw new IllegalArgumentException();
				String op1=stack.pop();
				if(stack.isEmpty())  throw new IllegalArgumentException();
				String op2=stack.pop();
				if(!isNumber(op1) || !isNumber(op2)) throw new IllegalArgumentException();
				String r=process(op2,op1, parts[i]);
				stack.push(r);
			}
			else throw new IllegalArgumentException();
		}
		i++;
	}
	String fim=stack.pop();
		if(!isNumber(fim) || !stack.isEmpty()) throw new IllegalArgumentException();

		return Integer.parseInt(fim);
}

	private static boolean isNumber(String s){
		for(int j=0; j<s.length();j++)
			if(j==0){
				if(! (Character.isDigit(s.charAt(0)) || s.charAt(0)=='-')) return false;
				else{
					if( s.charAt(0)=='-' && s.length()==1) return false;
				}
			}
			else{
				if(!Character.isDigit(s.charAt(j))) return false;
			}
		return true;

	}

	private static String process(String op1, String op2, String op){
		int d1=Integer.parseInt(op1);
		int d2=Integer.parseInt(op2);
		int result=0;
		char a= op.charAt(0);
		switch(a){
			case '+':  result=d1+d2; break;
			case '-': result= d1-d2; break;
			case '/': result= (int) d1/d2; break;
			default: result=d1*d2;
		}

		return String.valueOf(result);

	}

	private static boolean isOperator(String s){
		if(s.length()>1) return false;
		char a= s.charAt(0);
		return ( a=='+' || a=='-' || a=='*' || a=='/');

	}




}


