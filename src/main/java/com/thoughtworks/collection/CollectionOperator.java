package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left < right) {
            return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(right, left).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left > right) {
            return IntStream.rangeClosed(right, left).boxed()
                    .filter(x -> x % 2 == 0).sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        } else {
            return IntStream.rangeClosed(left, right).boxed()
                    .filter(x -> x % 2 == 0).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(Arrays.stream(secondArray).boxed().collect(Collectors.toList())::contains)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        final List<Integer> collect = Arrays.stream(firstArray).collect(Collectors.toList());
        final List<Integer> collect1 = Arrays.stream(secondArray).filter(x -> !collect.contains(x))
                .collect(Collectors.toList());
        collect.addAll(collect1);
        return collect;
    }
}
