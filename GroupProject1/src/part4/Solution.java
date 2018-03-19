package part4;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) throws InterruptedException {
		System.out.print("Recurisive");
		timeTimable((int n)->niavRecursive(n));
		System.out.println();
		System.out.print("dynamicRecurise");
		timeTimable((int n)->dynamicRecurise(n));
		System.out.println();
		System.out.print("tailRecursive");
		timeTimable((int n)->tailRecursive(n));
		System.out.println();
		System.out.print("iterative");
		timeTimable((int n)->iterative(n));
		System.out.println();
		System.out.print("closed");
		timeTimable((int n)->closed(n));
		
		System.out.println();
		//runs faster the second time, must be some optimizer in the runtime
		
		//running the dynamic version twice feels like cheating, but if it was being repeatedly called
		//it would approach what this sees
		System.out.print("dynamicRecurise");
		timeTimable((int n)->dynamicRecurise(n));
		System.out.println();
		System.out.print("tailRecursive");
		timeTimable((int n)->tailRecursive(n));
		System.out.println();
		System.out.print("iterative");
		timeTimable((int n)->iterative(n));
		System.out.println();
		System.out.print("closed");
		timeTimable((int n)->closed(n));
		System.out.println();
		System.out.print("Recurisive");
		timeTimable((int n)->niavRecursive(n));
		
		
	}
	
	
	
	public static void timeTimable(Timeable algorithm) {
		//first run is always slow,
		algorithm.run(0);
		for(int i=0;i<1000;i+=1) {
			long before=System.nanoTime();
			
			for(int j=0;j<10;j++) {
				/*
				 * run it 10 times to suppress random spikes
				 * if i were really doing this correctly I'd take the median run time 
				 * or something analogous to the mode
				 */
				algorithm.run(i);
			}
			long after=System.nanoTime();
			long diff=after-before;
			System.out.print(","+diff);
			if(diff>10000000000L) {//I don't have all day, and one of this would literally take years if not millenia to run at i=1000
				break;
			}
		}
		
		
	}
	//java lambda expressions require a single method interface
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
	static {//static initialization blocks, :)
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
	
	
	

}
