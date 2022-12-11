package com.amur.home.common;

public class Constants {
    public enum UserRelativeType {
        FATHER("FATHER","父亲"),
        MOTHER("MOTHER","母亲"),
        SON("SON","儿子"),
        DAUGHTER("DAUGHTER","女儿"),
        GRANDFATHER("GRANDFATHER","祖父"),
        GRANDMOTHER("GRANDMOTHER","祖母"),
        BROTHER("BROTHER","哥哥"),
        SISTER("SISTER","姐姐"),
        UNCLE("UNCLE","叔叔"),
        AUNT("AUNT","阿姨"),
        OTHER("OTHER","其他");

        UserRelativeType(String value,String name) {
            this.value = value;
            this.name = name();
        }

        private final String value;
        private final String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }

    public enum Home {

    }
}
