package part4;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) throws InterruptedException {
		System.out.println(isBool2("true"));
		System.out.println(isBool2("True"));
		System.out.println(isBool2("trUe"));
		System.out.println(isBool2("truthis"));
		System.out.println(isBool2("FalSe"));
		isBool("fAlSE");
		isBool("truth");
		isBool("true");
		isBool("fAlSE");
		isBool("truth");
		isBool("falling");
		isBool("true");
		isBool("fAlSE");
		isBool("truth");
		isBool("falling");
		isBool("falling");
		Thread.sleep(100);
		
		long time1=System.nanoTime();
		isBool2("true");
		isBool2("fAlSE");
		isBool2("truth");
		isBool2("falling");
		long time2=System.nanoTime();
		isBool("true");
		isBool("fAlSE");
		isBool("truth");
		isBool("falling");
		long time3=System.nanoTime();
		System.out.println(time2-time1);
		System.out.println(time3-time2);
		 time1=System.nanoTime();
		isBool2("true");
		isBool2("fAlSE");
		isBool2("truth");
		isBool2("falling");
		 time2=System.nanoTime();
		isBool("true");
		isBool("fAlSE");
		isBool("truth");
		isBool("falling");
		 time3=System.nanoTime();
		System.out.println(time2-time1);
		System.out.println(time3-time2);
		 time1=System.nanoTime();
		isBool2("true");
		isBool2("fAlSE");
		isBool2("truth");
		isBool2("falling");
		 time2=System.nanoTime();
		isBool("true");
		isBool("fAlSE");
		isBool("truth");
		isBool("falling");
		 time3=System.nanoTime();
		System.out.println(time2-time1);
		System.out.println(time3-time2);
		
		System.out.println((char)((int)'T'|0b00100000));
		/*
		System.out.println(closed(10));
		System.out.println(dynamicRecurise(10));
		System.out.println(tailRecursive(1000));
		System.out.println(iterative(10));
		
		
		timeTimable((int i)->closed(i));
		timeTimable((int i)->dynamicRecurise(i));
		/**/
		/*
		System.out.println(closed(0));
		System.out.println(niavRecursive(0));
		System.out.println(dynamicRecurise(0));
		System.out.println("______");
		System.out.println(closed(1));
		System.out.println(niavRecursive(1));
		System.out.println(dynamicRecurise(1));
		System.out.println("______");
		System.out.println(closed(2));
		System.out.println(niavRecursive(2));
		System.out.println(dynamicRecurise(2));
		System.out.println("______");
		System.out.println(closed(3));
		System.out.println(niavRecursive(3));
		System.out.println(tailRecursive(3));/**/
	}
	
	
	public static boolean isBool2(String s){
	    /*Crazy inlining here for speed purposes*/
	    /*Basically it checks if the string is (case-insensitive) equal to true or false */
	    return (s.length()==4 &&     (s.charAt(0) == 't' || s.charAt(0)== 'T') &&
	                                    (s.charAt(1) == 'r' || s.charAt(1) == 'R') &&
	                                    (s.charAt(2) == 'u' || s.charAt(2) == 'U') &&
	                                    (s.charAt(3) == 'e' || s.charAt(2) == 'E')) ||
	        ((s.length() == 5) && (s.charAt(0) == 'f' || s.charAt(0) == 'F') &&
	                                    (s.charAt(1) == 'a' || s.charAt(1) == 'A') &&
	                                    (s.charAt(2) == 'l' || s.charAt(2) == 'L') &&
	                                    (s.charAt(3) == 's' || s.charAt(3) == 'S') &&
	                                    (s.charAt(4) == 'e' || s.charAt(4) == 'E'));
	}
	public static boolean isBool(String s){
	    /*Crazy inlining here for speed purposes*/
	    /*Basically it checks if the string is (case-insensitive) equal to true or false */
	    return ((s.length()==4 &&     ((s.charAt(0)|(char)0b0010_0000)=='t')&&
	    		((s.charAt(1)|(char)0b0010_0000)=='r') &&
	    		((s.charAt(2)|(char)0b0010_0000)=='u') &&
	    		((s.charAt(3)|(char)0b0010_0000)=='e') )||
	        ((s.length() == 5) && ((s.charAt(0)|(char)0b0010_0000)=='f') &&
	        		((s.charAt(1)|(char)0b0010_0000)=='a') &&
	        		((s.charAt(2)|(char)0b0010_0000)=='l') &&
	                ((s.charAt(3)|(char)0b0010_0000)=='s') &&
	                ((s.charAt(4)|(char)0b0010_0000)=='e')));
	}
	
	
	public static void timeTimable(Timeable algorithm) {
		long before=System.currentTimeMillis();
		for(int i=0;i<200000;i+=1000) {
			algorithm.run(i);
		}
		long after=System.currentTimeMillis();
		System.out.println(after-before);
	}
	
	
	
	
	
	private interface Timeable{
		public double run(int n);
	}
	
	
	
	
	public static double closed(int n) {
		return (3*Math.pow(-2, n)-2+2*Math.pow(1.5, n));
		
	}
	public static double iterative(int n) {
		ArrayList<Double> previous=new ArrayList<Double>();
		previous.add((double) 3);
		previous.add((double) -5);
		previous.add((double) 29./2);
		
		for(int i=3;i<=n;i++) {
			previous.add(.5*previous.get(i-1)+7./2*previous.get(i-2)-3*previous.get(i-3));
		}
		return previous.get(n);
		
	}
	public static double niavRecursive(int n) {
		switch(n) {
		case 0:return 3;
		case 1:return -5;
		case 2:return 29./2;
		}
		
		return .5*niavRecursive(n-1)+7./2*niavRecursive(n-2)-3*niavRecursive(n-3);
		
	}
	
	
	private static ArrayList<Double> dynamic;
	static {
		dynamic=new ArrayList<Double>();
		dynamic.add((double) 3);
		dynamic.add((double) -5);
		dynamic.add((double) 29./2);
	}
	public static double dynamicRecurise(int n) {
		if(n>=dynamic.size()) {
			dynamic.add(.5*dynamicRecurise(n-1)+7./2*dynamicRecurise(n-2)-3*dynamicRecurise(n-3));
		}
		return dynamic.get(n);
	}
	
	
	public static double tailRecursive(int n) {
		
		switch(n) {
		case 0:return 3;
		case 1:return -5;
		case 2:return 29./2;
		}
			return(tailRecursiveHelper(3,-5,29./2,n-2));
	}
	private static double tailRecursiveHelper(double p3, double p2,double p1,int togo) {
		if(togo==0) {
			return p1;
		}
		return tailRecursiveHelper(p2,p1,.5*p1+7./2*p2-3*p3,togo-1);
		
	}
	
public static double nonTailRecursive(int n) {
		
		switch(n) {
		case 0:return 3;
		case 1:return -5;
		case 2:return 29./2;
		}
			return(nonTailRecursiveHelper(3,-5,29./2,n-2));
	}
	private static double nonTailRecursiveHelper(double p3, double p2,double p1,int togo) {
		if(togo==0) {
			return p1;
		}
		return nonTailRecursiveHelper(p2,p1,.5*p1+7./2*p2-3*p3,togo-1);
		
	}
	
	

}
