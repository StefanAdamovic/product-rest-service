package com.asioso.stefan.productservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test
    void validateSortField_ValidField_ReturnsSameField() {
        assertEquals("id", ValidationUtil.validateSortField("id"));
        assertEquals("name", ValidationUtil.validateSortField("name"));
    }

    @Test
    void validateSortField_InvalidField_ReturnsDefault() {
        assertEquals("id", ValidationUtil.validateSortField("price"));
    }

    @Test
    void validateSortOrder_ValidOrder_ReturnsSameOrder() {
        assertEquals("ASC", ValidationUtil.validateSortOrder("asc"));
        assertEquals("DESC", ValidationUtil.validateSortOrder("desc"));
    }

    @Test
    void validateSortOrder_InvalidOrder_ReturnsDefault() {
        assertEquals("ASC", ValidationUtil.validateSortOrder("ascending"));
    }

    @Test
    void validateStart_ValidStart_ReturnsSameStart() {
        assertEquals(10, ValidationUtil.validateStart(10));
    }

    @Test
    void validateStart_InvalidStart_ReturnsDefault() {
        assertEquals(1, ValidationUtil.validateStart(0));
    }

    @Test
    void validateLimit_ValidLimit_ReturnsSameLimit() {
        assertEquals(20, ValidationUtil.validateLimit(20));
    }

    @Test
    void validateLimit_InvalidLimit_ReturnsDefault() {
        assertEquals(1, ValidationUtil.validateLimit(0));
    }
}
