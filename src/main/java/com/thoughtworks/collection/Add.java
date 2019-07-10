package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.sum;
import static java.util.stream.Collectors.toList;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        IntStream intStream;
        if (leftBorder > rightBorder) {
            intStream =  IntStream.rangeClosed(rightBorder, leftBorder);
        } else {
            intStream = IntStream.rangeClosed(leftBorder, rightBorder);
        }
        return intStream.filter(x -> x % 2 == 0 ).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        IntStream intStream;
        if (leftBorder > rightBorder) {
            intStream =  IntStream.rangeClosed(rightBorder, leftBorder);
        } else {
            intStream = IntStream.rangeClosed(leftBorder, rightBorder);
        }
        return intStream.filter(x -> x % 2 != 0 ).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(x -> x * 3 + 2).reduce((x, y) -> x + y).get();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        final List<Integer> collect = arrayList.stream().map(x -> {
            if (x % 2 != 0) {
                return x * 3 + 2;
            } else {
                return x;
            }
        }).collect(toList());
        return collect;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 != 0)
                .map(x -> x * 3 + 5)
                .reduce((x, y) -> x + y).get();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0)
                .mapToDouble(x -> x).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        final List<Integer> collect = arrayList.stream()
                .filter(x -> x % 2 == 0).collect(toList());
        return collect.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(x -> x % 2 == 0)
                .distinct().collect(toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        final Map<Boolean, List<Integer>> collect = arrayList.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        final List<Integer> collect1 = collect.get(true).stream().sorted().collect(toList());
        final List<Integer> collect2 = collect.get(false).stream().sorted(Comparator.reverseOrder()).collect(toList());
        collect1.addAll(collect2);
        return collect1;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
