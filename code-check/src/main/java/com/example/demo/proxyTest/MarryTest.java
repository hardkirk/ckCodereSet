package com.example.demo.proxyTest;

/**
 * @Author chuke
 * @create 2020/11/18 20:32
 */
public class MarryTest implements HappyMarry{
    private HappyMarry happyMarry;
    public MarryTest(HappyMarry happyMarry){
    this.happyMarry = happyMarry;
    }
    @Override
    public String getHunny() {
        before();
        this.happyMarry.getHunny();
        after();
        return "gongxigongxi";
    }


    private void before(){
        System.out.println("布置现场");
    }
    private void after(){
        System.out.println("回收尾款");
    }
}
