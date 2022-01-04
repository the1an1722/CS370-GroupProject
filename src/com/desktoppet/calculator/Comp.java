package com.desktoppet.calculator;
/*
 * Description: Computing function for calculator function
 *
 * @author Bingming Zhang
 */

import java.util.Deque;
import java.util.LinkedList;
public class Comp {

	private Deque<Character> operation = new LinkedList<Character>();
	private Deque<Double> value = new LinkedList<Double>();

	public double add(double a, double b)
	{
		return a+b;
	}

	public double subtract(double a, double b)
	{
		return a-b;
	}

	public double multiply(double a, double b)
	{
		return a*b;
	}

	public double division(double a, double b)
	{
		if (b==0) throw new ArithmeticException("Cannot Divide Zero"); //throw exception
		else
		{
			return a/b;
		}
	}

	public double power(double a, double b)
	{
		double abs_b = Math.abs(b);
		if(abs_b - Math.ceil(abs_b)<0 && abs_b - Math.floor(abs_b)>0) return Math.pow(a,b);
		double prod = 1;
		for(int i=0;i<abs_b;i++)
		{
			prod = prod * a ;
		}
		if(b<0) return 1.0/prod;
		else return prod;
	}

	public double factorial(double a)
	{
		if(a - Math.ceil(a)<0 && a - Math.floor(a)>0)
			throw new ArithmeticException("Factorial only works on integer");
		if(a<=1) return 1;
		else if(a<5)
		{
			double prod = 1;
			for(int i = 2; i<=a;i++)
				prod = prod * i;
			return prod;
		}
		else
		{
			return a*factorial(a-1);
		}
	}

	public double mod(double a,double b)
	{
		if(b==0) throw new ArithmeticException("Cannot Divide Zero"); //throw exception
		return a%b;
	}

	public void Setup(String str)
	{
		str.trim();
		if(str.contains("!"))
		{
			String value1 = str.substring(0,str.length()-1);
			value.add(Double.parseDouble(value1));
			operation.add('!');
		}
		else{
			for(int i=0;i<str.length();i++)
				if((str.charAt(i) == '+'||
						str.charAt(i)=='-'||
						str.charAt(i)=='*'||
						str.charAt(i)=='/'||
						str.charAt(i)=='%'||
						str.charAt(i)=='^')&i!=0)
				{
					operation.add(str.charAt(i));
					String temp = str.substring(0,i);
					String temp2 = str.substring(i+1);
					try {
						value.add(Double.parseDouble(temp));
						value.add(Double.parseDouble(temp2));
					}catch (Exception e){}
					break;
				}

		}
	}


	public double operationCall()
	{
		char op = operation.pop();
		if(value.size()==0) throw new ArithmeticException("ERROR");
		double ans=0;
		double a =value.pop();
		double b = 0;
		if(value.size()==1)
			b = value.pop();
		if(op == '+')
			ans = add(a,b);
		else if (op == '-')
			ans = subtract(a,b);
		else if(op == '*')
			ans = multiply(a,b);
		else if(op == '/')
			ans = division(a,b);
		else if(op == '^')
			ans = power(a,b);
		else if(op == '!')
			ans = factorial(a);
		else if(op == '%')
			ans = mod(a,b);
		return ans;
	}

	/*public static void main(String[] args) {
		try {
				Comp me=new Comp();
				me.Setup("7856+623");
				me.operationCall();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}*/
}
