package com.android.tools.testsuit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public class CheckerManager {


    private static Map<String, Checker> checkerMap = new HashMap<>();

    /**
     * 创建builder
     *
     * @param tag 用于查找checker
     * @return check builder
     */
    public static Checker.Builder checkBuilder(String tag) {
        return new Checker.Builder(tag);
    }

    public static Checker.Builder checkBuilder() {
        return new Checker.Builder(null);
    }

    public static Checker getChecker(String tag) {
        return checkerMap.get(tag);
    }

    public static void putChecker(String tag, Checker checker) {
        checkerMap.put(tag, checker);
    }

    public static void removeChecker(String tag) {
        checkerMap.remove(tag);
    }

}
