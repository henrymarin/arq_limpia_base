package com.xxxxxxxxx.zzzzzzzzz.domain.exception;

import org.junit.Assert;
import org.junit.Test;

import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException;
import com.xxxxxxxxx.zzzzzzzzz.domain.exception.JPARepositoryException.Code;

public class JPARepositoryExceptionTest {

    public static final String DESCRIPCION_ERROR = "Descripcion error";
    public static final String ERROR = "error x";

    @Test
    public void test1() {
        JPARepositoryException e1 = new JPARepositoryException(Code.JPA);
        Assert.assertNotNull(e1.getErrorKey());
    }

    @Test
    public void test2() {
        JPARepositoryException e2 = new JPARepositoryException(DESCRIPCION_ERROR,
                new RuntimeException(ERROR), Code.JPA);
        Assert.assertNotNull(e2.getErrorKey());
    }

    @Test
    public void test3() {
        JPARepositoryException e3 = new JPARepositoryException(DESCRIPCION_ERROR, Code.JPA);
        Assert.assertNotNull(e3.getErrorKey());
    }

    @Test
    public void test4() {
        JPARepositoryException e4 = new JPARepositoryException(new RuntimeException(ERROR), Code.JPA);
        Assert.assertNotNull(e4.getErrorKey());
    }

}
