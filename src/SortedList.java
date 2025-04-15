import java.util.ArrayList;

public class SortedList
{
    private ArrayList<String> list;

    public SortedList()
    {
        list = new ArrayList<>();
    }

    private int findInsertionIndex(String value)
    {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(value) < 0)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }
        return left;
    }

    public void add(String value)
    {
        int index = findInsertionIndex(value);
        list.add(index, value);
    }

    public int search(String value)
    {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = list.get(mid).compareTo(value);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public ArrayList<String> getList()
    {
        return list;
    }
}