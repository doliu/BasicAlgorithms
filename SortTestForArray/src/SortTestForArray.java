public class SortTestForArray
{
  private int[] sortItems = {2, 3, 34, 1, 9, 456, 21, 634, 0, 81, 235};
  
  public int[] getSortItems()
  {
  	return sortItems;
  }
  
  
  private void swap(int i, int j)
  {
	int tmp = sortItems[i];
	sortItems[i] = sortItems[j];
	sortItems[j] = tmp;
  }
  
  public void radixSort()
  {
  	
  }
  
  public void bubbleSort()
  {
  /*
  2 fors
  time complexity average O(n*n), worst O(n*n), best O(n), space complexity O(1)
  stable
  */
  for(int i = sortItems.length-1; i > 0; i--)
	for(int j = 0; j < i; j++)
		if(sortItems[j+1] < sortItems[j])
			swap(j, j+1);
  }
  
  public void insertionSort()
  {
	/*
	time complexity average O(n*n), worst O(n*n), best O(n), space complexity O(1)
	stable
	*/
	//last unsorted position is i
	for(int i = 1; i < sortItems.length; i++)
	{
		//do insertion and change position while compare
		if(sortItems[i] < sortItems[i-1])
		{
			int j = i;
			int current = sortItems[j];
			do
			{
				sortItems[j] = sortItems[j-1];
				j--;
			}while(j > 0 && sortItems[j-1] > current);
			sortItems[j] = current;
		}
	}
  }
  
  public void selectionSort()
  {
	/*
	useless sort
	time complexity average O(n*n), worst O(n*n), best O(n*n), space complexity O(1)
	not stable
	*/
	for(int position = sortItems.length-1; position > 0; position--)
	{
		int maxIndex = max(position);
		swap(maxIndex, position);
	}
  }
  
  private int max(int position)
  {
	int maxIndex = 0;
	for(int i = 0; i <= position; i++)
	{
		if(sortItems[i] > sortItems[maxIndex])
			maxIndex = i;
	}
	return maxIndex;
  }
  
  public void shellSort()
  {
	/*
	time complexity worst O(pow(n, 1.3)), space complexity O(1)
	not stable
	*/
	
	
  }
  
  public void quickSort(int low, int high)
  {
	/*
	time complexity average O(n*lgn), worst O(n*n), best O(n*lgn), space complexity O(lgn)
	not stable
	*/
	int pivot_position = partition(low, high);
	if(low < high)
	{
		quickSort(low, pivot_position-1);
		quickSort(pivot_position+1, high);
	}
  }
  
  private int partition(int low, int high)
  {
	//set the middle number as pivot
	swap(low, (low+high)/2);
	int pivot = sortItems[low];
	int last_small = low;
	for(int i = low+1; i <= high; i++)
	{
		if(sortItems[i] < pivot)
		{
			last_small++;
			swap(i, last_small);
		}
	}
	swap(low, last_small);
	return last_small;
  }
  
  public void mergeSort()
  {
  	/*
	time complexity average O(n*lgn), worst O(n*lgn), best O(n*lgn), space complexity O(n)
	stable
	*/
	
	
  }
  
  public void heapSort()
  {}
  
  public static void main(String[] args)
  {
	SortTestForArray st = new SortTestForArray();
	int[] sItems = st.getSortItems();
	for(int i = 0; i<sItems.length; i++)
		System.out.print(sItems[i] + " ");
	System.out.print("\n");
	
	st.bubbleSort();
	int[] lItems = st.getSortItems();
	for(int i = 0; i<lItems.length; i++)
		System.out.print(lItems[i] + " ");
	System.out.print("\n");
  }
}
