public class UnsortedArrayPriorityQueue<QType> implements PQueue<QType>{

	public int arraySize = 10;
	public QType[] elms = new QType[arraySize];
	public Integer[] priorities = new Integer[arraySize];
	public Integer[] timeWaiting = new Integer[arraySize];

	public QType dequeue() {
		int highlander = -1;
		int newChallenger = -1;
		// keeps track of highest priority
		
		for (int i = 0; i < arraySize; i++) {
			if (priorities[i] > highlander) {
				highlander = i;
			} else if (priorities[i].equals(highlander)) {
				newChallenger = i;
				if (timeWaiting[newChallenger] > timeWaiting[highlander]) {
					highlander = newChallenger;
				} else if (timeWaiting[newChallenger].equals(timeWaiting[highlander])) {
					System.out.println("What did you DO?");
				} else {
					newChallenger = -1;
				}
			}
		}
		// Finds the highest priority, breaks ties between same priorities
		
		QType ret_val = elms[highlander];
		elms[highlander] = null;
		priorities[highlander] = null;
		timeWaiting = null;

		for (int i = highlander; i < elms.length - 1; i++) {
			elms[i] = elms[i+1];
			priorities[i] = priorities[i+1];
			timeWaiting[i] = timeWaiting[i+1];
		}

		elms[arraySize - 1] = null;
		priorities[arraySize - 1] = null;
		timeWaiting[arraySize - 1] = null;
		
		return ret_val;
	}

	public void enqueue(QType q, int pri) {
                for (int i = 0; i < arraySize; i++) {
                        if ((elms[i] == null && priorities[i] == null && timeWaiting[i
] == null) || (elms[i].trim().length() == 0 && priorities.trim().length() == 0 && time
Waiting.trim().length() == 0)) {
                                elms[i] = q;
                                priorities[i] = pri;
                                timeWaiting = 0;
                        } else {
                                doubleDown();
				enqueue(q, pri);
                }
        }

	public int size() {
		// This also doubles as data integrity verification to make sure all three arrays are working in tandem.
		int elmsize = 0;
		int psize = 0;
		int tmsize = 0;
		
		for (int i = 0; i < arraySize; i++) {
			if (elms[i] != null) {
				elmsize++;
			}
			if (priorities[i] != null) {
				psize++;
			}
			if (timeWaiting[i] != null) {
				tmsize++;
			}
		}

		if ((elmsize == psize) && (psize == tmsize) && (tmsize == elmsize)) {
			return elmsize;
		} else {
			System.exit(0);
		}

	}

	public void doubleDown() {
		;;
		// TODO: Double not only arrays, but variable arraySize
	}
}
