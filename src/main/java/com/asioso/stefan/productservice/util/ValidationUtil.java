package com.asioso.stefan.productservice.util;

import java.util.Set;

public abstract class ValidationUtil {

    private static final Set<String> VALID_SORT_FIELDS = Set.of("id", "name");
    private static final Set<String> VALID_SORT_ORDERS = Set.of("ASC", "DESC");

    public static String validateSortField(String sortField) {
        if (VALID_SORT_FIELDS.contains(sortField)) {
            return sortField;
        } else {
            return "id";
        }
    }

    public static String validateSortOrder(String sortOrder) {
        if (VALID_SORT_ORDERS.contains(sortOrder.toUpperCase())) {
            return sortOrder.toUpperCase();
        } else {
            return "ASC";
        }
    }

    public static long validateStart(long start) {
        if (start < 1) {
            return 1;
        }
        return start;
    }

    public static long validateLimit(long limit) {
        if (limit < 1) {
            return 1;
        }
        return limit;
    }
}
