package com.syk.boot.utils.asserts;


import com.syk.boot.utils.entity.Book;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 沈永康
 * @Date 2022/5/6 8:45
 * @Version 1.0
 */


public class AssertUtils {
    public static void main(String[] args) throws IOException {
        Book book1 = Book.builder().bookName("java").bookAuth("syk").bookPrice("100").build();
        Book book2 = Book.builder().bookName("c++").bookAuth("syk").bookPrice("80").build();
        Book book3 = null;
        Assert.notNull(book3,"参数不能为空");
        Assert.isNull(book2,"参数必须为空");
        Assert.isInstanceOf(Book.class,book1,"book1不是Book实例");
        String[] arr = {"111","222"};
        System.out.println(Arrays.toString(arr));
        String res = ObjectUtils.nullSafeClassName(book1);
        System.out.println(res);
        String res2 = ObjectUtils.nullSafeClassName(book3);
        System.out.println(res2);
        Integer res3 = ObjectUtils.nullSafeHashCode(book3);
        System.out.println(res3);
        String res4 = ObjectUtils.getIdentityHexString(book2);
        System.out.println(res4);
        String res5 = ObjectUtils.identityToString(book2);
        System.out.println(res5);
        String res6 = ObjectUtils.getDisplayString(book2);
        System.out.println(res6);
        boolean empty = ObjectUtils.isEmpty(book1);
        System.out.println(empty);
        boolean array = ObjectUtils.isArray(arr);
        System.out.println(array);
        boolean res8 = ObjectUtils.containsElement(arr, 222);
        System.out.println(res8);
         String word = "werioioioiocdsahdfjkh";
         String child = "io";
        boolean empty1 = StringUtils.isEmpty(book1);
        System.out.println(empty1);
        boolean jkh = StringUtils.endsWithIgnoreCase(word, "jkh");
        System.out.println(jkh);
        boolean wer = StringUtils.startsWithIgnoreCase(word, "wer");
        System.out.println(wer);
        int i = StringUtils.countOccurrencesOf(word, child);
        System.out.println(i);
        byte[] bytes = FileCopyUtils.copyToByteArray(new File("D:/upload/003.jpg"));
        System.out.println(bytes.length);


    }
}
