public class SortTest
{
  private int[] sortItems = {2, 3, 34, 1, 9, 456, 21, 634, 0, 81, 235};
  
  public int[] getSortItems()
  {
  	return sortItems;
  }
  
  public void quickSort(int low, int high)
  {
	//recursive condition
	if(low < high)
	{
		//get ordered position of pivot
		int pivot_position = partition(low, high);
		
		quickSort(low, pivot_position-1);
		quickSort(pivot_position+1, high);
	}
  }
  
  private int partition(int low, int high)
  {
	int pivot;
	int last_small = low;
	//set pivot, if not swap,  default is position low
	//swap(low, high);
	pivot = sortItems[low];
	//partition numbers according to pivot
	for(int i = low+1; i <= high; i++)
	{
		if(sortItems[i] < pivot)
		{
			last_small ++;
			swap(last_small, i);
		}
	}
	//swap pivot from low to its ordered position last_small
	swap(low, last_small);
	//return pivot ordered position
	return last_small;
  }
  
  private void swap(int i, int j)
  {
	int tmp = sortItems[i];
	sortItems[i] = sortItems[j];
	sortItems[j] = tmp;
  }
  
  public void mergeSort()
  {
  	
  }
  
  public void radixSort()
  {
  	
  }
  
  public void insertionSort()
  {}
  
  public void bubbleSort()
  {}
  
  public void selectionSort()
  {}
  
  public void shellSort()
  {}
  
  public void heapSort()
  {}
  
  public static void main(String[] args)
  {
	SortTest st = new SortTest();
	int[] sItems = st.getSortItems();
	for(int i = 0; i<sItems.length; i++)
		System.out.print(sItems[i] + " ");
	System.out.print("\n");
	
	st.quickSort(0, 10);
	int[] lItems = st.getSortItems();
	for(int i = 0; i<lItems.length; i++)
		System.out.print(lItems[i] + " ");
	System.out.print("\n");
  }
}
