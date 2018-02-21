package search;

public class AllSearch {
	
	public static int linearSearch(int[] data, int search)
	{
		for(int i = 0 ; i < data.length; i++)
			if(data[i] == search)	return i+1;
		return -1;
	}
	
	public static int binarySearch(int[] data, int search) {
		int mid = data.length/2;
		int i = 0, n = data.length;
		if(mid!=0)
		{
			if(data[mid]>search) {
				n = mid;
			}
			else if(data[mid]<search) {
				i = mid;
			}
			else {
				return mid+1;
			}
			for(int j = i ; j < n; j++) {
				if(data[j] == search)	return j+1;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch(int[] data, int first, int last, int search) {
		if(last>=first)
		{
			int mid = first + (last - first) / 2 ;
			if(data[mid] == search)
				return mid+1;
			else if(data[mid]>search)
				return recursiveBinarySearch(data, first, mid-1, search);
			return recursiveBinarySearch(data, mid+1, last, search);
		}
		return -1;
	}
	
	public static int iterativeBinarySearch(int[] data, int first, int last, int search) {
		while(first <= last) {
			int mid = first + (last - first)/2;
		    if (data[mid] == search) 
		        return mid+1;  
		    if (data[mid] < search) 
		        first = mid + 1; 
		    else
		        last = mid - 1; 
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//int[] data = {4,5,6,7,1,3,4,5};    // unsorted array
		int[] data = {4,5,6,7,8,9,10,11}; 	// sorted array
		int search = 10, result = 0;
	//	result = linearSearch(data, search);
	//	result = binarySearch(data, search);
	//	result = recursiveBinarySearch(data,0, data.length - 1, search);
		result = iterativeBinarySearch(data,0, data.length - 1, search);
		if( result != -1 )
		{
			System.out.println(search+" is at position "+result);
		}
		else
		{
			System.out.println(search+" not found !");
		}
	}	
}