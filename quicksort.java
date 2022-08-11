class QuickSort{
	
	public void sort(int arr[],int begin,int end){
		if (begin < end){
			int partitionIndex = partition(arr,begin,end);
			sort(arr,begin,partitionIndex-1);
			sort(arr,partitionIndex+1,end);
		}
	}

	private void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private int partition(int arr[],int begin,int end){
		int i = begin-1;
		int pivot = end;
		for(int j=begin;j<end;j++){
			if(arr[j] <= arr[pivot]){
				i++;
				swap(arr,j,i);
			}
		}
		swap(arr,i+1,end);
		return i+1;

	}

	public static void main(String[] args) {
		int arr[] = {2,3,10,1,8,6,7,5,9,0};
		int begin = 0;
		int end = arr.length - 1;

		QuickSort qs = new QuickSort();
		qs.sort(arr,begin,end);

		for(int x: arr){
			System.out.print(x+" ");
		}
	}
}
