package com.software.kot1.demo_and_class

//data class 数据类 , 多用于数据对象 , 使用主构造实现， 直接带 var 会变为 final
data class UserBean(val id: String, val name: String, val pwd: String)
//data class 带有方法 hashCode，equals，toString

//对应 JAVA demo
//public final class UserBean {
//    @NotNull
//    private final String id;
//    @NotNull
//    private final String name;
//    @NotNull
//    private final String pwd;
//
//    @NotNull
//    public final String getId() {
//        return this.id;
//    }
//
//    @NotNull
//    public final String getName() {
//        return this.name;
//    }
//
//    @NotNull
//    public final String getPwd() {
//        return this.pwd;
//    }
//
//    public UserBean(@NotNull String id, @NotNull String name, @NotNull String pwd) {
//        Intrinsics.checkNotNullParameter(id, "id");
//        Intrinsics.checkNotNullParameter(name, "name");
//        Intrinsics.checkNotNullParameter(pwd, "pwd");
//        super();
//        this.id = id;
//        this.name = name;
//        this.pwd = pwd;
//    }
//}

