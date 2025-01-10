package com.ruoyi.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huixh
 */
public class ListUtils {
    public static List<Long> stringToList(String str) {
        // 如果字符串为空或null，返回空的 List
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }

        // 将字符串按逗号分割并转换为 Long 类型的 List
        return Arrays.stream(str.split(","))
                .map(Long::valueOf)  // 将 String 转换为 Long
                .collect(Collectors.toList());
    }

    public static String listToString(List<Long> list) {
        // 使用流将 List<Long> 转换为字符串，元素之间用逗号分隔
        return list.stream()
                .map(String::valueOf)  // 将 Long 转换为 String
                .collect(Collectors.joining(","));
    }

}
