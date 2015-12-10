package gsh;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;



public class main {
    
    public static double closestPair(final points[] fuck)
	{
    	double result;
        double midresult=Double.MAX_VALUE;
    	double d;
        points []mid=new points[fuck.length];   	
    	if(fuck.length==2)
    	{
    	     return Math.sqrt(points.distancePow2(fuck[0], fuck[1]));    	    		
    	}
    	
    	if(fuck.length==3)
    	{
 
    		result=points.distancePow2(fuck[0], fuck[1])>points.distancePow2(fuck[0], fuck[2])?points.distancePow2(fuck[0],fuck[2]):points.distancePow2(fuck[0], fuck[1]);
    	    result=result>points.distancePow2(fuck[1], fuck[2])?points.distancePow2(fuck[1], fuck[2]):result;
    	    return Math.sqrt(result);
    	}
    	
    	else {
    		
    	  if(fuck.length%2==0)
    	  {
    		  double lresult;
    		  double rresult;
             points[]right =new points[fuck.length/2];
    		  points[]left =new points[fuck.length/2];
             for(int i=0;i<fuck.length/2;i++)
             {
            	 left[i]=new points(fuck[i].getX(),fuck[i].getY());
            	 right[i]=new points(fuck[fuck.length/2+i].getX(),fuck[fuck.length/2+i].getY());
            	
             }
            lresult=closestPair(left);
         
            rresult=closestPair(right);
            
            d= lresult>rresult?rresult:lresult;
            
    	  }
    	  
    	  else{
    		  double lresult;
    		  double rresult;
    		  points[]left =new points[fuck.length/2];
    		  points[]right =new points[fuck.length/2+1];
             for(int i=0;i<fuck.length/2;i++)
             {
            	 left[i]=new points(fuck[i].getX(),fuck[i].getY());
            	 right[i]=new points(fuck[fuck.length/2+i].getX(),fuck[fuck.length/2+i].getY());
             }
             right[fuck.length/2]=new points(fuck[fuck.length-1].getX(),fuck[fuck.length-1].getY());
             lresult=closestPair(left);
             rresult=closestPair(right);
             d= lresult>rresult?rresult:lresult;
    	  }
    	  //局部过程变量
    	  for(int i1=0;i1<fuck.length;i1++)
    		  System.out.println(fuck[i1]);
    	  System.out.println(fuck.length);
    	   int midx =fuck[fuck.length/2-1].getX();
    	 System.out.println("midx "+midx);
           int i;
           int j=0;
           for(i=0;i<fuck.length;i++)
           {
        	   if(fuck[i].getX()>midx-d&&fuck[i].getX()<midx+d)
        	   {
        		   mid[j++]=new points(fuck[i].getX(),fuck[i].getY());
        		 
        	   }
           }
          
        
           result=d;
           for(int p=0;p<mid.length;p++)
           {
        	   
        	  for (int q=p+1;q<mid.length;q++)
        	  {
        		   midresult=Math.sqrt(points.distancePow2(mid[p],mid[q]));
        		  if(midresult<d)
        		  {
        			  result=midresult;
        		  }
        	  }
        	  
           }
           return  result;
    	}
    
		
		
	}
	
	
	
public static void main(String[] args) {
    int N=10;
    StdDraw.setPenRadius(0.01);
    StdDraw.setXscale(0,10);
    StdDraw.setYscale(0,10);
    
	points[] fuck=new points[5];
	Random gsh=new Random();
  for(int i=0;i<5;i++)
  
	  fuck[i]=new points(gsh.nextInt(10),gsh.nextInt(10));
	  Arrays.sort(fuck);
   for(int i=0;i<5;i++)
   {
	   StdDraw.point(fuck[i].getX(), fuck[i].getY());
	   System.out.println(fuck[i]);
   }
   System.out.println(fuck.length);
   
    double bitch=closestPair(fuck);
    System.out.println("closest_pair： "+bitch);
    //System.out.println(4%2);
    
    
    
    
}

}
