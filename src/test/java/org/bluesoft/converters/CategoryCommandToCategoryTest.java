package org.bluesoft.converters;

import org.bluesoft.commands.CategoryCommand;
import org.bluesoft.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    private final Long ID_VALUE = 1L;
    private final String DESCRIPTION = "description";

    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testNotNullObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        // given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        // when
        Category testCategory = converter.convert(categoryCommand);

        assertEquals(ID_VALUE, testCategory.getId());
        assertEquals(DESCRIPTION, testCategory.getDescription());
    }

}