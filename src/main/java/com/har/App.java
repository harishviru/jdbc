package com.har;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

/**
 * Hello world!
 *
 */	
public class App extends FileTest
{
    public static void main( String[] args )
    {
    	
    	App ap=new App();
    	
    	System.out.println(ap.getClass().getSimpleName());
    	System.out.println(ap.getClass().getSuperclass().getSimpleName());
    	System.out.println(ap.getClass().getSuperclass().getSuperclass().getSimpleName());

    	
    	//test();
    	int b=4;
    	int[] ar;   //declaration
    	
    	
         ar=new int[b]; //construction 
    	 System.out.println(ar.length);
    	 
    	 for(int i=0;i<ar.length;i++) {
    		 System.out.println(ar[i]);
    	 }
    	 
    	 ar[0]=67; //inilization
    	 ar[1]=89;
    	 ar[2]=12;
    	 ar[3]=9;
    	 System.out.println("++++++++++++++++++++++++++");
    	 for(int i=0;i<ar.length;i++) {
    		 System.out.println(ar[i]);
    	 }
    	 
    	// System.out.println( ar[4]);
    	 
    	 int[] array = {10,20,30};
    	 
    	 
    	 
    	 
        
        
    	
    	
    }

	private static void test() throws ClassNotFoundException {
		long mb = 1024*1024;
    	Runtime r = Runtime.getRuntime();
    	System.out.println("Max Memory: "+r.maxMemory()/mb);
    	System.out.println("Total Memory: "+r.totalMemory()/mb);
    	System.out.println("Free Memory: "+r.freeMemory()/mb);
    	System.out.println("Consumed memory:"+(r.totalMemory()-r.freeMemory())/mb);
    	
    	System.out.println("++++++++++++++++++++++");
    	
    	
    	
    	
    	
    	
        Class<FileTest> clazz=(Class<FileTest>) Class.forName("com.har.FileTest");
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getSuperclass().getName());


        
        System.out.println("***************Constructors****************");

        Constructor[] constructors= clazz.getDeclaredConstructors();
        for(Constructor cons:constructors) {
        	System.out.println(cons);
        	System.out.println(cons.getParameterCount());
        	for(Parameter param:cons.getParameters()) {
            	System.out.println(param.getName());
            	System.out.println(param.getType());
        	}
        	System.out.println();
        }
        System.out.println("****************Fileds*********************");
        
      Field[] fields=  clazz.getDeclaredFields();
      for(Field filed:fields) {
      	System.out.println(filed.getName());
      	System.out.println(filed.getType());
      	System.out.println(filed);
      }
	}
}
