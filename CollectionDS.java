package com.epam.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class CollectionDS <C>{
		int size = 0;
		int defaultSize = 10;
		private Object[] elements;

		

		public CollectionDS()

		{

			elements = new Object[defaultSize];

		}

		

		public void add(int val) 
	    {
	        if (size == elements.length) {
	            Increase();
	        }
	        elements[size++] = val;
	    }

		

	    private void Increase() 

	    {

	    	int newSize = elements.length+1;

	    	elements = Arrays.copyOf(elements,newSize);

		}



	    @SuppressWarnings("unchecked")
		public C get(int i) 
	    {
	    	try 
	    	{
	    		if (i >= size || i < 0) 
	    		{
	    			throw new IndexOutOfBoundsException("Given Index : " + i + ", List Size : " + size);
	    		}
	    	}
	    	catch(IndexOutOfBoundsException e) {
	    		System.out.println(e);
	    		System.out.println("Given index is out of Bound");
	    	}
	        return (C) elements[i];
	    }
	    

	    @SuppressWarnings("unchecked")
		public C remove(int i)

	    {

	    	try 

	    	{

	    		if (i>size || i<0)

	    			throw new IndexOutOfBoundsException();

	    	}

	    	catch(IndexOutOfBoundsException e)

	    	{

	    		System.out.println("Given index os out of bound");

	    	}

	    	Object ele = elements[i];

	    	int num = elements.length-(i+1);

	    	System.arraycopy(elements,i+1,elements,i,num);

	    	size--;

	    	return (C) elements[i];

	    }

	    

	    public int size()

	    {

	    	return size;

	    }

	    

	    public String print()

	    {

	    	StringBuilder sb = new StringBuilder();

	        sb.append('[');

	        for(int i = 0; i < size ;i++) 

	        {

	            sb.append(elements[i].toString());

	            if(i<size-1)

	            {

	                sb.append(",");

	            }

	        }

	        sb.append(']');

	        return sb.toString();

	    }

		public static void main( String[] args )

	    {

			Scanner scan = new Scanner(System.in);

	        CollectionDS<Integer> Lin = new CollectionDS<>();

	        

	        Lin.add(10);
	        Lin.add(9);
	        Lin.add(8);
	        Lin.add(7);
	        Lin.add(6);
	        Lin.add(5);
	        Lin.add(4);
	        Lin.add(3);
	        Lin.add(2);
	        Lin.add(1);
	        System.out.println(Lin.print());

	        

	        while(true)

	        {

	        	System.out.println("\n1.Insert\n2.Delete\n3.Display\n4.Fetch\n5.Exit");

	        	int ch = scan.nextInt();

	        	if(ch==1)

	        	{

	        		System.out.println("Enter the element you want to insert");

	        		int ele = scan.nextInt();

	        		Lin.add(ele);

	        	}

	        	if(ch==2)

	        	{

	        		System.out.println("Enter the index at which you want to delete");

	        		int ele = scan.nextInt();

	        		Lin.remove(ele);

	        	}

	        	if(ch==3)

	        	{

	        		System.out.println(Lin.print());

	        	}

	        	if(ch==4)

	        	{

	        		System.out.println("Enter the index at which you want to fetch element");

	        		int ele = scan.nextInt();

	        		System.out.println(Lin.get(ele));

	        	}

	        	if(ch==5)

	        	{

	        		System.exit(0);

	        	}

	        }
	    }
	}