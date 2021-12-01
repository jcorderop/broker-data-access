package org.broker.dataaccess.model.common;

public class JPATools {

    public static final String PK_NAME = "id";

    public static String getSequenceName(String subName) {
        return subName + "_sequence";
    }
}
