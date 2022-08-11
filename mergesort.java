import java.lang.Math;
class Mergesort{

	public void merge(int[] arr,int mid,int begin,int end){
		int n1 = mid-begin+1;
		int n2 = end - mid;

		int [] L = new int[n1];
		int [] R = new int[n2];

		for(int i=0;i<n1;i++)
			L[i] = arr[begin+i];
		
		for(int i=0;i<n2;i++)
			R[i] = arr[mid+1+i];

		int i=0,j=0;
		int k= begin;

		while(i<n1 && j<n2){
			if(L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			}
			else{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while(i<n1){
			arr[k] = L[i];
			i++;
			k++;
		}

		while(j<n2){
			arr[k] = R[j];
			j++;
			k++;
		}
	}


	public void sort(int []arr,int begin,int end){
		if(begin < end){
			int mid = (begin+end)/2;
			sort(arr,begin,mid);
			sort(arr,mid+1,end);
			merge(arr,mid,begin,end);
		}
	}

	public static void main(String[] args){
		int n = 500;
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = (int)(Math.random()*n);
		}
		int begin = 0;
		int end = n-1;
		Mergesort ms = new Mergesort();
		Long start = System.currentTimeMillis();
		ms.sort(arr,begin,end);
		Long end1 = System.currentTimeMillis();
		for(int x: arr){
			System.out.print(x+" ");
		}
		System.out.println("\nExecution Time in nanoseconds: "+(end1 - start));
	}
}
