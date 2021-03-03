package com.example.transational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @description:
 * @author: Chuk
 * @time: 2021/1/27 17:17
 * @Params TestSetTransation2
 */
public class TestSetTransation2 {
    @Autowired
    private TestSetTransation testSetTransation;
    public void changeDetail2(){
        try {
        testSetTransation.changeDetail();
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
