package com.demo.Spring_V8;

/**
 * @author Aurora
 * @date 2025年12月31日 21:28
 */
public class DbSearchServiceImpl implements SearchService {
    @Override
    public void search(String keyword) {
        System.out.println("数据库搜索：" + keyword);
    }
}
