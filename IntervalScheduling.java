import java.util.*;
class IntervalScheduling{
	private int [][] jobs;
	private int [] memo;
	private ArrayList<Integer> includedJobs = new ArrayList<Integer>();

	public void calcschedule(int [][] inputJobs){
		jobs = inputJobs;
		memo = new int[jobs.length];
		Arrays.sort(jobs,(a,b)-> Integer.compare(a[2],b[2]));

		memo[0] = 0;

		for(int i=1;i<jobs.length;i++){
			memo[i] = Math.max(memo[i-1],jobs[i][3] + memo[leastCompatible(i)]);
		}

		System.out.println("Memoization array: "+ Arrays.toString(memo));
		System.out.println("Maximum profit from the optimal set of jobs: "+ memo[memo.length-1]);
		System.out.println("Jobs included in the optimal set:");
		findSolution(memo.length-1);
		for(int i = includedJobs.size()-1;i>=0;i--){
			System.out.println(getInfo(includedJobs.get(i)));
		}
	}

	private int leastCompatible(int j){
		int low = 0,high = j-1;
		while(low <= high){
			int mid = (high+low)/2;
			if(jobs[mid][2] == jobs[j][1])
				return mid;
			else if(jobs[mid][2] < jobs[j][1])
				low = mid+1;
			else
				high = mid-1;
		}
		return 0;
	}

	private void findSolution(int j){
		if (j==0)
			return;
		else if(jobs[j][3] + memo[leastCompatible(j)] > memo[j-1]){
			includedJobs.add(j);
			findSolution(leastCompatible(j));
		}
		else
			findSolution(j-1);
	}

	private String getInfo(int i){
		return "Job "+jobs[i][0]+": Time ("+jobs[i][1]+" - "+jobs[i][2]+") Value = "+jobs[i][3] ;
	}

	public static void main(String[] args) {
		IntervalScheduling schedule = new IntervalScheduling();
		int [][] inputJobs = { {0,0,0,0},
							   {1,1,2,100},
							   {2,2,5,200},
							   {3,3,6,300},
							   {4,4,8,400},
							   {5,5,9,500},
							   {6,6,10,100}
							};

	schedule.calcschedule(inputJobs);
	}
}
