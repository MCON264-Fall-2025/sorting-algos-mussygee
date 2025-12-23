package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement merge sort
        if (a.length <= 1) return;
        mergeSort(a, 0, a.length - 1, comp);
    }

    private <T> void mergeSort(T[] a, int left, int right, Comparator<? super T> comp) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(a, left, mid, comp);
        mergeSort(a, mid + 1, right, comp);
        merge(a, left, mid, right, comp);
    }

    @SuppressWarnings("unchecked")
    private <T> void merge(T[] a, int left, int mid, int right, Comparator<? super T> comp) {
        Object[] temp = new Object[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (comp.compare(a[i], a[j]) <= 0) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];

        for (int x = 0; x < temp.length; x++) {
            a[left + x] = (T) temp[x];
        }
    }
}
