package Lesson16_1;

public enum Category {
    ALL("Все товары");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public static Category byName(String name) {
        for (Category category : values()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}